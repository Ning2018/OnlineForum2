package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;
import serviceInterfaces.UserService;

public class RegisterAction extends BaseAction implements ModelDriven<User> {

	User user = new User();
	
	

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
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

	public String execute() throws Exception {

		try {
			System.out.println("in RegisterAction..."+user);
			UserService userService = serviceManager.getUserService();
			System.out.println(userService);
			userService.addUser(user);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "error";
		}

	}

}
