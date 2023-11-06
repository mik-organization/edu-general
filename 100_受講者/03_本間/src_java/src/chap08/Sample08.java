package chap08;

import java.text.NumberFormat;
import java.util.Locale;

public class Sample08 {
	public static void main(String args[]) {

		int number = 32800;

		//ロケールを取得
		Locale japan = new Locale("ja", "JP"); //日本

		//ロケールに対応したオブジェクトを生成
		NumberFormat nfJapan1 = NumberFormat.getInstance(japan);
		NumberFormat nfJapan2 = NumberFormat.getCurrencyInstance(japan);
		//デフォルト用　　数値フォーマット　通貨フォーマット
		NumberFormat nfDef1 = NumberFormat.getInstance();
		NumberFormat nfDef2 = NumberFormat.getCurrencyInstance();

		//フォーマットしたものを出力
		//日本用の数値フォーマット　通貨フォーマットで表示
		System.out.println(japan.getDisplayCountry());
		String ss = nfJapan2.format(number);
		System.out.println("数値にフォーマット : " + nfJapan1.format(number));
		System.out.println("通貨にフォーマット : " + ss);
		System.out.println();
		//デフォルト用の数値フォーマット　通貨フォーマットで表示
		System.out.println("デフォルト");
		System.out.println("数値にフォーマット : " + nfDef1.format(number));
		System.out.println("通貨にフォーマット : " + nfDef2.format(number));

	}
}
