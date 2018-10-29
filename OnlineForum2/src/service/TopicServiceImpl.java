package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;

import common.UserInfo;
import daoInterfaces.TopicDao;
import daoInterfaces.UserDao;
import entity.Topic;
import entity.User;
import serviceInterfaces.TopicService;

public class TopicServiceImpl implements TopicService {

	private TopicDao topicDao;
	private UserDao userDao;

	public TopicServiceImpl(TopicDao topicDao, UserDao userDao) {
		super();
		this.topicDao = topicDao;
		this.userDao = userDao;
	}

	@Override
	public void addTopic(UserInfo userInfo, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("in topicService..addtopic..cookieuser:"+userInfo.getCookieUser());
		User user = userDao.load(userInfo.getCookieUser());
		System.out.println("in topicService..addTopic..userDao.load(cookieuser)"+user);
		if (user == null)
			return;
		Topic topic = new Topic();
		
		topic.setTopic(userInfo.getTitle());  
		
		topic.setUser(user);
		Date date = new Date();
		topic.setLastReplyTime(date);
		topic.setPostTopicTime(date);
		topic.setLastReplyUser(user);
		topic.setTopic(userInfo.getTitle());
		Random random = new Random();
		String randomStr = String.valueOf(random.nextInt(Integer.MAX_VALUE));
		topic.setTopicPath(randomStr);
		System.out.println("in topicService..topic.."+topic);
		topicDao.save(topic);

		String fn = servletContext.getRealPath("/content");
		System.out.println("fn is:" + fn);
		fn += File.separator + userInfo.getCookieUser() + File.separator + randomStr;
		File dir = new File(fn);
		if (!dir.exists()) {
			dir.mkdirs();  //路径下创建文件夹
		}
		fn += File.separator + "topic.txt";
		System.out.println("fn is:" + fn);
        //内容写入topic.txt
		OutputStream os = new FileOutputStream(fn);  
		OutputStreamWriter osw = new OutputStreamWriter(os);
		System.out.println("in TopicService..addTopic..content: "+userInfo.getContent());
		osw.write(userInfo.getContent()); //通过OutputStreamWriter把content写入OutputStream
		osw.close();
		os.close();
	}

	@Override
	public List<Topic> getTopics(UserInfo userInfo) {
		// TODO Auto-generated method stub
		int totalPage = 1;
		if(userInfo.getSelect()!=null&&!userInfo.getSelect().equals(""))
		{	totalPage = getPageNumber(userInfo.getPageTopicNumber(),userInfo.getSelect());
		System.out.println("in TopicService..userInfo.getSelect!=null,"+userInfo.getSelect()+totalPage);}
		else totalPage = getPageNumber(userInfo.getPageTopicNumber(),null);
		userInfo.setTotalPage(totalPage);
		
		if(userInfo.getPage()>totalPage)
			userInfo.setPage(totalPage);
		if(userInfo.getPage()<1)
			userInfo.setPage(1);
		
		List<Topic> topics = null;
		String hql1 = "from Topic t where t.topic like ? order by t.lastReplyTime desc";
		String hql2="from Topic t order by t.lastReplyTime desc";
		
		if(userInfo.getSelect()!=null&&!userInfo.getSelect().equals(""))
		{
			topics=topicDao.query1(hql1, (userInfo.getPage()-1)*userInfo.getPageTopicNumber(),userInfo.getPageTopicNumber(),
					"%"+userInfo.getSelect()+"%");
		}
		else
			topics=topicDao.query2(hql2, (userInfo.getPage()-1)*userInfo.getPageTopicNumber(),userInfo.getPageTopicNumber());
	
		return topics;
	}
// 获取满足查询条件的主题 所占页数
	private int getPageNumber(int pageTopicNumber, String select) {
		// TODO Auto-generated method stub
		int count =1;
		//List<Long> cc =null;
		int topicsNumber=0;
		if(select == null)
			topicsNumber=topicDao.query("from Topic").size();
		else
				topicsNumber=topicDao.query("from Topic t where t.topic like ?","%"+select+"%").size();
			if(topicsNumber>0){
				count = topicsNumber;
				int n = count%pageTopicNumber;
				count = count/pageTopicNumber;
				if(n!=0) count++;}
			System.out.println("in TopicService getPageNumber, totalPageNumber is"+count);
			return count;
	}
}
