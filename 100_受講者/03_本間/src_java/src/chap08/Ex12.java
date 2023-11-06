package chap08;

class Ex12 {
	public static void main(String[] args){
		String[] str = {"brown","cat","blue","jump","texas"};
		//StringBufferクラスのオブジェクト sb を生成
		StringBuffer sb=new StringBuffer();
		//jをStringBufferオブジェクトに追加
		sb.append(str[3].substring(0,1));
		//eをStringBufferオブジェクトに追加
		sb.append(str[4].substring(1,2));
		//aをStringBufferオブジェクトに追加
		sb.append(str[1].substring(1,2));
		//nをStringBufferオブジェクトに追加
		sb.append(str[0].substring(4,5));
		//sをStringBufferオブジェクトに追加
		sb.append(str[4].substring(4,5));
		
		// jeans と表示したい
		System.out.println(sb);
	}
}
