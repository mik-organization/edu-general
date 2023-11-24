import java.util.Scanner;

public class Sample16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		//（今回の場合だとコンソールに直接）キーボード入力ができるようにするおまじない。
		
		System.out.print("0以上の数値を入力してください。->");
		int data = sc.nextInt();
		//キーボードから整数値の入力をし、変数dataに格納する。
		
		if(data >= 0) {
			System.out.println("入力した数値:" + data);
		}else {
			System.out.println("0以上の数値ではありません。");
		}

	}

}
