package chap11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpReqRes {
	public static void main(String[] args) {
		//URL の宣言
		URL url = null;
		//HttpURLConnection の宣言
		HttpURLConnection connection = null;
		//送信先のアドレス(ダミー)
		String address = "http://httpbin.org/post";
		try {
			//URL の生成
			url = new URL(address);
			try {
				// 接続用HttpURLConnection オブジェクト作成
				connection = (HttpURLConnection) url.openConnection();
				// リクエストメソッドの設定
				connection.setRequestMethod("POST");
				// doOutput フラグをtrue に設定
				connection.setDoOutput(true);
				// リダイレクトを自動で許可しない設定
				connection.setInstanceFollowRedirects(false);
				// ヘッダーの設定(複数設定可能)
				connection.setRequestProperty("Accept-Language", "jp");
				//パラメーターを書き込む
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(connection.getOutputStream(),
								StandardCharsets.UTF_8));
				writer.write("POST Body");
				writer.write(System.lineSeparator());
				writer.write("Hello Http Server!!");
				writer.write(System.lineSeparator());
				writer.flush();
				//接続
				connection.connect();
				//通信成功の場合
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					//HTTP からのストリームを受信するInputStreamReader を宣言
					InputStreamReader isr = null;
					//入力ストリームを読み込むBufferedReader を宣言
					BufferedReader reader = null;
					try {
						//HTTP からのストリームを受信
						isr = new InputStreamReader(
								connection.getInputStream(), StandardCharsets.UTF_8);
						//入力ストリームをBufferedReader に読み込む
						reader = new BufferedReader(isr);
						String line;
						//入力ストリームの内容をコンソールに表示
						while ((line = reader.readLine()) != null) {
							System.out.println(line);
						}
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						isr.close();
						reader.close();
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
