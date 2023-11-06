package chap08;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

//必要なパッケージをインポート

public class Ex19 {
	public static void main(String[] args){
		
		//日本のロケールを取得
		Locale lo = new Locale("ja","JP");
		
		//取得したロケールの国名を表示
		System.out.print("取得したロケールの国名 : ");
		System.out.println(lo.getDisplayCountry());
		
		//取得したロケールの言語名を表示
		System.out.print("取得したロケールの言語名 : ");
		System.out.println(lo.getDisplayLanguage());
		Double num = 55555.555;
		
		//数値をフォーマット
		NumberFormat nf = NumberFormat.getInstance(lo);
		
		//数値numをフォーマットして表示
		System.out.print("数値フォーマット : ");
		System.out.println(nf.format(num));
		
		//日付をフォーマット
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy'/'MM'/'dd" + " " + "E'曜日'" + " " + "H':'m':'s");
		
		//日付をフォーマットして表示
		System.out.print("日付フォーマット : ");
		System.out.println(sdf.format(Calendar.getInstance().getTime()));
		}
}
