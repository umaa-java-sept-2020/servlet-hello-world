package com.java.api.repository;

import com.java.api.models.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface IUserRepository {

    /**
     *  save the user details into the database table
     *
     * @param user
     * @param connection the database connection
     * @return the uuid of the User
     * @throws SQLException
     */
    String insert(User user, Connection connection) throws SQLException;

    User selectByEmail(String email, Connection connection) throws SQLException;

    User selectByUuid(String uuid, Connection connection) throws SQLException;
}
