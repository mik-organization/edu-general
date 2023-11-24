import java.util.Scanner;

public class Sample23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int data;
		do {
			System.out.print("数値を入力してください。 -> ");
			data = sc.nextInt();
			
			System.out.println(data);
		} while(data > 0);
		
		System.out.println("終了します。");
	}

}
/*キーボードで入力した数値を表示するプログラム。
 * ただし、0以下の数値を入力すると終了する*/
