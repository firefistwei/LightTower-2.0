package gen.wzp.main.message;

import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import gen.wzp.main.activity.ChatActivity;
import gen.wzp.main.domain.MyMsg;
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
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MessageLight extends Activity {

	private ListView msgList;
	private MyAdapter mAdapter;

	Context mContext = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.message);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		mContext = this;

		init();
	}

	private void init() {

		msgList = (ListView) this.findViewById(R.id.msg_listview);
		getMsgListData();

		mAdapter = new MyAdapter();
		msgList.setAdapter(mAdapter);

		// setListViewHeightBasedOnChildren(msgList);
		msgList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (MyConstants.mMsgList.get(position).getMsg_type() == 1) {
                    //对话
					Intent intent = new Intent(MessageLight.this,
							ChatActivity.class);
					intent.putExtra("mMsgList_position", position);
					startActivity(intent);
				}else if(MyConstants.mMsgList.get(position).getMsg_type() == 2){
					//好友申请
					Intent intent = new Intent(MessageLight.this,
							ChatActivity.class);
					intent.putExtra("mMsgList_position", position);
					startActivity(intent);
					
				}else if(MyConstants.mMsgList.get(position).getMsg_type() == 3){
					//活动申请
					Intent intent = new Intent(MessageLight.this,
							ChatActivity.class);
					intent.putExtra("mMsgList_position", position);
					startActivity(intent);
					
				}else if(MyConstants.mMsgList.get(position).getMsg_type() == 4){
					//活动答复
					Intent intent = new Intent(MessageLight.this,
							ChatActivity.class);
					intent.putExtra("mMsgList_position", position);
					startActivity(intent);
				}

			}
		});

	}

	public void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

	private void getMsgListData() {

		if (MyConstants.mMsgList.isEmpty()) {
			String json = MyConstants.msgJSON;
			try {
				JSONArray array = new JSONArray(json);
				MyMsg myMsg = null;
				for (int i = 0; i < array.length(); i++) {
					myMsg = new MyMsg();
					myMsg.setUid(array.getJSONObject(i).getInt("uid"));
					myMsg.setMid(array.getJSONObject(i).getInt("mid"));
					myMsg.setSender_id(array.getJSONObject(i).getInt(
							"sender_id"));
					myMsg.setSender_name(array.getJSONObject(i).getString(
							"sender_name"));
					myMsg.setSender_headurl(array.getJSONObject(i).getString(
							"sender_headurl"));
					myMsg.setMsg_time(array.getJSONObject(i).getString(
							"msg_time"));
					myMsg.setMsg_content(array.getJSONObject(i).getString(
							"msg_content"));
					myMsg.setMsg_type(array.getJSONObject(i).getInt("msg_type"));
					myMsg.setAid(array.getJSONObject(i).getInt("aid"));
					myMsg.setAagree(array.getJSONObject(i).getInt("aagree"));

					MyConstants.mMsgList.add(myMsg);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private class MyAdapter extends BaseAdapter {

		private List<MyMsg> mList;

		public MyAdapter() {
			if (MyConstants.mMsgList.size() != 0) {
				mList = MyConstants.mMsgList;
			} else {
				mList = new ArrayList<MyMsg>();
			}
		}

		@Override
		public int getCount() {
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;

			if (convertView == null) {
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.message_item, null);
				holder = new ViewHolder();
				holder.head = (ImageView) convertView
						.findViewById(R.id.msg_img1);
				holder.name = (TextView) convertView
						.findViewById(R.id.msg_text1);
				holder.time = (TextView) convertView
						.findViewById(R.id.msg_text3);
				holder.content = (TextView) convertView
						.findViewById(R.id.msg_text2);
				holder.type_img = (ImageView) convertView
						.findViewById(R.id.msg_img2);
				holder.type_text = (TextView) convertView
						.findViewById(R.id.msg_text4);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			MyMsg myMsg = mList.get(position);

			if (mList.get(position).getMsg_type() == 1) { //对话	
				//头像
				Bitmap bm = null;
				if(myMsg.getSender_headurl().equals("0")){
					int r = (int) (Math.random()*9+0.5);
					bm = BitmapFactory.decodeResource(
							mContext.getResources(), MyConstants.Head_boy[r]);
                }else{
                	
                }
				holder.head.setImageBitmap(PhotoUtil.toRoundCorner(bm, 20));
				holder.name.setText(myMsg.getSender_name());
				holder.time.setText(myMsg.getMsg_time());
				holder.content.setText(myMsg.getMsg_content());
				holder.type_img.setImageResource(R.drawable.msg_type_dialog);
				holder.type_text.setText("对 话");

			}else if(mList.get(position).getMsg_type() == 2){ //好友申请
				//头像
				Bitmap bm = null;
				if(myMsg.getSender_headurl().equals("0")){
					int r = (int) (Math.random()*9+0.5);
					bm = BitmapFactory.decodeResource(
							mContext.getResources(), MyConstants.Head_boy[r]);
                }else{
                	
                }
				holder.head.setImageBitmap(PhotoUtil.toRoundCorner(bm, 20));
				holder.name.setText(myMsg.getSender_name());
				holder.time.setText(myMsg.getMsg_time());
				holder.content.setText(myMsg.getMsg_content());
				holder.type_img.setImageResource(R.drawable.msg_type_add_friend);
				holder.type_text.setText("好友申请");
				
			}else if(mList.get(position).getMsg_type() == 3){ //活动申请
				//头像
				Bitmap bm = null;
				if(myMsg.getSender_headurl().equals("0")){
					int r = (int) (Math.random()*9+0.5);
					bm = BitmapFactory.decodeResource(
							mContext.getResources(), MyConstants.Head_boy[r]);
                }else{
                	
                }
				holder.head.setImageBitmap(PhotoUtil.toRoundCorner(bm, 20));

				holder.name.setText(myMsg.getSender_name());
				holder.time.setText(myMsg.getMsg_time());
				holder.content.setText(myMsg.getMsg_content());
				holder.type_img.setImageResource(R.drawable.msg_type_join_active);
				holder.type_text.setText("活动申请");
				
			}else if(mList.get(position).getMsg_type() == 4){ //活动答复
				//头像
				Bitmap bm = null;
				if(myMsg.getSender_headurl().equals("0")){
					int r = (int) (Math.random()*9+0.5);
					bm = BitmapFactory.decodeResource(
							mContext.getResources(), MyConstants.Head_boy[r]);
                }else{
                	
                }
				holder.head.setImageBitmap(PhotoUtil.toRoundCorner(bm, 20));

				holder.name.setText(myMsg.getSender_name());
				holder.time.setText(myMsg.getMsg_time());
				holder.content.setText(myMsg.getMsg_content());
				holder.type_img.setImageResource(R.drawable.msg_type_reply_active);
				holder.type_text.setText("活动答复");
			}		

			return convertView;
		}

		class ViewHolder {
			ImageView head;
			TextView name;
			TextView time;
			TextView content;
			ImageView type_img;
			TextView type_text;
		}

	}
}
