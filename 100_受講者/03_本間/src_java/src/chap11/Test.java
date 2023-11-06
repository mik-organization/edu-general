package chap11;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) {

		File fileData = new File("File1.txt");

		JSONObject jsonData = new JSONObject(fileData);
		System.out.println(jsonData);
		try {
			System.out.println("都市名：" + jsonData.getString("都市"));
		} catch (JSONException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
