package chap09;

import java.util.ArrayList;

public class Sample04 {
	public static void main(String args[]) {
		
		MyNumber1 n1=new MyNumber1(1);
		MyNumber1 n2=new MyNumber1(2);
		MyNumber1 n3=new MyNumber1(3);
		
		ArrayList al = new ArrayList();
		al.add(n1);
		al.add(n2);
		al.add(n3);
		
		for(Object obj:al){
			System.out.println(((MyNumber1)obj).num);
		}
		
		al.add(0,n3);
		System.out.println();
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(((MyNumber1)al.get(i)).num);
		}
	}
}
