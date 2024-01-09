package test06;

public class StartUp03 {
	public static void main(String[] args) {
		String suji = "10";
		
		//引数で指定した数字（数値文字列）を数値（int値）に変換する
		int i = Integer.parseInt(suji);
		System.out.println("数字をint値に変換した値:" + i);		
		
		//引数で指定した数字（数値文字列）を数値（Integer値）に変換する
		Integer data = Integer.valueOf(suji);
		//オブジェクトが持つ値をint型の数値で返す
		System.out.println("Integer型をint型に変換した値:" +data.intValue());
		//オブジェクトが持つ値をdouble型の数値で返す
		System.out.println("Integer型をdouble型に変換した値:" +data.doubleValue());
		//オブジェクトが持つ値を数字（数値文字列）で返す
		System.out.println("Integer型をString型に変換した値:" +data.toString());
	}
}
