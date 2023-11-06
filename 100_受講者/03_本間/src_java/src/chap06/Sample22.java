package chap06;

public class Sample22 {

	public static void main(String[] args) {
		Super22 spr = new Super22();
		Super22 ssb = new Sub22();
		Sub22 sb = new Sub22();
		spr.method(777);
		//spr.method("Hello"); //コメントアウト
		ssb.method(777);
		//ssb.method("Hello"); //コメントアウト
		sb.method(777);
		sb.method("Hello");
	}

}
