package chap06;

public class Sample45 {

	public static void main(String[] args) {
		/* Sub45クラスのインスタンスをそれぞれのインターフェース型の変数に代入 */
		InterSuper45A 	inter1 = new Sub45(); //インターフェース①型の変数
		InterSuper45B 	inter2 = new Sub45(); //インターフェース②型の変数
		InterSub45 		inter3 = new Sub45(); //インターフェース③型の変数
		
		InterSub45 		inter4 = (InterSub45)inter1;
		
		/* メソッドの呼び出し */
		inter1.method1();
		inter4.method2();
		inter4.method3();

		((InterSuper45A) inter2).method1();
		inter2.method2();
		//inter2.method3();

		inter3.method1();
		inter3.method2();
		inter3.method3();


	}

}
