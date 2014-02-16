package gen.wzp.main.activity;

import gen.wzp.main.Constants;
import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import gen.wzp.main.domain.ChatResult;
import gen.wzp.main.utils.PhotoUtil;
import gen.wzp.main.utils.TextUtil;
import gen.wzp.main.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * 聊天类
 * 
 * @author wei
 * 
 */
public class ChatActivity extends Activity {
	private LinearLayout mParent;

	private TextView mTitle;
	private ListView mDisplay;
	private EditText mContent;
	private Button mSend;

	private ChatAdapter mAdapter;

	private String mName;// 当前聊天用户名称
	private int mAvatar;// 当前聊天用户的头像

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chat_activity);
		
		
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		findViewById();
		setListener();
		init();
	}
	

	public void chat_back(View v){
		this.finish();
	}
	
	public void chat_log(View v){
		// 跳转到聊天记录界面,并传递当前聊天用户的姓名和头像
		Intent intent = new Intent();
		intent.setClass(ChatActivity.this,
				ChatLogsActivity.class);
		intent.putExtra("name", mName);
		intent.putExtra("avatar", mAvatar);
		startActivity(intent);
		
	}

	private void findViewById() {
		mParent = (LinearLayout) findViewById(R.id.chat_parent);
		
		mTitle = (TextView) findViewById(R.id.chat_head_name);
		
		mDisplay = (ListView) findViewById(R.id.chat_display);

		mContent = (EditText) findViewById(R.id.chat_content);
		mSend = (Button) findViewById(R.id.chat_send);
	}
	
	private void setListener() {
		
		mSend.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 获取当前输入的聊天内容
				String content = mContent.getText().toString().trim();
				// 聊天内容不为空时执行
				if (!TextUtils.isEmpty(content)) {
					// 添加聊天信息
					ChatResult result = new ChatResult();
					result.setTime(Utils.getTime(ChatActivity.this));
					result.setType(1);
					result.setUid(Constants.me_uid);
					result.setContent(content);
					MyConstants.mChatResults.add(result);
					// 更新界面并滚动到最后一条信息,并清空输入框
					mAdapter.notifyDataSetChanged();
					mDisplay.setSelection(MyConstants.mChatResults.size());
					mContent.setText("");
				}
			}
		});

	}

	private void init() {
		
		int position = getIntent().getIntExtra("mMsgList",0);
		
		// 获取当前聊天的用户的姓名和头像,并显示姓名到标题栏
		mName = MyConstants.mMsgList.get(position).getSender_name();
		mAvatar = MyConstants.mMsgList.get(position).getSender_id();
		mTitle.setText(mName);
		// 获取聊天记录
		getChat();
		// 添加适配器并滚动到最后一条信息
		mAdapter = new ChatAdapter();
		mDisplay.setAdapter(mAdapter);
		mDisplay.setSelection(MyConstants.mChatResults.size());
	}

	/**
	 * 获取聊天记录
	 */
	private void getChat() {
		// 判断存储的聊天记录是否已经存在,存在则不在获取
		if (MyConstants.mChatResults.isEmpty()) {
			try {
				
				String json = MyConstants.chatJSON;
				JSONArray array = new JSONArray(json);
				ChatResult result = null;
				for (int i = 0; i < array.length(); i++) {
					result = new ChatResult();
					result.setUid(array.getJSONObject(i).getInt("uid"));
					result.setHead(array.getJSONObject(i).getString("head"));
					result.setName(array.getJSONObject(i).getString("name"));
					result.setTime(array.getJSONObject(i).getString("time"));
					result.setContent(array.getJSONObject(i).getString(
							"content"));
					result.setType(array.getJSONObject(i).getInt("type"));
					MyConstants.mChatResults.add(result);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	public class ChatAdapter extends BaseAdapter {

		public int getCount() {
			return MyConstants.mChatResults.size();
		}

		public Object getItem(int position) {
			return MyConstants.mChatResults.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(ChatActivity.this).inflate(
						R.layout.chat_activity_item, null);
				holder = new ViewHolder();
				holder.in = (RelativeLayout) convertView
						.findViewById(R.id.chat_item_in_layout);
				holder.out = (RelativeLayout) convertView
						.findViewById(R.id.chat_item_out_layout);
				holder.inAvatar = (ImageView) convertView
						.findViewById(R.id.chat_item_in_avatar);
				holder.outAvatar = (ImageView) convertView
						.findViewById(R.id.chat_item_out_avatar);
				holder.inName = (TextView) convertView
						.findViewById(R.id.chat_item_in_name);
				holder.outName = (TextView) convertView
						.findViewById(R.id.chat_item_out_name);
				holder.inTime = (TextView) convertView
						.findViewById(R.id.chat_item_in_time);
				holder.outTime = (TextView) convertView
						.findViewById(R.id.chat_item_out_time);
				holder.inContent = (TextView) convertView
						.findViewById(R.id.chat_item_in_content);
				holder.outContent = (TextView) convertView
						.findViewById(R.id.chat_item_out_content);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			ChatResult result = MyConstants.mChatResults.get(position);
			// 根据消息的类型,显示不同的界面效果,1为用户自己发出的消息,2为用户收到的消息
			switch (result.getType()) {
			case 1:
				holder.in.setVisibility(View.GONE);
				holder.out.setVisibility(View.VISIBLE);
				holder.outAvatar.setImageBitmap(PhotoUtil.toRoundCorner(
						BitmapFactory.decodeResource(getResources(),
								R.drawable.random_head3), 15));
				holder.outName.setText("我");
				holder.outTime.setText(result.getTime());
				holder.outContent.setText(new TextUtil()
				.replace(result.getContent()));
				break;

			case 2:
				holder.out.setVisibility(View.GONE);
				holder.in.setVisibility(View.VISIBLE);
				holder.inAvatar.setImageBitmap(MyConstants
						.getAvatar(mAvatar));
				holder.inName.setText(mName);
				holder.inTime.setText(result.getTime());
				holder.inContent.setText(new TextUtil()
						.replace(result.getContent()));
				break;
			}
			return convertView;
		}

		class ViewHolder {
			RelativeLayout in;
			RelativeLayout out;
			ImageView inAvatar;
			ImageView outAvatar;
			TextView inName;
			TextView outName;
			TextView inTime;
			TextView outTime;
			TextView inContent;
			TextView outContent;
		}
	}
}