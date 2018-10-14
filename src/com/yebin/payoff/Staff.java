package com.yebin.payoff;

import java.util.Date;

public class Staff extends Employee {


	 public Staff(String n, Date b) {
		super(n, b);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public int GetSalary(int month) {
		// TODO 自动生成的方法存根
		 salary=(int) (Math.random()*1000+2000);
		 if((birthday.getMonth()+1)==month)
		 {
			  salary+=500;
			
		 }
		 return salary;
	}
	 

}
