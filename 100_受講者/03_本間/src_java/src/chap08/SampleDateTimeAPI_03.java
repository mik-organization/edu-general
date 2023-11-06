package chap08;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SampleDateTimeAPI_03 {
	public static void main(String[] args) {
		/*
		 * LocalDate クラス、LocalTime クラス、LocalDateTime クラスによる、任意の日時のオブジェクト生成
		 * static メソッド parse()メソッドを使用 引数に日時を文字列で設定する
		 * LocalDate.parse("2019-04-05") LocalTime.parse("10:15:01")
		 * LocalDateTime.parse("1955-10-07T21:10:04")
		 */
		LocalDate any_date = LocalDate.parse("2019-04-05");
		LocalTime any_time = LocalTime.parse("01:15:01");
		LocalDateTime any_date_time = LocalDateTime.parse("1955-10-07T21:10:04");

		System.out.println("any_date " + any_date);
		System.out.println("any_time " + any_time);
		System.out.println("any_date_time " + any_date_time);
	}
}