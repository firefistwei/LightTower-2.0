package gen.wzp.main.domain;

public class MyMsg {

	private int uid;
	private int mid;
	private int sender_id;
	private String sender_name;
	private String sender_headurl;
	private String msg_time;
	private String msg_content;
	private int msg_type;
	
	private int aid;
	private int aagree;
	
	public MyMsg(){
		
	}

	public MyMsg(int uid, int mid, int sender_id, String sender_name,
			String sender_headurl, String msg_time, String msg_content,
			int msg_type, int aid, int aagree) {
		super();
		this.uid = uid;
		this.mid = mid;
		this.sender_id = sender_id;
		this.sender_name = sender_name;
		this.sender_headurl = sender_headurl;
		this.msg_time = msg_time;
		this.msg_content = msg_content;
		this.msg_type = msg_type;
		this.aid = aid;
		this.aagree = aagree;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getSender_headurl() {
		return sender_headurl;
	}

	public void setSender_headurl(String sender_headurl) {
		this.sender_headurl = sender_headurl;
	}

	public String getMsg_time() {
		return msg_time;
	}

	public void setMsg_time(String msg_time) {
		this.msg_time = msg_time;
	}

	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	public int getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(int msg_type) {
		this.msg_type = msg_type;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAagree() {
		return aagree;
	}

	public void setAagree(int aagree) {
		this.aagree = aagree;
	}
	
	
	
}
