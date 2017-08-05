package cn.itcast.servlet.session.demo2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����Ʒ�����ﳵ
 * 
 * @author seawind
 * 
 */
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ù�����Ʒ���
		String id = request.getParameter("id");

		// 2�����ݱ�� �õ���Ʒ����
		String[] arr = { "����", "ϴ�»�", "��ˮ��", "΢��¯", "�յ�", "�緹��" };
		String productName = arr[Integer.parseInt(id) - 1];

		// 3���ж���Ʒ�����Ƿ��ڹ��ﳵ��
		// �жϹ��ﳵ�Ƿ����
		Map<String, Integer> cart = (Map<String, Integer>) request.getSession()
				.getAttribute("cart"); // ���ܷ��� null
		if (cart == null) {
			// ���ﳵ���󲻴���
			cart = new HashMap<String, Integer>();
		}

		if (cart.containsKey(productName)) {
			// ���ﳵ���ڸ���Ʒ ����+1
			int number = cart.get(productName);
			cart.put(productName, number + 1);
		} else {
			// ��Ʒû���ڹ��ﳵ��
			cart.put(productName, 1);
		}

		// �����ﳵ����session
		request.getSession().setAttribute("cart", cart);

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("��Ʒ�Ѿ������빺�ﳵ��");

		response.getWriter().println(
				"<a href='/day07/session/demo2/cart.jsp'>�鿴���ﳵ</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
