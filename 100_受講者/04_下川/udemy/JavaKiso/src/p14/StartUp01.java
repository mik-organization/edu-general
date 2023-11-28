package p14;

public class StartUp01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ABCXYZ";
		
		System.out.println("文字数:" + s.length());
		System.out.println("1番目にある文字:" + s.charAt(1));
		System.out.println("文字Cは何番目:" + s.indexOf('C'));
		System.out.println("XYZの部分をピックアップ:" + s.substring(3,6));
		System.out.println("XYZと等しい？:" + s.equals("XYZ"));
		
		System.out.println("数値の15を数字で表示:" + String.valueOf(15));
	}

}
