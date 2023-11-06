package chap06;

public class SampleCars1 {

	public static void main(String[] args) {

		// Carクラス型の配列
		Car2[] cars = {
				new PassengerCar2("Honda", "Fit", 1800, 2015, 150, 4),
				new FreightCar2(),
				new FreightCar2("FUSO", "Fighter", 7500, 2012, 140, 4000),
				new PassengerCar2()
		};
		
		for (int i = 0; i < cars.length; i++) {
			int spd = (int) (Math.random() * 300) - 50;
			cars[i].setCruiseSpeed(spd);

		}

		for (Car2 c : cars) {
			c.information();
		}

	}

}
