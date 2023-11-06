package ex27_A;
public class Pitcher extends Sportsman {
	private int win; //勝ち数
	/*コンストラクター*/
	public Pitcher(String name ,int win){
		super(name , 1); //スーパークラスのコンストラクター呼び出し
		setWin(win); //自フィールドを初期化
	}
	//アクセスメソッド
	public void setWin(int win) {
		if(win >= 0) {
			this.win = win;
		}else {
			this.win = 0;
			System.out.println(super.getName() + "さんの勝ち数が正しくありません。:" + win);
		}
	}
	@Override
	public void introduction(){ //オーバーライド
		System.out.println(getName() + "("+ getCategoryName()[getCategory()-1] +") 勝ち数：" + this.win + "勝" );
	}
}
