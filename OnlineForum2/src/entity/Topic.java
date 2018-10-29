package entity;

import java.util.Date;

public class Topic {
	
	private int id;
	private String topic;
	private User user;
	private User lastReplyUser;
	private Date postTopicTime;
	private Date lastReplyTime;
	private int viewCount;
	private int replyCount;
	private String topicPath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getLastReplyUser() {
		return lastReplyUser;
	}
	public void setLastReplyUser(User lastReplyUser) {
		this.lastReplyUser = lastReplyUser;
	}
	public Date getPostTopicTime() {
		return postTopicTime;
	}
	public void setPostTopicTime(Date postTopicTime) {
		this.postTopicTime = postTopicTime;
	}
	public Date getLastReplyTime() {
		return lastReplyTime;
	}
	public void setLastReplyTime(Date lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getTopicPath() {
		return topicPath;
	}
	public void setTopicPath(String topicPath) {
		this.topicPath = topicPath;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", topic=" + topic + ", user=" + user + ", lastReplyUser=" + lastReplyUser
				+ ", postTopicTime=" + postTopicTime + ", lastReplyTime=" + lastReplyTime + ", viewCount=" + viewCount
				+ ", replyCount=" + replyCount + ", topicPath=" + topicPath + "]";
	}

}
