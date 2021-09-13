package com.java.api.repository;

import com.java.api.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetExtractor {

    public static List<User> extractUsers(ResultSet resultSet) throws SQLException
    {
        List<User> users = new ArrayList<>();

        while(resultSet.next())
        {
            User u = new User();
            u.setUuid(resultSet.getString("UUID"));
            u.setFullName(resultSet.getString("FULLNAME"));
            u.setEmail(resultSet.getString("EMAIL"));
            u.setPassword(resultSet.getString("PASSWORD"));

            users.add(u); // each iteration over resultset adds one record to list
        }

        return users;
    }
}
