package by.tms.calculator.dataBase;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.storage.OperationStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryService implements OperationStorage {
    private static final String INSERT_QUERY = "INSERT INTO operations (NUM1, NUM2, TYPE, RESULT, AUTHOR) values (?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * from operations where AUTHOR = ?";

    public void save(Operation operation) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/history", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            setOperationToPreparedStatement(operation, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAllByAuthorUsername(String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Operation> operations = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/history", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Operation operation = getOperationResultSet(rs);
                operations.add(operation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("operations " + operations);
        return operations;
    }


    private static Operation getOperationResultSet(ResultSet rs) throws SQLException {
        Operation operation = new Operation();
        operation.setNum1(rs.getDouble("NUM1"));
        operation.setNum2(rs.getDouble("NUM2"));
        operation.setType(rs.getString("TYPE"));
        operation.setResult(rs.getDouble("RESULT"));
        operation.setAuthor((User) rs.getObject("AUTHOR"));
        return operation;
    }


    private static void setOperationToPreparedStatement(Operation operation, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setDouble(1, operation.getNum1());
        preparedStatement.setDouble(2, operation.getNum2());
        preparedStatement.setString(3, operation.getType());
        preparedStatement.setDouble(4, operation.getResult());
        preparedStatement.setString(5, String.valueOf(operation.getAuthor()));
    }
}