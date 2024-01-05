package test02;

public class Oya {
	void f1() {	
	}
}

public class Kodomo extends Oya{
	void f2() {
	}
}

Kodomo k = new Kodomo();
k.f1();	//〇
k.f2();	//〇

Oya o = new Kodomo();
o.f1(); //〇
o.f2();	//×	アクセスするには親クラスのメソッドを子クラスでオーバーライドしなければならないその際は子クラスが優先される

Kodomo k1 = new Oya();	//×	関係性がないのでできない

Oya o1 = new Kodomo();
Kodomo k2 = (Kodomo)o1;	//親クラスの参照変数を強制的にキャストすることによって子クラスの変数で参照することができる



