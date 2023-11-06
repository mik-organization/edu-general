package chap06;

public class FreightCar2 extends Car2 {
	
	// 追加の属性
	private int maxLoading;

	// コンストラクタ①
	public FreightCar2() {
		// // ()値なしの場合のデフォルト値
		this("Unknown", "Unknown", 0, 2000, 150, 1);
	}

	// コンストラクタ②
	public FreightCar2(String maker, String name,
			int disVol, int year, int maxSpeed, int maxLoading) {

		super(maker, name, disVol, year, maxSpeed);
		this.maxLoading = maxLoading;
	}
	
	public int getMaxLoading() {
		return maxLoading;
	}
	
	// 表示するメソッド
	@Override
	void information() {
		super.information();
		System.out.printf("%8dKg", this.maxLoading);
		System.out.println();
	}
}
