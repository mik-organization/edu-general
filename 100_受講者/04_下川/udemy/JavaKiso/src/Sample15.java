import java.util.Scanner;
public class Sample15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		//（今回の場合だとコンソールに直接）キーボード入力ができるようにするおまじない。
		
		System.out.print("0以上の数値を入力してください。->");
		int data = sc.nextInt();
		//キーボードから整数値の入力をし、変数dataに格納する。
		
		if(data < 0) {
			System.out.println("0以上の数値ではありません。");
			System.exit(1); //プログラムを強制終了する
			//キーボードから入力した値が0より小さいのであれば、System.out.printlnを用いて0以上の数値ではありません。と表示し、強制終了する。
		}

		System.out.println("入力した数値:" + data);
		//キーボードから入力した値が0より大きいのであれば、System.out.printlnを用いて入力した数字を表示する。
	}

}
        /*まず実行を押す。0以上の数値を入力してください。->と実行結果に表示されるため、
         * その横に数値を入力してエンターを押すと、それに元図いた結果がさらに下の行に表示される。*/
