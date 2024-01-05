package test04;

public class StartUp01a {

	public static void main(String[] args) {
		try {
			int result = 10/0;
			System.out.println(result);
		}catch(ArithmeticException e) {
			System.out.println("0で割れませんよ！");
		}finally {
			System.out.println("終了します。");
		}
	}

}
