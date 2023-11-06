package chap12;

public class Enum05 {
	public enum Point {
		NORTH, SOUTH, EAST, WEST
	}

	public static void main(String[] args) {
		for (Point po : Point.values()) {
			System.out.println(po.ordinal() + ":" + po);
		}
	}
}