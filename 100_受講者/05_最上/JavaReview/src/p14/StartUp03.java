package p14;

public class StartUp03 {

	public static void main(String[] args) {
		String suji = "10";
		
		int i = Integer.parseInt(suji);
		System.out.println("数字をint値に変換した値：" + i);
		
		Integer data = Integer.valueOf(suji);
		System.out.println("Integer型をint型に変換した値：" + data.intValue());
		System.out.println("Integer型をdouble型に変換した値：" + data.doubleValue());
		System.out.println("Integer型をString型に変換した値：" + data.toString());

	}

}
