package gen.wzp.main.active;

import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import gen.wzp.main.domain.MyActive;
import gen.wzp.main.utils.PhotoUtil;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ActiveLight extends Activity {

	private Button myAround;
	private Button myFriend;
	private ListView mListView;

	private MyAdapter mAdapter;

	private boolean isMyFriend = false;

	Context mContext = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.active_main);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		mContext = this;

		findViewById();
		setListener();
		init();
	}
	
	public void active_main_person(View v){
		Intent intent = new Intent(ActiveLight.this,UserActivity.class);
		startActivity(intent);
	}

	private void findViewById() {

		myAround = (Button) this.findViewById(R.id.active_btn_around);
		myFriend = (Button) this.findViewById(R.id.active_btn_friend);
		mListView = (ListView) this.findViewById(R.id.active_listview);

	}

	private void setListener() {

		myAround.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isMyFriend) {
					isMyFriend = false;
					myAround.setBackgroundResource(R.drawable.bottomtabbutton_leftred);
					myFriend.setBackgroundResource(R.drawable.bottomtabbutton_rightwhite);
					mAdapter = new MyAdapter();

					mListView.setAdapter(mAdapter);
				}
			}
		});

		myFriend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!isMyFriend) {
					isMyFriend = true;
					myAround.setBackgroundResource(R.drawable.bottomtabbutton_leftwhite);
					myFriend.setBackgroundResource(R.drawable.bottomtabbutton_rightred);
					mAdapter = new MyAdapter();

					mListView.setAdapter(mAdapter);
				}

			}

		});
		
		
	}

	private void init() {
		getAroundData();
		getFriendData();

		mAdapter = new MyAdapter();
		mListView.setAdapter(mAdapter);

		//setListViewHeightBasedOnChildren(mListView);
		
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				
				Intent intent = new Intent(ActiveLight.this,OneActive.class);
				intent.putExtra("active_position",position);
				intent.putExtra("uid", MyConstants.mActiveList.get(position).getUid());
				
				startActivity(intent);
				
			}
		});
	}
	

	private void getAroundData() {
		if (MyConstants.mActiveList.isEmpty()) {
			String json = MyConstants.activeJSON;
			try {
				JSONArray array = new JSONArray(json);
				MyActive myActive = null;
				for (int i = 0; i < array.length(); i++) {
					myActive = new MyActive();
					myActive.setUid(array.getJSONObject(i).getInt("uid"));
					myActive.setAid(array.getJSONObject(i).getInt("aid"));
					myActive.setAtype(array.getJSONObject(i).getInt("atype"));
					myActive.setAname(array.getJSONObject(i).getString("aname"));
					myActive.setAtime(array.getJSONObject(i).getString("atime"));
					myActive.setAposition(array.getJSONObject(i).getString(
							"aposition"));
					myActive.setAmember(array.getJSONObject(i).getString(
							"amember"));
					myActive.setApeople_no(array.getJSONObject(i).getString(
							"apeople_no"));
					myActive.setAdescrip(array.getJSONObject(i).getString(
							"adescrip"));
					myActive.setAlongi(array.getJSONObject(i).getDouble(
							"alongi"));
					myActive.setAlatitude(array.getJSONObject(i).getDouble(
							"alatitude"));
					myActive.setIsfull(array.getJSONObject(i).getInt("isfull"));
					myActive.setIsfinished(array.getJSONObject(i).getInt("isfinished"));

					MyConstants.mActiveList.add(myActive);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private void getFriendData() {
		if (MyConstants.mActiveFriendsList.isEmpty()) {
			String json = MyConstants.activeJSON;
			try {
				JSONArray array = new JSONArray(json);
				MyActive myActive = null;
				for (int i = 0; i < array.length(); i=i +(int)(Math.random()*3+1.5)) {
					myActive = new MyActive();
					myActive.setUid(array.getJSONObject(i).getInt("uid"));
					myActive.setAid(array.getJSONObject(i).getInt("aid"));
					myActive.setAtype(array.getJSONObject(i).getInt("atype"));
					myActive.setAname(array.getJSONObject(i).getString("aname"));
					myActive.setAtime(array.getJSONObject(i).getString("atime"));
					myActive.setAposition(array.getJSONObject(i).getString(
							"aposition"));
					myActive.setAmember(array.getJSONObject(i).getString(
							"amember"));
					myActive.setApeople_no(array.getJSONObject(i).getString(
							"apeople_no"));
//					myActive.setAdescrip(array.getJSONObject(i).getString(
//							"adescrip"));
					myActive.setAdescrip("附近200米");
					myActive.setAlongi(array.getJSONObject(i).getDouble(
							"alongi"));
					myActive.setAlatitude(array.getJSONObject(i).getDouble(
							"alatitude"));
					myActive.setIsfull(array.getJSONObject(i).getInt("isfull"));
					myActive.setIsfinished(array.getJSONObject(i).getInt("isfinished"));

					MyConstants.mActiveFriendsList.add(myActive);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private class MyAdapter extends BaseAdapter {

		private List<MyActive> mList= null;

		public MyAdapter() {
			
			if(!isMyFriend){
				mList = MyConstants.mActiveList;
			} else {
				mList = MyConstants.mActiveFriendsList;
			}	
			
		}

		@Override
		public int getCount() {
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			return mList.get(position);
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
						R.layout.home_activ_item, null);
				holder = new ViewHolder();
				holder.avatar = (ImageView) convertView
						.findViewById(R.id.home_activ_img1);
				holder.title = (TextView) convertView
						.findViewById(R.id.home_activ_tv1);
				holder.time = (TextView) convertView
						.findViewById(R.id.home_activ_tv2);
				holder.position = (TextView) convertView
						.findViewById(R.id.home_activ_tv3);
				holder.content = (TextView) convertView
						.findViewById(R.id.home_activ_tv4);
				holder.people_no = (TextView) convertView
						.findViewById(R.id.home_activ_tv5);

/*				layout = (LinearLayout) convertView
						.findViewById(R.id.linearlayout_home_activ);*/
				
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			
			MyActive myActive = mList.get(position);

			// 需要处理
			int r = (int)(Math.random()*15+0.5);
			Bitmap bm_head = BitmapFactory.decodeResource(mContext.getResources(), 
					MyConstants.Head_all[r]);
			holder.avatar.setImageBitmap(PhotoUtil.toRoundCorner(bm_head, 20));

			holder.title.setText(myActive.getAname());

			// 需要处理
			holder.time.setText(myActive.getAtime());

			// 需要处理
			holder.position.setText(myActive.getAposition());
			holder.content.setText(myActive.getAdescrip());
			holder.people_no.setText(myActive.getApeople_no());
			
			//layout.setOnClickListener(new layoutOnClickListener)

			return convertView;
		}

		class ViewHolder {
			ImageView avatar;
			TextView title;
			TextView time;
			TextView position;
			TextView content;
			TextView people_no;

		}
	}

}
