package chap07;
// インポート
import java.io.File;
import java.io.IOException;

public class FileIO01 {

	public static void main(String[] args) {
		
		try {
			File file = new File("newFile.txt");
			System.out.println(file.exists());
			System.out.println(file.createNewFile());
			System.out.println(file.exists());
			
		}catch(IOException e){
			
		}
	}

}
