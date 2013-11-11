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

public class DeleteBook implements Servlet {

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
		int id=Integer.valueOf(request.getParameter("id"));
		String sql="delete from book where id="+id;
		try{
			Connection con=sqlUtil.getConnection();
			Statement stmt=con.createStatement();
			int result=stmt.executeUpdate(sql);
			if(result!=0){
				out.println("删除成功</br><td><a href=selectbook>返回</a></td>");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
