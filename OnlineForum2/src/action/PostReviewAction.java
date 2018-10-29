package action;

import serviceInterfaces.ReviewService;

public class PostReviewAction extends BaseAction {
	
	public String execute() throws Exception{
		
		try {
			ReviewService reviewService = serviceManager.getReviewService();
			userInfo.setContent(servletRequest.getParameter("content"));
			userInfo.setUser(servletRequest.getParameter("user")); //For reviewService addReview() ∑Ω∑®¿Ô get topic
			userInfo.setPath(servletRequest.getParameter("path"));
			reviewService.addReview(userInfo, servletContext);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ERROR;
		}
		return SUCCESS;
	}

}
