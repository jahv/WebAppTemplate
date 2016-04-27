package jahv.selfstudy.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext.xml",
		"classpath*:META-INF/spring/jdbc-applicationContext.xml" })
@WebAppConfiguration
public class HelloControllerIT {

	private static final String BASE_URL = "/hello";
	private MockMvc mockMvc;

	@Autowired
	@Qualifier("testRestTemplate")
	private RestTemplate restTemplate;

	@Autowired
	private WebApplicationContext ctx;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testHelloModelAndView() throws Exception {
		final String url = BASE_URL + "/modelAndView";
		final MvcResult result =
				mockMvc.perform(MockMvcRequestBuilders.get(url)).andDo(MockMvcResultHandlers.print()).andExpect(
						MockMvcResultMatchers.status().isOk()).andReturn();

		final ModelAndView modelAndView = result.getModelAndView();
		System.out.println(modelAndView.getModel());
		System.out.println(modelAndView.getViewName());
	}

	@Test
	public void testHelloString() throws Exception {
		final String url = BASE_URL + "/string";
		final MvcResult result =
				mockMvc.perform(MockMvcRequestBuilders.get(url)).andDo(MockMvcResultHandlers.print()).andExpect(
						MockMvcResultMatchers.status().isOk()).andReturn();

		final ModelAndView modelAndView = result.getModelAndView();
		System.out.println(modelAndView.getModel());
		System.out.println(modelAndView.getViewName());
	}

	@Test
	public void testHelloJackson() throws Exception {
		final ObjectMapper mapper = new ObjectMapper();
		final String url = BASE_URL + "/jackson";

		final Map<String, String> map = new HashMap<String, String>();
		map.put("Name", "Name value");

		mockMvc.perform(MockMvcRequestBuilders.get(url)).andDo(MockMvcResultHandlers.print()).andExpect(
				MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.content().string(mapper.writeValueAsString(map)));
	}
}
