package chap06;

public class Sample35 {

	public static void main(String[] args) {
		double d = 1.0;
		double e = 0.0;
		try {
			if (e == 0.0) {
				// MyException m = new MyException();
				// m.msg();
				// throw m;
				
				throw new MyException("0割り算エラーが発生しました。");

			}
			System.out.println(d / e);
		} catch (MyException e1) {
			//System.out.println("0割り算です。");
			
			e1.msg();
		}
	}
}
