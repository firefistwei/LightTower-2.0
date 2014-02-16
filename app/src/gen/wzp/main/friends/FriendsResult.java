package gen.wzp.main.friends;

/**
 * 好友数据的实体
 * 
 * @author rendongwei
 * 
 */
public class FriendsResult {
	/**
	 * 好友的编号
	 */
	private String uid;
	/**
	 * 好友的头像编号
	 */
	private int avatar;
	/**
	 * 好友的姓名
	 */
	private String name;
	/**
	 * 好友的姓名拼音
	 */
	private String name_pinyin;
	/**
	 * 好友姓名的首字母
	 */
	private String name_first;
	
	public FriendsResult(){
		
	}

	public FriendsResult(String uid, int avatar, String name,
			String name_pinyin, String name_first) {
		super();
		this.uid = uid;
		this.avatar = avatar;
		this.name = name;
		this.name_pinyin = name_pinyin;
		this.name_first = name_first;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avatar;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((name_first == null) ? 0 : name_first.hashCode());
		result = prime * result
				+ ((name_pinyin == null) ? 0 : name_pinyin.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendsResult other = (FriendsResult) obj;
		if (avatar != other.avatar)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (name_first == null) {
			if (other.name_first != null)
				return false;
		} else if (!name_first.equals(other.name_first))
			return false;
		if (name_pinyin == null) {
			if (other.name_pinyin != null)
				return false;
		} else if (!name_pinyin.equals(other.name_pinyin))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_pinyin() {
		return name_pinyin;
	}

	public void setName_pinyin(String name_pinyin) {
		this.name_pinyin = name_pinyin;
	}

	public String getName_first() {
		return name_first;
	}

	public void setName_first(String name_first) {
		this.name_first = name_first;
	}
}