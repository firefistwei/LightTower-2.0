package gen.wzp.main.friends;

import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import gen.wzp.main.domain.Actives;
import gen.wzp.main.domain.UserHotFriends;
import gen.wzp.main.ui.base.MyLetterListView;
import gen.wzp.main.ui.base.MyLetterListView.OnTouchingLetterChangedListener;
import gen.wzp.main.utils.PhotoUtil;
import gen.wzp.main.utils.TextUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 * 
 */
public class FriendsLight extends Activity {
	private Context mContext;

	private EditText mSearch;
	private ListView mDisplay;
	private MyLetterListView mLetter;
	private Button mAll;
	private Button mHot;
	private TextUtil mTextUtil;
	private Adapter mAdapter;

	// 当前显示的好友数据
	private List<FriendsResult> mMyFriendsResults = new ArrayList<FriendsResult>();
	// 当前显示的好友的姓名的首字母的在列表中的位置
	private List<Integer> mMyFriendsPosition = new ArrayList<Integer>();
	// 当前显示的好友的姓名的首字母数据
	private List<String> mMyFriendsFirstName = new ArrayList<String>();

	// 是否显示的是全部好友
	private boolean mIsAll = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.friends);

		mContext = this;
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		findViewById();
		init();
		setListener();
	}

	private void findViewById() {

		mSearch = (EditText) this.findViewById(R.id.friends_search);
		mLetter = (MyLetterListView) this.findViewById(R.id.friends_letter);
		mDisplay = (ListView) this.findViewById(R.id.friends_display);

		mHot = (Button) this.findViewById(R.id.friends_good);
		mAll = (Button) this.findViewById(R.id.friends_all);

		mLayout = (LinearLayout) this.findViewById(R.id.layout_time_list);

	}

	private void setListener() {

		mAll.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 如果显示的不是全部好友 则显示全部
				if (!mIsAll) {
					mIsAll = true;

					mHot.setBackgroundResource(R.drawable.bottomtabbutton_leftwhite);
					mAll.setBackgroundResource(R.drawable.bottomtabbutton_rightred);

					int left = (int) TypedValue.applyDimension(
							TypedValue.COMPLEX_UNIT_DIP, 20, mContext
									.getResources().getDisplayMetrics());
					mHot.setPadding(left, 0, 0, 0);
					mSearch.setText("");
					mLetter.setVisibility(View.VISIBLE);
					mAdapter = new Adapter();
					mDisplay.setAdapter(mAdapter);

					mLayout.removeAllViews();
				}
			}
		});
		mHot.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 如果显示的是全部内容 则显示热度好友
				if (mIsAll) {
					mIsAll = false;

					mHot.setBackgroundResource(R.drawable.bottomtabbutton_leftred);
					mAll.setBackgroundResource(R.drawable.bottomtabbutton_rightwhite);

					int left = (int) TypedValue.applyDimension(
							TypedValue.COMPLEX_UNIT_DIP, 20, mContext
									.getResources().getDisplayMetrics());
					mHot.setPadding(left, 0, 0, 0);
					mSearch.setText("");
					mLetter.setVisibility(View.GONE);
					mAdapter = new Adapter();

					initHotFriendsList();
				}
			}

		});
		mLetter.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			public void onTouchingLetterChanged(String s) {
				// 根据触摸的字母,跳转到响应位置
				if (MyConstants.mMyFriendsFirstNamePosition.get(s) != null) {
					mDisplay.setSelection(MyConstants.mMyFriendsFirstNamePosition
							.get(s));
				}
			}
		});
		mSearch.addTextChangedListener(new TextWatcher() {
			// 当文本改变时调用
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// 获取当前输入的内容并大写
				String searchChar = s.toString().toUpperCase();
				// 如果显示的是全部
				if (mIsAll) {
					// 清除当前所有的数据
					mMyFriendsResults.clear();
					mMyFriendsPosition.clear();
					mMyFriendsFirstName.clear();
					// 判断输入内容的长度
					if (searchChar.length() > 0) {
						// 判断是否是字母
						if (searchChar.matches("^[a-z,A-Z].*$")) {
							// 判断当前好友里是有存在这个字母,有的话则取出数据更新界面,否则直接更新界面
							if (MyConstants.mMyFriendsGroupByFirstName
									.containsKey(searchChar)) {
								List<FriendsResult> results = MyConstants.mMyFriendsGroupByFirstName
										.get(searchChar);
								mMyFriendsResults.addAll(results);
								mMyFriendsFirstName.add(searchChar);
								mMyFriendsPosition.add(0);
								mAdapter.notifyDataSetChanged();
							} else {
								mAdapter.notifyDataSetChanged();
							}
						} else {
							mAdapter.notifyDataSetChanged();
						}
					} else {
						// 输入框没内容时,获取全部好友并更新界面
						mMyFriendsResults.addAll(MyConstants.mMyFriendsResults);
						mMyFriendsPosition
								.addAll(MyConstants.mMyFriendsPosition);
						mMyFriendsFirstName
								.addAll(MyConstants.mMyFriendsFirstName);
						mAdapter.notifyDataSetChanged();
					}
				} else {
					mAdapter.notifyDataSetChanged();
				}
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			public void afterTextChanged(Editable s) {

			}
		});
	}

	private void init() {
		// 实例化文本工具
		mTextUtil = new TextUtil();
		// 获取我的好友
		getMyFriends();

		getHotData();
		initHotFriendsList();

		// 添加适配器
		mAdapter = new Adapter();
		mDisplay.setAdapter(mAdapter);

		mDisplay.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(FriendsLight.this,
						FriendInfoActivity.class);
				intent.putExtra("friend_position", position);
				startActivity(intent);

			}
		});
	}

	/**
	 * 获取我的好友
	 */
	private void getMyFriends() {
		if (MyConstants.mMyFriendsResults.isEmpty()) {
			InputStream inputStream;
			try {

				String json = MyConstants.allFriensJSON;
				JSONArray array = new JSONArray(json);
				FriendsResult result = null;
				for (int i = 0; i < array.length(); i++) {
					result = new FriendsResult();
					result.setUid(array.getJSONObject(i).getString("uid"));
					result.setName(array.getJSONObject(i).getString("name"));
					result.setAvatar(array.getJSONObject(i).getInt("avatar"));

					result.setName_pinyin(mTextUtil.getStringPinYin(result
							.getName()));
					if (!TextUtils.isEmpty(result.getName_pinyin())) {
						result.setName_first(result.getName_pinyin()
								.substring(0, 1).toUpperCase());
					}
					MyConstants.mMyFriendsResults.add(result);

					if (result.getName_first().matches("^[a-z,A-Z].*$")) {
						if (MyConstants.mMyFriendsFirstName.contains(result
								.getName_first())) {
							MyConstants.mMyFriendsGroupByFirstName.get(
									result.getName_first()).add(result);
						} else {
							MyConstants.mMyFriendsFirstName.add(result
									.getName_first());
							List<FriendsResult> list = new ArrayList<FriendsResult>();
							list.add(result);
							MyConstants.mMyFriendsGroupByFirstName.put(
									result.getName_first(), list);
						}
					} else {
						if (MyConstants.mMyFriendsFirstName.contains("#")) {
							MyConstants.mMyFriendsGroupByFirstName.get("#")
									.add(result);
						} else {
							MyConstants.mMyFriendsFirstName.add("#");
							List<FriendsResult> list = new ArrayList<FriendsResult>();
							list.add(result);
							MyConstants.mMyFriendsGroupByFirstName.put("#",
									list);
						}
					}
				}
				Collections.sort(MyConstants.mMyFriendsFirstName);
				int position = 0;
				for (int i = 0; i < MyConstants.mMyFriendsFirstName.size(); i++) {
					MyConstants.mMyFriendsFirstNamePosition.put(
							MyConstants.mMyFriendsFirstName.get(i), position);
					MyConstants.mMyFriendsPosition.add(position);
					position += MyConstants.mMyFriendsGroupByFirstName.get(
							MyConstants.mMyFriendsFirstName.get(i)).size();
				}
			} catch (Exception e) {

			}
		}
		mMyFriendsResults.addAll(MyConstants.mMyFriendsResults);
		mMyFriendsPosition.addAll(MyConstants.mMyFriendsPosition);
		mMyFriendsFirstName.addAll(MyConstants.mMyFriendsFirstName);
	}

	private class Adapter extends BaseAdapter implements SectionIndexer {

		public int getCount() {
			if (mIsAll) {
				return mMyFriendsResults.size();
			} else {
				return 0;
			}

		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.friends_item, null);
				holder = new ViewHolder();
				holder.alpha = (TextView) convertView
						.findViewById(R.id.friends_item_alpha);
				holder.alpha_line = (ImageView) convertView
						.findViewById(R.id.friends_item_alpha_line);
				holder.avatar = (ImageView) convertView
						.findViewById(R.id.friends_item_avatar);
				holder.name = (TextView) convertView
						.findViewById(R.id.friends_item_name);
				holder.arrow = (ImageView) convertView
						.findViewById(R.id.friends_item_arrow);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			if (mIsAll) {
				int section = getSectionForPosition(position);
				final FriendsResult result = MyConstants.mMyFriendsGroupByFirstName
						.get(mMyFriendsFirstName.get(section)).get(
								position - getPositionForSection(section));
				if (getPositionForSection(section) == position) {
					holder.alpha.setVisibility(View.VISIBLE);
					holder.alpha_line.setVisibility(View.VISIBLE);
					holder.alpha.setText(mMyFriendsFirstName.get(section));
				} else {
					holder.alpha.setVisibility(View.GONE);
					holder.alpha_line.setVisibility(View.GONE);
				}
				holder.name.setText(result.getName());

				int r = (int) (Math.random() * 13 + 0.5);
				Bitmap bm_head = BitmapFactory.decodeResource(
						mContext.getResources(), MyConstants.Head_all[r]);
				holder.avatar.setImageBitmap(PhotoUtil.toRoundCorner(bm_head,
						20));
				holder.arrow.setVisibility(View.GONE);
			} else {

			}
			return convertView;
		}

		class ViewHolder {
			TextView alpha;
			ImageView alpha_line;
			ImageView avatar;
			TextView name;
			ImageView arrow;
		}

		public Object[] getSections() {
			return mMyFriendsFirstName.toArray();
		}

		public int getPositionForSection(int section) {
			if (section < 0 || section >= mMyFriendsFirstName.size()) {
				return -1;
			}
			return mMyFriendsPosition.get(section);
		}

		public int getSectionForPosition(int position) {
			if (position < 0 || position >= mMyFriendsResults.size()) {
				return -1;
			}
			int index = Arrays.binarySearch(mMyFriendsPosition.toArray(),
					position);
			return index >= 0 ? index : -index - 2;
		}
	}

	/**
	 * 现在开始时HotFriends了
	 */

	private void getHotData() {

		MyConstants.mHotFriendsList.add(new UserHotFriends(301, 1, 302,
				"13-5-30", "党森"));
		MyConstants.mHotFriendsList.add(new UserHotFriends(301, 1, 304,
				"13-5-30", "徐建兴"));
		MyConstants.mHotFriendsList.add(new UserHotFriends(301, 1, 303,
				"13-5-30", "严钦"));
		MyConstants.mHotFriendsList.add(new UserHotFriends(301, 1, 310,
				"13-5-30", "茱莉"));
		MyConstants.mHotFriendsList.add(new UserHotFriends(301, 1, 311,
				"13-5-30", "戴安娜"));
		MyConstants.mHotFriendsList.add(new UserHotFriends(301, 1, 312,
				"13-5-30", "娜美"));

		for (int j = 0; j < 6; j++) {
			MyConstants.mHotF_A_List.add(new ArrayList<Actives>());
		}
		MyConstants.mHotF_A_List.get(0).add(
				new Actives(1, "1", "党森", 1, "魔方挑战赛", "5-10 4:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(0).add(
				new Actives(1, "1", "党森", 1, "死党聚会", "5-12 5:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(0).add(
				new Actives(1, "1", "党森", 1, "同学KTV", "5-17 10:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(1)
				.add(new Actives(1, "1", "徐建兴", 1, "2+2认识朋友", "5-9 8:00PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(1)
				.add(new Actives(1, "1", "徐建兴", 1, "奇思妙想交流", "5-16 9:00PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(1).add(
				new Actives(1, "1", "徐建兴", 1, "一起滑滑板", "5-18 6:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(2).add(
				new Actives(1, "1", "严钦", 1, "晨读英语", "5-11 6:00AM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(2)
				.add(new Actives(1, "1", "严钦", 1, "1+1好友交流", "5-15 5:00PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(2).add(
				new Actives(1, "1", "严钦", 1, "熬夜党通宵学一次", "5-17 11:00PM", 1, 1,
						1));
		MyConstants.mHotF_A_List.get(2).add(
				new Actives(1, "1", "严钦", 1, "爬山结伴", "5-20 9:00AM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(2).add(
				new Actives(1, "1", "严钦", 1, "单车一日骑", "5-24 11:00AM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(2)
				.add(new Actives(1, "1", "严钦", 1, "3+3认识新朋友", "5-27 4:00PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(3)
				.add(new Actives(1, "1", "茱莉", 1, "哥们出来喝果汁", "5-14 8:00PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(3).add(
				new Actives(1, "1", "茱莉", 1, "计科专业交流", "5-16 9:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(3).add(
				new Actives(1, "1", "茱莉", 1, "愉快的午饭", "5-19 12:00AM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(3).add(
				new Actives(1, "1", "茱莉", 1, "我要请你", "5-25 6:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(4).add(
				new Actives(1, "1", "戴安娜", 1, "单身聚会", "5-11 8:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(4)
				.add(new Actives(1, "1", "戴安娜", 1, "羽毛球球技单挑", "5-13 3:30PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(4).add(
				new Actives(1, "1", "戴安娜", 1, "魔方挑战赛", "5-16 5:50PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(4).add(
				new Actives(1, "1", "戴安娜", 1, "2+2咱们聊聊吧", "5-20 5:30PM", 1, 1,
						1));
		MyConstants.mHotF_A_List.get(5).add(
				new Actives(1, "1", "娜美", 1, "一件有趣的事", "5-10 8:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(5).add(
				new Actives(1, "1", "娜美", 1, "出来走走", "5-13 2:00PM", 1, 1, 1));
		MyConstants.mHotF_A_List.get(5)
				.add(new Actives(1, "1", "娜美", 1, "我是学霸战通宵", "5-18 10:00PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(5)
				.add(new Actives(1, "1", "娜美", 1, "小型黑客马拉松", "5-21 8:00PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(5)
				.add(new Actives(1, "1", "娜美", 1, "我们一起跑步吧", "5-22 10:00PM", 1,
						1, 1));
		MyConstants.mHotF_A_List.get(5).add(
				new Actives(1, "1", "娜美", 1, "一起去自习", "5-23 7:00PM", 1, 1, 1));

	}

	public LinearLayout mLayout = null;
	private LayoutInflater mInflater;

	public static List<ArrayList<Actives>> friendsActives = null;

	private List<UserHotFriends> hotFriends = null;

	private void initHotFriendsList() {
		mLayout = (LinearLayout) this.findViewById(R.id.layout_time_list);
		mLayout.removeAllViews();
		mInflater = LayoutInflater.from(mLayout.getContext());

		friendsActives = MyConstants.mHotF_A_List;
		hotFriends = MyConstants.mHotFriendsList;

		for (int i = 0; i < hotFriends.size(); i++) {
			UserHotFriends result = hotFriends.get(i);

			View mView = mInflater.inflate(R.layout.hot_friends, null);

			Bitmap bm_head = BitmapFactory.decodeResource(
					mContext.getResources(), MyConstants.Head_all[i + 7]);

			((ImageView) mView.findViewById(R.id.hot_friend_avatar))
					.setImageBitmap(PhotoUtil.toRoundCorner(bm_head, 20));
			((TextView) mView.findViewById(R.id.hot_friend_name))
					.setText(result.getNotename());

			int r = (int)(Math.random()*8);
			((ImageView) mView.findViewById(R.id.hot_time_style_img))
					.setImageResource(MyConstants.Time_box[r]);
			((TextView) mView.findViewById(R.id.hot_time_style_text))
					.setText(MyConstants.Time_text[r]);

			mLayout.addView(mView, i);
			initHotActives(i, mView);
		}

	}

	private void initHotActives(int i, View view) {
		LinearLayout mLay = (LinearLayout) view
				.findViewById(R.id.layout_one_hot_actives);
		LayoutInflater mInf = LayoutInflater.from(mLay.getContext());
		Actives active = null;

		for (int j = 0; j < friendsActives.get(i).size(); j++) {
			View mVi = mInf.inflate(R.layout.one_hot_actives, null);

			active = friendsActives.get(i).get(j);
			((TextView) mVi.findViewById(R.id.one_hot_aname)).setText(active
					.getAname());
			((TextView) mVi.findViewById(R.id.one_hot_atime)).setText(active
					.getAtime());

			mLay.addView(mVi, j);
		}

	}
}
