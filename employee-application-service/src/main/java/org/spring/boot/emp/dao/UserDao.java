package org.spring.boot.emp.dao;

import java.util.List;

import org.spring.boot.emp.model.User;

public interface UserDao {

	public void addUser(User user);

	public List<User> getUser();

	public User findById(int id);

	public User update(User user, int id);

	public User updateCountry(User user, int id);

	public void delete(int id);
	
}
