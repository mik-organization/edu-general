package chap06;

public class Sample01 {

	public static void main(String[] args) {

		// Sub01をインスタンス化
		Sub01 sb = new Sub01();

		// インスタンス化していない親（Super01）クラスが扱えるようになっている
		System.out.println("superi=" + sb.superi);
		sb.superwrite("super");

		// 子（Sub01）クラス
		System.out.println("subi=" + sb.subi);
		sb.subwrite("sub");

	}

}
