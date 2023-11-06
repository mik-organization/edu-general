package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex21 {
	/*郵便番号の表現
	 * */
	public static void main(String[] args) {
		String[] zipCode =
			{"642-0511","612513","2314-562","123 2551","0030021"," 016--0872"};
		//上記の配列で郵便番号を表すものを表現するregex を定義する
		//ハイフンありでもなしでもOK とする
		//数値だけで7 桁
		String regex = "[0-9]{7}|[0-9]{3}-[0-9]{4}"; //ここに文字列表現を作成する
		//String regex = "[0-9]{3}-?[0-9]{4}";
		Pattern p = Pattern.compile(regex); //Patten オブジェクトの生成
		for(String s : zipCode){
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if(m.find()){ //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
	}
}
