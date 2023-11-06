package chap12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewFileIO12b {
	public static void main(String[] args) throws IOException {

		Path path1 = Paths.get("file13.txt"); //Pathオブジェクトを生成
		if (!Files.exists(path1)) { //ファイルが存在しないとき
			// ファイルを作る
			System.out.println(Files.createFile(path1));
		} else {
			System.out.println("ファイルが存在します。");
			// ファイルを削除する
			Files.delete(path1);
		}
		//前のページから
		if (Files.exists(path1)) { //ファイルが存在するとき
			System.out.println("ファイルが存在します。");
		} else {
			System.out.println("ファイルはありません。");
		}
	}
}
