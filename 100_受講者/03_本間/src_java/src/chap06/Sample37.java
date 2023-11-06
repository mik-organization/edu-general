package chap06;

public class Sample37 {

	public static void main(String[] args) {

		//Super37 ss=new Super37();
		Super37 ss = new Sub37A();
		
		Super37 sb = new Sub37B();

		ss.me();
		ss.ab();
		
		sb.ab(); // 中身のないメソッドを（例外も起こさずに）呼び出すことができる
	}
}
