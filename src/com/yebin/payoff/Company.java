package com.yebin.payoff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
public class Company {
     int profit; //����
     int turnover;//Ӫҵ��
     int outcome;//֧��
	 List<Employee> list=new ArrayList<>();//Ա����
	public Company() {
		// TODO �Զ����ɵĹ��캯�����
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL���ݿ�����
	    String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Mydatabase";//����Դ  
	    String Name="sa";
	    String Pwd="wait123";
	    Statement stmt=null;   //������sql��䴫�����ݿ�
	    ResultSet rs=null;     //����ִ��sql��䣬�����ز�ѯ�Ľ��
	    String sql="SELECT * FROM dbo.staff";
	    
	    try
	    {
	    Class.forName(driverName);
	    Connection conn=DriverManager.getConnection(dbURL,Name,Pwd);
	    if(conn!=null)
	    {
	    System.out.println("�������ݿ�ɹ�");
	    stmt=conn.createStatement();      //������sql��䴫�����ݿ�
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
	       System.out.println("����ʧ��");
	       }
	    

	}
	
 public void payoff()
 {
	 System.out.println("��������Ҫ��ѯ���·�:");
	 Scanner sc=new Scanner(System.in);
     int month=sc.nextInt();
     for(Iterator<Employee> it=list.iterator();it.hasNext();)
     {
        Employee temp=it.next();
        
        int salary=temp.GetSalary(month);
     	System.out.println(temp.toString()+"  "+ month+"�¹���Ϊ:"+salary);
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
	 System.out.println("��˾����Ӫҵ��Ϊ:"+turnover);
	 System.out.println("��˾���µ�֧��Ϊ:"+outcome);
	 System.out.println("��˾��������Ϊ:"+profit);
 }
}
