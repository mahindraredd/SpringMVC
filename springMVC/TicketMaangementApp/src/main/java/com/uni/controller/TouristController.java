package com.uni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.models.Tourist;
import com.uni.service.ITicketService;

@RestController
@RequestMapping("api/tourist")
public class TouristController {
	
	@Autowired
	private ITicketService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		try {
			System.out.println(tourist);
			String body=service.registerTourist(tourist);
			return new ResponseEntity<String>(body,HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<String>(" Something wrong with server ",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
		@GetMapping("/findAll")
		public ResponseEntity<?> getAll(){
			try {
				List<Tourist> list=service.getAll();
				return new ResponseEntity<List>(list ,HttpStatus.OK);
			}
			catch(Exception e){
				return new ResponseEntity<String>(" Something wrong with Db ",HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
		
	}
		@GetMapping("/find/{id}")
		public ResponseEntity<?> findById(@PathVariable("id") Integer id){
			try {
				
				return new ResponseEntity<Tourist>( service.fetechById(id),HttpStatus.OK);
			}
			catch(Exception e){
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			
		}
		@PutMapping("/modify")
		public ResponseEntity<String> modify(@RequestBody Tourist tourist ){
			try {
			
				return new ResponseEntity<String>( service.updateTouristByDetails(tourist),HttpStatus.OK);
			}
			catch(Exception e){
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
				
			}
		}
		
			@PatchMapping("/partialmodify/{id}/{budget}")
			public ResponseEntity<String> partialmodify(@PathVariable Integer id,@PathVariable Float budget ){
				try {
					
					return new ResponseEntity<String>(service.updateToursitBudget(id,budget),HttpStatus.OK);
				}
				catch(Exception e){
					return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
					
				}
			
		}

}
