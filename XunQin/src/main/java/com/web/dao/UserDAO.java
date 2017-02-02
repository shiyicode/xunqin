package com.web.dao;

import java.util.List;

import com.web.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by shiyi on 16/9/23.
 */

@Repository("UserDAO")
public interface UserDAO {
    public User selectUserFromId(int id);

    public List<User> selectUser(User user, int start, int size);

    public int insertUser(User user);

    public int deleteUser(int id);

    public int updateUser(User user);

}
