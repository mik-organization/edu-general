package chap06;

public class Sample12 {

	public static void main(String[] args) {
		//Super12の型にSuper12をインスタンス化
		Super12 spr = new Super12();
		//Super12の型にSub12をインスタンス化
		Super12 ssb = new Sub12();
		//Sub12の型にSub12をインスタンス化
		Sub12 sb = new Sub12();

		spr.getName();
		ssb.getName();
		sb.getName();
		
		spr.setName("スーパー");
		ssb.setName("スーパーサブ");
		sb.setName("サブ");
		
		spr.getName();
		ssb.getName();
		sb.getName();
		
		
		System.out.println();
		spr.printMsg();
		ssb.printMsg();
		sb.printMsg();
	}
}
