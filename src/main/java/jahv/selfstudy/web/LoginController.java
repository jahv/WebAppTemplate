package jahv.selfstudy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView logIn() {
		return new ModelAndView("login/loginForm");
	}

	@RequestMapping(value = "/login", params = "action=logout", method = RequestMethod.GET)
	public ModelAndView logOut() {
		return new ModelAndView("login/loginForm");
	}

	@RequestMapping(value = "/error/accessDeny", method = RequestMethod.GET)
	public ModelAndView accessDeny() {
		return new ModelAndView("error/accessDeny");
	}

}
