/*InterFace (インターフェース)
 * ・機能の概要
    ・クラスを自動生成することもある
 */

package service;

import java.util.ArrayList;

import entity.Member;

public interface MemberService {
	//String greetを定義
	String greet(int i);
	
    // int sumOf()を定義
   	int sumOf(int x,int y);
	ArrayList<Member> getAll();
	
}
