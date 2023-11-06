package chap06;

public class PassengerCar2 extends Car2 {
	
	// 追加の属性
	private int maxPassengers;

	// コンストラクタ①
	public PassengerCar2() {
		// ()値なしの場合のデフォルト値
		this("Unknown", "Unknown", 0, 2000, 180, 1);
	}

	// コンストラクタ②
	public PassengerCar2(String maker, String name,
			int disVol, int year, int maxSpeed, int maxPassengers) {

		super(maker, name, disVol, year, maxSpeed);
		this.maxPassengers = maxPassengers;
	}
	
	public int getMaxPassenger() {
		return maxPassengers;
	}
	
	// 表示するメソッド
	@Override 
	void information() {
		super.information();
		System.out.printf("%4d 人乗", this.maxPassengers);
		System.out.println();
	}
}
