package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import daoInterfaces.ReviewDao;
import entity.Review;

public class ReviewDaoImpl extends BaseDao implements ReviewDao {

	@Override
	public void save(Review review) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(review);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<Review> query(String hql, Object... params) {
		// TODO Auto-generated method stub
		
		Session session = null;
		
		try {
			session = getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			for (int i = 0, len = params.length; i < len; i++) {
				query.setParameter(i, params[i]);
			}
			return (List<Review>) query.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}finally{
			session.close();
		}
	}

}
