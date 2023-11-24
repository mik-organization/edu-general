package p04;

public class Human {
	String name;
	int age;
	
	Human(String n, int a){
		name = n;
		age = a;
	}
	
	void introduce() {
		System.out.println("名前:" + name);
		System.out.println("年齢:" + age);
	}

}
