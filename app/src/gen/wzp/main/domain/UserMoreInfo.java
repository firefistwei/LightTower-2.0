package gen.wzp.main.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class UserMoreInfo implements Parcelable{

	private int uid;
	private int single;
	private String birthday;
	private String constellation;
	private String hometown;
	private String livingplace;
	private String phonenumber;
	private String goodat;
	private String fromschool;
	private String fromcompany;
	
	public UserMoreInfo(){
		
	}
	public UserMoreInfo(int uid, int single, String birthday,
			String constellation, String hometown, String livingplace,
			String phonenumber, String goodat, String fromschool,
			String fromcompany) {
		super();
		this.uid = uid;
		this.single = single;
		this.birthday = birthday;
		this.constellation = constellation;
		this.hometown = hometown;
		this.livingplace = livingplace;
		this.phonenumber = phonenumber;
		this.goodat = goodat;
		this.fromschool = fromschool;
		this.fromcompany = fromcompany;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSingle() {
		return single;
	}
	public void setSingle(int single) {
		this.single = single;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getLivingplace() {
		return livingplace;
	}
	public void setLivingplace(String livingplace) {
		this.livingplace = livingplace;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getGoodat() {
		return goodat;
	}
	public void setGoodat(String goodat) {
		this.goodat = goodat;
	}
	public String getFromschool() {
		return fromschool;
	}
	public void setFromschool(String fromschool) {
		this.fromschool = fromschool;
	}
	public String getFromcompany() {
		return fromcompany;
	}
	public void setFromcompany(String fromcompany) {
		this.fromcompany = fromcompany;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(uid);
		dest.writeInt(single);
		dest.writeString(birthday);
		dest.writeString(constellation);
		dest.writeString(hometown);
		dest.writeString(livingplace);
		dest.writeString(phonenumber);
		dest.writeString(goodat);
		dest.writeString(fromschool);
		dest.writeString(fromcompany);
		
	}

	public static final Parcelable.Creator<UserMoreInfo> CREATOR = new Parcelable.Creator<UserMoreInfo>() {

		@Override
		public UserMoreInfo createFromParcel(Parcel source) {
			UserMoreInfo result = new UserMoreInfo();
			result.setUid(source.readInt());
			result.setSingle(source.readInt());
			result.setBirthday(source.readString());
			result.setConstellation(source.readString());
			result.setHometown(source.readString());
			result.setLivingplace(source.readString());
			result.setPhonenumber(source.readString());
			result.setGoodat(source.readString());
			result.setFromschool(source.readString());
			result.setFromcompany(source.readString());
			
			return result;
		}

		@Override
		public UserMoreInfo[] newArray(int size) {
			
			return new UserMoreInfo[size];
		}
		
	};
	
	
}



