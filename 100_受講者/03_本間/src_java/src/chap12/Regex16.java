package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex16 {
	/*「｜（パイプ）」の両側にスペースを入れない*/
	public static void main(String[] args) {
		String[] strAry = {"PHP","C++","JAVA","php"};
		String regex = "PHP|JAVA"; //一致させる文字列表現
		Pattern p = Pattern.compile(regex); //Patten オブジェクトの生成
		for(String s : strAry){
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if(m.find()){ //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
		System.out.println("--------------");
		strAry = new String[]{"ウィンドウズ","リナックス",
				"マックＯＳ","ウインドウズ"};
		regex = "ウィンドウズ|マックＯＳ";
		p = Pattern.compile(regex);
		for(String s : strAry){
			Matcher m = p.matcher(s);
			if(m.find()){
				System.out.println(s);
			}
		}
	}
}
