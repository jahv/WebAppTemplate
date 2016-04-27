package jahv.selfstudy.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {

	private static final String BASE_URL = "/hello";

	@InjectMocks
	private HelloController helloController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(helloController)
				.setViewResolvers(viewResolver)
				.build();
	}

	@Test
	public void testHelloModelAndView() throws Exception {
		final String url = BASE_URL + "/modelAndView";
		final MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url))
				.andDo(MockMvcResultHandlers.print()).andExpect(
						MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/modelAndView.jsp"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("date")).andReturn();
		final ModelAndView modelAndView = result.getModelAndView();
		System.out.println(modelAndView.getModel());
		System.out.println(modelAndView.getViewName());
	}
}
