package chap06;
//スーパークラス
class Super16{}
//サブクラス
class Sub16 extends Super16{}

public class Sample16{
	public static void main(String[] args){
		Sub16 sub = new Sub16();
		Super16 sup = new Super16();
		if(sub instanceof Sub16){
			System.out.println("subはSubにキャストできます。");
		}else{
			System.out.println("subはSubにキャストできません。");
		}
		if(sub instanceof Super16){
			System.out.println("subはSuperにキャストできます。");
		}else{
			System.out.println("subはSuperにキャストできません。");
		}
		if(sup instanceof Sub16){
			System.out.println("supはSubにキャストできます。");
		}else{
			System.out.println("supはSubにキャストできません。");
		}
		if(sup instanceof Super16){
			System.out.println("supはSuperにキャストできます。");
		}else{
			System.out.println("supはSuperにキャストできません。");
		}
	}
}
