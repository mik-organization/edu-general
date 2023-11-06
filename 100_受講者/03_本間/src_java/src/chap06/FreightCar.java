package chap06;

public class FreightCar extends Car {

	// 追加の属性
	int maxLoading;

	// コンストラクタ①
	public FreightCar() {
		// // ()値なしの場合のデフォルト値
		this("Unknown", "Unknown", 0, 2000, 0, 1);
	}

	// コンストラクタ②
	public FreightCar(String maker, String name,
			int disVol, int year, int cruseSpeed, int maxLoading) {

		super(maker, name, disVol, year, cruseSpeed);
		this.maxLoading = maxLoading;
	}

	// 表示するメソッド
	@Override
	void information() {
		super.information();
		System.out.printf("%8dKg", this.maxLoading);
		System.out.println();
	}
}
