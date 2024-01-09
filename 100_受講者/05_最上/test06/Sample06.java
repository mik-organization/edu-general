package test06;

public class Sample06 {

	public static void main(String[] args) {
		String [] list = new String[3];
		
		list[0]="みかん";
		list[1]="りんご";
		list[2]="ぶどう";

		for(int i = 0 ; i < list.length ;i++) {
			System.out.println(list[i]);
		}
		
		for(String s :list) {
			System.out.println(s);
		}
	}

}
