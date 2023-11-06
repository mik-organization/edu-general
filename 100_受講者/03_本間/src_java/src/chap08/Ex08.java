package chap08;

public class Ex08 {
	public static void main(String[] args) {
		String str = "easy come easy go";

		String[] strSplit = str.split(" ");
		for (String i : strSplit) {
			System.out.println(i);
		}

	}
}
