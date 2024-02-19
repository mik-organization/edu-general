package p13;

public class Sample00 {

	public static void main(String[] args) {
		try {
//			Exception e = new Exception();
//			throw e;
			
//			throw new Exception();
			throw new Exception("エラーだよ！");
		}catch(Exception e) {
//			System.out.println("例外が発生しました。");
			String m = e.getMessage();
			System.out.println(m);
		}

	}

}
