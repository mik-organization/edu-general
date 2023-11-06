package chap06;

import java.io.IOException;

public class Sample31 {

	public static void main(String[] args) throws IOException {
		char c; //入力された文字
		c = (char)System.in.read();
		System.out.println("入力された文字は、" + c + "です。");
	}

}
