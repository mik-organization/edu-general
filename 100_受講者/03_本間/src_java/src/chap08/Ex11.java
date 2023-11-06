package chap08;

import java.util.Arrays;

public class Ex11 {
	public static void main(String[] args) {
		String[] str = { "banana", "strawberry", "lemon", "grape", "apple" };
		//配列の要素を辞書的に並べ替える
		
		/*
		for (int i = 0; i < str.length; i++)
			for (int j = i + 1; j < str.length; j++) {

				int compareNum = str[i].compareTo(str[j]);
				//System.out.println(compareNum);
				if (compareNum > 0) {
					String tmp = str[i];
					str[i] = str[j];
					str[j] = tmp;
				}
			}
		*/
		
		Arrays.sort(str);
		
		for (String s : str) {
			System.out.println(s);
		}

	}
}
