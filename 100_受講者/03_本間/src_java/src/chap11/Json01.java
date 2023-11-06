package chap11;

import org.json.JSONException;
import org.json.JSONObject;

public class Json01 {
	public static void main(String[] args) {

		//JSON オブジェクトに設定する値を文字列で作成
		String jsonData = "{\"city\":\"札幌市\","
				+ "\"population\":1948262,"
				+ "\"household\":943521}";
		try {
			//値を引数にし、JSON オブジェクトをnew生成する。
			JSONObject json = new JSONObject(jsonData);
			//JSON オブジェクトより、値を取得し表示する。
			System.out.println("都市名：" + json.getString("city"));
			System.out.println("人口 ：" + json.getInt("population") + "人");
			System.out.println("世帯数：" + json.getInt("household") + "戸");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
