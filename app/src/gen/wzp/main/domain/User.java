package gen.wzp.main.domain;

public class User {

	private int uid;
	private String umailname;
	private String ukey;
	
	public User(){
		
	}
	public User(int uid, String umailname, String ukey) {
		super();
		this.uid = uid;
		this.umailname = umailname;
		this.ukey = ukey;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUmailname() {
		return umailname;
	}
	public void setUmailname(String umailname) {
		this.umailname = umailname;
	}
	public String getUkey() {
		return ukey;
	}
	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	
}
