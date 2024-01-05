package test03;

public class StartUp02 {

	public static void main(String[] args) {
		System.out.println("社訓:" + ZZZ.POLICY);
		
		ZZZ z1 = new Yamada();
		z1.work();
		z1.salary();
		
		ZZZ z2 = new Sato();
		z2.work();
		z2.salary();

	}

}
