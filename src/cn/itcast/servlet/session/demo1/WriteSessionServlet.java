package cn.itcast.servlet.session.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 向session 保存一个数据
 * 
 * @author seawind
 * 
 */
public class WriteSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得Session对象
		HttpSession httpSession = request.getSession();

		// 向session 保存一个数据
		httpSession.setAttribute("company", "传智播客");

		// 将写回给 浏览器 JSESSIONID 持久化
		Cookie cookie = new Cookie("JSESSIONID", httpSession.getId());
		cookie.setMaxAge(60 * 60);
		cookie.setPath("/day07");
		response.addCookie(cookie);

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("已经向session保存了一个数据！");

		String url = "/day07/readsession";
		// 对url 进行重写 拼接 jsessionid
		url = response.encodeURL(url);

		response.getWriter().println("<a href='" + url + "'>查看保存内容</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
