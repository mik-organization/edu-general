package chap12;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Sample23_A {
	/*メールアドレスの表現
	 * */
	public static void main(String[] args) {
		String[] zipCode =
			{"sapporo@ken-school.jp","ken_school.sapporo@gmail.com"};

		String regex = "^[a-zA-Z0-9_.+-]+[@][a-zA-Z0-9.-]+$";
		Pattern p = Pattern.compile(regex); //Patten オブジェクトの生成
		for(String s : zipCode){
			Matcher m = p.matcher(s); //Matcher オブジェクトの生成
			if(m.find()){ //文字列表現がみつかればtrue
				System.out.println(s);
			}
		}
	}
}