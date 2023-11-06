package chap08;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Sample11 {
	public static void main(String args[]) {

		//言語=英語 国=アメリカのロケール取得
		Locale usa = new Locale("en", "US"); 
		
		//実行時の日付オブジェクトをDateで取得
		Date d = new Date(); 
		
		//DateFormatオブジェクトを生成
		DateFormat df1 = DateFormat.getInstance();
		DateFormat df2 = DateFormat.getDateTimeInstance();
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, usa);
		
		// フォーマットし、Stringに代入
		String str1 = df1.format(d); // フォーマット①
		String str2 = df2.format(d); // フォーマット②
		String str3 = df3.format(d); // フォーマット③
		String str4 = df4.format(d); // フォーマット④
		
		// 出力
		System.out.println("フォーマット① : " + str1);
		System.out.println("フォーマット② : " + str2);
		System.out.println("フォーマット③ : " + str3);
		System.out.println("フォーマット④ : " + str4);
	}
}
