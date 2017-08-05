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
 * 完成上次访问时间查看，显示给用户
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

		// 如果用户第一次访问 ---- 判断请求中有没有cookie信息
		Cookie[] cookies = request.getCookies(); // 获得请求中所有cookie信息

		response.setContentType("text/html;charset=utf-8");

		if (cookies == null) {
			// 没有cookie 第一次访问
			// 将当前时间 以cookie写回客户端

			// 当前时间毫秒 等价 new Date().getTime()
			long now = System.currentTimeMillis();

			// 向客户端写出cookie 需要用到cookie
			Cookie cookie = new Cookie("last", now + "");

			cookie.setPath("/day07");

			// 设置cookie 有效时间
			cookie.setMaxAge(60 * 60 * 24 * 2);// 设置cookie 时间两天

			// 写cookie回到客户端
			response.addCookie(cookie);

			// 通知用户 第一次访问
			response.getWriter().println("欢迎您第一次访问本网站，购物愉快！");
		} else {
			// cookie存在 ---- 获得最后访问时间
			for (Cookie cookie : cookies) {
				// 获得每个cookie
				if (cookie.getName().equals("last")) {
					long lasttime = Long.parseLong(cookie.getValue());
					// 显示给用户
					Date date = new Date(lasttime);

					// 格式化日期
					DateFormat dateFormat = new SimpleDateFormat(
							"yyyy年MM月dd日 HH时mm分ss秒");

					response.getWriter().println(
							"上次访问时间 ：" + dateFormat.format(date));
				}
			}

			// 更新最后访问时间

			// 当前时间毫秒 等价 new Date().getTime()
			long now = System.currentTimeMillis();

			// 向客户端写出cookie 需要用到cookie
			Cookie cookie = new Cookie("last", now + "");

			cookie.setPath("/day07");

			// 设置cookie 有效时间
			cookie.setMaxAge(60 * 60 * 24 * 2);// 设置cookie 时间两天

			// 写cookie回到客户端
			response.addCookie(cookie);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
