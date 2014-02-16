package gen.wzp.main.domain;

/**
 * 聊天记录的数据实体
 * 
 * @author rendongwei
 * 
 */
public class ChatResult {

	private int uid;
	private String head;
	private String name;
	private String time;
	private String content;
	/**
	 * 内容类型(1-发出,2-接收)
	 */
	private int type;
	
	public ChatResult(){
		
	}
	
	public ChatResult(int uid, String head, String name, String time,
			String content, int type) {
		super();
		this.uid = uid;
		this.head = head;
		this.name = name;
		this.time = time;
		this.content = content;
		this.type = type;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	
}
