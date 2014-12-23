package so.env.dafei.mwc.web.controler;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;

@Controller
public abstract class ABaseController {
	public final static String PUBLIC_PATH = "/public";
	protected String sessionId;
	protected String contextPath;
	protected String realPath;
	protected String uploadPath;
	protected String uploadUri;
	
	@ModelAttribute
	public void setContext(HttpServletRequest request, Model model) {
		sessionId = request.getSession().getId();
		contextPath = request.getContextPath();
		realPath = request.getSession().getServletContext().getRealPath(PUBLIC_PATH);
		uploadUri = contextPath + PUBLIC_PATH + "/" + sessionId + "/";
		uploadPath = realPath + File.separator + sessionId + File.separator;
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()){
			uploadDir.mkdirs();
		}
	}
}
