package com.yebin.payoff;

import java.util.Date;

public class Stockholder extends Employee {

	int  stock_share;

	public Stockholder(String n, Date b) {
		super(n, b);
		// TODO 自动生成的构造函数存根
	}
	public int Getstock_share()
	{
		
		return stock_share;
		
	}
   
}
