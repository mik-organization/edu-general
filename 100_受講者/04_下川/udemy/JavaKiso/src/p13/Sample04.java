package p13; //throwsキーワードを使った例外処理

public class Sample04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int result = waru(10,0);
			System.out.println(result);
		}catch(ArithmeticException e){
			System.out.println("0で割れません。");
		}
	}

	static int waru(int x, int y) throws ArithmeticException{
		if(y == 0) {
			throw new ArithmeticException();
		}
		
		return x/y;
	}
	
}
