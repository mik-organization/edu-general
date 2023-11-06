package chap06;

import java.io.FileNotFoundException;
import java.io.IOException;

class Super36{
	// スーパークラスでIOExceptionをthrowsする
	void ioMethod() throws IOException{ }
}
class Sub36A extends Super36{
	// スーパークラスと同じ例外なのでOK
	void ioMethod() throws IOException{ }
}
class Sub36B extends Super36{
	// 例外をスローしていないのでOK
	void ioMethod() { }
}
class Sub36C extends Super36{
	//IOExceptionのサブクラスで例外をスローしているのでOK
	void ioMethod() throws FileNotFoundException{ }
}
class Sub36D extends Super36{
	//IOExceptionと継承関係がないのでNG (コンパイルエラー)
	//void ioMethod() throws ClassNotFoundException{ }
}
class Sub36E extends Super36{
	//実行時例外なのでOK
	void ioMethod() throws ArrayIndexOutOfBoundsException{ }
}
class Sub36F extends Super36{
	//広い範囲の例外はNG（コンパイルエラー）
	//void ioMethod() throws Exception{ }
}
