package so.env.dafei.mwc.web.pojo;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private boolean successful;
	private List<String> msgIdList;
		
	public Result() {
		super();
		this.successful = true;
		this.msgIdList = new ArrayList<String>();
	}
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
	public int getMsgCount(){
		return this.msgIdList.size();
	}
	
	public List<String> getMsgIdList() {
		return msgIdList;
	}
	
	public void putMsgid(String msgId){
		this.msgIdList.add(msgId);
	}
	
}
