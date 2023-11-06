package chap06;

public class Car2 {
	/*
	1 Carクラスを元にCar2クラスを作る
	Car2で新しく追加する要素
	・「最高速度（maxSpeed）」をフィールドに追加する
	・フィールドを全て隠蔽し、getterメソを作る
	・巡行速度フィールドの値に対し、if文で0以上、最高速度未満となるようにする
	・infoメソで全てのフィールドの値を表示できるよう変更する
	2 そのCar2を継承させて、PassengerCar2、FreightCar2を作る
	・PassCarでは乗車定員（maxPassengers）、FreiCarでは最大積載量（maxLoading）を追加
	・これら2つのフィールドもgetterメソのみ定義
	・infoメソをオーバーライドし、自クラスの新フィールドを追加して表示させる
	
	3 Sample08_01から、実行するアプリケーションクラス SampleCar1を作る
	 
	 */

	// 車の基本性能
	private String maker; // メーカー名
	private String name; // 車名
	private int disVol; // 排気量
	private int year; // 年式
	private int maxSpeed; // 最高速度 
	private int cruiseSpeed = 0; // 巡行速度

	public Car2() {
		this("Unknown", "Unknown", 0, 2000, 180);
	}

	public Car2(String maker, String name, int disVol, int year, int maxSpeed) {
		this.maker = maker;
		this.name = name;
		this.disVol = disVol;
		this.year = year;
		this.maxSpeed = maxSpeed;
	}

	// getterの定義
	public String getMaker() {
		return maker;
	}

	public String getName() {
		return name;
	}

	public int getDisVol() {
		return disVol;
	}

	public int getYear() {
		return year;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getCruiseSpeed() {
		return cruiseSpeed;
	}

	// 巡行速度フィールドの値に対し、if文で0以上、最高速度未満となるようにする
	public void setCruiseSpeed(int cruiseSpeed) {
		if (cruiseSpeed > 0 & cruiseSpeed < this.maxSpeed) {
			this.cruiseSpeed = cruiseSpeed;
		} else {

			System.out.println(
					"--- " + this.name + "の巡行速度" + cruiseSpeed + "km/hは範囲外です。 ---");
		}
	}

	// 属性を表示するメソッド
	void information() {
		System.out.printf("%-10s", maker);
		System.out.printf("%-12s", name);
		System.out.printf("%6dcc", disVol);
		System.out.printf("%6d 年式", year);
		System.out.printf("最高速度 %-4dkm/h", maxSpeed);
		System.out.printf("%5dkm/h", cruiseSpeed);

	}

	// getInstance()メソッドを作る
	public static Car2 getInstance(String maker, String name,
			int disVol, int year, int maxSpeed, int num) {
		Car2 car = null;
		if (num >= 100) {

			car = new FreightCar2(maker, name, disVol, year, maxSpeed, num);
		} else {
			car = new PassengerCar2(maker, name, disVol, year, maxSpeed, num);
		}
		return car;
	}

}
