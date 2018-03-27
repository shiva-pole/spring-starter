
package com.homeunion.investor.test.property.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.homeunion.investor.property.dao.mapper.PropertySaleHistoryMapper;
import com.homeunion.investor.test.common.dao.mapper.MapperTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class PropertySaleHistoryMapperTest extends MapperTestUtils {

	@InjectMocks
	private PropertySaleHistoryMapper mapper;

	@Test
	public void testPropertySaleHistoryMapper() throws Exception {

		testMapper(mapper);
	}
}
