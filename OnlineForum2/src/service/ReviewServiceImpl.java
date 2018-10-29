package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import common.UserInfo;
import daoInterfaces.ReviewDao;
import daoInterfaces.TopicDao;
import daoInterfaces.UserDao;
import entity.Review;
import entity.Topic;
import entity.User;
import serviceInterfaces.ReviewService;

public class ReviewServiceImpl implements ReviewService {

	private ReviewDao reviewDao;
	private UserDao userDao;
	private TopicDao topicDao;

	public ReviewServiceImpl(ReviewDao reviewDao, UserDao userDao, TopicDao topicDao) {
		super();
		this.reviewDao = reviewDao;
		this.userDao = userDao;
		this.topicDao = topicDao;
	}

	@Override
	public void getReviews(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String hql = "from Topic t where t.user.name=? and t.topicPath=?";
		List<Topic> list = topicDao.query(hql, userInfo.getUser(), userInfo.getPath());
		Topic topic = list.get(0);
		topic.setViewCount(topic.getViewCount() + 1);
		topicDao.update(topic);

		//String topicPath = "C:/Java Projects/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/OnlineForum2/content/" + userInfo.getUser() + "/" + userInfo.getPath() + "/";
		String topicPath="C:/Users/A/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OnlineForum2/content/"+ userInfo.getUser() + "/" + userInfo.getPath() + "/";
	//	String topicPath="/content/"+ userInfo.getUser() + "/" + userInfo.getPath() + "/";
		String topicURL = topicPath + "topic.txt";

		userInfo.setTopicPath(topicPath);
		userInfo.setTopicURL(topicURL);
		userInfo.setTopic(topic);

		List<Review> reviews = reviewDao.query("from Review r where r.topicId = ? order by reviewTime asc", topic.getId());
		if (reviews.size() > 0) {
			userInfo.setReviews(reviews);
		}

		List<String> reviewURLs = new ArrayList<String>();
		for (Review review: reviews)
		{
			reviewURLs.add(topicPath+review.getId()+".txt");
		}
		userInfo.setReviewURLs(reviewURLs);
	//	userInfo.setReviews(reviews);
		System.out.println("in ReviewService.."+reviews);
		userInfo.setReviews(reviews);
	}

	@Override
	public void addReview(UserInfo userInfo, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub

		User user = userDao.load(userInfo.getCookieUser());
		Review review = new Review();
		review.setReviewUser(user);

		String hql = "from Topic t where t.user.name=? and t.topicPath=?";
		List<Topic> list = topicDao.query(hql, userInfo.getUser(), userInfo.getPath());
		Topic topic = list.get(0);
		topic.setLastReplyUser(user);
		topic.setReplyCount(topic.getReplyCount() + 1);
		Date date = new Date();
		topic.setLastReplyTime(date);
		topicDao.update(topic);

		review.setTopicId(topic.getId());
		review.setReviewTime(date);
		reviewDao.save(review);

		String fn = servletContext.getRealPath("/content");
		fn += File.separator + topic.getUser().getName() + File.separator + topic.getTopicPath();
		fn += File.separator + String.valueOf(review.getId()).toString() + ".txt";

		OutputStream os = new FileOutputStream(fn);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		osw.write(userInfo.getContent());
		osw.close();
		os.close();
	}

}
