package gen.wzp.main.domain;

public class Actives {

	private int uid;
	private String uheadurl;
	private String uname;
	private int aid;
	private String aname;
	private String atime;
	private int tojoin;
	private int enable;
	private int isfinished;
	
	public Actives(){
		
	}

	public Actives(int uid, String uheadurl, String uname, int aid,
			String aname, String atime, int tojoin, int enable, int isfinished) {
		super();
		this.uid = uid;
		this.uheadurl = uheadurl;
		this.uname = uname;
		this.aid = aid;
		this.aname = aname;
		this.atime = atime;
		this.tojoin = tojoin;
		this.enable = enable;
		this.isfinished = isfinished;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUheadurl() {
		return uheadurl;
	}

	public void setUheadurl(String uheadurl) {
		this.uheadurl = uheadurl;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAtime() {
		return atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}

	public int getTojoin() {
		return tojoin;
	}

	public void setTojoin(int tojoin) {
		this.tojoin = tojoin;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getIsfinished() {
		return isfinished;
	}

	public void setIsfinished(int isfinished) {
		this.isfinished = isfinished;
	}
	
}
