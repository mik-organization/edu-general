package chap07;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter04 {

	public static void main(String[] args) {

		try {
			// オープン処理（バイトストリーム）
			//FileOutputStream fos = new FileOutputStream("newFile.txt");
			// 変換処理（バイトストリームから文字ストリームに変換）
			//OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			// 文字ストリームのオープン
			FileWriter fw=new FileWriter("newFile.txt");
			
			// 出力処理
			fw.write("あいう\n");
			fw.write('い');
			fw.write('う');

			// クローズ処理
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
