package com.udemy.spring3item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.spring3item.model.Item;
import com.udemy.spring3item.repo.ItemRepository;

@SpringBootApplication
public class Spring3itemApplication implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Spring3itemApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		itemRepository.save(new Item("ネックレス","ジュエリ"));
		itemRepository.save(new Item("パーカー","ファッション"));
		itemRepository.save(new Item("ファイスクリーム","ビューティ"));
		itemRepository.save(new Item("サプリメント","ヘルス"));
		itemRepository.save(new Item("ブルーベリー","フード"));
	}

}
