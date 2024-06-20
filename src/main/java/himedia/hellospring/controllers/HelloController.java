package himedia.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import himedia.hellospring.vo.UserVo;

@Controller
public class HelloController {
	@RequestMapping("/hello")
//	public ModelAndView hello(@RequestParam("name") String name) {			// 기본 요청
	public ModelAndView hello(@RequestParam(value="name", 
											required=false,
											defaultValue="익명") 
											String name) {					// Optional하게 받을 때
		// Servlet에서 getParameter로 해준 일 -> @RequestParam(Parameter명)
		ModelAndView mav = new ModelAndView();								// Data와 View 정보를 함께 가진 객체
		
		mav.addObject("message", "Hello, " + name);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello2")
	// return type: String -> ViewName
	public String hello2(@RequestParam("name") String name, 
						 @RequestParam("no") int no, 
						 @RequestParam("password") String password) {
		System.out.println("Name: " + name);
		System.out.println("No: " + no);
		System.out.println("Password: " + password);
		
		return "/WEB-INF/views/hello2.jsp";									// ViewName
	}
	
	@ResponseBody															// return된 문자열을 직접 응답으로 출력한다.(MessageConverter)
	@RequestMapping("/hello3")
	public String hello3(@ModelAttribute UserVo vo) {
		// @ModeAttribute: 복잡한 요청 파라미터를 자동으로 Vo에 mapping
		return "<h1>Request</h1><p>" + vo + "</p>";
	}
	

}
