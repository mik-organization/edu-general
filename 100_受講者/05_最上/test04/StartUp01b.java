package test04;

import vo.Human;

public class StartUp01b {

	public static void main(String[] args) {
		try {
			int result = 10/2;
			System.out.println(result);
			
			Human h =null;
			h.eat();
		}catch(ArithmeticException e) {
			System.out.println("0で割れませんよ！");
		}catch(NullPointerException e) {
			System.out.println("オブジェクトが生成されてないよ！");
		}
	}

}
