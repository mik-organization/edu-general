package p08;

public class Yamada extends Human{
	public void playBaseball() {
		System.out.println("野球をしています。");
	}
	
	public void eat() {
		super.eat();
		System.out.println("ラーメンを食べました。");
	}

}
