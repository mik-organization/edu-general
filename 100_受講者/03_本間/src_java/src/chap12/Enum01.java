package chap12;

public class Enum01 {
	//enumの定義
	public enum Point {
		NOUTH, SOUTH, EAST, WEST
	}

	public static void main(String[] args) {
		//enumの値を表示
		System.out.println("東は" + Point.EAST +"です。");
		System.out.println("西は" + Point.WEST +"です。");
		System.out.println("南は" + Point.SOUTH +"です。");
		System.out.println("北は" + Point.NOUTH +"です。");
	}
}