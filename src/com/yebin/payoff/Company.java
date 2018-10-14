package com.yebin.payoff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
public class Company {
     int profit; //利润
     int turnover;//营业额
     int outcome;//支出
	 List<Employee> list=new ArrayList<>();//员工表
	public Company() {
		// TODO 自动生成的构造函数存根
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
	    String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Mydatabase";//数据源  
	    String Name="sa";
	    String Pwd="wait123";
	    Statement stmt=null;   //用来将sql语句传到数据库
	    ResultSet rs=null;     //用来执行sql语句，并返回查询的结果
	    String sql="SELECT * FROM dbo.staff";
	    
	    try
	    {
	    Class.forName(driverName);
	    Connection conn=DriverManager.getConnection(dbURL,Name,Pwd);
	    if(conn!=null)
	    {
	    System.out.println("连接数据库成功");
	    stmt=conn.createStatement();      //用来将sql语句传到数据库
	    rs=stmt.executeQuery(sql);        //
	    	  while(rs.next())
	  		{  if(rs.getInt("id")==6||rs.getInt("id")==7)
	  			list.add(new Manager(rs.getString("name"),rs.getDate("birthday")));
	  		else 
	  		   list.add(new Staff(rs.getString("name"),rs.getDate("birthday")));
	  		}
	     	 if (rs != null) {
	               rs.close();
	     		  rs = null;
	     		          }
	         if (stmt != null) {
	     		   stmt.close();
	     		   stmt = null;
	     		          }
	          if (conn != null) {
	     		   conn.close();
	     		    conn = null;
	     		             }
	    }
	    
	    }catch(Exception e){
	     e.printStackTrace();
	       System.out.println("连接失败");
	       }
	    

	}
	
 public void payoff()
 {
	 System.out.println("请输入你要查询的月份:");
	 Scanner sc=new Scanner(System.in);
     int month=sc.nextInt();
     for(Iterator<Employee> it=list.iterator();it.hasNext();)
     {
        Employee temp=it.next();
        
        int salary=temp.GetSalary(month);
     	System.out.println(temp.toString()+"  "+ month+"月工资为:"+salary);
     	outcome+=salary;
     }
 }
 
 public void Gettrunover()
 {
	 turnover=(int) (Math.random()*100000)+100000;
 }
	
 public void Getprofit()
 {
	 profit=turnover-outcome;
 }
  
 public void PrintInfo()
 {  
	 Gettrunover();
	 Getprofit();
	 System.out.println("公司该月营业额为:"+turnover);
	 System.out.println("公司该月的支出为:"+outcome);
	 System.out.println("公司该月利润为:"+profit);
 }
}
