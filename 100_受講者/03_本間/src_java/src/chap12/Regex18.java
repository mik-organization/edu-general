package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex18 {
	/*[ ]内には範囲を指定できる
	 * [a-z]と記述すると、アルファベットの小文字全部のうちの1 文字
	 * [0-9]ならば数字の1 文字
	 * []内の先頭に「^」をつけると否定
	 * [^0-9]は数字ではないことを表す
	 * []内はメタ文字も普通の文字として扱う
	 * */
	public static void main(String[] args) {
		String[] strAry = {"fine","cloudy","Rainy","Sunshine","snow"};
		String regex = "[a-z]+$"; //一致させる文字列表現
		Pattern p = Pattern.compile(regex); //Patten オブジェクトの生成
		for(String s : strAry){
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if(m.find()){ //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
		System.out.println("--------------");
		strAry = new String[]{"1234","WINDOWS7","WINDOWS XP","MacOS10"};
		regex = "^[A-z0-9]+$";
		p = Pattern.compile(regex);
		for(String s : strAry){
			Matcher m = p.matcher(s);
			if(m.find()){
				System.out.println(s);
			}
		}
	}
}
