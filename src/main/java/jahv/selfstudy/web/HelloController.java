package jahv.selfstudy.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * HelloController to handle calls for /hello
 * @author jahv
 *
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

	private final static Logger LOGGER = Logger.getLogger(HelloController.class);

	/**
	 * Handles /hello/modelAndView calls
	 * @return
	 */
	@RequestMapping(value = "/modelAndView", method = RequestMethod.GET)
	public ModelAndView helloModelAndView() {
		LOGGER.info("hello/modelAndView starts");
		ModelAndView model = new ModelAndView();
		model.setViewName("modelAndView");

		model.addObject("date", new Date());

		return model;
	}

	/**
	 * Handles /hello/string calls
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String helloString(ModelMap model) {
		LOGGER.info("hello/string starts");
		model.addAttribute("date2", new Date());
		return "string";
	}

	/**
	 * Ha
	 * @return
	 */
	@RequestMapping(value = "/jackson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> helloJackson() {
		LOGGER.info("hello/jackson starts");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Name", "Name value");
		return map;
	}
}
