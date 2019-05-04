package com.segmentfault.springbootlesson1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
@MapperScan("com.segmentfault.springbootlesson1.minapp.demo.mapper")
public class SpringBootLesson1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson1Application.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "Hello World";
	}

	@RequestMapping("/rest")
	@ResponseBody
	public Map<String, Object> rest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", 1);
		map.put("2", "A");
		return map;
	}

}
