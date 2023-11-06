package chap06;
class Super17{}
class Sub17 extends Super17{}
class Other17{}
public class Sample17{
	public static void main(String[] args){
		Sub17 sub = new Sub17();
		if(sub instanceof Super17){}
		// if(sub instanceof Other17){} //ここでコンパイルエラー
	}
}