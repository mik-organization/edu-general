package p13; //throwキーワードを使った例外処理

public class Sample02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			throw new Exception("エラーだよ！");
			
		}catch(Exception e) {
			String m = e.getMessage();
			System.out.println(m);
		}

	}

}
