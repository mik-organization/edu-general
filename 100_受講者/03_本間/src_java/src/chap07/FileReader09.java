package chap07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader09 {

	public static void main(String[] args) {

		FileReader fr = null;

		try {
			
			fr = new FileReader("File1.txt");
			int c;
			while ((c = fr.read()) != -1) {
				System.out.println((char) c);
			}

		} catch (FileNotFoundException e) {
		} catch (IOException ee) {
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {

			}
		}
	}

}
