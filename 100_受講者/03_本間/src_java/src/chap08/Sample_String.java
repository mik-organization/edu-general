package chap08;

public class Sample_String {
	public static void main(String[] args){
		//length()
		String str1 = "北海道";
		int num = str1.length();
		System.out.println(num);
		//substring()
		String str2 = "あいうえおかきくけこ";
		System.out.println(str2.substring(3,8)); //「えおかきく」が出力される
		System.out.println(str2.substring(3)); //「えおかきくけこ」が出力される
		//compareTo()
		String str3 = "garden";
		String str4 = "school";
		System.out.println(str3.compareTo(str4)); //負の数が返ります
		System.out.println(str3.compareTo(str3)); //0が返ります
		System.out.println(str4.compareTo(str3)); //正の数が返ります
		//toUpperCase()toLowerCase()
		String str5 = "cHoCoLatE";
		System.out.println(str5.toUpperCase()); //"CHOCOLATE"が出力される
		System.out.println(str5.toLowerCase()); //"chocolate"が出力される
		//trim()
		String str6 = " チョコ  "; //文字列の先頭と末尾に空白
		System.out.println(str6.trim() + "レート"); //"チョコレート"が出力される
		//split()
		String str ="apple,gorilla,trumpet,bread";
		String[] strSp = str.split(","); //「","」を基準に文字列を分割し配列に格納
		for(String s : strSp){ //拡張forループを使って配列の中身を出力
			System.out.println(s);
		}

	}
}










