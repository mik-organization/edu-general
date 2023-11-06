package chap12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class NewFileIO12 {
	public static void main(String[] args) throws IOException{
		//FileWiter オブジェクトをラップしたBufferedWriter オブジェクトでファイルを作成、
		//内容を書き込む
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("file13.txt"))){
			bw.write("Spring,Summer,Autumn,Winter");
			bw.write(System.lineSeparator());
			bw.write("東京");
			bw.write(System.lineSeparator());
			bw.write("大阪");
			bw.write(System.lineSeparator());
			bw.write("福岡");
			bw.write(System.lineSeparator());
			bw.write("札幌");
			bw.write(System.lineSeparator());
		}
		//元ファイルをPath オブジェクトに取得
		Path source = Paths.get("file13.txt");
		//コピー先をPath オブジェクトに取得
		Path target = Paths.get("file13copy.txt");
		//元ファイルをコピーする
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("処理が終了しました。");
	}
}











