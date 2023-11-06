package chap06;

public class Myclass09 {
	//フィールド
	private double width; //横
	private double heigth; //縦
	
	// コンストラクター
	public Myclass09(double width, double heigth) {
		//this.width = width;
		//this.height = heigth;
		setWidth(width);
		setHeight(heigth);
	}

	//アクセスメソッド
	public double getArea() {
		return this.width * this.heigth;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width > 0) {
			this.width = width;
		} else {
			System.out.println("不当な幅「" + width + "」を代入しようとしました。");
			this.width = 0;
		}
	}

	public double getHeight() {
		return heigth;
	}

	public void setHeight(double height) {
		if (height > 0) {
			this.heigth = height;
		} else {
			System.out.println("不当な高さ「" + height + "」を代入しようとしました。");
			this.heigth = 0;
		}
	}

}
