package ex27;

public class Ex27 {

	public static void main(String[] args) {

		Sportsman[] player = {
				Sportsman.getInstance("武田", 1, 15),
				Sportsman.getInstance("山中", 2, 0.324),
				Sportsman.getInstance("安部", 2, 0.310),
				Sportsman.getInstance("岩本", 1, 11),
		};

		for (int j = 0; j < 10; j++) {
			System.out.println((j + 1) + "回目");
			for (int i = 0; i < player.length; i++) {
				int h = (int) (Math.random() * 51);
				player[i].setPoint(h);

				System.out.println(player[i].name + " " + player[i].point + "票");
			}
			System.out.println("----------------");
		}

		System.out.println("総得票数は、" + Sportsman.totalPoint + "票です。");

		for (int k = 0; k < player.length - 1; k++) {
			for (int m = k + 1; m < player.length; m++) {
				if (player[k].point < player[m].point) {
					Sportsman temp = player[k];
					player[k] = player[m];
					player[m] = temp;
				}
			}
		}

		System.out.println("優勝者紹介：");
		player[0].introduction();
	}

}
