/*InterFace 
 * ・機能の概要
    ・クラスを自動生成することもある
 */

package service;

import java.util.ArrayList;

import entity.Member;

public interface MemberService {

	String greet(int i);
	//引数の数字に応じて異なる挨拶文を返す
	
	int sumOf(int x,int y);
	
	ArrayList<Member> getAll();
	//会員の一覧データを返す
}
