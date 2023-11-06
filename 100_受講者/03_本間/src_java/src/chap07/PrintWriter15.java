package chap07;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter15 {

	public static void main(String[] args) {

		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter("File4.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 3; i++) {
			pw.print("print " + i + " ");
			pw.println("println " + i + " ");
			pw.printf("printf %s", i + " ");
		}
		System.out.println("データの書き込みが終わりました。");

		pw.close();
	}

}
