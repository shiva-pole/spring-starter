
package com.analytics.scatterfit.dto.session;

import java.io.Serializable;

import com.analytics.scatterfit.dto.user.MemberInfoDTO;

public class UserSessionData implements Serializable {

	private static final long serialVersionUID = -6953627518777352903L;
	private MemberInfoDTO memberInfo;

	public MemberInfoDTO getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfoDTO memberInfo) {
		this.memberInfo = memberInfo;
	}

}
