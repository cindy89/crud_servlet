package gyh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {//必须实现servlet接口
	
	/**
	 * 对象new出来后会自动运行init方法（init方法只在对象出现时调用一次）
	 * 当有请求时会调用service方法
	 */
	public HelloServlet(){
		super();
		System.out.println("Hello Servlet");
	}

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

		System.out.println("init()... ...");
	}
/**
 * request和response是由servlet容器创建的
 */
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service()... ...");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title> hello servlet</title></head>");
		out.println("<body>");
		out.println("hello!");
		out.println("welcome to servlet study");
		out.println("</body>");
		out.println("</html>");

	}

}
