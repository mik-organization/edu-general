//例外02　try～catch文で複数の例外処理を行う

package p12;

import vo.Human;

public class StartUp_ca2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int result = 10/0;
			System.out.println(result);
			
			Human h = null;
			h.eat();
		}catch(ArithmeticException e) {
			System.out.println("0で割れませんよ！");
		}catch(NullPointerException e) {
			System.out.println("オブジェクトが生成されていませんよ!");
		}
	}

}
