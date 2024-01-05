package test05;

public class Sample02 {
	public static void main(String[] args) {
	try {
		throw new Exception();
	}catch(Exception e) {
		System.out.println("例外が発生しました。");
	}
}
}
