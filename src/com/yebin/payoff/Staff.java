package com.yebin.payoff;

import java.util.Date;

public class Staff extends Employee {


	 public Staff(String n, Date b) {
		super(n, b);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public int GetSalary(int month) {
		// TODO �Զ����ɵķ������
		 salary=(int) (Math.random()*1000+2000);
		 if((birthday.getMonth()+1)==month)
		 {
			  salary+=500;
			
		 }
		 return salary;
	}
	 

}
