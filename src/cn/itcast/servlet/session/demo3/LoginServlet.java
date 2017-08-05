package cn.itcast.servlet.session.demo3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登陆
 * 
 * @author seawind
 * 
 */
public class LoginServlet extends HttpServlet {

	private Map<String, String> userInfo = new HashMap<String, String>();

	@Override
	public void init() throws ServletException {
		// 制作用户假数据
		userInfo.put("aaa", "111");
		userInfo.put("bbb", "222");
		userInfo.put("ddd", "333");
		userInfo.put("www", "444");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 乱码解决
		request.setCharacterEncoding("utf-8");

		// 判断验证码输入是否正确
		String checkcode = request.getParameter("checkcode");
		String checkcode_session = (String) request.getSession().getAttribute(
				"checkcode_session");
		// 删除session中验证码
		request.getSession().removeAttribute("checkcode_session");

		if (checkcode_session == null || !checkcode_session.equals(checkcode)) {
			// 验证码无效 -- 跳回login.jsp
			// response.sendRedirect("/day07/session/demo3/login.jsp");

			// 传递错误信息给jsp
			request.setAttribute("msg", "验证码错误错误");
			request.getRequestDispatcher("/session/demo3/login.jsp").forward(
					request, response);
			return;
		}

		// 1 从请求获得数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2 判断用户信息是否正确
		if (userInfo.containsKey(username)) {
			// 如果用户名存在
			if (userInfo.get(username).equals(password)) {
				// 密码正确 --- 登陆成功
				// 将用户信息 保存session
				request.getSession().setAttribute("username", username);

				// 跳转登陆成功 系统主页
				response.sendRedirect("/day07/session/demo3/welcome.jsp");

			} else {
				// 密码错误
				// response.sendRedirect("/day07/session/demo3/login.jsp");
				request.setAttribute("msg", "密码输入错误");
				request.getRequestDispatcher("/session/demo3/login.jsp")
						.forward(request, response);
			}

		} else {
			// 用户名不存在
			// response.sendRedirect("/day07/session/demo3/login.jsp");
			request.setAttribute("msg", "用户名不存在");
			request.getRequestDispatcher("/session/demo3/login.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
