package chap06;

public class Car {

	// 車の基本性能
	String maker; // メーカー名
	String name; // 車名
	private int disVol; // 排気量
	int year; // 年式
	int cruseSpeed; // 巡行速度

	// コンストラクタ①
	public Car() {
		/*
		ブロック内で、this()とすることで、thisが上のCarを呼び出して、
		引数のあるCarメソッドとして、コンストラクタ②が呼び出される 
		 */
		this("Unknown", "Unknown", 0, 2000, 0); 
	}

	// コンストラクタ②
	public Car(String maker, String name, int disVol, int year, int cruseSpeed) {
		this.maker = maker;
		this.name = name;
		this.disVol = disVol;
		this.year = year;
		this.cruseSpeed = cruseSpeed;
	}

	// 属性を表示するメソッド
	void information() {
		System.out.printf("%-10s", maker);
		System.out.printf("%-12s", name);
		System.out.printf("%6dcc", disVol);
		System.out.printf("%6d 年式", year);
		System.out.printf("%5dkm/h", cruseSpeed);
	}
}
