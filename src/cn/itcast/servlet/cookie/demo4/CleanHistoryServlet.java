package cn.itcast.servlet.cookie.demo4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��� history��cookie��Ϣ
 * 
 * @author seawind
 * 
 */
public class CleanHistoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("history", "");

		// ����MaxAge Ϊ0
		cookie.setMaxAge(0);

		// pathһ��
		cookie.setPath("/day07");

		response.addCookie(cookie);

		// ��ת����Ʒ�б�ҳ�� ��ת�����ض���
		response.sendRedirect("/day07/cookie/demo4/product.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
