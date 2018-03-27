
package com.analytics.scatterfit.user.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.analytics.scatterfit.common.dao.BaseDAO;
import com.analytics.scatterfit.user.dao.MemberDAO;

@Component
public class MemberDAOImpl extends BaseDAO implements MemberDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberDAOImpl.class);
	@Value("${member-test.cron-enabled}")
	private boolean jobEnabled;

	@Override
	@Scheduled(cron = "${member-test.cron}")
	public void registerUser() {
		if (jobEnabled) {
			long now = System.currentTimeMillis() / 1000;
			// System.out.println("schedule tasks using cron jobs - " + now);
			LOGGER.info("schedule tasks using cron jobs - " + now);
		}
	}
}
