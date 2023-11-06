package chap09;

public class Sample12a {

	public static void main(String[] args) {

		Myclass12a<Integer> mc0 = new Myclass12a<>();
		mc0.swap(10, 10);

		Myclass12a<Integer> mc1 = new Myclass12a<>();
		mc1.swap(128, 128);

		Myclass12a<Double> mc2 = new Myclass12a<>();
		mc2.swap(1.2, 1.2);

		Myclass12a<Character> mc3 = new Myclass12a<>();
		mc3.swap('a', 'b');

		Myclass12a<String> mc4 = new Myclass12a<>();
		mc4.swap("hello!", "How Low?");

	}

}
