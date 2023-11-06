package chap07;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream03 {

	public static void main(String[] args) {

		try {
			// オープン処理（バイトストリーム）
			FileOutputStream fos = new FileOutputStream("newFile.txt");
			
			// 出力処理
			fos.write('あ');
			fos.write('い');
			fos.write('う');
			
			// クローズ処理
			fos.close(); 

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
