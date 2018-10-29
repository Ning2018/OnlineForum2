package service;

import daoInterfaces.UserDao;
import entity.User;
import serviceInterfaces.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		System.out.println("in UserService..userDao.."+userDao);
	}

/*	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
*/
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in UserService..addUser"+user);
		System.out.println("userDao.exists(user)"+userDao.exists(user));
		if (userDao.exists(user)) {
			throw new Exception("<" + user + ">ÒÑ¾­´æÔÚ");
		}
		userDao.save(user);
	}

	@Override
	public User loadUser(String username) {
		// TODO Auto-generated method stub
		return userDao.load(username);
	}

	@Override
	public boolean verifyUser(User user) {
		// TODO Auto-generated method stub
		String passwordMD5 = userDao.getPasswordMD5(user);
		boolean result = false;
		try {
			result = (user.getPasswordMD5().equals(passwordMD5)) ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return result;
	}

}
