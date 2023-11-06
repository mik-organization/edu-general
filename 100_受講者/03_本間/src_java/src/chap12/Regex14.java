package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex14 {
	
	public static void main(String[] args) {
		
		//「.」は任意の1 文字をあらわす
		// 「^」文字列の先頭もしくは[]内では否定形を表す
		// 「$」文字列の末尾を表す
		String[] strAry = { "Say", "Clay", "Way", "Boy" };
		String regex = "^.ay$"; //一致させる文字列表現（パターン）
		Pattern p = Pattern.compile(regex);//Patten オブジェクトの生成
		for (String s : strAry) {
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if (m.find()) { //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
		System.out.println("--------------");
		strAry = new String[] { "島田", "佐々木", "田中", "吉田", "小田島" };
		regex = "^.田$";
		p = Pattern.compile(regex);
		for (String s : strAry) {
			Matcher m = p.matcher(s);
			if (m.find()) {
				System.out.println(s);
			}
		}
	}
}