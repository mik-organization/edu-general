package chap08;

import java.util.Calendar;

public class Sample09 {
	public static void main(String[] args) {
		String[] dayName = { "日", "月", "火", "水", "木", "金", "土" };
		//現在の日時
		//TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
		Calendar cal 	= Calendar.getInstance(); // 実行時の年月日時分秒
		int year 		= cal.get(Calendar.YEAR);
		int month 		= cal.get(Calendar.MONTH)+1; // 0～11なので+1しないと月に対応しない
		int date 		= cal.get(Calendar.DATE);
		int dayNum 		= cal.get(Calendar.DAY_OF_WEEK); // 日曜日==>1
		int hour 		= cal.get(Calendar.HOUR_OF_DAY);
		int minute 		= cal.get(Calendar.MINUTE);
		int second 		= cal.get(Calendar.SECOND);
		System.out.println(year + "年" + month + "月" + date + "日");
		System.out.println(dayName[dayNum - 1] + "曜日"); //配列から取得するので-1
		System.out.println(hour + "時" + minute + "分" + second + "秒"+ "\n");
		//月を12月に設定
		cal.set(Calendar.MONTH, 10); // １２月を指定
		month = cal.get(Calendar.MONTH)+1;
		System.out.println(year + "年" + month + "月" + date + "日");
		System.out.println(hour + "時" + minute + "分" + second + "秒" + "\n");
		//任意の日時を設定
		cal.set(1989, 2, 12,12,34,56); // 年,月,日.時,分,秒を指定
		year 	= cal.get(Calendar.YEAR);
		month 	= cal.get(Calendar.MONTH) +1 ;
		date 	= cal.get(Calendar.DATE);
		dayNum 	= cal.get(Calendar.DAY_OF_WEEK);
		hour 	= cal.get(Calendar.HOUR_OF_DAY);
		minute 	= cal.get(Calendar.MINUTE);
		second 	= cal.get(Calendar.SECOND);
		System.out.println(year + "年" + month + "月" + date + "日");
		System.out.println(dayName[dayNum - 1] + "曜日");
		System.out.println(hour + "時" + minute + "分" + second + "秒");
	}
}











