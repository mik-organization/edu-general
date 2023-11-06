package chap12;

import java.util.ArrayList;

public class SuppressWarningsTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		al.add("abcd");

		@SuppressWarnings("unused")
		int i = 0;
	}

}
