package chap06;
class Super19{
	//フィールド
	private String name = "Super";
	//アクセスメソッド
	public void getName(){
		System.out.println(this.name);
	}
}
/*
class Sub19 extends Super19{
	//フィールド
	private String name = "Sub";
	//アクセスメソッド
	protected void getName(){ //オーバーライド
		System.out.println(this.name);
	}
}

public class Sample19{
	public static void main(String[] args){
		Super19 ssb = new Sub19();
		ssb.getName();
	}
}
*/