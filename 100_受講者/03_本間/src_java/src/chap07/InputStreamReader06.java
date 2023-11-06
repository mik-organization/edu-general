package chap07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader06 {

	public static void main(String[] args) {

		try {
			// オープン処理
			FileInputStream fis = new FileInputStream("newFile.txt");
			InputStreamReader isr = new InputStreamReader(fis);

			int c;
			while ((c = isr.read()) != -1) {
				System.out.print((char) c + " ");
			}

			// クローズ処理
			isr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
