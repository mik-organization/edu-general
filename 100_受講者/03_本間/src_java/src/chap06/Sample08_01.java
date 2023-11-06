package chap06;

public class Sample08_01 {

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

		// Carクラス型の配列
		Car[] cars = {
				new PassengerCar("Honda", "Fit", 1800, 2015, 50, 4),
				new FreightCar(),
				new FreightCar("FUSO", "Fighter", 7500, 2012, 40, 4000),
				new PassengerCar()
		};

		// 配列の中にあるオブジェクトを順番に、information()で呼び出す
		for (Car i : cars) { 
			/* 
			carsの参照値の中で、Car配列の要素数をiとして
			0からカウントアップしながら処理を繰り返す
			 */
			i.information();
			
		}


	}

}
