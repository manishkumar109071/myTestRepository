package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class MyServlet {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>>getAllemployee(){
		Employee emp=new Employee();
		List<Employee> list= new ArrayList<>();
		list.add(emp);
	return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
}
