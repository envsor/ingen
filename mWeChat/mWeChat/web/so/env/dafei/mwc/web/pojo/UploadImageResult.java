package so.env.dafei.mwc.web.pojo;

public class UploadImageResult extends Result {
	private String suffix;
	private Integer height;
	private Integer width;
	private Long size;
	private String imgUri;
	
	public UploadImageResult() {
		super();
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}
	public String getImgUri() {
		return imgUri;
	}

}
