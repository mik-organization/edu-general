package chap11;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Json04 {
	public static void main(String[] args) {
		//JSON オブジェクトの宣言
		JSONObject json;
		//JSON オブジェクトに設定する値を文字列で作成
		String jsonData ="{\"majorCity\":" +
				"[{\"city\":\"札幌市\",\"population\":1948262,\"household\":943521}," +
				"{\"city\":\"福岡市\",\"population\":1542857,\"household\":766922}," +
				"{\"city\":\"大阪市\",\"population\":2698024,\"household\":1377862}]}";
		try {
			//値を引数にし、JSON オブジェクトを生成する。
			json = new JSONObject(jsonData);
			//JSON配列のオブジェクトを生成
			JSONArray ja=json.getJSONArray("majorCity");
			for(int i = 0;i<ja.length()	;i++){
				//配列から要素を取得
				JSONObject city = ja.getJSONObject(i);
				//SON オブジェクトより、値を取得し表示する。
				System.out.print("都市名："+ city.getString("city"));
				System.out.print(" 人口："+ city.getInt("population") +"人");
				System.out.println(" 世帯数："+ city.getInt("household") +"戸");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
