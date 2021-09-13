package com.java.api.repository;

import com.java.api.models.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements IUserRepository{

    private static String INSERT="INSERT INTO TBL_USER(UUID,FULLNAME,EMAIL,PASSWORD) VALUES(?,?,?,?)";
    private static String SELECT_BY_EMAIL="SELECT * FROM TBL_USER WHERE EMAIL=?";

    @Override
    public String insert(User user, Connection connection) throws SQLException {

        PreparedStatement preparedStatement
                 = connection.prepareStatement(INSERT);
        preparedStatement.setString(1, user.getUuid());
        preparedStatement.setString(2, user.getFullName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4,user.getPassword());

        int rowsInserted = preparedStatement.executeUpdate();
        System.out.println("rows inserted: "+ rowsInserted);
        return user.getUuid();
    }

    @Override
    public User selectByEmail(String email, Connection connection) throws SQLException {
        PreparedStatement preparedStatement
                = connection.prepareStatement(SELECT_BY_EMAIL);
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<User> users = ResultSetExtractor.extractUsers(resultSet);

        if(users.size() == 0)
            return null;
        return users.get(0);
    }

    @Override
    public User selectByUuid(String uuid, Connection connection) throws SQLException {
        // do yourself
        return null;
    }

    public static void main(String[] args) throws SQLException {


        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setPassword("pass@123");
        user.setEmail("john.doe@gmail.com");
        user.setFullName("John Doe");

        Connection connection = DatabaseConnectionUtils.getConnection();
        IUserRepository userRepository = new UserRepositoryImpl();

        //userRepository.insert(user,connection);

        user = userRepository.selectByEmail(user.getEmail(), connection);

        System.out.println(user);
    }
}
