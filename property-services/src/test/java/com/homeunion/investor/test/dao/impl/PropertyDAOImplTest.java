
package com.homeunion.investor.test.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.homeunion.investor.property.dao.impl.PropertyDAOImpl;
import com.homeunion.investor.test.common.dao.impl.DAOTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class PropertyDAOImplTest extends DAOTestUtils {

	@InjectMocks
	private PropertyDAOImpl dao;

	@Before
	public void before() {

		initMocks(dao);
	}

	@Test
	public void testPropertyDAOImpl() throws Exception {

		testDao(dao);
	}
}
