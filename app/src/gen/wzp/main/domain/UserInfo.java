package gen.wzp.main.domain;

public class UserInfo {

	private int uid;
	private String name;
	private String headurl;
	private int head;
	private int sex;
	private String sig;
	private String level;
	private int score;
	private int time_style;
	private String time_words;
	
	public UserInfo(){
		
	}
	public UserInfo(int uid, String name, int head, int sex){
		this.uid = uid;
		this.name = name;
		this.head = head;
		this.sex = sex;
	}
	
	public UserInfo(int uid, String name, String headurl, int head, int sex,
			String sig, String level, int score, int time_style,
			String time_words) {
		super();
		this.uid = uid;
		this.name = name;
		this.headurl = headurl;
		this.head = head;
		this.sex = sex;
		this.sig = sig;
		this.level = level;
		this.score = score;
		this.time_style = time_style;
		this.time_words = time_words;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public int getHead() {
		return head;
	}
	public void setHead(int head) {
		this.head = head;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTime_style() {
		return time_style;
	}
	public void setTime_style(int time_style) {
		this.time_style = time_style;
	}
	public String getTime_words() {
		return time_words;
	}
	public void setTime_words(String time_words) {
		this.time_words = time_words;
	}

	
}
