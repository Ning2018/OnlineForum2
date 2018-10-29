package action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

import common.UserInfo;
import service.ServiceManager;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware {
	
	protected ServiceManager serviceManager;
	protected UserInfo userInfo;
	protected Map<String, String> cookies;
	protected HttpServletRequest servletRequest;
	protected HttpServletResponse servletResponse;
	protected ServletContext servletContext;

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.servletResponse=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.servletRequest=request;
		userInfo.setCookieUser(getCookieValue("user")); 
		System.out.println("in BaseAction setServletRequest: "+userInfo);
	}
	
	protected String getCookieValue(String name){
		Cookie cookies[] = servletRequest.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(!cookie.getName().equals(name)){
					continue;
				}
				return cookie.getValue();
			}
		}
		return null;
	}
	
	protected void saveCookie(String name, String value, int maxAge){
		
		Cookie cookie = new Cookie(name,value);
		cookie.setPath(servletRequest.getContextPath());
		cookie.setMaxAge(maxAge);
		servletResponse.addCookie(cookie);
	}

}
