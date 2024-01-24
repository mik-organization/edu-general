package com.spring.edu_app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EduApp2Application  extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EduApp2Application.class);
	}
	
	//@Autowired
	//private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EduApp2Application.class, args);
	}
	
	/*
	@Override
	public void run(String...args) throws Exception{
		userRepository.save(new User("田中 テスト１","aaaa","aaa@sample.com","2024-01-20"));
		userRepository.save(new User("佐藤 テスト２","bbbb","bbb@sample.com","2024-02-22"));
		userRepository.save(new User("鈴木 テスト３","cccc","ccc@sample.com","2024-03-30"));
	
	}
	*/

}
