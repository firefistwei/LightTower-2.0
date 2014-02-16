package gen.wzp.main.friends;

import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import gen.wzp.main.activity.AboutActivity;
import gen.wzp.main.activity.ChatActivity;
import gen.wzp.main.activity.PhotoActivity;
import gen.wzp.main.domain.UserMoreInfo;
import gen.wzp.main.utils.PhotoUtil;
import gen.wzp.main.utils.TextUtil;
import gen.wzp.main.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FriendInfoActivity extends Activity{

	private TextView mTitle;
	private ListView mDisplay;
	private View mHead;
	private ImageView mHead_Wallpager;
	private ImageView mHead_Avatar;
	private TextView mHead_Name;
	private ImageView mHead_Gender;
	private TextView mHead_Constellation;

	private TextView mHead_Sig;
	
	private Button mHead_Chat;
	
	private TextView mHead_About;
	private TextView mHead_Photo;
	private TextView mHead_Times;
	

	private FriendInfoAdapter mAdapter;

	private String mUid;// 当前用户的ID
	private String mName;// 当前用户的姓名
	private int mAvatar;// 当前用户的头像
	private UserMoreInfo mInfoResult;// 当前用户的资料数据
	
	Context mContext = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.friendinfo_activity);
		
	    getWindow().setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	    
		mHead = LayoutInflater.from(this).inflate(
				R.layout.friendinfo_activity_head, null);
		
		mContext = this;
		
		findViewById();
		setListener();
		init();
		
	}
	
	public void friendinfo_back(View v){
		this.finish();
	}

	private void findViewById() {
		
		mTitle = (TextView) findViewById(R.id.friendinfo_title);
		mDisplay = (ListView) findViewById(R.id.friendinfo_display);
		
		mHead_Chat = (Button) mHead.findViewById(R.id.friendinfo_head_chat);
		
		mHead_Wallpager = (ImageView) mHead
				.findViewById(R.id.friendinfo_head_wallpager);
		mHead_Avatar = (ImageView) mHead
				.findViewById(R.id.friendinfo_head_avatar);
		mHead_Name = (TextView) mHead.findViewById(R.id.friendinfo_head_name);
		mHead_Gender = (ImageView) mHead
				.findViewById(R.id.friendinfo_head_gender);
		mHead_Constellation = (TextView) mHead
				.findViewById(R.id.friendinfo_head_constellation);
		

		mHead_Sig = (TextView) mHead.findViewById(R.id.friendinfo_head_sig);
		mHead_About = (TextView) mHead.findViewById(R.id.friendinfo_head_about);
		mHead_Photo = (TextView) mHead.findViewById(R.id.friendinfo_head_photo);

		mHead_Times = (TextView) mHead
				.findViewById(R.id.friendinfo_head_times);

	}

	private void setListener() {
		
		mHead_Chat.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 跳转到聊天界面并传递姓名和头像
				Intent intent = new Intent();
				intent.setClass(FriendInfoActivity.this, ChatActivity.class);
				intent.putExtra("name", mName);
				intent.putExtra("avatar", mAvatar);
				startActivity(intent);
			}
		});
		
		mHead_About.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 跳转到关于界面并传递ID和资料
				Intent intent = new Intent();
				intent.setClass(FriendInfoActivity.this, AboutActivity.class);
				intent.putExtra("uid", mUid);
				intent.putExtra("result", mInfoResult);
				startActivity(intent);
			}
		});
		mHead_Photo.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 跳转到照片界面并传递ID和姓名
				Intent intent = new Intent();
				intent.setClass(FriendInfoActivity.this, PhotoActivity.class);
				intent.putExtra("uid", mUid);
				intent.putExtra("name", mName);
				startActivity(intent);
			}
		});
		mHead_Times.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 跳转到日记界面并传递ID和姓名
				Intent intent = new Intent();
				intent.setClass(FriendInfoActivity.this, ChatActivity.class);
				intent.putExtra("uid", mUid);
				intent.putExtra("name", mName);
				startActivity(intent);
			}
		});
		
	}

	private void init() {
		// 接收用户的ID、姓名、头像
		mUid = getIntent().getStringExtra("uid");
		mName = getIntent().getStringExtra("name");
		mAvatar = getIntent().getIntExtra("avatar", -1);
		// 获取资料
		getInfo();
		
		/*// 获取状态
		getStatus();*/
		// 根据用户ID显示界面内容,ID为空时代表为当前用户资料则隐藏聊天和送礼物功能
		if (mUid == null) {
			mTitle.setText("TA的资料");
			mHead_Chat.setVisibility(View.GONE);
			
			/*mAdapter = new FriendInfoAdapter(FriendInfoActivity.this,
					MyConstants.mMyStatusResults,
					MyConstants.getAvatar(mAvatar));*/
		} else {
			mTitle.setText(mName);
			mHead_Chat.setVisibility(View.VISIBLE);
			/*
			if (MyConstants.mFriendStatusResults.containsKey(mUid)) {
				mAdapter = new FriendInfoAdapter(FriendInfoActivity.this,
						MyConstants.mFriendStatusResults.get(mUid),
						MyConstants.getAvatar(mAvatar));
			} else {
				mAdapter = new FriendInfoAdapter(FriendInfoActivity.this, null,
						MyConstants.getAvatar(mAvatar));*/
			}
		
	
	    mAdapter  = new FriendInfoAdapter();
		// 添加头布局和适配器
		mDisplay.addHeaderView(mHead);
		mDisplay.setAdapter(mAdapter);
	}

	/**
	 * 获取用户资料
	 */
	private void getInfo() {
		// ID为空代表为当前用户数据
				if (mUid == null) {
					if (MyConstants.mUserMoreInfo == null) {
						InputStream inputStream;
						MyConstants.mUserMoreInfo = new UserMoreInfo();
						try {
							String json = MyConstants.my_infoJSON;
							JSONObject object = new JSONObject(json);
					/*		MyConstants.mUserMoreInfo.setName(object
									.getString("name"));
							MyConstants.mUserMoreInfo.setAvatar(object
									.getInt("avatar"));
							MyConstants.mUserMoreInfo.setGender(object
									.getInt("gender"));
							MyConstants.mUserMoreInfo.setConstellation(object
									.getString("constellation"));
							MyConstants.mUserMoreInfo.setSignature(object
									.getString("signature"));
							MyConstants.mUserMoreInfo.setPhoto_count(object
									.getInt("photo_count"));
							MyConstants.mUserMoreInfo.setFriend_count(object
									.getInt("friend_count"));
							MyConstants.mUserMoreInfo.setWallpager(object
									.getInt("wallpager"));
							MyConstants.mUserMoreInfo.setDate(object
									.getString("date"));*/
							mInfoResult = MyConstants.mUserMoreInfo;
							setInfo();
						} catch (JSONException e) {
							e.printStackTrace();
						}
					} else {
						mInfoResult = MyConstants.mUserMoreInfo;
						setInfo();
					}
		} else {
			if (MyConstants.mFriendInfoResults.containsKey(mUid)) {
				mInfoResult = MyConstants.mFriendInfoResults.get(mUid);
				setInfo();
			} else {

				mInfoResult = new UserMoreInfo();
				try {
					
					String json = MyConstants.friendInfoResultJSON;
					JSONObject object = new JSONObject(json);
/*					mInfoResult.setName(object.getString("name"));
					mInfoResult.setAvatar(object.getInt("avatar"));
					mInfoResult.setGender(object.getInt("gender"));
					mInfoResult.setConstellation(object
							.getString("constellation"));
					mInfoResult.setSignature(object.getString("signature"));
					mInfoResult.setPhoto_count(object.getInt("photo_count"));
					
					mInfoResult.setFriend_count(object.getInt("friend_count"));
					
					mInfoResult.setWallpager(object.getInt("wallpager"));
					mInfoResult.setDate(object.getString("date"));*/
					MyConstants.mFriendInfoResults.put(mUid, mInfoResult);
					setInfo();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 添加资料数据显示到界面上
	 */
	private void setInfo() {
/*		mHead_Name.setText(mInfoResult.getName());
		mHead_Avatar.setImageBitmap(MyConstants.getAvatar(mInfoResult
				.getAvatar()));
		mHead_Gender.setImageBitmap(Utils.getGender(getResources(),
				mInfoResult.getGender()));
		mHead_Constellation.setText(mInfoResult.getConstellation());
		mHead_Sig.setText(new TextUtil().replace(mInfoResult
				.getSignature()));
		mHead_About.setText("关于");
		mHead_Photo.setText("照片 " + mInfoResult.getPhoto_count());
		

		mHead_Wallpager.setImageBitmap(MyConstants
				.getTitleWallpager(mInfoResult.getWallpager()));*/
	}

	
/*
	*//**
	 * 获取用户的状态数据
	 *//*
	private void getStatus() {
		// ID为空代表为当前用户数据
		if (mUid == null) {
			if (mKXApplication.mMyStatusResults.isEmpty()) {
				InputStream inputStream;
				try {
					inputStream = getAssets().open("data/my_status.KX");
					String json = new TextUtil(mKXApplication)
							.readTextFile(inputStream);
					JSONArray array = new JSONArray(json);
					StatusResult result = null;
					for (int i = 0; i < array.length(); i++) {
						result = new StatusResult();
						result.setName(array.getJSONObject(i).getString("name"));
						result.setTime(array.getJSONObject(i).getString("time"));
						result.setContent(array.getJSONObject(i).getString(
								"content"));
						result.setFrom(array.getJSONObject(i).getString("from"));
						result.setComment_count(array.getJSONObject(i).getInt(
								"comment_count"));
						result.setForward_count(array.getJSONObject(i).getInt(
								"forward_count"));
						result.setLike_count(array.getJSONObject(i).getInt(
								"like_count"));
						mKXApplication.mMyStatusResults.add(result);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} else {
			if (!mKXApplication.mFriendStatusResults.containsKey(mUid)) {
				InputStream inputStream;
				try {
					inputStream = getAssets().open(
							"data/" + mUid + "_status.KX");
					String json = new TextUtil(mKXApplication)
							.readTextFile(inputStream);
					JSONArray array = new JSONArray(json);
					StatusResult result = null;
					List<StatusResult> list = new ArrayList<StatusResult>();
					for (int i = 0; i < array.length(); i++) {
						result = new StatusResult();
						result.setName(array.getJSONObject(i).getString("name"));
						result.setTime(array.getJSONObject(i).getString("time"));
						result.setContent(array.getJSONObject(i).getString(
								"content"));
						result.setFrom(array.getJSONObject(i).getString("from"));
						result.setComment_count(array.getJSONObject(i).getInt(
								"comment_count"));
						result.setForward_count(array.getJSONObject(i).getInt(
								"forward_count"));
						result.setLike_count(array.getJSONObject(i).getInt(
								"like_count"));
						list.add(result);
					}
					mKXApplication.mFriendStatusResults.put(mUid, list);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
	}
*/
	private class FriendInfoAdapter extends BaseAdapter {



		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.friendinfo_activity_item, null);
				holder = new ViewHolder();
				holder.avatar = (ImageView) convertView
						.findViewById(R.id.friendinfo_item_avatar);
				holder.name = (TextView) convertView
						.findViewById(R.id.friendinfo_item_name);
				holder.time = (TextView) convertView
						.findViewById(R.id.friendinfo_item_time);
				holder.content = (TextView) convertView
						.findViewById(R.id.friendinfo_item_content);
				
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			// 添加状态信息到界面
/*			StatusResult result = mResults.get(position);
			holder.avatar.setImageBitmap(mAvatar);
			holder.name.setText(result.getName());
			holder.time.setText(result.getTime());
			holder.content.setText(result.getContent());
			holder.from.setText(result.getFrom());
			holder.comment_count.setText(result.getComment_count() + "");
			holder.forward_count.setText(result.getForward_count() + "");
			holder.like_count.setText(result.getLike_count() + "");*/
			return convertView;
		}

		class ViewHolder {
			ImageView avatar;
			TextView name;
			TextView time;
			TextView content;
			TextView from;
			TextView comment_count;
			TextView forward_count;
			TextView like_count;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
	}


}
