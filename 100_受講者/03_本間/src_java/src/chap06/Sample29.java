package chap06;

public class Sample29 {

	public static void main(String[] args) {
		
		try {
			Test29 t1 = new Test29();
			t1.arrays();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("配列エラーが発生しました。");
		} finally {
			System.out.println("終了します。");
		}
	}
}
