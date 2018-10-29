package serviceInterfaces;

import java.util.List;

import javax.servlet.ServletContext;

import common.UserInfo;
import entity.Review;

public interface ReviewService {
	
	public void getReviews(UserInfo userInfo);
	public void addReview(UserInfo userInfo, ServletContext servletContext) throws Exception;

}
