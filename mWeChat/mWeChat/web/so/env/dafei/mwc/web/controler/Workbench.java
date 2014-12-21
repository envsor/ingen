package so.env.dafei.mwc.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Workbench extends ABaseController{
	
	@RequestMapping(value="/workbench", method=RequestMethod.GET)
	public String workbench() {
		return "workbench";
	}
}
