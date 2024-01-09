package test06;

import java.util.ArrayList;

public class StartUp05 {

	public static void main(String[] args) {
		ArrayList<String>list = new ArrayList <String>();
		
		list.add("みかん");
		list.add("りんご");
		list.add("ぶどう");
		
		for(int i = 0 ; i < list.size();i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		list.add("いちご");
		list.set(1, "メロン");	//１番目をメロンに変更
		list.remove(2);	//削除
		
		for(String s :list) {
			System.out.println(s);
		}

		
	}

}
