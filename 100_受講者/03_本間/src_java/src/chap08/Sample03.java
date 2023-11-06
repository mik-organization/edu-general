package chap08;

public class Sample03 {
	public static void main(String[] args) {
		String str1 = "あいうえお";
		String str2 = "かきくけこ";
		String str3 = "あいうえお";
		String str4 = new String("あいうえお");
		System.out.println("内容が等しいか？(equals()メソッド)");
		System.out.println("str1.equals(str2) : " + str1.equals(str2));
		System.out.println("str1.equals(str3) : " + str1.equals(str3));
		System.out.println("str1.equals(str4) : " + str1.equals(str4));
		System.out.println("str2.equals(str3) : " + str2.equals(str3));
		System.out.println("str2.equals(str4) : " + str2.equals(str4));
		System.out.println("str3.equals(str4) : " + str3.equals(str4));

		System.out.println("同じオブジェクトか？（==演算子）");
		System.out.println("str1 == str2 	  : " + (str1 == str2));
		System.out.println("str1 == str3 	  : " + (str1 == str3));
		System.out.println("str1 == str4      : " + (str1 == str4));
		System.out.println("str2 == str3      : " + (str2 == str3));
		System.out.println("str2 == str4      : " + (str2 == str4));
		System.out.println("str3 == str4      : " + (str3 == str4));
	}
}



















