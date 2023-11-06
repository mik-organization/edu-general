package chap11;

import org.json.JSONException;
import org.json.JSONObject;
public class Json03 {
	public static void main(String[] args) {
		//都市配列
		String city[] = {"sapporo","fukuoka","oosaka"};
		//JSON オブジェクトの宣言
		JSONObject json;
		//JSON オブジェクトに設定する値を文字列で作成
		String jsonData =
				"{\"sapporo\":" +
						"{\"city\":\"札幌市\",\"population\":1948262,\"household\":943521}," +
				 "\"fukuoka\":" +
						"{\"city\":\"福岡市\",\"population\":1542857,\"household\":766922}," +
				 "\"oosaka\":" +
						"{\"city\":\"大阪市\",\"population\":2698024,\"household\":1377862}}";
		try {
			//値を引数にし、JSON オブジェクトを生成する。
			json = new JSONObject(jsonData);
			for(int i = 0 ; i < city.length ; i++){
				//JSON オブジェクトより、値を取得し表示する。
				JSONObject jcity = json.getJSONObject(city[i]);
				System.out.print("都市名："+ jcity.getString("city"));
				System.out.print(" 人口 ："+ jcity.getInt("population") +"人");
				System.out.println(" 世帯数："+ jcity.getInt("household") +"戸");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
