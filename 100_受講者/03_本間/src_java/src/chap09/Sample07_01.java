package chap09;

import java.util.ArrayList;

public class Sample07_01 {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		al.add(new Integer(10));
		al.add(new Double(3.14));
		//al.add(new String("abc"));
		disp(al);
		
	}
	public static void disp(ArrayList al) {
		for(Object obj: al) {
			if(obj instanceof Integer) {
				System.out.println(((Integer)obj).toString() +"は、Integer型です。");	
			}else if(obj instanceof Double) {
				System.out.println(((Double)obj).toString() +"は、Double型です。");	
			}
		}
	}

}
