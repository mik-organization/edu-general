package chap10;

public class Outer3{
	static int si = 0;
	int ci = 1;
	void meth0(int di,final int FI){
		int mi0 = 2;
		final int MI1 = 3;
		class A{ // ローカルクラスを作ります。
			void methA(){
				System.out.println("si = " + si);
				System.out.println("ci = " + ci);
				System.out.println("mi0 = " + mi0); // mi0 はfinal でないためアクセス不可
				System.out.println("MI1 = " + MI1);
				System.out.println("di = " + di); // di はfinal でないためアクセス不可
				System.out.println("FI = " + FI);	
			}	
		}
		new A().methA();
	}
}
