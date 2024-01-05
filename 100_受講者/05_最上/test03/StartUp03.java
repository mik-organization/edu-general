package test03;

public class StartUp03 {

	public static void main(String[] args) {
		System.out.println("社訓:" + ZZZ.POLICY);
		
		ZZZ [] z = new ZZZ[2];
	
		z[0] = new Yamada();
		z[1] = new Sato();
		
		for(int i = 0 ; i < z.length ; i++ ) {
			z[i].work();
			z[i].salary();
		}
	}

}
