package test02;

public class Yamada02 extends Human{
	public void playBaseball() {
		System.out.println("野球をしています。");
	}
	
	public void eat() {
		super.eat();
		System.out.println("ラーメンを食べました。");
	}

}
