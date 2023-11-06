package ex27;

public class Pitcher extends Sportsman {

	// フィールド
	int win;

	// メソッド
	public void introduction() {
		System.out.println(name + "（Pitcher）勝ち組：" + win + "勝");
	}
	
	// コンストラクタ
	public Pitcher(String name, int category, double win) {
		
		super(name, category);
		this.win=(int)win;
		
	}
}
