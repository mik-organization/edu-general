package chap06;

public class MyException extends Exception {
	
	String s="";
	
	public MyException() {
		this.s="エラーが発生しました。";
	}
	
	public MyException(String s) {
		this.s=s;
	}
	
	public void msg() {
		System.out.println(this.s);
	}
	
}
