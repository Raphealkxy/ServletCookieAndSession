package cn.itcast.servlet.cookie.demo1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ϴη���ʱ��鿴����ʾ���û�
 * 
 * @author seawind
 * 
 */
public class LastVisitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);
		response.setHeader("Pragma", "no-cache");

		// ����û���һ�η��� ---- �ж���������û��cookie��Ϣ
		Cookie[] cookies = request.getCookies(); // �������������cookie��Ϣ

		response.setContentType("text/html;charset=utf-8");

		if (cookies == null) {
			// û��cookie ��һ�η���
			// ����ǰʱ�� ��cookieд�ؿͻ���

			// ��ǰʱ����� �ȼ� new Date().getTime()
			long now = System.currentTimeMillis();

			// ��ͻ���д��cookie ��Ҫ�õ�cookie
			Cookie cookie = new Cookie("last", now + "");

			cookie.setPath("/day07");

			// ����cookie ��Чʱ��
			cookie.setMaxAge(60 * 60 * 24 * 2);// ����cookie ʱ������

			// дcookie�ص��ͻ���
			response.addCookie(cookie);

			// ֪ͨ�û� ��һ�η���
			response.getWriter().println("��ӭ����һ�η��ʱ���վ��������죡");
		} else {
			// cookie���� ---- ���������ʱ��
			for (Cookie cookie : cookies) {
				// ���ÿ��cookie
				if (cookie.getName().equals("last")) {
					long lasttime = Long.parseLong(cookie.getValue());
					// ��ʾ���û�
					Date date = new Date(lasttime);

					// ��ʽ������
					DateFormat dateFormat = new SimpleDateFormat(
							"yyyy��MM��dd�� HHʱmm��ss��");

					response.getWriter().println(
							"�ϴη���ʱ�� ��" + dateFormat.format(date));
				}
			}

			// ����������ʱ��

			// ��ǰʱ����� �ȼ� new Date().getTime()
			long now = System.currentTimeMillis();

			// ��ͻ���д��cookie ��Ҫ�õ�cookie
			Cookie cookie = new Cookie("last", now + "");

			cookie.setPath("/day07");

			// ����cookie ��Чʱ��
			cookie.setMaxAge(60 * 60 * 24 * 2);// ����cookie ʱ������

			// дcookie�ص��ͻ���
			response.addCookie(cookie);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
