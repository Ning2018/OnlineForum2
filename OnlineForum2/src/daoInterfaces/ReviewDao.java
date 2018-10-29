package daoInterfaces;

import java.util.List;

import entity.Review;

public interface ReviewDao {
	
	public void save(Review review);
	public List<Review> query(String hql, Object...params);

}
