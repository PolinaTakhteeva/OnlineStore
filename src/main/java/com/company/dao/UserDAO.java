package com.company.dao;

import java.util.List;
import com.company.model.User;
import java.io.IOException;

public interface UserDAO {
    public User getUser(int productId);
    public List<User> getAllUsers();
    public void insertUser(User user);
    public void deleteUser(User user) throws IOException;
    public void updateUser(User user);
}
