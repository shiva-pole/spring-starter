
package com.homeunion.investor.property.domain.financial;

import java.util.Calendar;

import com.google.gson.JsonObject;

public class AuthToken {

	private String accessToken;
	private String refreshToken;
	private int expiresIn;
	private long expiryTime;

	public AuthToken(JsonObject authTokenResp) {

		if (authTokenResp != null) {
			accessToken = authTokenResp.get("access_token").getAsString();
			refreshToken = authTokenResp.get("refresh_token").getAsString();
			expiresIn = authTokenResp.get("expires_in").getAsInt();
			expiryTime = Calendar.getInstance().getTimeInMillis() + (1000 * expiresIn);
		}
	}

	public boolean isExpired() {

		return Calendar.getInstance().getTimeInMillis() > expiryTime;
	}

	public String getAccessToken() {

		return accessToken;
	}

	public void setAccessToken(String accessToken) {

		this.accessToken = accessToken;
	}

	public String getRefreshToken() {

		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {

		this.refreshToken = refreshToken;
	}

	public int getExpiresIn() {

		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {

		this.expiresIn = expiresIn;
	}
}
