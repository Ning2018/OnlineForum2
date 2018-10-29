package service;

import serviceInterfaces.ReviewService;
import serviceInterfaces.TopicService;
import serviceInterfaces.UserService;

public class ServiceManager {
	
	private ReviewService reviewService;
	private TopicService topicService;
	private UserService userService;
	
	public ReviewService getReviewService() {
		return reviewService;
	}
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	public TopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String toString() {
		return "ServiceManager [reviewService=" + reviewService + ", topicService=" + topicService + ", userService="
				+ userService + "]";
	}

}
