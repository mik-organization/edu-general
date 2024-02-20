package p00;

public class Sample08a {

	public static void main(String[] args) {
		int dasu = 3;		//打数
		int hit = 1;		//安打数
		
		//打率計算
		double ave = (double)hit/dasu;
		
		//打率表示
		System.out.println("打率 = " + ave);
	}

}
