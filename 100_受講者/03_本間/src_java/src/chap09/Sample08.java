package chap09;

import java.util.ArrayList;

public class Sample08 {

	public static void main(String[] args) {
		
		ArrayList<String> al= new ArrayList<String>();
		al.add(new String("とても便利なジェネリックス"));
		
		System.out.print(al.get(0));
		
	}

}
