package chap08;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SampleDateTimeAPI_02 {
	public static void main(String[] args) {
		/*
		 * LocalDate クラス、LocalTime クラス、LocalDateTime クラスによる、任意の日時のオブジェクト生成
		 * static メソッド of()メソッドを使用 引数に日時を設定する LocalDate.of(年,月,日)
		 * LocalTime.of(時,分,秒) LocalDateTime.of(年,月,日,時,分,秒)
		 */
		LocalDate any_date = LocalDate.of(2019, 1, 5);
		LocalTime any_time = LocalTime.of(10, 15, 10);
		LocalDateTime any_date_time = LocalDateTime.of(1955, 10, 7, 21, 10, 4);
		System.out.println("any_date " + any_date);
		System.out.println("any_time " + any_time);
		System.out.println("any_date_time " + any_date_time);
	}
}