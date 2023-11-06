package chap06;

public class Sample08 {

	public static void main(String[] args) {

		/*前提情報
		 
		String maker; メーカー名
		String name;  車名
		int disVol;  排気量
		int year;  年式
		int cruseSpeed;  巡行速度
		int maxPassenger:  乗車定員
		
		 PassengerCar(String maker, String name,
		  		int disVol, int year, int cruseSpeed, int maxPassenger)
		  		
		 FreightCar(String maker, String name,
			int disVol, int year, int cruseSpeed, int maxLoading)
		 */

		// ()の中で、インスタンス化と同時に情報をセットする
		PassengerCar fit = new PassengerCar("Honda", "Fit",
				1800, 2015, 50, 4);
		// ()に値なしで
		PassengerCar un = new PassengerCar();
		
		FreightCar fuso = new FreightCar("FUSO", "Fighter",
				7500, 2012, 40, 4000);

		fit.information();
		un.information(); //デフォコンが呼び出されて、既定のデフォルト値が表示される
		fuso.information();
		
		/*
		 上の実行すると、
		 
		0
		sub
		
		と表示されるが、
		sa の頭にある型を優先するので、親側の値が参照される
		ただし、同名メソッドがある場合には、新しいもの（今回はsub）の内容に
		置き換えられて、参照されるため、
		この例では継承された子クラスのメソッドが参照され、表示される
		 
		 
		 */

	}

}
