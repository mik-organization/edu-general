package chap12;

public class Enum03 {
	public enum Point {
		NORTH, SOUTH, EAST, WEST
	}

	public static void main(String[] args) {
		
		System.out.println("*** 比較演算子(==) ***");
		for (Point po : Point.values()) {
			if (po == Point.EAST) {
				System.out.println(po + "は東です。");
			} else {
				System.out.println(po + "は東ではありません。");
			}
		}
		System.out.println("\n*** equals() ***");
		for (Point po : Point.values()) {
			if (po.equals(Point.EAST)) {
				System.out.println(po + "は東です。");
			} else {
				System.out.println(po + "は東ではありません。");
			}
		}
	}
}
