package Section01;

import java.util.Scanner;

public class Sample19b {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int data;
		
		do {
			System.out.print("数値を入力してください。->");
			data = sc.nextInt();
			
			System.out.println(data);
		}while(data > 0);
		
		System.out.println("終了します。");
		
	}

}
