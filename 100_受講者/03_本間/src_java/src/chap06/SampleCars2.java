package chap06;

public class SampleCars2 {

	public static void main(String[] args) {
		//サブクラスのインスタンスをスーパークラス型に代入*/
		Car2 crown = new PassengerCar2("TOYOTA","Crown",3500,2010,200,5);
		//サブクラスのインスタンスをサブクラス型に代入
		PassengerCar2 ferrari = new PassengerCar2("FERRARI","F430",4300,2008,260,2);
		int spd = (int)(Math.random() * 300) - 50;
		crown.setCruiseSpeed(spd); //スーパークラス独自のメソッド
		spd = (int)(Math.random() * 300) - 50;
		ferrari.setCruiseSpeed(spd); //スーパークラス独自のメソッド
		/*スーパークラス独自のメソッドとサブクラス独自のメソッドで表示*/
		System.out.println(crown.getMaker() + " " + crown.getName() + "は" +
							((PassengerCar2) crown).getMaxPassenger() + "人乗りです。");
		System.out.println(ferrari.getMaker() + " " + ferrari.getName() + "は" +
							ferrari.getMaxPassenger() + "人乗りです。");

	}

}
