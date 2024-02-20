package p00;

public class Sample04 {

	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		
		x += y;
		System.out.println("加算結果：" + x);		
		x -= y;
		System.out.println("減算結果：" + x);
		x *= y;
		System.out.println("乗算結果：" + x);
		x /= y;
		System.out.println("除算結果：" + x);
		x %= y;
		System.out.println("剰余結果：" + x);

	}

}
