package chap07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderCSV14 {

	public static void main(String[] args) {
		BufferedReader br = null;
		String rec = null;
		String[] title = { "id", "商品名", "価格" };

		try {
			br = new BufferedReader(new FileReader("FileCSV1.csv"));

			while ((rec = br.readLine()) != null) {
				String[] str = rec.split(",");
				for (int i = 0; i < title.length; i++) {
					System.out.print(title[i] + "：" + str[i] + " ");
				}
				System.out.println();
			}

		} catch (FileNotFoundException e) {
		} catch (IOException ee) {
		} finally {
			try {
				if (br != null)
					br.close();

			} catch (IOException e) {

			}
		}
	}

}
