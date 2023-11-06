package chap09;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {

		String seasons = "Spring Summer Autumn Winter";

		ArrayList<String> seasonsList = new ArrayList<>();
		Scanner scan = new Scanner(seasons);
		while (scan.hasNext()) {
			seasonsList.add(scan.next());
		}
		scan.close();
		for (String s : seasonsList) {
			System.out.println(s);
		}
	}

}