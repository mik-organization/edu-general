package chap07;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter07 {

	public static void main(String[] args) {

		try {
			// オープン処理
			FileWriter fw = new FileWriter("File1.txt");

			for (int i = 1; i <= 5; i++) {
				fw.write(i + "行目");
			}

			// クローズ処理
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
