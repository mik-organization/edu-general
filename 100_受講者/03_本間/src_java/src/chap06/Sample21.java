package chap06;
class Super21{
	//アクセスメソッド
	public static void printMsg(){
		System.out.println("スーパー");
	}
}
class Sub21 extends Super21{
	//アクセスメソッド
	public static void printMsg(){ //オーバーライド？
		System.out.println("サブ");
	}
}
public class Sample21{
	public static void main(String[] args){
		Super21 spr = new Super21();
		Super21 ssb = new Sub21();
		Sub21 sb = new Sub21();

		spr. printMsg();
		ssb. printMsg();
		sb. printMsg();

	}
}
