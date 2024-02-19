package p12;

import p09.Human;

public class StartUp01 {
	public static void main(String[]args) {
		try {
			int result = 10 / 0;
			System.out.println(result);
			
//			Human h = null;
//			h.eat();
			
		}catch(ArithmeticException e) {
			e.printStackTrace();
//			String m = e.getMessage();
//			System.out.println(m);
//			System.out.println("0で割れませんよ！");
//		}catch(NullPointerException e) {
//			System.out.println("オブジェクトが生成されてないよ！");
//
//		}catch(Exception e) {
//			System.out.println("例外が発生しました。");		
//		}finally {
//			System.out.println("終了します。");
		}
	}

}
