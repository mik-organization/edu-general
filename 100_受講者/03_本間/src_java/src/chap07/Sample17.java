package chap07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sample17 {

	public static void main(String[] args) {

		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader("FileCSV1.csv")));
			sc.useDelimiter(",");
			while (sc.hasNext()) {
				System.out.print(sc.next() + " ");
			}
		
		} catch (IOException ee) {
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
