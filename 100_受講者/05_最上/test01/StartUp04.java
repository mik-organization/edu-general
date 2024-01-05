package test01;

public class StartUp04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human04 h = new Human04();
		
		h.setName("山田太郎");
		h.setAge(23);
		
		String name = h.getName();
		int age = h.getAge();
		
		System.out.println("名前:" + name);
		System.out.println("年齢:" + age);
	}

}
