package chap06;

public class SampleCars3 {

	public static void main(String[] args) {
		/*3台の車の配列をgetInstance()を使って生成*/
		Car2[] cars = {
				Car2.getInstance("TOYOTA", "Crown", 3500, 2010, 200, 5),
				Car2.getInstance("FUSO", "Fighter", 7500, 2012, 140, 4000),
				Car2.getInstance("FERRARI", "F430", 4300, 2008, 260, 2)
		};

		for (Car2 c : cars) {
			System.out.print(c.getMaker() + " " + c.getName() + " は、");
			// instanceof 演算子を使って、ケース分け
			if (c instanceof PassengerCar2) {
				System.out.println(((PassengerCar2) c).getMaxPassenger() + "人乗りです。");
			} else if (c instanceof FreightCar2) {
				System.out.println("最大積載量" + ((FreightCar2) c).getMaxLoading() + "Kgです。");

			}else {
				System.out.println("どちらの種類でもありません。");
			}
		}
	}
}
