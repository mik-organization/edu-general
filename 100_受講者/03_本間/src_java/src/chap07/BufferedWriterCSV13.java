package chap07;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterCSV13 {

	public static void main(String[] args) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("FileCSV1.csv"));
			for (int i = 1; i <= 5; i++) {
				int id = i;
				String name = "商品名" + (char) ('A' + i - 1);
				int price = i * 1000;
				
				// 値をコンマ区切りでつなぎ合わせる
				String rec = id + "," + name + "," + price;
				bw.write(rec + System.lineSeparator());
			}

		} catch (FileNotFoundException e) {
		} catch (IOException ee) {
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {

			}
		}
	}

}
