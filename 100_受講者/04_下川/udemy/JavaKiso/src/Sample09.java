
public class Sample09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dasu = 3; //打数
		int hit = 1; //安打数
		
		double ave = (double)hit / (double)dasu;
		 //打率計算(hit/dasuの前にdoubleを入れないと0.00になる)
		
		System.out.println("打率 =" + ave);
		 //打率表示
	}

}
