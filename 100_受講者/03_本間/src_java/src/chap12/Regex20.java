package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex20 {
	/*（）はグループ化
	 * 一致させる文字列を"JAVA|PHP Pro"とすると、
	 * 「JAVA」または「PHP Pro」となる
	 * 「JAVA Pro」または「PHP Pro」としたいときは
	 * "(PHP|JAVA) Pro"とすればよい
	 * */
	public static void main(String[] args) {
		String[] strAry = {"JAVA","PHP","PHP Programming",
				"C++ Programming","JAVA Programming",
				"PHP Programming School","JAVA Professional"};
		String regex = "^(PHP|JAVA) Pro"; //一致させる文字列表現
		Pattern p = Pattern.compile(regex); //Patten オブジェクトの生成
		for(String s : strAry){
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if(m.find()){ //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
	}
}
