package chap07;

// インポート
import java.io.File;

public class FileIO02 {

	public static void main(String[] args) {

		// 参照ディレクトリを指定
		String path = ".";
		File fi = new File(path);

		// オブジェクトを絶対パスで表示
		System.out.println("指定したディレクトリは" + fi.getAbsolutePath() + "です。");

		// ディレクトリ内のファイル・ディレクトリを配列にする
		File[] fiList = fi.listFiles();

		for (int i = 0; i < fiList.length; i++) {
			if (fiList[i].isFile() == true) {
				System.out.println("ファイル名は" + fiList[i].getName() + "です。");
			} else if (fiList[i].isDirectory() == true) {
				System.out.println("ディレクトリ名は" + fiList[i].getName() + "です。");
			}
		}
	}

}
