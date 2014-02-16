package gen.wzp.main;

import gen.wzp.main.domain.Actives;
import gen.wzp.main.domain.ChatResult;
import gen.wzp.main.domain.UserHotFriends;
import gen.wzp.main.domain.UserMoreInfo;
import gen.wzp.main.domain.MyActive;

import gen.wzp.main.domain.MyMsg;

import gen.wzp.main.friends.FriendsResult;
import gen.wzp.main.utils.PhotoUtil;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MyConstants {

	public static List<MyActive> mActiveList = new ArrayList<MyActive>();
	public static String activeJSON = "[{\"uid\":301,\"aid\":17,\"atype\":1,\"aname\":\"3+3随即好友下午茶\",\"atime\":\"今天  4:20PM\",\"aposition\":\"后花园奶茶店\",\"amember\":\"301+302+303\",\"apeople_no\":\"1/10\",\"adescrip\":\"别宅了，出来聊聊，认识新的朋友.\\r\\n3+3是一个随机陌生人交流的活动，要开始这个活动必须要3个男生 和3个女生，主要可以就某个话题进行讨论，从而让宅宅们脱离使他们变宅的环境，到线下与别人面对面交流。\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0},"
			+ "{\"uid\":302,\"aid\":11,\"atype\":1,\"aname\":\"魔方高手挑战\",\"atime\":\"今天  20:20\",\"aposition\":\"1310教室\",\"amember\":\"302\",\"apeople_no\":\"1/2\",\"adescrip\":\"没错，我是魔方社长，求挑战！\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0},"
			+ "{\"uid\":303,\"aid\":5,\"atype\":1,\"aname\":\"乒乓球高手挑战\",\"atime\":\"今天  20:20\",\"aposition\":\"操场乒乓球处\",\"amember\":\"303\",\"apeople_no\":\"1/2\",\"adescrip\":\"谁要打乒乓球，呵呵，求高手MM,呵呵，球拍自带，呵呵\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0},"
			+ "{\"uid\":304,\"aid\":3,\"atype\":1,\"aname\":\"android大神交流会\",\"atime\":\"今天  8:20PM\",\"aposition\":\"1号教学楼前\",\"amember\":\"304\",\"apeople_no\":\"1/10\",\"adescrip\":\"安卓达人交流会，不要错过哦，也许改变世界的想法就在这里诞生哦！\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0},"
			+ "{\"uid\":301,\"aid\":9,\"atype\":1,\"aname\":\"操场跑步求一起\",\"atime\":\"今天  9:30PM\",\"aposition\":\"操场田径场\",\"amember\":\"301\",\"apeople_no\":\"1/5\",\"adescrip\":\"身体是革命的本钱，加入我，和我们一起跑步。\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0}]";
	
	public static List<MyActive> mActiveFriendsList = new ArrayList<MyActive>();

	public static String date = null;
	public static String alltime = null;
	static {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		date = dateFormat.format(now);
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yy/MM/dd HH:mm");
		alltime = dateFormat2.format(now);
	}
	
	public static int Wall_pager[]={
		R.drawable.wall_pager1,R.drawable.wall_pager2,R.drawable.wall_pager3,
		R.drawable.wall_pager4,R.drawable.wall_pager5,R.drawable.wall_pager6,
	};
	
	public static int Head_boy[]={R.drawable.random_head0, R.drawable.random_head1,
		R.drawable.random_head2, R.drawable.random_head3, R.drawable.random_head4,
		R.drawable.random_head5, R.drawable.random_head6, R.drawable.random_head7,
		R.drawable.random_head8, R.drawable.random_head9	
	};
	
	public static int Head_girl[]={R.drawable.random_head10, R.drawable.random_head11,
		R.drawable.random_head12, R.drawable.random_head13, R.drawable.random_head14,
		R.drawable.random_head15, R.drawable.random_head16, R.drawable.random_head17,
		R.drawable.random_head18, R.drawable.random_head19		
	};

	public static int Head_all[]={R.drawable.random_head0, R.drawable.random_head1,
		R.drawable.random_head2, R.drawable.random_head3, R.drawable.random_head4,
		R.drawable.random_head5, R.drawable.random_head6, R.drawable.random_head7,
		R.drawable.random_head8, R.drawable.random_head9,
		R.drawable.random_head10, R.drawable.random_head11,
		R.drawable.random_head12, R.drawable.random_head13, R.drawable.random_head14,
		R.drawable.random_head15, R.drawable.random_head16, R.drawable.random_head17,
		R.drawable.random_head18, R.drawable.random_head19		
	};

	
	//时间状态
	public static int Time_box[]={R.drawable.time_type_0,R.drawable.time_type_1,
		R.drawable.time_type_2,R.drawable.time_type_3,R.drawable.time_type_4,
		R.drawable.time_type_5,R.drawable.time_type_6,R.drawable.time_type_7,	
	};
	
	public static String Time_text[]={"什么都没干","奋斗","懒散", "求勾搭","求游玩","吃啊吃","无聊中","自定义"};
	
	public static List<Actives> wzpActivesList = new ArrayList<Actives>();
	public static String wzpActivesJSON = "[{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"韦泽鹏\",\"aid\":5,\"aname\":\"3+3随机好友下午茶\",\"atime\":\"5-30 4：20PM\",\"tojoin\":0,\"enable\":-1,\"isfinished\":0}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"韦泽鹏\",\"aid\":3,\"aname\":\"6人行吃街头美食\",\"atime\":\"5-28 10:20AM\",\"tojoin\":1,\"enable\":0,\"isfinished\":0}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"韦泽鹏\",\"aid\":3,\"aname\":\"2V2魔兽挑战\",\"atime\":\"5-22 4:30AM\",\"tojoin\":1,\"enable\":1,\"isfinished\":1}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"韦泽鹏\",\"aid\":4,\"aname\":\"Android大神讨论会\",\"atime\":\"5-26 8：20PM\",\"tojoin\":0,\"enable\":-1,\"isfinished\":0}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"韦泽鹏\",\"aid\":3,\"aname\":\"2+2中午吃大餐\",\"atime\":\"5-23 11:30AM\",\"tojoin\":1,\"enable\":1,\"isfinished\":1}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"韦泽鹏\",\"aid\":2,\"aname\":\"学姐，我请你吃饭\",\"atime\":\"5-20 6：20PM\",\"tojoin\":0,\"enable\":-1,\"isfinished\":1}]";

	/**
	 * 根据编号获取表情图片
	 */
	public static Bitmap getFaceBitmap(int position) {
		try {
			String faceName = mFacesText.get(position);
			Bitmap bitmap = null;
			if (mFaceCache.containsKey(faceName)) {
				SoftReference<Bitmap> reference = mFaceCache.get(faceName);
				bitmap = reference.get();
				if (bitmap != null) {
					return bitmap;
				}
			}
			bitmap = BitmapFactory.decodeResource(
					MainActivity.instance.getResources(), mFaces[position]);
			mFaceCache.put(faceName, new SoftReference<Bitmap>(bitmap));
			return bitmap;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 表情名称
	 */
	public static List<String> mFacesText = new ArrayList<String>();
	/**
	 * 表情缓存
	 */
	public static HashMap<String, SoftReference<Bitmap>> mFaceCache = new HashMap<String, SoftReference<Bitmap>>();

	/**
	 * 表情
	 */
	public static int[] mFaces = { R.drawable.face_0, R.drawable.face_1,
			R.drawable.face_2, R.drawable.face_3, R.drawable.face_4,
			R.drawable.face_5, R.drawable.face_6, R.drawable.face_7,
			R.drawable.face_8, R.drawable.face_9, R.drawable.face_10 };

	/**
	 * 当前用户的好友数据
	 */
	public static List<FriendsResult> mMyFriendsResults = new ArrayList<FriendsResult>();
	/**
	 * 当前用户的好友根据姓名首字母分组
	 */
	public static Map<String, List<FriendsResult>> mMyFriendsGroupByFirstName = new HashMap<String, List<FriendsResult>>();
	/**
	 * 当前用户的好友的姓名首字母在列表中的位置
	 */
	public static Map<String, Integer> mMyFriendsFirstNamePosition = new HashMap<String, Integer>();
	/**
	 * 当前用户的好友的姓名的首字母数据
	 */
	public static List<String> mMyFriendsFirstName = new ArrayList<String>();
	/**
	 * 当前用户的好友的姓名的首字母的在列表中的位置
	 */
	public static List<Integer> mMyFriendsPosition = new ArrayList<Integer>();

	/**
	 * 头像名称
	 */
	public static String[] mAvatars;
	/**
	 * 圆形头像缓存
	 */
	public static HashMap<String, SoftReference<Bitmap>> mAvatarCache = new HashMap<String, SoftReference<Bitmap>>();

	/**
	 * 默认头像
	 */
	public static Bitmap mDefault_Avatar;

	public static String allFriensJSON = "[{\"name\":\"韦泽鹏\",\"avatar\":\"0\",\"uid\":\"301\"},{\"name\":\"党森\",\"avatar\":\"1\",\"uid\":\"302\"},{\"name\":\"严钦\",\"avatar\":\"2\",\"uid\":\"303\"},{\"name\":\"徐建兴\",\"avatar\":\"3\",\"uid\":\"304\"},{\"name\":\"路飞\",\"avatar\":\"4\",\"uid\":\"2001\"},{\"name\":\"索隆\",\"avatar\":\"5\",\"uid\":\"2002\"},{\"name\":\"香吉\",\"avatar\":\"6\",\"uid\":\"2003\"},{\"name\":\"娜美\",\"avatar\":\"7\",\"uid\":\"2004\"},{\"name\":\"乌索普\",\"avatar\":\"7\",\"uid\":\"2005\"},{\"name\":\"乔巴\",\"avatar\":\"7\",\"uid\":\"2006\"},{\"name\":\"罗宾\",\"avatar\":\"7\",\"uid\":\"2007\"}]";

	static {
		mDefault_Avatar = PhotoUtil.toRoundCorner(
				BitmapFactory.decodeResource(
						MainActivity.instance.getResources(),
						R.drawable.random_head12), 15);
	}

	/**
	 * 根据编号获取用户圆形头像
	 */
	public static Bitmap getAvatar(int position) {
		try {
			String avatarName = mAvatars[position];
			Bitmap bitmap = null;
			if (mAvatarCache.containsKey(avatarName)) {
				SoftReference<Bitmap> reference = mAvatarCache.get(avatarName);
				bitmap = reference.get();
				if (bitmap != null) {
					return bitmap;
				}
			}
			bitmap = PhotoUtil.toRoundCorner(mDefault_Avatar, 15);
			mAvatarCache.put(avatarName, new SoftReference<Bitmap>(bitmap));
			return bitmap;
		} catch (Exception e) {
			return mDefault_Avatar;
		}
	}

	public static List<MyMsg> mMsgList = new ArrayList<MyMsg>();

	public static String msgJSON = "[{\"uid\":301,\"mid\":10,\"sender_id\":302,\"sender_name\":\"党森\",\"sender_headurl\":0,\"msg_time\":\"昨天  上午\",\"msg_content\":\"灯塔做的怎么样了\",\"msg_type\":1,\"aid\":0,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":9,\"sender_id\":303,\"sender_name\":\"严钦\",\"sender_headurl\":\"0\",\"msg_time\":\"昨天  下午\",\"msg_content\":\"U2B第二版还没改好？\",\"msg_type\":1,\"aid\":0,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":8,\"sender_id\":301,\"sender_name\":\"韦泽鹏\",\"sender_headurl\":\"0\",\"msg_time\":\"昨天  下午\",\"msg_content\":\"Android交流会 活动申请\",\"msg_type\":\"3\",\"aid\":3306,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":7,\"sender_id\":313,\"sender_name\":\"娜美\",\"sender_headurl\":\"0\",\"msg_time\":\"昨天  下午\",\"msg_content\":\"好友申请\",\"msg_type\":2,\"aid\":0,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":6,\"sender_id\":304,\"sender_name\":\"徐建兴\",\"sender_headurl\":\"0\",\"msg_time\":\"昨天  下午\",\"msg_content\":\"现在需要我做什么？\",\"msg_type\":1,\"aid\":0,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":5,\"sender_id\":312,\"sender_name\":\"香吉\",\"sender_headurl\":\"0\",\"msg_time\":\"昨天  下午\",\"msg_content\":\"6人行街头美食 活动答复\",\"msg_type\":4,\"aid\":3305,\"aagree\":1}]";

	/**
	 * 当前用户的资料数据
	 */
	public static UserMoreInfo mUserMoreInfo = null;

	public static List<UserMoreInfo> mList_UserMoreInfo = new ArrayList<UserMoreInfo>();

	public static String my_infoJSON = "[{\"name\":\"韦泽鹏\",\"avatar\":\"-1\",\"gender\":\"1\",\"constellation\":\"白羊座\",\"signature\":\"机会与挑战同在。\",\"photo_count\":\"0\",\"friend_count\":\"4\",\"wallpager\":\"-1\",\"date\":\"1992年3月29日\"}]";

	/**
	 * 壁纸名称
	 */
	public static String[] mTitleWallpagersName;

	/**
	 * 壁纸缓存
	 */
	public static HashMap<String, SoftReference<Bitmap>> mTitleWallpagersCache = new HashMap<String, SoftReference<Bitmap>>();

	static {
		try {
			mTitleWallpagersName = MainActivity.instance.getAssets().list(
					"title_wallpaper");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 默认标题壁纸
	 */
	public static Bitmap mDefault_TitleWallpager;
	static {
		mDefault_TitleWallpager = BitmapFactory.decodeResource(
				MainActivity.instance.getResources(), R.drawable.wall_pager1);
	}

	public static Bitmap getTitleWallpager(int position) {
		try {
			String titleWallpagerName = mTitleWallpagersName[position];
			Bitmap bitmap = null;
			if (mTitleWallpagersCache.containsKey(titleWallpagerName)) {
				SoftReference<Bitmap> reference = mTitleWallpagersCache
						.get(titleWallpagerName);
				bitmap = reference.get();
				if (bitmap != null) {
					return bitmap;
				}
			}
			bitmap = BitmapFactory.decodeStream(MainActivity.instance
					.getAssets().open("title_wallpager/" + titleWallpagerName));
			mTitleWallpagersCache.put(titleWallpagerName,
					new SoftReference<Bitmap>(bitmap));
			return bitmap;
		} catch (Exception e) {
			return mDefault_TitleWallpager;
		}
	}

	/**
	 * 当前壁纸编号
	 */
	public static int mWallpagerPosition = 0;

	public static Object mMyTimeStatus;

	public static List<ChatResult> mChatResults = new ArrayList<ChatResult>();

	public static String chatJSON = "[{\"uid\":\"10005\",\"head\":\"-1\",\"name\":\"党森\",\"time\":\"14:25:29\",\"content\":\"在么?,\",\"type\":\"2\"},"
			+ "{\"uid\":\"10005\",\"head\":\"-1\",\"name\":\"党森\",\"time\":\"14:26:28\",\"content\":\"灯塔做的怎么样了，我最近比较忙，也没时间看。\",\"type\":\"2\"},"
			+ "{\"uid\":\"10001\",\"head\":\"-1\",\"name\":\"韦泽鹏\",\"time\":\"14:26:59\",\"content\":\"这不快截止了，忙得不行了。\",\"type\":\"1\"},"
			+ "{\"uid\":\"10005\",\"head\":\"-1\",\"name\":\"党森\",\"time\":\"14:27:39\",\"content\":\"这么好的作品不被认可就可惜了。\",\"type\":\"2\"},"
			+ "{\"uid\":\"10001\",\"head\":\"-1\",\"name\":\"韦泽鹏\",\"time\":\"14:28:01\",\"content\":\"是啊，一定要做完啊，可压力上大，能用的时间我都用了，可是还是不够。\",\"type\":\"1\"},"
			+ "{\"uid\":\"10005\",\"head\":\"-1\",\"name\":\"党森\",\"time\":\"14:25:29\",\"content\":\"泽鹏加油，大家支持你。\",\"type\":\"2\"}]";

	/**
	 * 所有好友的资料数据 (Key对应该好友的uid)
	 */
	public static Map<String, UserMoreInfo> mFriendInfoResults = new HashMap<String, UserMoreInfo>();
	public static String friendInfoResultJSON = "{\"name\":\"严钦\",\"avatar\":\"0\",\"gender\":\"1\",\"constellation\":\"水瓶座\",\"signature\":\"今天真开心呢~~\",\"photo_count\":\"2\",\"friend_count\":\"5\",\"wallpager\":\"0\",\"date\":\"1990年1月1日\"}";

	/**
	 * 存放拍照上传的照片路径
	 */
	public static String mUploadPhotoPath;
	
	
	public static List<UserHotFriends> mHotFriendsList = new ArrayList<UserHotFriends>();

	
	public static List<ArrayList<Actives>> mHotF_A_List = new ArrayList<ArrayList<Actives>>();	
	

}
