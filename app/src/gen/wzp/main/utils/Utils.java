package gen.wzp.main.utils;

import gen.wzp.main.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.format.DateUtils;



/**
 * ������
 * 
 * @author rendongwei
 * 
 */
public class Utils {
	/**
	 * �����Ա����ֻ�ȡ���Ա�ͼƬ
	 * 
	 * @param res
	 *            Resources����
	 * @param gender
	 *            0����Ů��,1��������
	 * @return �Ա�ͼƬ(Bitmap ����)
	 */
	public static Bitmap getGender(Resources res, int gender) {
		switch (gender) {
		case 0:
			return BitmapFactory.decodeResource(res,
					R.drawable.sex_2);
		case 1:
			return BitmapFactory.decodeResource(res,
					R.drawable.sex_1);
		default:
			return BitmapFactory.decodeResource(res,
					R.drawable.sex_2);
		}
	}

	/**
	 * �����Ա����ֻ�ȡ���Ա�����
	 * 
	 * @param gender
	 *            0����Ů��,1��������
	 * @return �Ա�����(String ����)
	 */
	public static String getGender(int gender) {
		switch (gender) {
		case 0:
			return "Ů";
		case 1:
			return "��";
		default:
			return "δ֪";
		}
	}

	/**
	 * ת��long�����ڸ�ʽ
	 * 
	 * @param context
	 * @param date
	 * @return
	 */
	public static String formatDate(Context context, long date) {
		int format_flags = DateUtils.FORMAT_NO_NOON_MIDNIGHT
				| DateUtils.FORMAT_ABBREV_ALL | DateUtils.FORMAT_CAP_AMPM
				| DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_DATE
				| DateUtils.FORMAT_SHOW_TIME;
		return DateUtils.formatDateTime(context, date, format_flags);
	}

	/**
	 * ת��long�����ڸ�ʽ
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(long date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date(date));
	}

	/**
	 * ��ȡ��ǰ��ʱ��
	 * 
	 * @param context
	 * @return
	 */
	public static String getTime(Context context) {
		return formatDate(context, System.currentTimeMillis());
	}

	/**
	 * ��ȡ��ǰ��ʱ��
	 * 
	 * @return
	 */
	public static String getTime() {
		return formatDate(System.currentTimeMillis());
	}
}