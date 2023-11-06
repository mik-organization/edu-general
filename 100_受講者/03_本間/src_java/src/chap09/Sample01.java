package chap09;

public class Sample01 {
	public static void main(String args[]){
		Goods1 g1 = new Goods1(); //同じGoodsクラスから複数のオブジェクトを生成
		g1.goodsName = "ジーンズ";
		g1.price = 20000;
		Goods1 g2 = new Goods1();
		g2.goodsName = "Tシャツ";
		g2.price = 6000;
		Goods1 g3 = new Goods1();
		g3.goodsName = "スニーカー";
		g3.price = 10000;

		g1.showGoods();
		g2.showGoods();
		g3.showGoods();

	}
}
