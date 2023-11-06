package chap06;

public class PassengerCar extends Car {

	// 追加の属性
	int maxPeesenger;

	// コンストラクタ①
	public PassengerCar() {
		// ()値なしの場合のデフォルト値
		this("Unknown", "Unknown", 0, 2000, 0, 1);
	}

	// コンストラクタ②
	public PassengerCar(String maker, String name,
			int disVol, int year, int cruseSpeed, int maxPassenger) {

		super(maker, name, disVol, year, cruseSpeed);
		this.maxPeesenger = maxPassenger;
	}

	// 表示するメソッド
	@Override 
	void information() {
		super.information();
		System.out.printf("%4d 人乗", this.maxPeesenger);
		System.out.println();
	}
}
