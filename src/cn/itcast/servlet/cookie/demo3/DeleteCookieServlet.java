package cn.itcast.servlet.cookie.demo3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ɾ���ϴη���ʱ��
 * 
 * @author seawind
 * 
 */
public class DeleteCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("last", "");
		// ɾ��cookie������Ч�� 0
		cookie.setMaxAge(0);

		// pathһ��
		cookie.setPath("/day07");

		response.addCookie(cookie);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
