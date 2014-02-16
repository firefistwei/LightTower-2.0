package gen.wzp.main;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeFirst extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome_first);
	
	    init();
	
	}

	private void init() {
		
		ImageView imageView = (ImageView)this.findViewById(R.id.welcome_img);
		TextView text1 = (TextView)this.findViewById(R.id.welcome_tv1);
		TextView text2 = (TextView)this.findViewById(R.id.welcome_tv2);
		double a = Math.random();
		if(a>0.75){
			imageView.setImageResource(R.drawable.welcome2);
			text1.setVisibility(View.INVISIBLE);
			text2.setVisibility(View.INVISIBLE);
		}else if(a>0.5){
			imageView.setImageResource(R.drawable.welcome3);
			text1.setVisibility(View.INVISIBLE);
			text2.setVisibility(View.INVISIBLE);
		}else{
			imageView.setImageResource(R.drawable.welcome1);
		}
		
		
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				Intent intent = new Intent (WelcomeFirst.this,LoginActivity.class);			
				startActivity(intent);			
				WelcomeFirst.this.finish();
			}
		}, 2000);
		
	}

}
