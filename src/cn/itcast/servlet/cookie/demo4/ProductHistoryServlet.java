package cn.itcast.servlet.cookie.demo4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.CookieUtils;

/**
 * �����Ʒ ������Ʒ�����¼��� Cookie
 * 
 * @author seawind
 * 
 */
public class ProductHistoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] arr = { "����", "ϴ�»�", "�ʼǱ�����", "�ֻ�", "�յ�", "��ˮ��", "΢��¯", "�����" };

		// 1 ����û�����鿴��Ʒ ���
		String id = request.getParameter("id");

		// 2. ����Ʒ��Ŵ���cookie
		// Cookie cookie = new Cookie("history", id);
		// cookie.setMaxAge(60 * 60);
		// cookie.setPath("/day07");

		response.setContentType("text/html;charset=utf8");
		response.getWriter().println(
				"�û����������Ʒ��" + arr[Integer.parseInt(id) - 1]);
		response.getWriter().println(
				"<a href='/day07/cookie/demo4/product.jsp'>����</a>");

		// ��ȡ�ͻ���cookie
		Cookie cookie = CookieUtils.findCookie(request.getCookies(), "history");
		if (cookie == null) {
			// û�������¼
			cookie = new Cookie("history", id);
			cookie.setMaxAge(60 * 60);
			cookie.setPath("/day07");
			// 3��д��cookie
			response.addCookie(cookie);
		} else {
			// �Ѿ�������Ʒ�����¼���жϵ�ǰ�����Ʒ�Ƿ��Ѿ��ڼ�¼��
			String ids = cookie.getValue();
			String[] idArray = ids.split(",");
			for (String existId : idArray) {
				if (existId.equals(id)) {
					// ��ǰ�����Ʒ �Ѿ����������¼��
					return;
				}
			}

			// ��ǰidû���������¼��
			cookie.setValue(ids + "," + id);
			cookie.setMaxAge(60 * 60);
			cookie.setPath("/day07");
			// 3��д��cookie
			response.addCookie(cookie);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
