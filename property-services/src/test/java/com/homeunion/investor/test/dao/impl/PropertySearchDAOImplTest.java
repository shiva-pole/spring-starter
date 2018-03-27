
package com.homeunion.investor.test.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.homeunion.investor.property.dao.impl.PropertySearchDAOImpl;
import com.homeunion.investor.test.common.dao.impl.DAOTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class PropertySearchDAOImplTest extends DAOTestUtils {

	@InjectMocks
	private PropertySearchDAOImpl dao;

	@Before
	public void before() {

		initMocks(dao);
	}

	@Test
	public void testPropertySearchDAOImpl() throws Exception {

		testDao(dao);
	}
}
