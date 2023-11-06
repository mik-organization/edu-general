
package chap08;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex20 {
	public static void main(String[] args) {
		//データ
		String[] dataItem = { "ジーンズ", "Tシャツ", "ブーツ" };
		int[] itemPrice = { 19800, 7200, 39800 };

		Locale localeJP = new Locale("ja", "JP");

		//数値をフォーマット
		NumberFormat nfCurrency = NumberFormat.getCurrencyInstance(localeJP);

		for (int i = 0; i < dataItem.length; i++) {
			
			System.out.print(dataItem[i] + ":" );
			
			String formatedPrice = nfCurrency.format(itemPrice[i]);
			System.out.println(formatedPrice);
		}
		
	}
}
