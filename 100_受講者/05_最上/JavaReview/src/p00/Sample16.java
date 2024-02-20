package p00;

import java.util.Scanner;

public class Sample16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("曜日を入力してください　->");
		String week = sc.next();
		
		switch(week) {
		case"月":System.out.println("本日のランチはハンバーグです。");break;
		case"火":System.out.println("本日のランチは鶏の唐揚げです。");break;
		case"水":System.out.println("本日のランチはパスタです。");break;
		case"木":System.out.println("本日のランチはカレーです。");break;
		case"金":System.out.println("本日のランチは鍋焼きうどんです。");break;
		default:System.out.println("本日のランチはありません。");break;
		}
		
		
	}

}
