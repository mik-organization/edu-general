package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex19 {
	/*｛ ｝内に数値を記述すると、直前の文字の繰り返し回数を指定できる
	 * 「a{3｝」は「aaa」を表す
	 * 「a{1,3}」は「a」の1 回から3 回までの繰り返し
	 * 「a{2,}」は「a」の2 回以上の繰り返しを表し
	 * */
	public static void main(String[] args) {
		String[] strAry = {"Gd!","God!","Good!","Goooood!","Book!"};
		String regex = "^.o{2}.!"; //一致させる文字列表現
		Pattern p = Pattern.compile(regex); //Patten オブジェクトの生成
		for(String s : strAry){
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if(m.find()){ //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
		System.out.println("--------------");
		regex = "^.o{1,2}.!";
		p = Pattern.compile(regex);
		for(String s : strAry){
			Matcher m = p.matcher(s);
			if(m.find()){
				System.out.println(s);
			}
		}
		System.out.println("--------------");
		strAry = new String[]{"System123","System45","System6789"};
		regex = "[A-z]+[0-9]{3}";
		p = Pattern.compile(regex);
		for(String s : strAry){
			Matcher m = p.matcher(s);
			if(m.find()){
				System.out.println(s);
			}
		}
	}
}
