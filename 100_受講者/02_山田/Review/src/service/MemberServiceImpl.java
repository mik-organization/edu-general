package service;

import java.util.ArrayList;

import entity.Member;

public class MemberServiceImpl implements MemberService {
	
	private static MemberServiceImpl singleton = new MemberServiceImpl();
	
	private MemberServiceImpl() {};
	
	public static MemberServiceImpl getInstance() {
		return singleton;
		
	}
	
	@Override
	//引数に合わせて配列の要素を返す(今回は"Good evening")
	public String greet(int i) {
		String[] greetings = {"Good morning","Hello","Good evening"};
		return greetings[i];
		
		
	}

	@Override
	public ArrayList<Member> getAll() {
		// new ArrayList<>();でリストの枠組みを作る
		ArrayList<Member> list = new ArrayList<>();
		//枠組みの中身1を作成しmem1に格納
		Member mem1 = new Member(1,"Linda"  ,"linda@example.com");
		//枠組みの中身2を作成しmem2に格納
		Member mem2 = new Member(2,"James","james@example.com");
		//中身1をリストに追加
		list.add(mem1);
		//中身2をリストに追加
		list.add(mem2);
		
		//listを返す
		return list;
		
	}

	//@Override
	public int sumOfa(int x, int y) {
		 int sum = 0;
		 for(int i = x; i <= y; i++) {
			 sum += i;
		 }
		 return sum;
	}

	@Override
	public int sumOf(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

}
