package cn.itcast.utils;

import javax.servlet.http.Cookie;

/**
 * ������ȡCookie��ÿ�ζ�ȡ��Ҫִ��forѭ��������ȡcookie������ȡ����
 * 
 * @author seawind
 * 
 */
public class CookieUtils {
	/**
	 * ��Cookie������ ����ָ��name cookie
	 * 
	 * @param cookies
	 * @param name
	 * @return
	 */
	public static Cookie findCookie(Cookie[] cookies, String name) {
		if (cookies == null) {// û��cookie
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
