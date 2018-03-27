
package com.analytics.scatterfit.dto.user;

import java.io.Serializable;

public class MemberInfoDTO implements Serializable {

	private static final long serialVersionUID = -7284971991407173330L;
	private String memberId;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String deviceType;
	private String ipAddress;
	private String mobilePhone;
	private Integer memberType;
	private Boolean isActive;

	public String getMemberId() {

		return memberId;
	}

	public void setMemberId(String memberId) {

		this.memberId = memberId;
	}

	public String getEmailAddress() {

		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {

		this.emailAddress = emailAddress;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public String getDeviceType() {

		return deviceType;
	}

	public void setDeviceType(String deviceType) {

		this.deviceType = deviceType;
	}

	public String getIpAddress() {

		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {

		this.ipAddress = ipAddress;
	}

	public String getMobilePhone() {

		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {

		this.mobilePhone = mobilePhone;
	}

	public Integer getMemberType() {

		return memberType;
	}

	public void setMemberType(Integer memberType) {

		this.memberType = memberType;
	}

	public Boolean getIsActive() {

		return isActive;
	}

	public void setIsActive(Boolean isActive) {

		this.isActive = isActive;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("MemberInfoDTO [memberId=");
		builder.append(memberId);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", deviceType=");
		builder.append(deviceType);
		builder.append(", ipAddress=");
		builder.append(ipAddress);
		builder.append(", mobilePhone=");
		builder.append(mobilePhone);
		builder.append(", memberType=");
		builder.append(memberType);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}
}
