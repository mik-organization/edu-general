package p02;

public class StartUp {

	public static void main(String args[]) {
		Human h = new Human();
		
		h.name = "山田太郎";
		h.age = 23;
		
		h.introduce();
		h.walk();
		h.eat();
	}
}
