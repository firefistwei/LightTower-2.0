package gen.wzp.main;

import gen.wzp.main.domain.UserInfo;

public class Constants {

	// UserInfo
	public static int me_uid = 10000;

	public static String me_name ="韦泽鹏";
	
	public static String me_headURL = "";
	public static int me_head =0;
	
	public static int me_sex = 1;

	public static String me_sig ="机会与挑战同在。";
	
	public static String me_level = "信誉等级：5星";
	public static int me_score = 500;
	
	public static int time_style =1;
	public static String time_words ="好忙啊，最近！";
	
	public static UserInfo me_UserInfo = new UserInfo(me_uid,me_name,me_headURL,me_head
			,me_sex,me_sig,me_level,me_score,time_style,time_words);
	
	//UserPosition
	public static double me_longitude = 134;
	public static double me_latitude = 80;
	
	//UserMoreInfo
	public static String me_constellation ="白羊座";
	
	//默认头像类
	
}
