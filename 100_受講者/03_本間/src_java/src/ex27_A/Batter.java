package ex27_A;
public class Batter extends Sportsman {
	private double avg; //打率
	/* コンストラクター */
	public Batter(String name ,double avg){
		super(name , 2); //スーパークラスのコンストラクター呼び出し
		setAvg(avg); //自フィールドを初期化
	}
	//アクセスメソッド
	public void setAvg(double avg) {
		if(avg >= 0 && avg <= 1) {
			this.avg = avg;
		}else {
			this.avg = 0;
			System.out.println(super.getName() + "さんの打率が正しくありません。:" + avg);
		}
	}
	@Override
	public void introduction(){ //オーバーライド
		int  wri = (int)(this.avg * 10);
		int  bu  = (int)(this.avg * 100) - (wri * 10);
		int  rin = (int)(this.avg * 1000) - (wri * 100) - (bu * 10);
		System.out.println(getName() + "("+ getCategoryName()[getCategory()-1] +") 打率："
				+ wri + "割" + bu + "分" + rin + "厘" );
		//String s = Integer.toString((int)(this.avg * 1000)); //打率表示のためStringに変換
		//System.out.println(getName() + "("+ getCategoryName()[getCategory()-1] +") 打率："
		//		+ s.charAt(0) + "割" + s.charAt(1) + "分" + s.charAt(2) + "厘" );
	}
}
