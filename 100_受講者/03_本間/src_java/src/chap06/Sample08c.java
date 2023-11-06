package chap06;
class Myclass06c{
	public int data = 0; // コンストラクター

	public Myclass06c(int data){ // コンストラクター
		this.data = data;
	}
	public int getData(){ // メソッド
		return data;
	}
}

class Sample08c{
	public static void main(String[] args){
		int num = 0;
		Myclass06c myc = new Myclass06c(10); //コンストラクターに10を渡す
		num = myc.getData();
		System.out.println("myc = " + num);
	}
}
