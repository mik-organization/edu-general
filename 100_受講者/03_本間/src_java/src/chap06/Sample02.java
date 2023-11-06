package chap06;

public class Sample02 {

	public static void main(String[] args) {

		// Sub02 をインスタンス化
		Sub02 sb = new Sub02();

		sb.write();
		
		/*
		 上を実行すると「Subです。」と表示されるが、
		 
		 継承された親クラスとインスタンス化された子クラスの中に、
		 同じ名前のメソッドがある場合、インスタンス化されたクラス（Sub02）
		 のメソッドが優先される
		 
		 */
		
		// では、この状態で親クラスの同名メソッドを使うにはどうしたらいいか
		// 方法その1　Super02をインスタンス化する
		Super02 sp=new Super02();
		sp.write();
		
		// 方法その2　子クラスの中で親クラスのメソッドを別名でメソッド化する
		sb.writeSuper();
		
	}

}
