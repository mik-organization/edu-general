package chap06;

public class Sub12 extends Super12{
	//フィールド
	private String name = "Sub";
	//アクセスメソッド
	@Override
	public void getName(){
		System.out.println(this.name);
	}
}
