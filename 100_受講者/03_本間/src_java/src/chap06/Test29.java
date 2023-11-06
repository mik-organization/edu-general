package chap06;

public class Test29 {

	void arrays() throws ArrayIndexOutOfBoundsException {
		
		int i[] = new int[2];
		for (int j = 0; j <= 2; j++) {
			i[j] = j;
			System.out.println("i[" + j + "]=" + j);
		}
	}

}
