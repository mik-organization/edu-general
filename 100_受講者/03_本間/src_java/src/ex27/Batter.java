package ex27;

public class Batter extends Sportsman {

	// フィールド
	double avg;

	// メソッド
	public void introduction() {
		String s = Integer.toString((int) (this.avg * 1000));
		System.out.println(name + "（Batter）打率："
				+ s.charAt(0) + "割" + s.charAt(1) + "分" + s.charAt(2) + "厘");
	}

	// コンストラクタ
	public Batter(String name, int category, double avg) {

		super(name, category);
		this.avg = avg;
	}
}
