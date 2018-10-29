package action;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;
import serviceInterfaces.UserService;

public class LoginAction extends BaseAction implements ModelDriven<User>{
	
	User user = new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public String execute() throws Exception{
		
		try {
			UserService userService = serviceManager.getUserService();
			if (userService.verifyUser(user)) {
				saveCookie("user", user.getName(), 24 * 60 * 60);  
				System.out.println("in LoginAction after save cookie: "+userInfo);
				
				HttpSession session = servletRequest.getSession();
				session.setAttribute("username", user.getName());
				session.setMaxInactiveInterval(60 * 60 * 3);
				
				return "success";
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}
	
	public void validate(User user) {
		if ("".equals(user.getValidationCode()))
			return;
		Object obj = ActionContext.getContext().getSession().get("validation_code");
		String validationCode = (obj != null) ? obj.toString() : "";
		if (!validationCode.equalsIgnoreCase(user.getValidationCode()))
			if (user.getValidationCode() != null)
				this.addFieldError("validationCode", "—È÷§¬Î ‰»Î¥ÌŒÛ£°");
	}
}
