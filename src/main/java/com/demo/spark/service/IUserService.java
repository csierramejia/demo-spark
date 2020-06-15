/**
 * 
 */
package com.demo.spark.service;

import java.util.Collection;

import com.demo.spark.dto.User;

/**
 * @author
 *
 */
public interface IUserService {

    public void addUser(User user);

    public Collection<User> getUsers();

    public User getUser(String id);

    public User editUser(User user) throws UserException;

    public void deleteUser(String id);

    public boolean userExist(String id);
    
}
