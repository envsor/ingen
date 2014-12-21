package so.env.dafei.mwc.web.controler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Slides extends ABaseController {
	
	@RequestMapping(value="/basic_function/slides", method=RequestMethod.GET)
	public String getSlidesPage() {
		return "basic_function/slides";
	}
	
	@RequestMapping(value="/basic_function/slide/add", method=RequestMethod.GET)
	public String getAddSlidePage() {
		return "basic_function/add_slide";
	}
	
	@RequestMapping(value="/basic_function/slide/upload", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public @ResponseBody Integer uploadSlidePage(@RequestParam MultipartFile file, Model model) {
		model.addAttribute("message", "你好" + file.getOriginalFilename() + "' uploaded successfully");
		return 111;
	}
}
