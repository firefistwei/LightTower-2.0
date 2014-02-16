package gen.wzp.main.activity;

import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import gen.wzp.main.domain.ChatResult;
import gen.wzp.main.utils.PhotoUtil;
import gen.wzp.main.utils.TextUtil;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * �����¼��
 * 
 * @author wei
 * 
 */
public class ChatLogsActivity extends Activity {

	private ListView mDisplay;

	private String mName;// ��ǰ�����¼�������û�����
	private int mAvatar; // ��ǰ�����¼�������û�ͷ��

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chatlogs_activity);
		
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		findViewById();

		init();
	}
	
	public void chatlogs_back(View v){
		this.finish();
	}

	private void findViewById() {
		mDisplay = (ListView) findViewById(R.id.chatlogs_display);
	}



	private void init() {
		// ���յ�ǰ�����¼�����û���������ͷ��
		mName = getIntent().getStringExtra("name");
		mAvatar = getIntent().getIntExtra("avatar", -1);

		// ���������
		mDisplay.setAdapter(new ChatLogsAdapter());
	}

	public class ChatLogsAdapter extends BaseAdapter {

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
				convertView = LayoutInflater.from(ChatLogsActivity.this)
						.inflate(R.layout.chat_activity_item, null);
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
			// ������Ϣ������,��ʾ��ͬ�Ľ���Ч��,1Ϊ�û��Լ���������Ϣ,2Ϊ�û��յ�����Ϣ
			switch (result.getType()) {
			case 1:
				holder.in.setVisibility(View.GONE);
				holder.out.setVisibility(View.VISIBLE);
				holder.outAvatar.setImageBitmap(PhotoUtil.toRoundCorner(
						BitmapFactory.decodeResource(getResources(),
								R.drawable.random_head5), 15));
				holder.outName.setText("��");
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
