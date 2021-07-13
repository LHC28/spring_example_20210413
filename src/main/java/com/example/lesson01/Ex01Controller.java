package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// controller를 보고 mapping을 본 후 body가 있다면 return값을 가지고 출력하게 되는 과정
@RequestMapping("/lesson01/ex01") // 이 매핑부터 보고 밑의 매핑을 합쳐서 보는 식이다. 결과적으로는 같은 것이다.
// 메소드에 붙은 mapping보다 먼저 적용되는 것.
@Controller // controller spring bean
public class Ex01Controller { // controller는 스프링에서 사용되는 용어. 주소를 치고 들어오는 부분
	
	// 요청 url : http://localhost:8080/lesson01/ex01/1
	//controller가 있는 것에서 mapping을 찾는 것임. controller와 requestmapping이 쌍으로 쓰이는 것이다.
	@RequestMapping("/1") // url 주소 매핑
	@ResponseBody // 위치는 상관 없다. 리턴되는 값을 response body로 보내는 것이다.
	public String printString() {
		String text = "예제1번<br>문자열을 response body로 보내는 예제";
		return text;
	}
	
	//servlet의 경우 하나에 대한 요청만 받을 수밖에 없었지만 여기에서는 여러 개가 가능하다.
	
	// 요청 url : http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 10);
		map.put("orange", 125);
		map.put("grape", 67);
		
		// map을 리턴하면 json으로 나타난다.
		// 환경설정시 선택했던 것 중 spring boot devtools에 들어있는 것으로 gradel의 dependencies보면 boot-starter-wep에
		// 의해 map이 리턴되면 json으로 변환하라는 것이 들어 있기 때문.
		
		// web starter에 jackson이라는 라이브러리가 포함되어 있기 때문.
		return map; //{"apple"=4 ........}
		// jackson은 대개 필수적으로 사용한다. 대개 json으로 통신하기 때문에. jackson을 기억하도록 하자.
	}
}
