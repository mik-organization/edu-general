//例外2　未参照のオブジェクトのメソッド実行時のエラー

package p12;

import vo.Human;

public class StartUp02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Human h =null;
		//何も参照されていないまま実行すると、NullPointerExceptionというエラーが出る。
		/*java.lang.NullPointerException
		  ⇒java.langパッケージ内のNullPointerExceptionという例外オブジェクトがスローされて(投げられて)、
		  プログラムが終了する。*/
		h.eat();

	}

}
