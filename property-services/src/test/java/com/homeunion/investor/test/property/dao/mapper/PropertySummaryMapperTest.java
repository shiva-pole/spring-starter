
package com.homeunion.investor.test.property.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.homeunion.investor.property.dao.mapper.PropertySummaryMapper;
import com.homeunion.investor.test.common.dao.mapper.MapperTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class PropertySummaryMapperTest extends MapperTestUtils {

	@InjectMocks
	private PropertySummaryMapper mapper;

	@Test
	public void testPropertySummaryMapper() throws Exception {

		testMapper(mapper);
	}
}
