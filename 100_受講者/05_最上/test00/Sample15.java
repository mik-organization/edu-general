package test00;

import java.util.Scanner;

public class Sample15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//キーボード入力
		Scanner sc = new Scanner(System.in);
		
		System.out.print("0以上の数値を入力してください。->");
		int data = sc.nextInt();
		
		if(data >= 0) {
			System.out.println("入力した数値:" +data);
		}else {
			System.out.println("0以上の数値ではありません。");
		}
		
		
		
		

	}

}
