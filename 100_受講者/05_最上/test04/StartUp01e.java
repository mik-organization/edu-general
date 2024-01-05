package test04;

import vo.Human;

public class StartUp01e {

	public static void main(String[] args) {
		try {
			int result = 10/0;
			System.out.println(result);
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}
	}

}
