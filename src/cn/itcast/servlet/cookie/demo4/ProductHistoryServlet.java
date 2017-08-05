package cn.itcast.servlet.cookie.demo4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.CookieUtils;

/**
 * 浏览商品 ，将商品浏览记录添加 Cookie
 * 
 * @author seawind
 * 
 */
public class ProductHistoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] arr = { "冰箱", "洗衣机", "笔记本电脑", "手机", "空调", "热水器", "微波炉", "电风扇" };

		// 1 获得用户点击查看商品 编号
		String id = request.getParameter("id");

		// 2. 将商品编号存入cookie
		// Cookie cookie = new Cookie("history", id);
		// cookie.setMaxAge(60 * 60);
		// cookie.setPath("/day07");

		response.setContentType("text/html;charset=utf8");
		response.getWriter().println(
				"用户正在浏览商品：" + arr[Integer.parseInt(id) - 1]);
		response.getWriter().println(
				"<a href='/day07/cookie/demo4/product.jsp'>返回</a>");

		// 读取客户端cookie
		Cookie cookie = CookieUtils.findCookie(request.getCookies(), "history");
		if (cookie == null) {
			// 没有浏览记录
			cookie = new Cookie("history", id);
			cookie.setMaxAge(60 * 60);
			cookie.setPath("/day07");
			// 3、写回cookie
			response.addCookie(cookie);
		} else {
			// 已经存在商品浏览记录，判断当前浏览商品是否已经在记录中
			String ids = cookie.getValue();
			String[] idArray = ids.split(",");
			for (String existId : idArray) {
				if (existId.equals(id)) {
					// 当前浏览商品 已经在浏览器记录中
					return;
				}
			}

			// 当前id没有在浏览记录中
			cookie.setValue(ids + "," + id);
			cookie.setMaxAge(60 * 60);
			cookie.setPath("/day07");
			// 3、写回cookie
			response.addCookie(cookie);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
