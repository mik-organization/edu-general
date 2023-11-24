package vo;
/*packageキーワードを使用して「～.class」を作成するフォルダを指定する。
  package フォルダ名;
  package フォルダ名1.フォルダ名2;
  ※フォルダはドットで区切って階層化できる。
  ※package文はコメントを除いてプログラムの先頭に記述する。*/

//import vo.Human;
//⇒voパッケージのHumanクラスを指定する。
//⇒voパッケージ内の全てのクラスを指定する場合は「import vo.*;」とすると指定できる。
/*importキーワードを使用して使いたい別フォルダに存在するクラスを指定する。
  import フォルダ名.クラス名;
  import フォルダ名1.フォルダ名2.クラス名;
  ※フォルダはドットで区切って階層化できる。
  ※フォルダ内の全てのクラスを指定する場合は「import フォルダ名.*」という指定ができる。
  ※import文はコメントとpackage文を除いてプログラムの先頭に記述する。
  ※「java.lang」パッケージ内のクラスはインポートしなくても利用できる。*/

public class Human {
	private String name;
	private int age;
	
	public void eat(){
		System.out.println("食事中です。");
	}

}
