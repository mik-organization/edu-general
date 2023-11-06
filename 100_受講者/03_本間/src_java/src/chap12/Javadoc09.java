package chap12;

/**
 * Javadoc のサンプル
 * @author イデアル
 * @version バージョンの記述
 */
public class Javadoc09 {
	/**
	 * クラス変数:
	 */
	public static final int HENSUU = 0;
	public static void main(String[] args) {
	}
	/**
	 * サンプルメソッドsetData の説明<br>
	 * ①.説明１<br>
	 * ②.説明２<br>
	 * @param aData 引数名 引数の説明
	 * @return aData 戻り値の説明
	 * @see java.lang.Integer#parseInt
	 * @see <a href="http://www.foo.bar.ac.jp/">参考ページ</a>
	 * @exception java.lang.ArithmeticException 指定されたデータに対応できない場合に発生
	 */
	public int setData( int aData ){

		return aData;
	}
}
