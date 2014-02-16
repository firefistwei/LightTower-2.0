package gen.wzp.main.domain;

public class UserHotFriends {

	private int uid;
	private int hotlevel;
	private int fid;
	private String lasttime;
	private String notename;
	
	public UserHotFriends(){
		
	}
	public UserHotFriends(int uid, int hotlevel, int fid, String lasttime,
			String notename) {
		super();
		this.uid = uid;
		this.hotlevel = hotlevel;
		this.fid = fid;
		this.lasttime = lasttime;
		this.notename = notename;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getHotlevel() {
		return hotlevel;
	}
	public void setHotlevel(int hotlevel) {
		this.hotlevel = hotlevel;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public String getNotename() {
		return notename;
	}
	public void setNotename(String notename) {
		this.notename = notename;
	}
	
	
	
}
