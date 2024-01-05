package test00;

import java.util.Scanner;

public class Sample16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//キーボード入力
		Scanner sc = new Scanner(System.in);
		
		System.out.print("曜日を入力してください。->");
		String week = sc.next();
		
		switch(week) {
		case "月":	System.out.println("月曜日のランチはハンバーグです。");	break;
		case "火":	System.out.println("火曜日のランチは鳥のからあげです。");	break;
		case "水":	System.out.println("水曜日のランチはパスタです。");	break;
		case "木":	System.out.println("木曜日のランチはカレーです。");	break;
		case "金":	System.out.println("金曜日のランチは鍋焼きうどんです。");	break;
		default:	System.out.println("ランチはありません。");	break;
		
		}
		
		
		
		

	}

}
