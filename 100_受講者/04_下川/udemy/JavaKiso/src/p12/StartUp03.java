//例外3　文字列を数値へ変換できない時のエラー

package p12;

public class StartUp03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s ="ABC";
		int result = Integer.parseInt(s);
		//Integer.parseIntは数字しか数値に変換できないため、文字列ABCを数値に変換できず、NumberFormatExceptionというエラーが出る。
		/*java.lang.NumberFormatException
		 * ⇒java.langパッケージ内のNumberFormatExceptionという例外オブジェクトがスローされて(投げられて)、
		  プログラムが終了する。*/
		System.out.println(result);

	}

}

/*int data = Integer.parseInt("123");
 * ⇒数字を数値に変換するおまじない。()内に設定した数字を数値に変換し、変数データに格納する。
 */