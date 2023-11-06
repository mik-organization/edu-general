package chap07;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream05 {

	public static void main(String[] args) {

		try {
			// オープン処理
			FileInputStream fis = new FileInputStream("newFile.txt");

			int c;
			while ((c = fis.read()) != -1) {
				System.out.print((char) c + " ");
			}

			// クローズ処理
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
