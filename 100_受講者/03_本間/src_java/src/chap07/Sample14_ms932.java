package chap07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Sample14_ms932 {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		BufferedReader br = null;

		try {
			//br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter
					(new FileOutputStream("FileCSV1ms932.csv"),"MS932"));

			System.out.print("\n 文字を入力してください（qで終了）：");
			String s;
			while (!(s = br.readLine()).equals("q")) {
				bw.write(s + System.lineSeparator());
				System.out.print("\n 文字を入力してください（qで終了）：");

			}

		} catch (FileNotFoundException e) {
		} catch (IOException ee) {
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
			} catch (IOException e) {

			}
		}
	}

}
