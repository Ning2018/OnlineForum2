package serviceInterfaces;

import entity.User;

public interface UserService {
	
	public void addUser(User user) throws Exception;
	public User loadUser(String username);
	public boolean verifyUser(User user);

}
