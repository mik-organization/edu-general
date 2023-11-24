package p05;

public class Product {

	String name;
	int price;
	static double tax;
	
	Product(String n, int p, double t){
		name = n;
		price = p;
		tax = t;
	}

	void displayInfo() {
		System.out.println("商品名:" + name);
		System.out.println("単価:" + price);
		System.out.println("消費税:" + tax);
	}
}
