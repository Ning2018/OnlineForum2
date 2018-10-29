package action;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import serviceInterfaces.TopicService;

public class PostTopicAction extends BaseAction {
	
	public String execute() throws Exception{
		
		try{
			TopicService topicService = serviceManager.getTopicService();
			
			System.out.println("in PostTopic Action..servletRequest.getParameter(content): "+servletRequest.getParameter("content"));
			System.out.println("in PostTopic Action..servletRequest.getParameter(title): "+servletRequest.getParameter("title"));
			
			userInfo.setContent(servletRequest.getParameter("content"));
			userInfo.setTitle(servletRequest.getParameter("title"));
			topicService.addTopic(userInfo, servletContext);
			
			System.out.println("in PostTopicAction..userInfo.."+userInfo);
			return SUCCESS;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return ERROR;
		
	}

}
