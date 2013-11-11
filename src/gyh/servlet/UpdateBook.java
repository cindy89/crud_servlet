package gyh.servlet;

import gyh.util.SqlUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateBook implements Servlet {

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
		String sql="select * from book where id="+id;
//		System.out.println(sql);
		
		out.println("<html>");
		out.println("<head><title>修改</title></head>");
		out.println("<body>");
		try{
			Connection con=sqlUtil.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
		
		out.println("<form action='update' method='post'>");
		while(rs.next()){
		out.println("<table align='center' border='1'>" +
		                        "<tr><td>id:<input type='text' name='id' value='"+rs.getInt("id")+"' readonly></td></tr>"+
				                 "<tr><td>no:<input type='text' name='no' value='"+rs.getString("no")+"'></td></tr>"+	
		                         "<tr><td>name:<input type='text' name='name' value='"+rs.getString("name")+"'></td></tr>"+
				                 "<tr><td>price:<input type='text' name='price' value='"+rs.getString("price")+"'></td></tr>"+ 
		                         "<tr><td><input type='submit' value='保存'></td><td><a href='selectbook'>返回</a></td></tr>"+               
				               "</table>");
		}
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		}catch(Exception e){
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
