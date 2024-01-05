package test01;

public class Human02 {
	String name;
	int age;

	Human02(String n , int a){
		name = n;
		age = a;
	}
	void introduce() {
		System.out.println("名前:" + name);
		System.out.println("年齢:" + age);
	}

}
