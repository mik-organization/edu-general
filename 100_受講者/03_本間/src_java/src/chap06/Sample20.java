package chap06;
class Super20{
	//フィールド
	private String name = "Super";
	//アクセスメソッド
	public final void getName(){ // final指定されているメソッド
		System.out.println(this.name);
	}
}
class Sub20 extends Super20{
	//フィールド
	private String name = "Sub";
	//アクセスメソッド
	/*
	public  void getName(){ //オーバーライド
		System.out.println(this.name);
	}
	*/
}
public class Sample20{
	public static void main(String[] args){
		Super20 ssb = new Sub20();
		ssb.getName();
	}
}
