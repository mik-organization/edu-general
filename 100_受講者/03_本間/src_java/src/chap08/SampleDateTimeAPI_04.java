package chap08;

import java.time.LocalDate;

public class SampleDateTimeAPI_04 {
	public static void main(String[] args) {
		/*
		 * LocalDate クラス、LocalTime クラス、LocalDateTime クラスによる、任意の日時のオブジェクト生成 ※注意
		 * LocalDate.parse("2019-01-01");はOK LocalDate.parse("2019-1-1");はNG
		 */
		LocalDate any_date = LocalDate.parse("2019-1-1");
		System.out.println("any_date " + any_date);
	}
}
