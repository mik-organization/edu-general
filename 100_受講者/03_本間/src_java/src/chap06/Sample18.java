package chap06;
class Super18{
	//フィールド
	private String name = "Super";
	//アクセスメソッド
	private void getName(){ //private指定されているメソッド
		System.out.println(this.name);
	}
}
class Sub18 extends Super18{
	//フィールド
	private String name = "Sub";
	//アクセスメソッド

	public void getName(){ //オーバーライド
		System.out.println(this.name);
	}
}
public class Sample18{
	public static void main(String[] args){
		Super18 ssb = new Sub18();
		//ssb.getName();
	}
}
