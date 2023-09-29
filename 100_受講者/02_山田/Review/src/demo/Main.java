package demo;

import java.util.ArrayList;

import entity.Member;
import service.MemberServiceImpl;

public class Main {

	public static void main(String[] args) {
		MemberServiceImpl service = MemberServiceImpl.getInstance();   
		//Serviceインスタンスのメソッドを利用する
		//MemberServiceImplからインスタンスを持ってきて『service』に代入
		
		System.out.println(service.greet(2));   
		//MemberServiceImplからgreetメソッド内のString[] greetingsを持ってきて表示させる
		//今回は引数が2なので配列の2号室(3番目)である"Good evening"が表示される
		
		System.out.println(service.getAll());
		//getAllメソッドの処理を表示
		
		
		ArrayList<Member> list = service.getAll();
		
		for(Member mem : list) {
		
			System.out.println(mem.getId() + "," + mem.getName() + "," + mem.getEmail());
			//mem.get～() でlistに格納されている数だけ繰り返し表示
		}
		
		System.out.println(service.sumOf(3, 5));
		
	}

}
