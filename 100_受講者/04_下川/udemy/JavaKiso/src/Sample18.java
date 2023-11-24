
public class Sample18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list = {10,20,30};
		//listの0号室に10、1号室に20、2号室に30をそれぞれ格納する。
		
		for(int i = 0;i < list.length; i++) {
			//int i = 0⇒配列の0号室から順番に指定していくため、初期値である0(0号室)を指定する。
			/*i < list.length⇒iを何回繰り返すかを表している。
			配列の要素は0号室・1号室・2号室の3つしかないため、iの値はlistのlength、
			所謂3つより小さい間繰り返すという条件式*/
			//i++⇒後置インクリメント。処理後に1を足す。
			System.out.println(list[i]);
		}

	}

}
            /*i++は、
             System.out.println(list[i]);の後にi++;と置いてもよいし、
             (list[i])の中に(list[i++])と置いてもよい。*/