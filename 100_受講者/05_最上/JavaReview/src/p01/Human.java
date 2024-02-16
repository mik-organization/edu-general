package p01;

public class Human {

	String name;
	int age;
	
	void introduce() {
		System.out.println("名前:" + name);
		System.out.println("年齢:" + age);
	}
	
	void walk() {
		System.out.println("歩いています。");
	}
	
	void eat() {
		System.out.println("食事をしています。");
	}
}
