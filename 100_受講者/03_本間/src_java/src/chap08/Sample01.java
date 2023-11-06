package chap08;

public class Sample01 {
	public static void main(String[] args) {
		Myclass1 mc1 = new Myclass1();
		Myclass1 mc2 = new Myclass1();
		Myclass1 mc3 = mc1;
		//equals()でオブジェクトを比較
		System.out.println("mc1.equals(mc3) : " + mc1.equals(mc3));
		System.out.println("mc1.equals(mc2) : " + mc1.equals(mc2));
		//==でオブジェクトを比較
		System.out.println("mc1 == mc3 : " + (mc1 == mc3));
		System.out.println("mc1 == mc2 : " + (mc1 == mc2));
		//オブジェクトを表すメソッド toString()
		System.out.println("mc1:" + mc1.toString());
		System.out.println("mc2:" + mc2.toString());
		System.out.println("mc3:" + mc3.toString());

	}
}
