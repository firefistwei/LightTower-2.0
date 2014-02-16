package gen.wzp.main.setting;

import gen.wzp.main.R;
import gen.wzp.main.active.UserActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SettingLight extends Activity {

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_main);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		this.context = this;

	}

	public void setting_layout1(View v) { // 个人信息
		Intent intent = new Intent(SettingLight.this, UserActivity.class);
		startActivity(intent);
	}

	public void setting_layout2(View v) { // 我的账号
		Intent intent = new Intent(SettingLight.this, Set_Account.class);
		startActivity(intent);
	}

	public void setting_layout3(View v) { // 隐私设置
		Intent intent = new Intent(SettingLight.this, Set_Privacy.class);
		startActivity(intent);
	}

	public void setting_layout4(View v) { // 高级设置
		Intent intent = new Intent(SettingLight.this, Set_Advance.class);
		startActivity(intent);
	}

	public void setting_layout5(View v) { // 版本更新
		Intent intent = new Intent(SettingLight.this, Set_Edition.class);
		startActivity(intent);
	}

	public void setting_layout6(View v) { // 关于灯塔
		Intent intent = new Intent(SettingLight.this, Set_About.class);
		startActivity(intent);
	}

	public void setting_layout7(View v) { // 退出登录
		Toast.makeText(getApplicationContext(), "用户账号已退出，下次需要重新登录", 1500)
				.show();
		this.finish();
	}

}
