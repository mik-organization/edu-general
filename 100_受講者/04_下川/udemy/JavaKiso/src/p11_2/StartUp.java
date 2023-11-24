package p11_2;

import p11_1.Sato;
import p11_1.Yamada;
import p11_1.ZZZ;

public class StartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println("社訓:"+ ZZZ.POLICY);
		
		ZZZ z1 = new Yamada();
		z1.work();
		z1.salary();
		
		ZZZ z2 = new Sato();
		z2.work();
		z2.salary();
	}

}
