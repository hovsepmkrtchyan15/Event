package event.manager;

import event.db.DBConnectionProvider;
import event.model.Event;
import event.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private Connection connection;
    EventManager eventManager = new EventManager();
    Scanner scanner = new Scanner(System.in);

    public UserManager() {

        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void add(User user) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("Insert into user(name, surname, email, event_id) Values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setInt(4, user.getEventId());

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            user.setId(id);
        }
    }

    public void showUsers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        List<User> users = new LinkedList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setEventId(resultSet.getInt("event_id"));

            users.add(user);

        }
        for (User user : users) {
            System.out.println(user);
        }

    }
}

