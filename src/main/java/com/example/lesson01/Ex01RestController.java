package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
	
@RequestMapping("/lesson01/ex01") // mapping도 겹치면 안 된다.
@RestController // @Controller + @ResponseBody : 데이터를 내릴 때 주로 사용된다.
public class Ex01RestController {

	// 요청 url : http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	@RequestMapping("/4")
	public Map<String, String> printMap(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map; //json
	}
	
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); // 일반 java bean
		data.setId(1);
		data.setName("이힘찬");
		System.out.println(data);
		return data; // 일반 bean 객체도 JSON으로 내려간다. (jackson 라이브러리 때문)
		// responseBody가 있기 때문에 브라우저에 나오는 것이다.
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data(); // 일반 java bean
		data.setId(2);
		data.setName("가나다");
		
		// 크롬 > Network 탭 응답값 확인 - status를 확인할 수 있다.
		//return new ResponseEntity<>(data, HttpStatus.OK); // 200 OK
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // 대표적인 500 에러.
	}
}
