package serviceInterfaces;

import java.util.List;

import javax.servlet.ServletContext;

import common.UserInfo;
import entity.Topic;

public interface TopicService {
	
	public void addTopic(UserInfo userInfo, ServletContext servletContext) throws Exception;
	public List<Topic> getTopics(UserInfo userInfo);

}
