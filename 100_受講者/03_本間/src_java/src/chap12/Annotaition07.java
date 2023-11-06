package chap12;

public class Annotaition07 extends Superclass1{
	@Override
	public void talk() {
		System.out.println("Children");
	}
	public static void main(String[] args) {
		Annotaition07 sb = new Annotaition07();
		sb.talk();
	}
}
