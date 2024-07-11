package org.hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ServletApplication {

	// SpringBootApplication : 스프링 부트 애플리케이션 생성
	// ServletComponentScan : 스프링 컨테이너에 서블릿 매핑 자동 등록
	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
