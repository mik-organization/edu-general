package test04;

import vo.Human;

public class StartUp01c {

	public static void main(String[] args) {
		try {
			int result = 10/2;
			System.out.println(result);
			
			Human h =null;
			h.eat();
		}catch(Exception e) {
			System.out.println("例外が発生しました！");
		}
	}

}
