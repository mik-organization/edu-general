package p11;

public class StartUp {

	public static void main(String[] args) {
		System.out.println("社訓：" + ZZZ.POLICY);
		
//		Yamada y = new Yamada();
//		y.work();
//		y.salary();
//		
//		Sato s = new Sato();
//		s.work();
//		s.salary();
		
		
//		ZZZ z1 = new Yamada();
//		z1.work();
//		z1.salary();
//		
//		ZZZ z2 = new Sato();
//		z2.work();
//		z2.salary();

		ZZZ [] z = new ZZZ[2];
		
		z[0] =new Yamada();
		z[1] = new Sato();
		
		for(int i = 0 ; i < z.length ; i++) {
			z[i].work();
			z[i].salary();
		}
	}

}