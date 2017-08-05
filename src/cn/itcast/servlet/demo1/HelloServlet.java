package cn.itcast.servlet.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response
				.getWriter()
				.println(
						"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println(
				"<style type=\"text/css\">h1{color:red;}</style>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Hello</h1>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
