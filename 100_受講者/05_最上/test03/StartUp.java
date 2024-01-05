package test03;

public class StartUp {

	public static void main(String[] args) {
		System.out.println("社訓:" + ZZZ.POLICY);
		
		Yamada y = new Yamada();
		y.work();
		y.salary();
		
		Sato s = new Sato();
		s.work();
		s.salary();

	}

}
