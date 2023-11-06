package chap08;
import java.text.NumberFormat;
public class Ex20_A {
	public static void main(String[] args){
		//データ
		String[][] data = {{"ジーンズ","19800"}
							 ,{"Tシャツ","7200"}
							 ,{"ブーツ","39800"}};
		//通貨用フォーマットの生成
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		//配列のそれぞれの名前とフォーマットされた金額を表示
		for(String[] s: data){
			//商品名の表示
			System.out.print(s[0] + ":");
			//文字列の価格を数値(int型)に変換
			int kakaku = 0;
			try{
				kakaku = Integer.parseInt(s[1]);
			}catch(NumberFormatException e){
				System.out.print("数値以外のデータです！");
			}
			//数値の価格を通貨用フォーマットで表示
			System.out.println(nf.format(kakaku));
		}

	}
}
