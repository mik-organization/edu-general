package test06;

public class StartUp01 {

	public static void main(String[] args) {
		String s ="ABCXYZ";
		
		//文字の長さを表示
		System.out.println("文字数:" + s.length());
		//引数で指定した位置にあるchar値を返す。開始位置は０
		System.out.println("１番目にある文字:" + s.charAt(1));
		//文字列の中で引数で指定した文字が何番目にあるか調べる。文字がなければ-1
		System.out.println("文字Cは何番目:" + s.indexOf('C'));
		//文字列から第一引数から第二引数までの部分をピックアップ
		System.out.println("XYZの部分をピックアップ:" + s.substring(3,6));
		//引数の文字列と比較する。同じであればtrue、違っていればfalseを返す
		System.out.println("XZYと等しい？:" + s.equals("XYZ"));
		//引数に指定したint値をString値に変換する
		System.out.println("数値の１５を数字で表示:" + String.valueOf(15));
	}

}
