package chap06;
class Myclass06a{
	private int data = 0; //フィールド


	private Myclass06a(int data){ // コンストラクター
		this.data = data;
	}
	private  int getData(){ //メソッド
		return data;
	}

}

class Sample08a{
	public static void main(String[] args){
		int num = 0;
		//Myclass06a myc = new Myclass06a(10); //コンストラクターに10を渡す
		//num = myc.getData();
		//System.out.println("myc=" + num);
		//System.out.println("myc.data=" + myc.data);
	}
}
