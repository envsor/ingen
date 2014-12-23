package so.env.dafei.mwc.web.controler;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import so.env.dafei.mwc.service.ImageProcessor;
import so.env.dafei.mwc.web.pojo.UploadImageResult;

@Controller
public class Slides extends ABaseController {
	private static final Logger logger = LoggerFactory.getLogger(Slides.class.getPackage().getName()); 
	
	@RequestMapping(value="/basic_function/slides", method=RequestMethod.GET)
	public String getSlidesPage() {
		return "basic_function/slides";
	}
	
	@RequestMapping(value="/basic_function/slide/add", method=RequestMethod.GET)
	public String getAddSlidePage() {
		return "basic_function/add_slide";
	}
	
	@RequestMapping(value="/basic_function/slide/upload", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public @ResponseBody UploadImageResult uploadSlidePage(@RequestParam MultipartFile file, Model model, HttpServletRequest request) {
		logger.debug("Enter /basic_function/slide/upload: " + file.getOriginalFilename());
		UploadImageResult uir = new UploadImageResult();
		String imagePath;
		String imageUri;
		String imageFileName;
		File imgFile;
		try {
			ImageProcessor ip = new ImageProcessor(file.getInputStream());
			if(!ip.validateSize(file.getSize())){
				uir.setSuccessful(false);
				uir.putMsgid("MSG_SLIDES_0001");
				uir.setSize(file.getSize());
				logger.debug("Image file is too big.");
			}
			if(!ip.validateFormat()){
				uir.setSuccessful(false);
				uir.putMsgid("MSG_SLIDES_0002");
				logger.debug("Image format is not jpg, gif or png.");
			}
			if(!ip.validateDimension()){
				uir.setSuccessful(false);
				uir.putMsgid("MSG_SLIDES_0003");
				uir.setHeight(ImageProcessor.IMAGE_HEIGHT);
				uir.setWidth(ImageProcessor.IMAGE_WIDTH);
				logger.debug("Image is not " + ImageProcessor.IMAGE_WIDTH + " * " + ImageProcessor.IMAGE_HEIGHT);
			}
			
			if(uir.isSuccessful()){
				imageFileName = UUID.randomUUID().toString() + "." + ip.getSuffix();
				imagePath = uploadPath + imageFileName;
				imgFile = new File(imagePath);
				file.transferTo(imgFile);
				logger.debug(imagePath);
				imageUri = uploadUri + imageFileName;
				uir.setImgUri(imageUri);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uir;
	}
}
