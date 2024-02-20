package p14;

import java.util.ArrayList;

public class StartUp05 {

	public static void main(String[] args) {
	//可変長配列
	ArrayList <String> list = new ArrayList <String>();
	
	list.add("みかん");
	list.add("りんご");
	list.add("ぶどう");
	list.add("いちご");
	
	list.set(1, "メロン");
	list.remove(2);
	
	for(int i = 0 ; i <list.size() ; i++) {
		String s = list.get(i);
		System.out.println(s);
	}
		
	}

}
