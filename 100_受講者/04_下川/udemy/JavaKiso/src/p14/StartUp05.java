package p14;

import java.util.ArrayList;

public class StartUp05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>();
		//可変長配列。固定長配列と違い、データの変更や追加ができる。
		
		list.add("みかん");
		list.add("りんご");
		list.add("ぶどう");
		list.add("いちご");
		//データの追加。
		
		list.set(1, "メロン");
		//データの変更。1号室のデータの変更し、りんご→メロンへ。
		
		list.remove(2);
		//データの削除。2号室の"ぶどう"を削除し、いちごが2号室へ。
		
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
			
	  /*for文の別の記述の仕方
	    for(String s : list){
			System.out.println(s);
		}*/
			
		}
		
	

	}

}
