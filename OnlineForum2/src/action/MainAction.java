package action;

import com.opensymphony.xwork2.ActionSupport;

import serviceInterfaces.TopicService;

public class MainAction extends BaseAction  {
	
/*	private String testString;
	
	
	public String getTestString() {
		return testString;
	}


	public void setTestString(String testString) {
		this.testString = testString;
	}
*/

	public String execute() throws Exception
	{
		try
		{			
			System.out.println("in MainAction..execute()..");
			TopicService topicService = serviceManager.getTopicService();
			userInfo.setSelect(servletRequest.getParameter("select"));
			
			String s = servletRequest.getParameter("page");
			if(s!=null)
			{
				try {
					int pageNo = Integer.parseInt(s);
					userInfo.setPage(pageNo);
					System.out.println("in MainAction..execute()..servletRequest.getParameter(page).." + pageNo);
					//	userInfo.setPage(Integer.valueOf(servletRequest.getParameter("page")).intValue());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
			
			userInfo.setTopics(topicService.getTopics(userInfo));  //userInfo下能看到的主题，并不是userInfo下写的主题。
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return SUCCESS;
	}
	
	

}
