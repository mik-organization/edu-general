package p13;

public class Sample02 {

	public static void main(String[] args) {
		try {
			int result = waru(10, 0);
			System.out.println(result);
		}catch(UserException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int waru(int x, int y) throws UserException{
		if(y == 0) {
			System.out.println("0で割れないよ！");
		}
		
		return x / y;
	}

}
