package chap11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetPostCode {
	public static void main(String[] args) {

		//送信するデータと送信先アドレスの指定
		String zipNum = "0620936";
		String urlAddress = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=" + zipNum;
		HttpURLConnection connection = null;
		URL url = null;

		try {
			//URL の new生成
			url = new URL(urlAddress);
			try {
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setInstanceFollowRedirects(false);
				connection.setRequestProperty("Accept-Language", "jp");
				connection.connect();

				//通信成功の場合
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

					try (InputStreamReader isr = new InputStreamReader(
							connection.getInputStream(), StandardCharsets.UTF_8);

							BufferedReader reader = new BufferedReader(isr)) {
						String rec;
						StringBuffer line = new StringBuffer();

						while ((rec = reader.readLine()) != null) {
							line.append(rec);
						}
						JSONObject json = new JSONObject(line.toString());
						int status = json.getInt("status");
						if (status == 200) {
							if (!json.isNull("results")) {
								JSONArray jar = json.getJSONArray("results");
								JSONObject data = jar.getJSONObject(0);
								String pref = data.getString("address1");
								String city = data.getString("address2");
								String town = data.getString("address3");
								System.out.println("住所：" + pref + city + town);
							} else {
								System.out.println("〒" + zipNum + ":該当の郵便番号は存在しません！");

							}
						} else {
							String message = json.getString("message");
							System.out.println("status：" + status + " message：" + message);
						}

					} catch (JSONException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} finally {
				if (connection != null) {
					connection.disconnect();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
