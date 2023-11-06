package chap07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sample17A {

	public static void main(String[] args) {
		BufferedReader br = null;
		Scanner sc = null;

		try {
			br = new BufferedReader(new FileReader("FileCSV1.csv"));
			String rec;
			while ((rec = br.readLine()) != null) {
				sc = new Scanner(rec);
				sc.useDelimiter(",");
				while (sc.hasNext()) {
					System.out.print(sc.next() + " ");
				}
				System.out.println();
			}

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
