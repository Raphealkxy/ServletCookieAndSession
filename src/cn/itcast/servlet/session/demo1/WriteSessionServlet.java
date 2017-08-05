package cn.itcast.servlet.session.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��session ����һ������
 * 
 * @author seawind
 * 
 */
public class WriteSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���Session����
		HttpSession httpSession = request.getSession();

		// ��session ����һ������
		httpSession.setAttribute("company", "���ǲ���");

		// ��д�ظ� ����� JSESSIONID �־û�
		Cookie cookie = new Cookie("JSESSIONID", httpSession.getId());
		cookie.setMaxAge(60 * 60);
		cookie.setPath("/day07");
		response.addCookie(cookie);

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("�Ѿ���session������һ�����ݣ�");

		String url = "/day07/readsession";
		// ��url ������д ƴ�� jsessionid
		url = response.encodeURL(url);

		response.getWriter().println("<a href='" + url + "'>�鿴��������</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
