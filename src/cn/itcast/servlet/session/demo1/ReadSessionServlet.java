package cn.itcast.servlet.session.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��ȡ WriteSessionServlet ��������
 * 
 * @author seawind
 * 
 */
public class ReadSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���Session����
		HttpSession httpSession = request.getSession();

		response.setContentType("text/html;charset=utf-8");

		// �������
		response.getWriter().println(
				"��ȡ֮ǰ����session��Ϣ ��" + httpSession.getAttribute("company"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
