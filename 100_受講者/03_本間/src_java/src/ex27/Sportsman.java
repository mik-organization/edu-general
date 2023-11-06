package ex27;

public abstract class Sportsman {

	// フィールド
	String name;
	int category;
	int point;
	static int totalPoint;

	String CATEGORY_NAME;

	// メソッド
	void setPoint(int point) {
		this.point += point;
		totalPoint += point;
	}

	abstract void introduction();

	public static Sportsman getInstance(String name, int category, double num) {
		Sportsman spo = null;
		if (category == 1) {
			spo = new Pitcher(name, category, num);
		}else if(category == 2) {
			spo=new Batter(name, category, num);
		}
		
		return spo;
	}

	// コンストラクタ
	public Sportsman() {

	}

	public Sportsman(String name, int category) {
		this.name = name;
		this.category = category;
		if(category==1) {
			CATEGORY_NAME="Pitcher";
		}else if(category==2) {
			CATEGORY_NAME="Batter";
		}else {
			System.out.println("エラーが発生しました。");
		}
		System.out.println(name + "さんが登録しました。カテゴリーは" +  CATEGORY_NAME + "です。");
	}
}
