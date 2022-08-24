package event.manager;

import event.db.DBConnectionProvider;
import event.model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EventManager {


    private Connection connection;

    public EventManager(){

        connection = DBConnectionProvider.getInstance().getConnection();
    }
    public void add(Event event) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into event(name, place, isOnline, price, eventType) Values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, event.getName());
        preparedStatement.setString(2, event.getPlace());
        preparedStatement.setString(3, event.getIsOnline());
        preparedStatement.setDouble(4, event.getPrice());
        preparedStatement.setString(5, event.getEventType());

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if(resultSet.next()){
            int id = resultSet.getInt(1);
            event.setId(id);
        }
    }




        public void showEvents() throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM event");
            List<Event> events = new LinkedList<>();
            while (resultSet.next()) {
                Event event = new Event();
                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setPlace(resultSet.getString("place"));
                event.setIsOnline(resultSet.getString("isOnline"));
                event.setPrice(resultSet.getDouble("price"));
                event.setEventType(resultSet.getString("eventType"));
                events.add(event);

            }
            for (Event event : events) {
                System.out.println(event);
            }

        }
    }


