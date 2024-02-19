package p09;

public class StatUp {

	public static void main(String[] args) {
		Human h1 = new Yamada();	
//		h1.playBaseball();	//アクセスできない
		h1.eat();
		
		Human h2 = new Sato();
//		h2.cook();		//アクセスできない
		h2.eat();
		
	}

}
