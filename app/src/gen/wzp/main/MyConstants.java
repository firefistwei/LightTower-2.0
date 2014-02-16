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
	public static String activeJSON = "[{\"uid\":301,\"aid\":17,\"atype\":1,\"aname\":\"3+3�漴���������\",\"atime\":\"����  4:20PM\",\"aposition\":\"��԰�̲��\",\"amember\":\"301+302+303\",\"apeople_no\":\"1/10\",\"adescrip\":\"��լ�ˣ��������ģ���ʶ�µ�����.\\r\\n3+3��һ�����İ���˽����Ļ��Ҫ��ʼ��������Ҫ3������ ��3��Ů������Ҫ���Ծ�ĳ������������ۣ��Ӷ���լլ������ʹ���Ǳ�լ�Ļ��������������������潻����\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0},"
			+ "{\"uid\":302,\"aid\":11,\"atype\":1,\"aname\":\"ħ��������ս\",\"atime\":\"����  20:20\",\"aposition\":\"1310����\",\"amember\":\"302\",\"apeople_no\":\"1/2\",\"adescrip\":\"û������ħ���糤������ս��\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0},"
			+ "{\"uid\":303,\"aid\":5,\"atype\":1,\"aname\":\"ƹ���������ս\",\"atime\":\"����  20:20\",\"aposition\":\"�ٳ�ƹ����\",\"amember\":\"303\",\"apeople_no\":\"1/2\",\"adescrip\":\"˭Ҫ��ƹ���򣬺Ǻǣ������MM,�Ǻǣ������Դ����Ǻ�\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0},"
			+ "{\"uid\":304,\"aid\":3,\"atype\":1,\"aname\":\"android��������\",\"atime\":\"����  8:20PM\",\"aposition\":\"1�Ž�ѧ¥ǰ\",\"amember\":\"304\",\"apeople_no\":\"1/10\",\"adescrip\":\"��׿���˽����ᣬ��Ҫ���Ŷ��Ҳ��ı�������뷨�������ﵮ��Ŷ��\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0},"
			+ "{\"uid\":301,\"aid\":9,\"atype\":1,\"aname\":\"�ٳ��ܲ���һ��\",\"atime\":\"����  9:30PM\",\"aposition\":\"�ٳ��ﾶ��\",\"amember\":\"301\",\"apeople_no\":\"1/5\",\"adescrip\":\"�����Ǹ����ı�Ǯ�������ң�������һ���ܲ���\",\"alongi\":\"108.876082087\",\"alatitude\":\"34.1502375676\",\"isfull\":0,\"isfinished\":0}]";
	
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

	
	//ʱ��״̬
	public static int Time_box[]={R.drawable.time_type_0,R.drawable.time_type_1,
		R.drawable.time_type_2,R.drawable.time_type_3,R.drawable.time_type_4,
		R.drawable.time_type_5,R.drawable.time_type_6,R.drawable.time_type_7,	
	};
	
	public static String Time_text[]={"ʲô��û��","�ܶ�","��ɢ", "�󹴴�","������","�԰���","������","�Զ���"};
	
	public static List<Actives> wzpActivesList = new ArrayList<Actives>();
	public static String wzpActivesJSON = "[{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"Τ����\",\"aid\":5,\"aname\":\"3+3������������\",\"atime\":\"5-30 4��20PM\",\"tojoin\":0,\"enable\":-1,\"isfinished\":0}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"Τ����\",\"aid\":3,\"aname\":\"6���гԽ�ͷ��ʳ\",\"atime\":\"5-28 10:20AM\",\"tojoin\":1,\"enable\":0,\"isfinished\":0}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"Τ����\",\"aid\":3,\"aname\":\"2V2ħ����ս\",\"atime\":\"5-22 4:30AM\",\"tojoin\":1,\"enable\":1,\"isfinished\":1}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"Τ����\",\"aid\":4,\"aname\":\"Android�������ۻ�\",\"atime\":\"5-26 8��20PM\",\"tojoin\":0,\"enable\":-1,\"isfinished\":0}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"Τ����\",\"aid\":3,\"aname\":\"2+2����Դ��\",\"atime\":\"5-23 11:30AM\",\"tojoin\":1,\"enable\":1,\"isfinished\":1}," +
			"{\"uid\":301,\"uheadurl\":\"0\",\"uname\":\"Τ����\",\"aid\":2,\"aname\":\"ѧ�㣬������Է�\",\"atime\":\"5-20 6��20PM\",\"tojoin\":0,\"enable\":-1,\"isfinished\":1}]";

	/**
	 * ���ݱ�Ż�ȡ����ͼƬ
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
	 * ��������
	 */
	public static List<String> mFacesText = new ArrayList<String>();
	/**
	 * ���黺��
	 */
	public static HashMap<String, SoftReference<Bitmap>> mFaceCache = new HashMap<String, SoftReference<Bitmap>>();

	/**
	 * ����
	 */
	public static int[] mFaces = { R.drawable.face_0, R.drawable.face_1,
			R.drawable.face_2, R.drawable.face_3, R.drawable.face_4,
			R.drawable.face_5, R.drawable.face_6, R.drawable.face_7,
			R.drawable.face_8, R.drawable.face_9, R.drawable.face_10 };

	/**
	 * ��ǰ�û��ĺ�������
	 */
	public static List<FriendsResult> mMyFriendsResults = new ArrayList<FriendsResult>();
	/**
	 * ��ǰ�û��ĺ��Ѹ�����������ĸ����
	 */
	public static Map<String, List<FriendsResult>> mMyFriendsGroupByFirstName = new HashMap<String, List<FriendsResult>>();
	/**
	 * ��ǰ�û��ĺ��ѵ���������ĸ���б��е�λ��
	 */
	public static Map<String, Integer> mMyFriendsFirstNamePosition = new HashMap<String, Integer>();
	/**
	 * ��ǰ�û��ĺ��ѵ�����������ĸ����
	 */
	public static List<String> mMyFriendsFirstName = new ArrayList<String>();
	/**
	 * ��ǰ�û��ĺ��ѵ�����������ĸ�����б��е�λ��
	 */
	public static List<Integer> mMyFriendsPosition = new ArrayList<Integer>();

	/**
	 * ͷ������
	 */
	public static String[] mAvatars;
	/**
	 * Բ��ͷ�񻺴�
	 */
	public static HashMap<String, SoftReference<Bitmap>> mAvatarCache = new HashMap<String, SoftReference<Bitmap>>();

	/**
	 * Ĭ��ͷ��
	 */
	public static Bitmap mDefault_Avatar;

	public static String allFriensJSON = "[{\"name\":\"Τ����\",\"avatar\":\"0\",\"uid\":\"301\"},{\"name\":\"��ɭ\",\"avatar\":\"1\",\"uid\":\"302\"},{\"name\":\"����\",\"avatar\":\"2\",\"uid\":\"303\"},{\"name\":\"�콨��\",\"avatar\":\"3\",\"uid\":\"304\"},{\"name\":\"·��\",\"avatar\":\"4\",\"uid\":\"2001\"},{\"name\":\"��¡\",\"avatar\":\"5\",\"uid\":\"2002\"},{\"name\":\"�㼪\",\"avatar\":\"6\",\"uid\":\"2003\"},{\"name\":\"����\",\"avatar\":\"7\",\"uid\":\"2004\"},{\"name\":\"������\",\"avatar\":\"7\",\"uid\":\"2005\"},{\"name\":\"�ǰ�\",\"avatar\":\"7\",\"uid\":\"2006\"},{\"name\":\"�ޱ�\",\"avatar\":\"7\",\"uid\":\"2007\"}]";

	static {
		mDefault_Avatar = PhotoUtil.toRoundCorner(
				BitmapFactory.decodeResource(
						MainActivity.instance.getResources(),
						R.drawable.random_head12), 15);
	}

	/**
	 * ���ݱ�Ż�ȡ�û�Բ��ͷ��
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

	public static String msgJSON = "[{\"uid\":301,\"mid\":10,\"sender_id\":302,\"sender_name\":\"��ɭ\",\"sender_headurl\":0,\"msg_time\":\"����  ����\",\"msg_content\":\"����������ô����\",\"msg_type\":1,\"aid\":0,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":9,\"sender_id\":303,\"sender_name\":\"����\",\"sender_headurl\":\"0\",\"msg_time\":\"����  ����\",\"msg_content\":\"U2B�ڶ��滹û�ĺã�\",\"msg_type\":1,\"aid\":0,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":8,\"sender_id\":301,\"sender_name\":\"Τ����\",\"sender_headurl\":\"0\",\"msg_time\":\"����  ����\",\"msg_content\":\"Android������ �����\",\"msg_type\":\"3\",\"aid\":3306,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":7,\"sender_id\":313,\"sender_name\":\"����\",\"sender_headurl\":\"0\",\"msg_time\":\"����  ����\",\"msg_content\":\"��������\",\"msg_type\":2,\"aid\":0,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":6,\"sender_id\":304,\"sender_name\":\"�콨��\",\"sender_headurl\":\"0\",\"msg_time\":\"����  ����\",\"msg_content\":\"������Ҫ����ʲô��\",\"msg_type\":1,\"aid\":0,\"aagree\":-1},"
			+ "{\"uid\":301,\"mid\":5,\"sender_id\":312,\"sender_name\":\"�㼪\",\"sender_headurl\":\"0\",\"msg_time\":\"����  ����\",\"msg_content\":\"6���н�ͷ��ʳ ���\",\"msg_type\":4,\"aid\":3305,\"aagree\":1}]";

	/**
	 * ��ǰ�û�����������
	 */
	public static UserMoreInfo mUserMoreInfo = null;

	public static List<UserMoreInfo> mList_UserMoreInfo = new ArrayList<UserMoreInfo>();

	public static String my_infoJSON = "[{\"name\":\"Τ����\",\"avatar\":\"-1\",\"gender\":\"1\",\"constellation\":\"������\",\"signature\":\"��������սͬ�ڡ�\",\"photo_count\":\"0\",\"friend_count\":\"4\",\"wallpager\":\"-1\",\"date\":\"1992��3��29��\"}]";

	/**
	 * ��ֽ����
	 */
	public static String[] mTitleWallpagersName;

	/**
	 * ��ֽ����
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
	 * Ĭ�ϱ����ֽ
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
	 * ��ǰ��ֽ���
	 */
	public static int mWallpagerPosition = 0;

	public static Object mMyTimeStatus;

	public static List<ChatResult> mChatResults = new ArrayList<ChatResult>();

	public static String chatJSON = "[{\"uid\":\"10005\",\"head\":\"-1\",\"name\":\"��ɭ\",\"time\":\"14:25:29\",\"content\":\"��ô?,\",\"type\":\"2\"},"
			+ "{\"uid\":\"10005\",\"head\":\"-1\",\"name\":\"��ɭ\",\"time\":\"14:26:28\",\"content\":\"����������ô���ˣ�������Ƚ�æ��Ҳûʱ�俴��\",\"type\":\"2\"},"
			+ "{\"uid\":\"10001\",\"head\":\"-1\",\"name\":\"Τ����\",\"time\":\"14:26:59\",\"content\":\"�ⲻ���ֹ�ˣ�æ�ò����ˡ�\",\"type\":\"1\"},"
			+ "{\"uid\":\"10005\",\"head\":\"-1\",\"name\":\"��ɭ\",\"time\":\"14:27:39\",\"content\":\"��ô�õ���Ʒ�����ϿɾͿ�ϧ�ˡ�\",\"type\":\"2\"},"
			+ "{\"uid\":\"10001\",\"head\":\"-1\",\"name\":\"Τ����\",\"time\":\"14:28:01\",\"content\":\"�ǰ���һ��Ҫ���갡����ѹ���ϴ����õ�ʱ���Ҷ����ˣ����ǻ��ǲ�����\",\"type\":\"1\"},"
			+ "{\"uid\":\"10005\",\"head\":\"-1\",\"name\":\"��ɭ\",\"time\":\"14:25:29\",\"content\":\"�������ͣ����֧���㡣\",\"type\":\"2\"}]";

	/**
	 * ���к��ѵ��������� (Key��Ӧ�ú��ѵ�uid)
	 */
	public static Map<String, UserMoreInfo> mFriendInfoResults = new HashMap<String, UserMoreInfo>();
	public static String friendInfoResultJSON = "{\"name\":\"����\",\"avatar\":\"0\",\"gender\":\"1\",\"constellation\":\"ˮƿ��\",\"signature\":\"�����濪����~~\",\"photo_count\":\"2\",\"friend_count\":\"5\",\"wallpager\":\"0\",\"date\":\"1990��1��1��\"}";

	/**
	 * ��������ϴ�����Ƭ·��
	 */
	public static String mUploadPhotoPath;
	
	
	public static List<UserHotFriends> mHotFriendsList = new ArrayList<UserHotFriends>();

	
	public static List<ArrayList<Actives>> mHotF_A_List = new ArrayList<ArrayList<Actives>>();	
	

}
