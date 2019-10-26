package com.epam.model.mapper;

import com.epam.model.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    private final static String USER_ID = "user_id";
    private final static String USER_NAME = "user_name";
    private final static String USER_EMAIL = "user_email";
    private final static String USER_BIRTH_DATE = "user_birth_date";


    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        long userId = resultSet.getLong(USER_ID);
        String userName = resultSet.getString(USER_NAME);
        String userEmail = resultSet.getString(USER_EMAIL);
        Date userBirthDate = resultSet.getDate(USER_BIRTH_DATE);

        return new User(userId, userName, userEmail, userBirthDate);
    }
}
