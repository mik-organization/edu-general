package demo;

import java.util.ArrayList;

import entity.Member;
import service.MemberServiceImpl;

public class Main {

	public static void main(String[] args) {
		//Serviceインスタンスのメソッドを利用する
		//MemberServiceImplからインスタンスを持ってきて『service』に代入
		MemberServiceImpl service = MemberServiceImpl.getInstance();   
		
		//MemberServiceImplからgreetメソッド内のString[] greetingsを持ってきて表示させる
		//今回は引数が2なので配列の2号室(3番目)である"Good evening"が表示される
		System.out.println(service.greet(2));   
		
		//getAllメソッドの処理を表示
		System.out.println(service.getAll());
	
		
		
		ArrayList<Member> list = service.getAll();
		
		for(Member mem : list) {
			//mem.get～() でlistに格納されている数だけ繰り返し表示
			System.out.println(mem.getId() + "," + mem.getName() + "," + mem.getEmail());
			
		}
		
		System.out.println(service.sumOf(3, 5));
		
	}

}
