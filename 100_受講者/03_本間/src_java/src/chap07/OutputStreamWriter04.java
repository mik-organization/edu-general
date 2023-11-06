package chap07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter04 {

	public static void main(String[] args) {

		try {
			// オープン処理（バイトストリーム）
			FileOutputStream fos = new FileOutputStream("newFile.txt");
			// 変換処理（バイトストリームから文字ストリームに変換）
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			// 出力処理
			osw.write('あ');
			osw.write('い');
			osw.write('う');

			// クローズ処理
			osw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
