package cn.itcast.servlet.session.demo2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加商品到购物车
 * 
 * @author seawind
 * 
 */
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获得购买商品编号
		String id = request.getParameter("id");

		// 2、根据编号 得到商品名称
		String[] arr = { "冰箱", "洗衣机", "热水器", "微波炉", "空调", "电饭锅" };
		String productName = arr[Integer.parseInt(id) - 1];

		// 3、判断商品名称是否在购物车中
		// 判断购物车是否存在
		Map<String, Integer> cart = (Map<String, Integer>) request.getSession()
				.getAttribute("cart"); // 可能返回 null
		if (cart == null) {
			// 购物车对象不存在
			cart = new HashMap<String, Integer>();
		}

		if (cart.containsKey(productName)) {
			// 购物车存在该商品 数量+1
			int number = cart.get(productName);
			cart.put(productName, number + 1);
		} else {
			// 商品没有在购物车中
			cart.put(productName, 1);
		}

		// 将购物车加入session
		request.getSession().setAttribute("cart", cart);

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("商品已经被加入购物车！");

		response.getWriter().println(
				"<a href='/day07/session/demo2/cart.jsp'>查看购物车</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
