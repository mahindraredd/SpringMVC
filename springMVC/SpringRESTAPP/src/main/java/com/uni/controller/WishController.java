package com.uni.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishController {
	@GetMapping("/read")
	public ResponseEntity<String> show(@RequestParam("id") Integer id,@RequestParam("name") String name){
		return new ResponseEntity<String>("id is ",HttpStatus.OK);
	}
	@GetMapping("/read2/{ids}/{id}")
	public ResponseEntity<String> show2(@PathVariable("id") Integer second,
			@PathVariable("ids") Integer first){
		System.out.println(second+first);
		return new ResponseEntity<String>("id is "+first+" "+second ,HttpStatus.OK);
	}
	@PostMapping("/insert")
	public ResponseEntity<String> insert(){
		return new ResponseEntity<String>("THis is post- insertMethod",HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(){
		return new ResponseEntity<String>("THis is put- updateMethod",HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(){
		return new ResponseEntity<String>("THis is delete- deleteMethod",HttpStatus.OK);
	}

}
