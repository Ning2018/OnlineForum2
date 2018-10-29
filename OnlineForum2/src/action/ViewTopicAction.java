package action;

import serviceInterfaces.ReviewService;

public class ViewTopicAction extends BaseAction {
	
	public String execute() throws Exception{
		
		try {
			ReviewService reviewService = serviceManager.getReviewService();
			userInfo.setUser(servletRequest.getParameter("user")); //For reviewService getReivews() 方法里 get topic, addReview() 方法里 get topic
			userInfo.setPath(servletRequest.getParameter("path")); //main.jsp传来   view_topic.action?path=
		//	userInfo.setTopicURL(servletRequest.getRealPath("));
			reviewService.getReviews(userInfo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return SUCCESS;
	}	
}
