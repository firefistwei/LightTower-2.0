package gen.wzp.main.activity;


import gen.wzp.main.Constants;
import gen.wzp.main.MyConstants;
import gen.wzp.main.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class TimeGrid extends Activity {

	private GridView gridView = null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_time_gridview);

		gridView = (GridView) this.findViewById(R.id.time_gridview);
		gridView.setAdapter(new ImageAdapter(TimeGrid.this));

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Constants.time_style = position;
				
		              
				Toast.makeText(getApplicationContext(), "成功更新时光状态", 1000).show();
				TimeGrid.this.finish();
			}

		});
	}

	public class ImageAdapter extends BaseAdapter {
		private Context context;

		int time_imgs[] = null;
		
		public ImageAdapter(Context context) {
			this.context = context;
			time_imgs = MyConstants.Time_box;
		}

		public int getCount() {
			return time_imgs.length;
		}

		public Object getItem(int position) {
			
			return time_imgs[position];
		}

		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ImageView imageView;
			if (convertView == null) {
				// if it's not recycled, initialize some attributes
				imageView = new ImageView(context);
				imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(1, 1, 1, 1);
			} else {
				imageView = (ImageView) convertView;
			}
			imageView.setImageResource(time_imgs[position]);
			return imageView;

		}
	}

}
