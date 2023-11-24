import java.util.Scanner;

public class Sample17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		//（今回の場合だとコンソールに直接）キーボード入力ができるようにするおまじない。
		
		System.out.print("曜日を入力してください。 ->");
		String week = sc.next();
		//キーボードから文字列の入力をし、変数sに格納する。
		
		switch(week) {
		case"月" : System.out.println("本日のランチはハンバーグです。"); break;
		case"火" : System.out.println("本日のランチは鶏のからあげです。"); break;
		case"水" : System.out.println("本日のランチはパスタです。"); break;
		case"木" : System.out.println("本日のランチはカレーです。"); break;
		case"金" : System.out.println("本日のランチは鍋焼きうどんです。"); break;
		default : System.out.println("ランチはありません。"); break;
		}
	}

}
