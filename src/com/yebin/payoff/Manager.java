package com.yebin.payoff;

import java.util.Date;

public class Manager extends Employee {

	int bouns=1000;
	
	
	 public Manager(String n, Date b) {
		super(n, b);
		// TODO �Զ����ɵĹ��캯�����
	}


	@Override
	public int GetSalary(int month) {
		// TODO �Զ����ɵķ������
		salary=(int) (Math.random()*1000+4000)+bouns;
		 if((birthday.getMonth()+1)==month)
		 {
			  salary+=500;
		 }
		 return salary;
	}

  

}
