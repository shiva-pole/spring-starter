
package com.homeunion.investor.property.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.homeunion.investor.common.domain.FileInfo;
import com.homeunion.investor.common.excel.ExcelReportBuilder;
import com.homeunion.investor.external.http.HttpUtil;
import com.homeunion.investor.property.domain.financial.AuthToken;
import com.homeunion.investor.property.domain.financial.FinancialProjection;
import com.homeunion.investor.property.domain.financial.FinancialProjectionInput;
import com.homeunion.investor.property.domain.financial.FinancialProjectionResponse;
import com.homeunion.investor.property.domain.financial.excel.FinancialProjectionReportType;
import com.homeunion.investor.property.domain.financial.excel.FinancialProjectionTable;
import com.homeunion.investor.property.exception.PlatformServiceException;
import com.homeunion.investor.property.service.PropertyFinancialProjectionService;

@Component
@EnableOAuth2Client
public class PropertyFinancialProjectionServiceImpl implements PropertyFinancialProjectionService, InitializingBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyFinancialProjectionServiceImpl.class);
	private static final String OAUTH_TOKEN_ENDPOINT = "oauth/token";
	private static final String FIN_PROJ_JS_ENDPOINT = "restapi/js/financial-projection/%s/%s";
	private JsonParser jsonParser = new JsonParser();
	@Value("${platform.host}")
	private String host;
	@Value("${platform.client-id}")
	private String clientId;
	@Value("${platform.client-secret}")
	private String clientSecret;
	@Value("${platform.user-name}")
	private String user;
	@Value("${platform.password}")
	private String password;
	@Value("${platform.auth.enabled}")
	private boolean authenticationEnabled;
	private Map<String, String> authTokenParams = new HashMap<>();
	private AuthToken authToken;
	@Autowired
	private ExcelReportBuilder excelReportBuilder;

	@Override
	public FileInfo getFinancialProjectionJS(String hil, String zip) {

		String endpoint = String.format(FIN_PROJ_JS_ENDPOINT, hil, zip);
		byte[] responseBytes = null;
		//check whether authentication enabled and make post call accordingly
		if (authenticationEnabled) {
			String accessToken = authenticate();
			responseBytes = HttpUtil.getWithAuth(host + endpoint, accessToken);
			if (responseBytes == null) {
				authToken = null;
				accessToken = authenticate();
				responseBytes = HttpUtil.getWithAuth(host + endpoint, accessToken);
			}
		} else {
			responseBytes = HttpUtil.get(host + endpoint);
		}
		//check for response
		if (responseBytes == null || responseBytes.length == 0) {
			LOGGER.error("Platform Financial Projection JS sent null or empty response");
			throw new PlatformServiceException("Financial Projection JS sent null or empty response");
		}
		FileInfo fileInfo = new FileInfo();
		fileInfo.setMediaType("text/javascript; charset=utf-8");
		fileInfo.setContent(responseBytes);
		return fileInfo;
	}

	private synchronized String authenticate() {

		if (authToken == null || authToken.isExpired()) {
			acquireAccessToken(authToken);
		}
		return authToken.getAccessToken();
	}

	private void acquireAccessToken(AuthToken authToken) {

		LOGGER.info("Acquiring access token for platform financial projection API");
		String accessTokenResponse = HttpUtil.post(host + OAUTH_TOKEN_ENDPOINT, authTokenParams);
		if (accessTokenResponse != null) {
			authToken = new AuthToken((JsonObject) jsonParser.parse(accessTokenResponse));
			LOGGER.info("Successfully acquired access token for platform financial projection API: {}", authToken);
			this.authToken = authToken;
		} else {
			LOGGER.warn("Could not acquire access token for platform financial projection API");
			this.authToken = null;
			throw new PlatformServiceException("Access Token not acquired");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		authTokenParams.put("client_id", clientId);
		authTokenParams.put("client_secret", clientSecret);
		authTokenParams.put("grant_type", "password");
		authTokenParams.put("username", user);
		authTokenParams.put("password", password);
		LOGGER.info("Configured Platform API Config as Host, Client Id, Client Secret, User, Password as {}, {}, {}, {}, {}",
		            host,
		            clientId,
		            clientSecret,
		            user,
		            password);
	}

	@Override
	public FileInfo getDetailedCalculationAsExcel(boolean leveraged, FinancialProjectionReportType type, FinancialProjectionInput request) throws IOException {

		AccessTokenRequest atr = new DefaultAccessTokenRequest();
		FinancialProjection projection = null;
		OAuth2RestTemplate oauthRestTemp = new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
		FileInfo fileInfo = new FileInfo();
		try {
			FinancialProjectionResponse response = oauthRestTemp.postForObject(new URI(host + "restapi/financial/projection"),
			                                                                   request,
			                                                                   FinancialProjectionResponse.class);
			if (leveraged) {
				projection = response.getFinancedProjection();
			} else {
				projection = response.getAllCashProjection();
			}
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("projection", new FinancialProjectionTable(projection));
			byte[] content = excelReportBuilder.buildExcelReport(type.getTemplateType(), model);
			fileInfo.setContent(content);
			fileInfo.setMediaType("application/excel");
			fileInfo.setName("FinancialProjection.xlsx");
			LOGGER.info(response.toString());
		} catch (RestClientException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileInfo;
	}

	protected OAuth2ProtectedResourceDetails resource() {

		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails() {

			public boolean isClientOnly() {

				return true;
			}
		};
		resource.setAccessTokenUri(host + OAUTH_TOKEN_ENDPOINT);
		resource.setClientId(clientId);
		resource.setClientSecret(clientSecret);
		resource.setGrantType("password");
		resource.setUsername(user);
		resource.setPassword(password);
		resource.setClientAuthenticationScheme(AuthenticationScheme.form);
		return resource;
	}
}
