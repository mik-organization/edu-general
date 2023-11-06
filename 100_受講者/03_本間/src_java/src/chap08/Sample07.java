package chap08;

import java.util.Locale;

public class Sample07 {

	public static void main(String[] args) {

		// 言語と国のロケールを取得
		Locale japan = new Locale("ja", "JP");
		Locale usa = new Locale("en", "US");
		Locale china = new Locale("zh", "CN");

		System.out.println("japanのロケール→言語「" +
				japan.getDisplayLanguage() + "」、国「" + japan.getDisplayCountry() + "」");
		
		System.out.println("usaのロケール→言語「" +
				usa.getDisplayLanguage() + "」、国「" + usa.getDisplayCountry() + "」");
		
		System.out.println("chinaのロケール→言語「" +
				china.getDisplayLanguage() + "」、国「" + china.getDisplayCountry() + "」");
		
		
		Locale def =  Locale.getDefault();
		System.out.println("defaultのロケール→言語「" +
				def.getDisplayLanguage() + "」、国「" + def.getDisplayCountry() + "」");
	}

}
