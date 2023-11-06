package chap08;

public class Sample06 {
	public static void main(String[] args){
		String str = "あいうえお";
		System.out.print(str);
		System.out.println(" :のハッシュコード:" + str.hashCode());
		str += "かきくけこ";
		System.out.print(str);
		System.out.println(" :のハッシュコード:" + str.hashCode());
	}
}
