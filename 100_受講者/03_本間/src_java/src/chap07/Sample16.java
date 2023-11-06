package chap07;

import java.util.Scanner;

public class Sample16 {

	public static void main(String[] args) {

		String str="one two three four five";
		Scanner sc=new Scanner(str);
		
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
	}

}
