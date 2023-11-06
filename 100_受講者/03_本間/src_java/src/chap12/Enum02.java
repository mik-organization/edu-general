package chap12;

public class Enum02 {
	//enumの定義
	public enum Point {
		NORTH, SOUTH, EAST, WEST
	}

	public static void main(String[] args) {
		//values()でenumの値を取得
		for (Point po : Point.values()) {

			switch (po) {
			case EAST:
				System.out.println("東です。");
				break;
			case WEST:
				System.out.println("西です。");
				break;
			case NORTH:
				System.out.println("北です。");
				break;
			case SOUTH:
				System.out.println("南です。");
				break;
			}
		}
	}
}
