package dao;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import daoInterfaces.TopicDao;
import entity.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
	public void save(Topic topic) {
		// TODO Auto-generated method stub

		Session session = null;
		Transaction transaction = null;
		
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(topic);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}finally{
			session.close();
		}
		
	}
	
	
	@Override
	public void update(Topic topic) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(topic);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<Topic> query(String hql, Object... params) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			System.out.println("in TopicDaoImpl, List<Topic> query, params.length:"+params.length);
			for (int i = 0, len = params.length; i < len; i++) {
				System.out.println("in TopicDaoImpl, List<Topic> query, params[i]"+params[i]);
			}
			for (int i = 0, len = params.length; i < len; i++) {
				query.setParameter(i, params[i]);
			}
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public void execute(final String hql, final Object... params) {
		// TODO Auto-generated method stub
		Session session = null;
		System.out.println("in TopicDaoImpl..execute..");
		try {
			session = getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			for (int i = 0, len = params.length; i < len; i++) {
				query.setParameter(i, params[i]);
			}
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
	}

	@Override
	public List<Topic> query1(final String hql, final int firstRow, final int maxRow, final Object... params) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			for (int i = 0, len = params.length; i < len; i++) {
				query.setParameter(i, params[i]);
			}
			query.setFirstResult(firstRow);
			query.setMaxResults(maxRow);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		return null;
	}
	public List<Topic> query2(final String hql, final int firstRow, final int maxRow) {
		// TODO Auto-generated method stub
		Session session = null;
		System.out.println("in TopicDaoImpl, query2, firstRow:"+firstRow+"maxRow:"+maxRow);
		try {
			session = getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(firstRow);
			query.setMaxResults(maxRow);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		return null;
	}



}
