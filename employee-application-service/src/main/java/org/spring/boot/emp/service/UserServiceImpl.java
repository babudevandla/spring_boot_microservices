package org.spring.boot.emp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.spring.boot.emp.dao.UserDao;
import org.spring.boot.emp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    UserDao userDao;

	@Cacheable(value="users")
    public List<User> getUser() {
        // TODO Auto-generated method stub
        return userDao.getUser();
    }

    public User findById(int id) {
       System.out.println("get user by Id ::"+id);
        return userDao.findById(id);
    }

    public void createUser(User user) {
        // TODO Auto-generated method stub
        userDao.addUser(user);
    }

    public void deleteUserById(int id) {
        // TODO Auto-generated method stub
        userDao.delete(id);
    }
    @Override
    public User updatePartially(User user, int id) {
        userDao.updateCountry(user,id);
        return userDao.findById(id);
    }

    @Override
    public User update(User user,int id) {
        // TODO Auto-generated method stub
        return userDao.update(user, id);
    }
}
