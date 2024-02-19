package p13;

public class Sample {

	public static void main(String[] args) {
		try {
			int result = waru(10, 0);
			System.out.println(result);
		}catch(ArithmeticException e) {
			System.out.println("0で割れません。");
		}
	}

	static int waru(int x, int y)throws  ArithmeticException{
		if(y == 0) {
		throw new ArithmeticException();
		}
		return x/y; 
	}
}
