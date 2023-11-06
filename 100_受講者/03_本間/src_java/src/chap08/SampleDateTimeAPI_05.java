package chap08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SampleDateTimeAPI_05 {
	public static void main(String[] args) {
		// Date and Time API
		/*
		 * DateTimeFormatter クラス 独自のフォーマッタを使用してテキスト文字列から日付/時間オブジェクトを取得することも可能です。
		 * ofPattern()メソッドを使用
		 */
		// 独自フォーマッタの生成
		DateTimeFormatter fmt01 = DateTimeFormatter
				.ofPattern("yyyy/MM/dd HH:mm:ss");
		// 日時(文字列)
		String date_time = "2019/01/01 10:10:34";
		// 日時オブジェクトの生成 parse()メソッドで独自フォーマッタを使用
		LocalDateTime any_date_time = LocalDateTime.parse(date_time, fmt01);
		// 日時を表示
		System.out.println("ISO_DATE_TIME " + any_date_time);
		// 日時を表示 独自フォーマッタで表示
		System.out.println("独自フォーマッタ " + fmt01.format(any_date_time));
	}
}
