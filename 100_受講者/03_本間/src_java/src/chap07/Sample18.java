package chap07;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sample18 {
	public static void main(String[] args) {
		//tryの後に（）を付加しその中でインスタンスを生成
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("FileCSV1.csv"));) {
			for (int i = 1; i <= 5; i++) {
				int id = i;
				//商品名を生成。今回は前回と区別するため小文字aからにした
				String name = "商品名" + (char) ('A' + i - 1);
				int price = i * 1000; //価格を設定
				//値をコンマ区切りでつなぎ合わせる
				String rec = id + "," + name + "," + price;
				bw.write(rec + System.lineSeparator()); //改行を含めて書き出し
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		//close()がなくてもクローズされ、ファイルが書き出される
	}
}
