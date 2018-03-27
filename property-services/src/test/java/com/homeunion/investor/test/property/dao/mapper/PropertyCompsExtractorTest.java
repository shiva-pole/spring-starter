
package com.homeunion.investor.test.property.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.homeunion.investor.property.dao.mapper.PropertyCompsExtractor;
import com.homeunion.investor.test.common.dao.mapper.MapperTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class PropertyCompsExtractorTest extends MapperTestUtils {

	@InjectMocks
	private PropertyCompsExtractor extractor;

	@Test
	public void testPropertyCompsExtractor() throws Exception {

		testExtractor(extractor);
	}
}
