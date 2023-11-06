package chap07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedRW11 {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		BufferedReader br = null;

		try {
			bw = new BufferedWriter(new FileWriter("File1.txt"));
			bw.write("福岡" + System.lineSeparator());
			bw.write("札幌" + System.lineSeparator());
			bw.write("東京" + System.lineSeparator());
			bw.flush();

			br = new BufferedReader(new FileReader("File1.txt"));
			String s;
			while ((s = br.readLine()) != null) {
				System.out.print(s);
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
