package gyh.servlet;

import gyh.util.SqlUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddMethod implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		
		PrintWriter out=response.getWriter();
		
		SqlUtil sqlUtil=new SqlUtil();
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
	//	String str=insert into book(no,name,price) values('no','name','price');
		String sql="insert into book(no,name,price) values('"+no+"','"+name+"','"+price+"')";
	//	System.out.println("sql-------->"+sql);	
		try{
		Connection con=sqlUtil.getConnection();
		Statement stmt=con.createStatement();
		int result=stmt.executeUpdate(sql);
		if(result!=0){
			out.println("添加成功");
			out.println("<a href=selectbook>查看</a>");
		}
	//	con.close();  关闭后无法查看
		}catch(Exception e){
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
		
	}

}
