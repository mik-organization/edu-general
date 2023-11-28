package p12;

import vo.Human;

public class StartUp_ca3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int result = 10/0;
			System.out.println(result);
			
			Human h = null;
			h.eat();
		}catch(Exception e) {
			System.out.println("例外が発生しました！");
		}
	}

}
