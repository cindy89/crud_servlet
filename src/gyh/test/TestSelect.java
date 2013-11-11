package gyh.test;

import gyh.util.SqlUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {

	//测试部分
		@SuppressWarnings("static-access")
		public static void main(String[] args){
			SqlUtil s=new SqlUtil();
			Statement stmt=null;
			ResultSet rs=null;
			Connection con=s.getConnection();
		   ResultSet r=  s.select("book", con,stmt,rs);
		  try{
			  while(r.next()){
				  System.out.println("id:"+r.getString("id")+"\nno:"+r.getString("no")+
						  "\nname:"+r.getString("name")+"\nprice:"+r.getString("price"));
				  
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		}
}
