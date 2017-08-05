package cn.itcast.servlet.session.demo3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �û���½
 * 
 * @author seawind
 * 
 */
public class LoginServlet extends HttpServlet {

	private Map<String, String> userInfo = new HashMap<String, String>();

	@Override
	public void init() throws ServletException {
		// �����û�������
		userInfo.put("aaa", "111");
		userInfo.put("bbb", "222");
		userInfo.put("ddd", "333");
		userInfo.put("www", "444");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post ������
		request.setCharacterEncoding("utf-8");

		// �ж���֤�������Ƿ���ȷ
		String checkcode = request.getParameter("checkcode");
		String checkcode_session = (String) request.getSession().getAttribute(
				"checkcode_session");
		// ɾ��session����֤��
		request.getSession().removeAttribute("checkcode_session");

		if (checkcode_session == null || !checkcode_session.equals(checkcode)) {
			// ��֤����Ч -- ����login.jsp
			// response.sendRedirect("/day07/session/demo3/login.jsp");

			// ���ݴ�����Ϣ��jsp
			request.setAttribute("msg", "��֤��������");
			request.getRequestDispatcher("/session/demo3/login.jsp").forward(
					request, response);
			return;
		}

		// 1 ������������
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2 �ж��û���Ϣ�Ƿ���ȷ
		if (userInfo.containsKey(username)) {
			// ����û�������
			if (userInfo.get(username).equals(password)) {
				// ������ȷ --- ��½�ɹ�
				// ���û���Ϣ ����session
				request.getSession().setAttribute("username", username);

				// ��ת��½�ɹ� ϵͳ��ҳ
				response.sendRedirect("/day07/session/demo3/welcome.jsp");

			} else {
				// �������
				// response.sendRedirect("/day07/session/demo3/login.jsp");
				request.setAttribute("msg", "�����������");
				request.getRequestDispatcher("/session/demo3/login.jsp")
						.forward(request, response);
			}

		} else {
			// �û���������
			// response.sendRedirect("/day07/session/demo3/login.jsp");
			request.setAttribute("msg", "�û���������");
			request.getRequestDispatcher("/session/demo3/login.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
