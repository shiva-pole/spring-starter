
package com.homeunion.investor.test.property.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.homeunion.investor.property.dao.mapper.PropertyListingInfoMapper;
import com.homeunion.investor.test.common.dao.mapper.MapperTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class PropertyListingInfoMapperTest extends MapperTestUtils {

	@InjectMocks
	private PropertyListingInfoMapper mapper;

	@Test
	public void testPropertyListingInfoMapper() throws Exception {

		testMapper(mapper);
	}
}
