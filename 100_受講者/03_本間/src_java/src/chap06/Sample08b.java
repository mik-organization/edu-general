package chap06;
class Myclass06b{
	protected int data = 0; //フィールド

	protected Myclass06b(int data){ // コンストラクター
		this.data = data;
	}
	protected int getData(){ //メソッド
		return data;
	}
}

class Sample08b{
	public static void main(String[] args){
		int num = 0;
		Myclass06b myc = new Myclass06b(10); //コンストラクターに10を渡す
		num = myc.getData();
		System.out.println("myc = " + num);
	}
}
