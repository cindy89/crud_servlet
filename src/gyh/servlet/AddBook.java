package gyh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddBook implements Servlet {

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
		
		out.println("<html>");
		out.println("<head><title>新增</title></head>");
		out.println("<form action='add' method='post'>");
		out.println("<table align='center' border='1'><tr><td><input type='hidden' name='id'></td></tr>" +
				                 "<tr><td>no:<input type='text' name='no'></td></tr>" +
				                 "<tr><td>name:<input type='text' name='name'></td></tr>" +
				                 "<tr><td>price:<input type='text' name='price'></td></tr>");
		out.println("<tr><td><input type='submit' value='添加'><input type='reset' value='重置'></td>" +
				"<td><a href=selectbook>查看</a></td></tr></table></from>");
		out.println("</table>");
		out.println("</html>");
       out.flush();
       out.close();
		
	}

}
