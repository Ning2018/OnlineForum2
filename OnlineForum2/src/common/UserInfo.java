package common;

import java.util.List;

import entity.Review;
import entity.Topic;

public class UserInfo {
	
	private String cookieUser;
	private String title;
	private String content;
	private String select;
	
	private int page;
	private int totalPage;
	private int pageTopicNumber;
	private List<Topic> topics;  //MainAction中，userInfo.setTopics(page,select)
	
	private String user;   //userInfo下浏览的帖子topic.user.name路径里的参数,通过main.jsp中view_topic.action?参数 传递
	private String path;   //randomStr  对应topic类中的topicPath
	private Topic topic;   //userInfo下浏览(ViewTopicAction)的帖子
	private String topicPath;  // /content/cookieUser/randomStr/topic.txt
	private String postTopicTime;
	private String topicURL;    
	private List<String> reviewURLs;
	private List<Review> reviews;
	
	public String getCookieUser() {
		return cookieUser;
	}
	public void setCookieUser(String cookieUser) {
		this.cookieUser = cookieUser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageTopicNumber() {
		return pageTopicNumber;
	}
	public void setPageTopicNumber(int pageTopicNumber) {
		this.pageTopicNumber = pageTopicNumber;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getTopicPath() {
		return topicPath;
	}
	public void setTopicPath(String topicPath) {
		this.topicPath = topicPath;
	}
	public String getPostTopicTime() {
		return postTopicTime;
	}
	public void setPostTopicTime(String postTopicTime) {
		this.postTopicTime = postTopicTime;
	}
	public String getTopicURL() {
		return topicURL;
	}
	public void setTopicURL(String topicURL) {
		this.topicURL = topicURL;
	}
	public List<String> getReviewURLs() {
		return reviewURLs;
	}
	public void setReviewURLs(List<String> reviewURLs) {
		this.reviewURLs = reviewURLs;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@Override
	public String toString() {
		return "UserInfo [cookieUser=" + cookieUser + ", title=" + title + ", content=" + content + ", select=" + select
				+ ", page=" + page + ", totalPage=" + totalPage + ", pageTopicNumber=" + pageTopicNumber + ", topics="
				+ topics + ", user=" + user + ", path=" + path + ", topic=" + topic + ", topicPath=" + topicPath
				+ ", postTopicTime=" + postTopicTime + ", topicURL=" + topicURL + ", reviewURLs=" + reviewURLs
				+ ", reviews=" + reviews + "]";
	}
	
}
