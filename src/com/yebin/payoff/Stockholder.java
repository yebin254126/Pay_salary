package com.yebin.payoff;

import java.util.Date;

public class Stockholder extends Employee {

	int  stock_share;

	public Stockholder(String n, Date b) {
		super(n, b);
		// TODO �Զ����ɵĹ��캯�����
	}
	public int Getstock_share()
	{
		
		return stock_share;
		
	}
   
}
