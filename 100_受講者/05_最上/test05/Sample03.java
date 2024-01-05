package test05;

public class Sample03 {
	public static void main(String[] args) {
	try {
		throw new Exception("エラーだよ！");
	}catch(Exception e) {
		String m = e.getMessage();
		System.out.println(m);
	}
}
}
