package gen.wzp.main.domain;

public class UserAlbum {

	private int uid;
	private int photo_no;
	private String photo_url;
	private String photo_content;
	
	public UserAlbum(){
		
	}
	public UserAlbum(int uid, int photo_no, String photo_url,
			String photo_content) {
		super();
		this.uid = uid;
		this.photo_no = photo_no;
		this.photo_url = photo_url;
		this.photo_content = photo_content;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPhoto_no() {
		return photo_no;
	}
	public void setPhoto_no(int photo_no) {
		this.photo_no = photo_no;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	public String getPhoto_content() {
		return photo_content;
	}
	public void setPhoto_content(String photo_content) {
		this.photo_content = photo_content;
	}
	
	
	
}
