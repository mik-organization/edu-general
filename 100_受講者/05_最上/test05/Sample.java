package test05;

public class Sample {
	public static void main(String[] args) {
	try {
		Exception e = new Exception();
		throw e;
	}catch(Exception e) {
		System.out.println("例外が発生しました。");
	}
}
}
