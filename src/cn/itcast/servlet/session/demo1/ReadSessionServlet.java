package cn.itcast.servlet.session.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 读取 WriteSessionServlet 保存数据
 * 
 * @author seawind
 * 
 */
public class ReadSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得Session对象
		HttpSession httpSession = request.getSession();

		response.setContentType("text/html;charset=utf-8");

		// 获得数据
		response.getWriter().println(
				"读取之前保存session信息 ：" + httpSession.getAttribute("company"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
