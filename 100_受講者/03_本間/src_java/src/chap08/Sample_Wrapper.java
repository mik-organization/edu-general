package chap08;

public class Sample_Wrapper {

	public static void main(String[] args) {
		//ラッパークラスの生成
		Integer i1 = new Integer(10); //int型をコンストラクターの引数にとる
		System.out.println("i1:" + i1);

		Integer i2 = new Integer("10"); //String で表されたint 型を引数にとる
		System.out.println("i2:" + i2 * 2);
		//Integer i3 = new Integer("one");

		//valueOf()メソッド
		Double d1 = Double.valueOf(3.14); //double型を引数に
		Double d2 = Double.valueOf("3.14"); //String で表されるdouble 型を引数に
		//Double d3 = Double.valueOf("three");
		//parse×××()メソッド
		int i = Integer.parseInt("10");
		double d = Double.parseDouble("10.0");
		//×××Value()メソッド
		Integer ii = new Integer(10); //Integerオブジェクトを生成
		double dd = ii.doubleValue(); //double型に変換
		System.out.println(dd); //"10.0"が出力される
		//equals()メソッド
		Double dd1 = new Double(10.0);
		Double dd2 = new Double(10.0);
		Integer iix = new Integer(10);
		System.out.println(dd1.equals(dd2)); //true が出力される
		System.out.println(dd1 == dd2); //false が出力される
		//AutoboxingとUnboxing
		int ii1 = 10;
		Integer ii2 = ii1; //int型の値をIntegerへ（Autoboxing）
		ii1 = ii2; //Integer 型のオブジェクトをint 型へ（Unboxing）

	}

}
