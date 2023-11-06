package chap09;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex07_A {
	public static void main(String[] args) {
		String seasons = "Spring Summer Autumn Winter";
		ArrayList<String> al = new ArrayList<>();
		try(Scanner scn = new Scanner(seasons)){
			while(scn.hasNext()) {
				al.add(scn.next());
			}
		}
		for(String s : al) {
			System.out.println(s);
		}
	}
}