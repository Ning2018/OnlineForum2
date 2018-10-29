package entity;

import java.util.Date;

public class Review {

	private int id;
	private int topicId;
	private User reviewUser;
	private Date reviewTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public User getReviewUser() {
		return reviewUser;
	}
	public void setReviewUser(User reviewUser) {
		this.reviewUser = reviewUser;
	}
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", topicId=" + topicId + ", reviewUser=" + reviewUser + ", reviewTime=" + reviewTime
				+ "]";
	}
	
}
