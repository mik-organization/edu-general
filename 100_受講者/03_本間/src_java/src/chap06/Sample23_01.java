package chap06;

public class Sample23_01 {

	public static void main(String[] args) {
		int[] i = new int[2];

		try {
			for (int j = 0; j <= 2; j++) {
				i[j] = j / (j - 2);
				System.out.println("i[" + j + "]=" + i[j]);
			}

		} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
			System.out.println("エラーが発生しました。");
		} catch (Exception e) {
			System.out.println("エラーが発生しました。");
			e.printStackTrace();
		} finally {
			System.out.println("終了します。");
		}
	}
}
