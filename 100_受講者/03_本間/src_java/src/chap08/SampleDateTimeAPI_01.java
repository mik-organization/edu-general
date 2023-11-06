package chap08;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class SampleDateTimeAPI_01 {
	public static void main(String[] args) {
		// Date and Time API
		/*
		 * LocalDate クラス、LocalTime クラス、LocalDateTime クラスによる、現在日時の取得 static メソッド
		 * now()メソッドを使用
		 */
		LocalDate now_date = LocalDate.now();
		LocalTime now_time = LocalTime.now();
		LocalDateTime now_date_time = LocalDateTime.now();
		System.out.println("now_date " + now_date);
		System.out.println("now_time " + now_time);
		System.out.println("now_date_time " + now_date_time);
		
		LocalDate now_date1=now_date.plusDays(1);
		System.out.println("now_date " + now_date1);
		
		System.out.println(ChronoUnit.DAYS.between(now_date, now_date1));
		
	}
}