package com.uni.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Employee {
	private String ename="sachin";
	private Integer eno;
	private Integer esal;
	private String eaddress;
	private Integer eage;
	public Employee(){
		System.out.println("Zerp Parameter Constructor");
	}
}
