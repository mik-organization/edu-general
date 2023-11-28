package p13; //throwキーワードを使った例外処理

public class Sample01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Exception e = new Exception();
			throw e;
			/*try内の別の記述の仕方
			 throw new Exception();
			 */
		}catch(Exception e) {
			System.out.println("例外が発生しました。");
		}

	}

}
