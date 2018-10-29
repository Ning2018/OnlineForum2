package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import daoInterfaces.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		System.out.println("in UserDaoImpl..saveUser.." + user);
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			System.out.println("in UserDaoImpl," + session + user);
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public User load(String username) {
		// TODO Auto-generated method stub
		String hql = "from User user WHERE user.name='"+username+"'";
		Session session = null;

		try {
			session = getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			if (list.size() > 0)
				return list.get(0);
			else
				return null;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
	/*
	 * @Override public boolean exists(User user) { // TODO Auto-generated
	 * method stub String hql="Select * FROM User"; Session session = null;
	 * Transaction transaction = null; List<User> list = null; try { session =
	 * getSessionFactory().openSession(); list =
	 * session.createQuery(hql).list(); }catch(Exception e){
	 * transaction.rollback(); }finally { // TODO: handle finally clause
	 * session.close(); }
	 * 
	 * if (list.contains(user)){ return true; } else return false; }
	 */

	public boolean exists(User user) {
		return (getPasswordMD5(user) != null) ? true : false;
	}

	@Override
	public String getPasswordMD5(User user) {
		// TODO Auto-generated method stub
		String username = user.getName();
		String hql = "Select passwordMD5 from User user where user.name='"+username+"'";

		Session session = null;

		try {
			session= getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			List<String> passwordMD5 = query.list();
			if (passwordMD5.size() > 0) {
				return passwordMD5.get(0);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

}
