package chap09;

import java.util.ArrayList;

public class Sample02 {
	public static void main(String args[]) {

		//同じGoodsクラスから複数のオブジェクトを生成
		Goods1 g1 = new Goods1();
		g1.goodsName = "ジーンズ";
		g1.price = 20000;
		Goods1 g2 = new Goods1();
		g2.goodsName = "Tシャツ";
		g2.price = 6000;
		Goods1 g3 = new Goods1();
		g3.goodsName = "スニーカー";
		g3.price = 10000;

		// コレクションの生成、要素の追加
		ArrayList al = new ArrayList();
		al.add(g1);
		al.add(g2);
		al.add(g3);

		// 要素の取り出し
		for (Object obj : al) {
			((Goods1) obj).showGoods();
		}
		
		System.out.println();
		
		for (int i = 0; i < al.size(); i++) {
			((Goods1) (al.get(i))).showGoods();
		}
	}
}
