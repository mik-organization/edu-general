package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex17 {
	/*[ ]内に記述された文字のいずれかを表現
	 * [abc]と記述すると、「a」または「b」または「c」に一致すればよい
	 * */
	public static void main(String[] args) {
		String[] strAry = {"Say","Clay","Way","Boy","Bay"};
		String regex = "[SW]ay"; //一致させる文字列表現
		Pattern p = Pattern.compile(regex); //Patten オブジェクトの生成
		for(String s : strAry){
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if(m.find()){ //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
		System.out.println("--------------");
		strAry = new String[]{"島田","佐々木","田中","吉田","小田島","杉田"};
		regex = "[島杉小]田";
		p = Pattern.compile(regex);
		for(String s : strAry){
			Matcher m = p.matcher(s);
			if(m.find()){
				System.out.println(s);
			}
		}
	}
}
