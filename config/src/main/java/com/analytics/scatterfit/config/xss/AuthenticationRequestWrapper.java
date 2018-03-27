
package com.analytics.scatterfit.config.xss;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class AuthenticationRequestWrapper extends HttpServletRequestWrapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationRequestWrapper.class);
	private String payload;

	public AuthenticationRequestWrapper(HttpServletRequest request) {

		super(request);
		// read the original payload into the payload variable
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			// read the payload into the StringBuilder
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				// make an empty string since there is no payload
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			LOGGER.error("Exception occured while reading input stream", ex);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException iox) {
					LOGGER.debug("Exception occurred while closing buffered reader", iox);
				}
			}
		}
		payload = stringBuilder.toString();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payload.getBytes());
		ServletInputStream inputStream = new ServletInputStream() {

			@Override
			public int read() throws IOException {

				return byteArrayInputStream.read();
			}

			@Override
			public boolean isFinished() {

				return byteArrayInputStream.available() == 0;
			}

			@Override
			public boolean isReady() {

				return true;
			}

			@Override
			public void setReadListener(ReadListener readListener) {

				try {
					throw new Exception("Not implemented");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		return inputStream;
	}

	public String getPayload() {

		return payload;
	}

	@Override
	public String[] getParameterValues(String parameter) {

		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = XSSUtil.stripXSS(values[i]);
		}
		return encodedValues;
	}

	@Override
	public String getParameter(String parameter) {

		String value = super.getParameter(parameter);
		if (!StringUtils.isEmpty(this.payload)) {
			String s = XSSUtil.stripXSS(getPayload());
			this.payload = s;
		}
		return XSSUtil.stripXSS(value);
	}

	@Override
	public String getHeader(String name) {

		String value = super.getHeader(name);
		return XSSUtil.stripXSS(value);
	}
}