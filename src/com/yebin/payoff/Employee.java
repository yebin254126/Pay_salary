package com.yebin.payoff;

import java.util.Date;
  
public class Employee {
	public String name;
	public int salary;
	public Date birthday;
	public Employee(String n,Date b)
	{
		name=n;
		birthday=b;
	}
	
 public int GetSalary(int month)
 {
	 
		
	 return 0;
 }
 public String  toString ()
 {
	//return name+" "+(birthday.getMonth()+1)+"-"+birthday.getDate();
	 return name;
	
 }

}
