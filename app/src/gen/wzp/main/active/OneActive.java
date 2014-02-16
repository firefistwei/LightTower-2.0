package gen.wzp.main.active;

import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import gen.wzp.main.domain.MyActive;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OneActive extends Activity{
	
	ImageView head;
	TextView name;
	ImageView sex;
	TextView level;
	TextView sig;
	
	TextView a_name;
	TextView a_type;
	TextView a_time;
	TextView a_position;
	TextView a_descrip;
	
	TextView a_people_no;
	Button btn_join;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.active_one);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		findViewById();
		init();
	}
	
	public void active_one_btn_back(View v){
		this.finish();
	}
	
	
	
	private void findViewById(){
		head = (ImageView)this.findViewById(R.id.one_activ_img_head);
		name = (TextView)this.findViewById(R.id.one_activ_tv_person_name);
		sex = (ImageView)this.findViewById(R.id.one_activ_tv_person_sex);
		level = (TextView)this.findViewById(R.id.one_activ_tv_person_level);
		sig = (TextView)this.findViewById(R.id.one_activ_tv_person_sig);
		
		a_name = (TextView)this.findViewById(R.id.active_one_a_name);
		a_type = (TextView)this.findViewById(R.id.active_one_a_type);
		a_time = (TextView)this.findViewById(R.id.active_one_a_time);
		a_position = (TextView)this.findViewById(R.id.active_one_a_position);
		a_descrip = (TextView)this.findViewById(R.id.active_one_a_descrip);
		
		a_people_no = (TextView)this.findViewById(R.id.active_one_a_people_no);
		btn_join = (Button)this.findViewById(R.id.active_one_btn_join);
		
	}

	private void init() {

		
		int active_position = this.getIntent().getIntExtra("active_position", -1);
		if(active_position != -1){
			MyActive myActive = MyConstants.mActiveList.get(active_position);
			a_name.setText(myActive.getAname());
			if(myActive.getAtype()==1){
			  a_type.setText("公共活动");
			}else{
			  a_type.setText("私人活动");
			}
			a_time.setText(myActive.getAtime());
			a_position.setText(myActive.getAposition());
			a_descrip.setText(myActive.getAdescrip());
			a_people_no.setText(myActive.getApeople_no());
		}
		
		btn_join.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//发出请求
				btn_join.setText("请求已发出");
				btn_join.setEnabled(false);
				
			}
		});
		
	}

	
	
	
}
