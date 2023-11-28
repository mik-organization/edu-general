package p14;

public class Sample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] list = new String[3];
		//固定長配列。
		
		list[0] = "みかん";
		list[1] = "りんご";
		list[2] = "ぶどう";
		
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
			
	  /*for文の別の記述の仕方
	   　for(String s : list){
			System.out.println(s);
		}*/
			
		}
		
	}

}
