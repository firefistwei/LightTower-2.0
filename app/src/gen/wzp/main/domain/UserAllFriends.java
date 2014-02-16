package gen.wzp.main.domain;

public class UserAllFriends {

	private int uid;
	private int fid;
	private String fheadurl;
	private String fnotename;
	
	public UserAllFriends(){
		
	}

	public UserAllFriends(int uid, int fid, String fheadurl, String fnotename) {
		super();
		this.uid = uid;
		this.fid = fid;
		this.fheadurl = fheadurl;
		this.fnotename = fnotename;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFheadurl() {
		return fheadurl;
	}

	public void setFheadurl(String fheadurl) {
		this.fheadurl = fheadurl;
	}

	public String getFnotename() {
		return fnotename;
	}

	public void setFnotename(String fnotename) {
		this.fnotename = fnotename;
	}
	
	
	
}
