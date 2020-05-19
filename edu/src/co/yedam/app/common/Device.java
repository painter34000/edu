package co.yedam.app.common;

import javax.servlet.http.HttpServletRequest;

public class Device {
	public static final String IS_MOBILE = "MOBILE";
	public static final String IS_PHONE = "PHONE";
	public static final String IS_TABLET = "TABLET";
	public static final String IS_PC = "PC";

	/**
	 * 모바일,타블렛,PC구분
	 * @param req
	 * @return
	 */
	public static String getDevice(HttpServletRequest request) {
	    String userAgent = request.getHeader("User-Agent").toUpperCase();
		
	    if(userAgent.indexOf(IS_MOBILE) > -1) {
	        if(userAgent.indexOf(IS_PHONE) == -1)
	        	return IS_MOBILE;
			else
			    return IS_TABLET;
	    } else
	    	return IS_PC;
	}
}
