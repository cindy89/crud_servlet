package gyh.servlet;

import gyh.util.SqlUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SelectBook implements Servlet {

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
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		//编码的设置必须放在开头，否则设置失效
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		SqlUtil s=new SqlUtil();
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=s.getConnection();
	   ResultSet r=  s.select("book", con,stmt,rs);
		out.println("<html>");
		out.println("<head><title>图书查询</title></head>");
		out.println("<body>");
		out.println("<table align='center' border='1'><tr><td>序号</td>" +
				"<td>图书编号</td><td>图书名字</td><td>图书价格</td><td>修改</td><td>删除</td></tr>");
		try {
			while(r.next()){
				String id=r.getString("id");
			    out.println("<tr><td>" +id+"</td>" +
					                          "<td>" +r.getString("no")+"</td>" +
							                  "<td>" +r.getString("name")+"</td>" +
							                  "<td>" +r.getString("price")+"</td>" +
							                  "<td><a href=updatebook?id="+id+">修改</a></td>"+
							                  "<td><a href=deletebook?id="+id+">删除</a></td>"+"</tr>");
			}
			out.println("<td><a href=addbook>添加</a></td>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	s.close(rs, stmt, con);
		out.flush();
		out.close();
	}

}
