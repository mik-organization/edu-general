package com.example.demo.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controllerというアノテーションをつけると自動的にインスタンス化される。
//今はこういうものだと覚えておく
@Controller

//@RequestMapping("/～")特定のURLリクエストに対してマッピングを行う
//()の中身がドメイン以降のURLにあたる
@RequestMapping("/sample")

public class SampleController {

//	private final JdbcTemplate jdbcTemplate;

//	public SampleController(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	// GETリクエストをURLとコントローラーのクラスまたはメソッドに紐づけるためのアノテーション
	// 下記のようなメソッドの際につける
	@GetMapping("/test")
	// ページの出力に対応するメソッド。このStringはHTMLのファイル名を返す
	public String test(Model model) {
		// SQL文を入力
//		String sql = "SELECT id,  name, email" + "FROM inquiry WHERE id = 1";
//		// 上の行で既にSQLを作っているので変数sqlを代入
//		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
//		// 引数がStringとオブジェトのものを選ぶ
		model.addAttribute("title", "Inquiry Form");
//		model.addAttribute("name", map.get("name"));
//		model.addAttribute("email", map.get("email"));
		return "test";

	}

}
