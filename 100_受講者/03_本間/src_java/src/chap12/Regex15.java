package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex15 {
	/*①「*」は直前文字の0 回以上の繰り返し
	 *② 「＋」は直前の文字の1 回以上の繰り返し
	 * regex の「*」を「+」に変更してみる
	 *③「？」は、直前の文字の0 回または1 回の繰り返し
	 * regex の「+」を「?」に変更してみる*/
	
	public static void main(String[] args) {
		String[] strAry = {"Good Job!","Goooood Job!","Gd!"};
		String regex = "Go*"; //一致させる文字列表現
		Pattern p = Pattern.compile(regex); //Patten オブジェクトの生成
		for(String s : strAry){
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if(m.find()){ //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
		System.out.println("--------------");
		strAry = new String[]{"よーし！","よーーーーっしゃ！","よし！"};
		regex = "よー*";
		p = Pattern.compile(regex);
		for(String s : strAry){
			Matcher m = p.matcher(s);
			if(m.find()){
				System.out.println(s);
			}
		}
	}
	/*
「＊」は、直前の文字の0 回以上の繰り返し
「よー＊し」と記述すると、「よーし」も「よーーーし」も、
「よし」もヒット
直前の文字が「ー（長音）」なので、これが0 回以上何回繰り返していてもヒット
	 */
}
