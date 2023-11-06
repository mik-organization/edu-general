package chap06;

public class Super12 {
	//フィールド
	private String name = "Super";

	//アクセスメソッド
	public void getName() {
		System.out.println(this.name);
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public void printMsg() {
		System.out.println("スーパー");
	}
}
