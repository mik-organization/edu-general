package chap08;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Sample10 {
	public static void main(String[] args) {

		// ロケールの呼び出し
		Locale usa = new Locale("en", "us");
		
		// フォーマット形式の指定
		String format = "y/M/d (E) kk:mm";
		String formatUsa = "MMM d y (E) a hh:mm";

		// SimpleDateFormatのnew生成
		SimpleDateFormat sdf01 = new SimpleDateFormat(format);
		SimpleDateFormat sdf02 = new SimpleDateFormat(formatUsa, usa);

		String formated01 = sdf01.format(Calendar.getInstance().getTime());
		String formated02 = sdf02.format(Calendar.getInstance().getTime());

		System.out.println(formated01);
		System.out.println(formated02);

	}
}
