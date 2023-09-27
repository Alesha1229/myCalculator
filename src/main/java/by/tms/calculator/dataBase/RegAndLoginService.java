package by.tms.calculator.dataBase;

import by.tms.calculator.entity.User;
import by.tms.calculator.storage.RegistrationStorage;

import java.sql.*;

public class RegAndLoginService implements RegistrationStorage {
    private static final String INSERT_QUERY_REGISTRATIONS = "INSERT INTO registrations (NAME, USERNAME, PASSWORD) values (?, ?, ?)";
    private static final String FIND_QUERY_REGISTRATIONS = "SELECT * FROM registrations WHERE USERNAME = ? AND PASSWORD = ?;";

    @Override
    public void save(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/history", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY_REGISTRATIONS)) {
            setRegistrationToPreparedStatement(user, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String load(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/history", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_QUERY_REGISTRATIONS)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return "false";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



        private static void setRegistrationToPreparedStatement (User user, PreparedStatement preparedStatement) throws
        SQLException {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());


        }
    }