package cn.itcast.servlet.cookie.demo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ͨ����������cookie ������Ч·��path
 * 
 * @author seawind
 * 
 */
public class PathCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("company", "itcast");
		cookie.setMaxAge(60 * 60);
		// �ֶ�����path
		cookie.setPath("/day07");

		response.addCookie(cookie);

		Cookie cookie2 = new Cookie("address", "beijing");
		cookie2.setMaxAge(60 * 60);
		cookie2.setPath("/day07");
		response.addCookie(cookie2);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
