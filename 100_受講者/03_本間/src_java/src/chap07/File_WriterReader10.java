package chap07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_WriterReader10 {

	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;

		try {
			fw = new FileWriter("File1.txt");
			fw.write("おはよう" + System.lineSeparator());
			fw.write("こんにちは" + System.lineSeparator());
			fw.write("こんばんは" + System.lineSeparator());
			fw.flush();

			fr = new FileReader("File1.txt");
			int c;
			while ((c = fr.read()) != -1) {
				System.out.println((char) c);
			}

		} catch (FileNotFoundException e) {
		} catch (IOException ee) {
		} finally {
			try {
				if (fw != null)
					fw.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {

			}
		}
	}

}
