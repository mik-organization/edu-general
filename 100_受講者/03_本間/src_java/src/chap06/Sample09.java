package chap06;

public class Sample09 {

	public static void main(String[] args) {
		Myclass09 myc = new Myclass09(-2.5 , 3.5);
		
		System.out.println("Area = " + myc.getArea());
		
		//myc.width=1.5;
		//myc.height=3.0;
		myc.setWidth(-1.5);
		myc.setHeight(-3.0);
		
		System.out.println("Area = " + myc.getArea());
	}

}
