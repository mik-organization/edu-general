package chap11;
import org.json.JSONException;
import org.json.JSONObject;
public class Json02 {
	public static void main(String[] args) {
		//都市配列
		String city[] = {"sapporo","fukuoka","oosaka"};
		
		//JSON オブジェクトに設定する値を文字列で作成
		String jsonData ="{\"city1\":\"札幌市\",\"population1\":1948262,\"household1\":943521,"
				+ "\"city2\":\"福岡市\",\"population2\":1542857,\"household2\":766922,"
				+ "\"city3\":\"大阪市\",\"population3\":2698024,\"household3\":1377862}";
		try {
			//値を引数にし、JSON オブジェクトを生成する。
			JSONObject json = new JSONObject(jsonData);
			//SON オブジェクトより、値を取得し表示する。
			//札幌の情報を表示
			System.out.print("都市名："+ json.getString("city1"));
			System.out.print(" 人口 ："+ json.getInt("population1") +"人");
			System.out.println(" 世帯数："+ json.getInt("household1") +"戸");
			//福岡の情報を表示
			System.out.print("都市名："+ json.getString("city2"));
			System.out.print(" 人口 ："+ json.getInt("population2") +"人");
			System.out.println(" 世帯数："+ json.getInt("household2") +"戸");
			//大阪の情報を表示
			System.out.print("都市名："+ json.getString("city3"));
			System.out.print(" 人口 ："+ json.getInt("population3") +"人");
			System.out.println(" 世帯数："+ json.getInt("household3") +"戸");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
