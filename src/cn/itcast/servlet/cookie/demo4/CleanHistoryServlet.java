package cn.itcast.servlet.cookie.demo4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 清除 history的cookie信息
 * 
 * @author seawind
 * 
 */
public class CleanHistoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("history", "");

		// 设置MaxAge 为0
		cookie.setMaxAge(0);

		// path一致
		cookie.setPath("/day07");

		response.addCookie(cookie);

		// 跳转到商品列表页面 ：转发或重定向
		response.sendRedirect("/day07/cookie/demo4/product.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
