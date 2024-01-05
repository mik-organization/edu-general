package test04;

import vo.Human;

public class StartUp01d {

	public static void main(String[] args) {
		try {
			int result = 10/0;
			System.out.println(result);
		}catch(ArithmeticException e) {
			String m = e.getMessage();
			System.out.println(m);
		}
	}

}
