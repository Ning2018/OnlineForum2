package daoInterfaces;

import entity.User;

public interface UserDao {
	
	public void save(User user);
	public User load(String username);
	public boolean exists(User user);
	public String getPasswordMD5(User user);

}
