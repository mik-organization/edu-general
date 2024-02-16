package p03;

public class Human {

	String name;
	int age;
	
	void eat(int money) {
		System.out.println(money + "円もらったので、寿司を食べます。");
	}
	
	void eat(String bento) {
		System.out.println(bento + "をもらったので、その弁当を食べます。");
	}
	
	void eat() {
		System.out.println("何もくれないので、自腹で食べます。");
	}
}
