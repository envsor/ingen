package so.env.dafei.mwc.service;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageProcessor {
	
	public static String IMAGE_TYPE_GIF = "gif";// 图形交换格式
    public static String IMAGE_TYPE_JPG = "jpg";// 联合照片专家组
    public static String IMAGE_TYPE_PNG = "png";// 可移植网络图形
    /* Max size 500k */
    public static int IMAGE_MAX_SIZE = 500 * 1024;
    public static int IMAGE_WIDTH = 640;
    public static int IMAGE_HEIGHT = 1008;
        
    private String suffix;
    private BufferedInputStream bfStream;
    private Image image;
    
    public ImageProcessor(InputStream in) throws IOException{
    	bfStream = new BufferedInputStream(in);
    	this.bfStream.mark(IMAGE_MAX_SIZE * 8);
    	image = ImageIO.read(this.bfStream);
    	this.bfStream.reset();
    	suffix = "unknown";
    }
    
    public boolean validateSize(Long size){
    	if(size <= IMAGE_MAX_SIZE){
    		return true;
    	}
    	return false;
    }
    
    public boolean validateFormat() throws IOException{
    	if(!this.bfStream.markSupported()){
    		throw new IllegalArgumentException("Input stream must support mark");
    	}
    	if(isJpg() || isPng() || isGif()){
    		return true;
    	}
    	return false;
    }
    
    public boolean validateDimension(){
    	int width = this.image.getWidth(null);
    	int height = this.image.getHeight(null);
    	if(width != IMAGE_WIDTH || height != IMAGE_HEIGHT){
    		return false;
    	}
    	return true;
    }
    
    public boolean isJpg() throws IOException{
    	this.bfStream.mark(30);
    	// If the first two bytes are a JPEG SOI marker, it's probably  
        // a JPEG file. If they aren't, it definitely isn't a JPEG file.  
        try {  
            int byte1 = this.bfStream.read();  
            int byte2 = this.bfStream.read();  
            if ((byte1 == 0xFF) && (byte2 == 0xD8)) {
            	this.suffix = IMAGE_TYPE_JPG;
                return true;  
            }  
        } finally {  
        	this.bfStream.reset();  
        }  
        return false; 
    }
    
    public boolean isPng() throws IOException {  
        byte[] b = new byte[8];  
        try {  
        	this.bfStream.mark(30);  
        	this.bfStream.read(b);
        	if(b[0] == (byte) 137 && b[1] == (byte) 80 && b[2] == (byte) 78 && b[3] == (byte) 71 && b[4] == (byte) 13  
                    && b[5] == (byte) 10 && b[6] == (byte) 26 && b[7] == (byte) 10){
            	this.suffix = IMAGE_TYPE_PNG;
            	return true;
            }
        } finally {  
        	this.bfStream.reset();  
        }  
        return false;  
    }  
    
    public boolean isGif() throws IOException {  
        byte[] b = new byte[6];  
  
        try {  
        	this.bfStream.mark(30);  
        	this.bfStream.read(b);  
        	if (b[0] == 'G' && b[1] == 'I' && b[2] == 'F' && b[3] == '8' && (b[4] == '7' || b[4] == '9') && b[5] == 'a'){
        		this.suffix = IMAGE_TYPE_GIF;
        		return true;
        	}
        } finally {  
        	this.bfStream.reset();  
        }  
  
        return false;  
    }

	public String getSuffix() {
		return suffix;
	}  
}
