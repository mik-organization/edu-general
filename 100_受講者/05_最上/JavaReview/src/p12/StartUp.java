package p12;

import p09.Human;

public class StartUp {

	public static void main(String[] args) {
		try {
//			int result = 10 / 0;
//			System.out.println(result);
			
//			Human h = null;
//			h.eat();
			
//			String s = "ABC";
//			int data = Integer.parseInt(s);
//			System.out.println(data);
			
			String [] list = {"AAA", "BBB", "CCC"};
			System.out.println(list[3]);
			
		}catch(ArithmeticException e) {
			System.out.println("0で割れません！");
		}catch(NullPointerException e) {
			System.out.println("オブジェクトが生成できていません！");
		}catch(NumberFormatException e) {
			System.out.println("数値に変換できません！");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("要素番号が指定できません！");
		}

	}

}
