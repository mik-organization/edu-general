//例外04　指定できない配列の要素番号を指定した時のエラー

package p12;

public class StartUp04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] list = {"AAA","BBB","CCC"};
		System.out.println(list[3]); //(list[2])であれば正常に動く。
        //配列で指定できない配列の要素番号を指定しているため、ArrayIndexOutOfBoundsExceptionというエラーが出る。
		/*java.lang.ArrayIndexOutOfBoundsException
		  ⇒java.langパッケージ内のArrayIndexOutOfBoundsExceptionという例外オブジェクトがスローされて(投げられて)、
		  プログラムが終了する。*/
	}

}
