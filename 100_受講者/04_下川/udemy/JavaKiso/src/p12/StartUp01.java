//例外1　0で割れない時のエラー
/*例外(exception)とは、プログラム実行中のエラーのこと。
  自動車の運転中に交通事故を起こすなどの可能性があるというようなもの*/

package p12;

public class StartUp01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = 10/0;
		//数値は0で割ることができないため、ArithmeticExceptionというエラーが出る。
		/*java.lang.ArithmeticException
		  ⇒java.langパッケージ内のArithmeticExceptionという例外オブジェクトがスローされて(投げられて)、
		  プログラムが終了する。
		 */
		System.out.println(result);

	}

}
