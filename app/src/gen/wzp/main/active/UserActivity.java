package gen.wzp.main.active;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import gen.wzp.main.Constants;
import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import gen.wzp.main.activity.AboutActivity;
import gen.wzp.main.activity.Achievement;
import gen.wzp.main.activity.PhotoActivity;
import gen.wzp.main.activity.TimeGrid;
import gen.wzp.main.domain.Actives;
import gen.wzp.main.utils.PhotoUtil;
import gen.wzp.main.utils.TextUtil;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class UserActivity extends Activity {

	private View headView;
	// 头布局控件
	private ImageView mHead_Wallpager;
	private ImageView mHead_Avatar;
	private TextView mHead_Name;
	private ImageView mHead_Gender;
	private TextView mHead_Level;
	private LinearLayout mHead_Sig_Layout;
	private TextView mHead_Sig;
	private TextView mHead_About;
	private TextView mHead_Photo;

	private TextView mHead_Actives;

	Context mContext = null;

	// 显示内容的ListView以及适配器
	private ListView mDisplay;
	private ActivesAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.user_activity);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		mContext = this;
		headView = LayoutInflater.from(this).inflate(R.layout.user_info_head,
				null);

		findViewById();
		setListener();
		init();
	}

	public void user_activity_back(View v) {
		this.finish();
	}

	public void time_grid_btn(View v) {
		Intent intent = new Intent(UserActivity.this, TimeGrid.class);
		startActivity(intent);
	}

	@Override
	protected void onResume() {
		super.onResume();
		((ImageView) this.findViewById(R.id.time_grid_img))
				.setImageResource(MyConstants.Time_box[Constants.time_style]);
		((TextView) this.findViewById(R.id.time_status_text)).setText("时间状态："
				+ MyConstants.Time_text[Constants.time_style]);
	}

	private void findViewById() {
		mHead_Wallpager = (ImageView) headView
				.findViewById(R.id.user_info_head_wallpager);
		mHead_Avatar = (ImageView) headView
				.findViewById(R.id.user_info_head_avatar);
		mHead_Name = (TextView) headView.findViewById(R.id.user_info_head_name);
		mHead_Gender = (ImageView) headView
				.findViewById(R.id.user_info_head_gender);
		mHead_Level = (TextView) headView
				.findViewById(R.id.user_info_head_level);
		mHead_Sig_Layout = (LinearLayout) headView
				.findViewById(R.id.user_info_head_sig_layout);
		mHead_Sig = (TextView) headView.findViewById(R.id.user_info_head_sig);

		mHead_About = (TextView) headView
				.findViewById(R.id.user_info_head_about);
		mHead_Photo = (TextView) headView
				.findViewById(R.id.user_info_head_photo);

		mHead_Actives = (TextView) headView
				.findViewById(R.id.user_info_head_actives);

		mDisplay = (ListView) this.findViewById(R.id.user_info_display);
	}

	private void setListener() {
		// 墙纸监听
		/*
		 * mHead_Wallpager.setOnClickListener(new OnClickListener() {
		 * 
		 * public void onClick(View v) { // 跳转到修改墙纸界面 startActivityForResult(new
		 * Intent(mContext, ChangeWallpagerActivity.class),
		 * ActivityForResultUtil.REQUESTCODE_CHANGEWALLPAGER); } }); // 头像监听
		 * mHead_Avatar.setOnClickListener(new OnClickListener() {
		 * 
		 * public void onClick(View v) {
		 * 
		 * } });
		 * 
		 * // 签名监听 mHead_Sig_Layout.setOnClickListener(new OnClickListener() {
		 * 
		 * public void onClick(View v) { // 跳转到修改签名界面 startActivityForResult(new
		 * Intent(mContext, EditSignatureActivity.class),
		 * ActivityForResultUtil.REQUESTCODE_EDITSIGNATURE);
		 * 
		 * } });
		 */

		// 关于监听
		mHead_About.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 跳转到关于界面
				Intent intent = new Intent();
				intent.setClass(mContext, AboutActivity.class);

				intent.putExtra("result", MyConstants.mUserMoreInfo);
				mContext.startActivity(intent);
			}
		});
		// 照片监听
		mHead_Photo.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 跳转到照片界面
				mContext.startActivity(new Intent(mContext, PhotoActivity.class));
			}
		});

		// 好友监听
		mHead_Actives.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(UserActivity.this, Achievement.class);
				startActivity(intent);

			}
		});

	}

	private void init() {

		showInfo();
		mDisplay.addHeaderView(headView);

		getMyActives();
		mAdapter = new ActivesAdapter();
		mDisplay.setAdapter(mAdapter);
	}

	private void getMyActives() {
		if (MyConstants.wzpActivesList.isEmpty()) {
			String json = MyConstants.wzpActivesJSON;
			try {
				JSONArray array = new JSONArray(json);
				Actives mActives = null;
				for (int i = 0; i < array.length(); i++) {
					mActives = new Actives();
					mActives.setUid(array.getJSONObject(i).getInt("uid"));
					mActives.setUheadurl(array.getJSONObject(i).getString(
							"uheadurl"));
					mActives.setAname(array.getJSONObject(i).getString("aname"));

					mActives.setAid(array.getJSONObject(i).getInt("aid"));
					mActives.setAname(array.getJSONObject(i).getString("aname"));
					mActives.setAtime(array.getJSONObject(i).getString("atime"));

					mActives.setTojoin(array.getJSONObject(i).getInt("tojoin"));
					mActives.setEnable(array.getJSONObject(i).getInt("enable"));
					mActives.setIsfinished(array.getJSONObject(i).getInt(
							"isfinished"));

					MyConstants.wzpActivesList.add(mActives);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private void showInfo() {
		// 界面的数据赋值
		mHead_Name.setText(Constants.me_name);

		Bitmap head = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.random_head0);
		Bitmap head_bp = PhotoUtil.toRoundCorner(head, 15);
		mHead_Avatar.setImageBitmap(head_bp);

		if (Constants.me_sex == 1) {
			mHead_Gender.setImageResource(R.drawable.sex_1);
		} else {
			mHead_Gender.setImageResource(R.drawable.sex_2);
		}

		mHead_Level.setText(Constants.me_level);
		mHead_Sig.setText(Constants.me_sig);

		mHead_About.setText("资料");
		mHead_Photo.setText("照片");

		mHead_Actives.setText("活动 ");

		/**
		 * 原有的墙纸取消,采用随机的墙纸,这样保证每次进入都不一样,其他用户采用自己设定的墙纸显示,如注释掉的代码
		 * 
		 */

		int r = (int) (Math.random() * 5 + 0.5);
		Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
				MyConstants.Wall_pager[r]);
		mHead_Wallpager.setImageBitmap(bitmap);

	}

	/**
	 * 修改墙纸
	 */
	public void setWallpager() {
		mHead_Wallpager.setImageBitmap(MyConstants
				.getTitleWallpager(MyConstants.mWallpagerPosition));
	}

	/**
	 * 修改签名
	 * 
	 * @param arg0
	 *            修改的签名文本
	 */
	public void setSignature(String arg0) {
		mHead_Sig.setText(new TextUtil().replace(arg0));
	}

	/**
	 * 修改头像
	 * 
	 * @param bitmap
	 *            修改的头像
	 */
	public void setAvatar(Bitmap bitmap) {
		mHead_Avatar.setImageBitmap(bitmap);
	}

	private class ActivesAdapter extends BaseAdapter {

		private List<Actives> mActives;

		public ActivesAdapter() {
			if (MyConstants.wzpActivesList != null) {
				mActives = MyConstants.wzpActivesList;
			} else {
				mActives = new ArrayList<Actives>();
			}
		}

		@Override
		public int getCount() {
			return mActives.size();
		}

		@Override
		public Object getItem(int position) {
			return mActives.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.user_info_item, null);
				holder = new ViewHolder();
				holder.avatar = (ImageView) convertView
						.findViewById(R.id.user_info_item_avatar);
				holder.name = (TextView) convertView
						.findViewById(R.id.user_info_item_name);
				holder.time = (TextView) convertView
						.findViewById(R.id.user_info_item_time);
				holder.content = (TextView) convertView
						.findViewById(R.id.user_info_item_content);
				holder.tojoin = (TextView) convertView
						.findViewById(R.id.user_info_item_tojoin);
				holder.enable = (TextView) convertView
						.findViewById(R.id.user_info_item_enable);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			Actives active = mActives.get(position);

			Bitmap avatar = PhotoUtil.toRoundCorner(BitmapFactory
					.decodeResource(mContext.getResources(),
							R.drawable.random_head0), 20);
			holder.avatar.setImageBitmap(avatar);

			holder.time.setText(active.getAtime());
			holder.content.setText(active.getAname());

			if (active.getTojoin() == 0) {
				holder.tojoin.setText("发布了");
			} else {
				holder.tojoin.setText("参与了");
			}

			if (active.getIsfinished() == 0) {
				holder.enable.setText("未结束");
			} else {
				holder.enable.setText("已结束");
				holder.enable.setTextColor(Color.RED);
			}
			holder.name.setText(active.getUname()); // /??? Why不出现

			return convertView;
		}

		class ViewHolder {
			ImageView avatar;
			TextView name;
			TextView tojoin;
			TextView time;
			TextView content;
			TextView enable;
		}

	}

}
