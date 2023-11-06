package chap12;

public class Enum06 {
	public enum Point {
		NORTH, SOUTH, EAST, WEST; //値の終了に ; を記述
		//メソッドを記述

		String str() {
			return "値は、" + name() + "です";
		}

	}

	public static void main(String[] args) {
		for (Point po : Point.values()) {
			System.out.println(po.str()); //記述したメソッド呼び出し
		}
	}
}