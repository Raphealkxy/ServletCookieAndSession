package cn.itcast.utils;

import javax.servlet.http.Cookie;

/**
 * 经常读取Cookie，每次读取需要执行for循环，将读取cookie操作抽取出来
 * 
 * @author seawind
 * 
 */
public class CookieUtils {
	/**
	 * 在Cookie数组中 查找指定name cookie
	 * 
	 * @param cookies
	 * @param name
	 * @return
	 */
	public static Cookie findCookie(Cookie[] cookies, String name) {
		if (cookies == null) {// 没有cookie
			return null;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
			return null;
		}
	}
}
