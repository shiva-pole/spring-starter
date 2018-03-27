
package com.homeunion.investor.test.property.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.homeunion.investor.property.dao.mapper.EmployersInfoMapper;
import com.homeunion.investor.test.common.dao.mapper.MapperTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class EmployersInfoMapperTest extends MapperTestUtils {

	@InjectMocks
	private EmployersInfoMapper mapper;

	@Test
	public void testEmployersInfoMapper() throws Exception {

		testMapper(mapper);
	}
}
