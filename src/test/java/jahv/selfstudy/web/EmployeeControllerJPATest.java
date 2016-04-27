package jahv.selfstudy.web;

import jahv.selfstudy.model.EmployeeEntity;
import jahv.selfstudy.service.EmployeeServiceJPA;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerJPATest {

	private static final String BASE_URL = "/employeeJPA";

	@InjectMocks
	private EmployeeControllerJPA employeeControllerJPA;

	@Mock
	private EmployeeServiceJPA employeeServiceJPA;

	@Test
	public void testGetAllEmployees() throws Exception {
		final List<EmployeeEntity> serviceResult = new ArrayList<EmployeeEntity>();
		serviceResult.add(new EmployeeEntity());

		Mockito.when(employeeServiceJPA.getEmployees()).thenReturn(serviceResult);

		final String url = BASE_URL;

		MockMvcBuilders.standaloneSetup(employeeControllerJPA).build()
				.perform(MockMvcRequestBuilders.get(url))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
