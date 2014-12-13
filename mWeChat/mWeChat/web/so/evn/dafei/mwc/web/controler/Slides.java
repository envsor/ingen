package so.evn.dafei.mwc.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Slides extends ABaseController {
	
	@RequestMapping(value="/basic_function/slides", method=RequestMethod.GET)
	public String getSlidesPage() {
		return "basic_function/slides";
	}
}
