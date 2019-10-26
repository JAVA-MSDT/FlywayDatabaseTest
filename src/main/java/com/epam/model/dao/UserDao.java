package com.epam.model.dao;

import com.epam.model.entity.User;
import com.epam.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private final static String GET_BY_ID = "SELECT * FROM user_table WHERE user_id = ? ";
    private final static String GET_ALL_USERS = "SELECT * FROM user_table";
    private final static String UPDATE_USER = "UPDATE user_table SET user_name = ?, user_email = ?, " +
            "user_birth_date = ? WHERE user_id = ?";
    private final static String REMOVE_USER = "DELETE FROM user_table WHERE user_id = ? ";
    private final static String ADD_USER = "INSERT INTO user_table(user_id, user_name, user_email, user_birth_date)" +
            " VALUES (? , ?, ?, ?) ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserById(long id){
        return jdbcTemplate.queryForObject(GET_BY_ID, new Object[]{id}, new UserMapper());
    }

    public List<User> getAllUsers(){
        return jdbcTemplate.query(GET_ALL_USERS, new UserMapper());
    }

    public int updateUser(User user){
        return jdbcTemplate.update(UPDATE_USER, user.getUserName(), user.getUserEmail(),
                user.getUserBirthDay(), user.getUserId());
    }

    public int removeUSer(long id){
        return jdbcTemplate.update(REMOVE_USER, id);
    }

    public int addUser(User user){
        return jdbcTemplate.update(ADD_USER, user.getUserId(), user.getUserName(), user.getUserEmail(),
                user.getUserBirthDay());
    }
}
