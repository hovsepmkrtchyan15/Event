package event;

import event.command.Commands;
import event.enums.EventType;
import event.manager.EventManager;
import event.manager.UserManager;
import event.model.Event;
import event.model.User;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;

import static event.enums.EventType.CONCERT;
import static event.enums.EventType.EXHIBITION;


public class Main implements Commands {
    private static Scanner scanner = new Scanner(System.in);

    private static EventManager eventManager = new EventManager();

    private static UserManager userManager = new UserManager();

    public static void main(String[] args) throws SQLException {

        int command;
        boolean run = true;

        while (run) {
            Commands.printCommands();
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input correct commands");
                command = -1;
            }
            switch (command) {
                case ADD_EVENT:
                    addevent();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case SHOW_EVENTS:
                    eventManager.showEvents();
                    break;
                case SHOW_USERS:
                    userManager.showUsers();
                    break;

                default:
                    System.err.println("Invalid index");
                    break;

            }

        }

    }

    private static void addUser() throws SQLException {
        eventManager.showEvents();
        System.out.println("Please coose event id");
        int idevent = Integer.parseInt(scanner.nextLine());

        System.out.println("Please input name");
        String username = scanner.nextLine();

        System.out.println("Please input surname");
        String usersurname = scanner.nextLine();

        System.out.println("Please input email");
        String useremail = scanner.nextLine();

        User user= new User();
        user.setName(username);
        user.setSurname(usersurname);
        user.setEmail(useremail);
        user.setEventId(idevent);

        userManager.add(user);
    }

    private static void addevent() throws SQLException {
        System.out.println("Please input name");
        String eventname = scanner.nextLine();

        System.out.println("Please input place");
        String eventplace = scanner.nextLine();

        System.out.println("Please input isOnline");
        String eventIsOnline = scanner.nextLine();

        System.out.println("Please input price");
        double eventprice = Double.parseDouble(scanner.nextLine());

        System.out.println("Please choose eventType");
        System.out.print(EXHIBITION.name() + ", ");
        System.out.println(CONCERT.name());
        String eventType = scanner.nextLine();
        
        Event event = new Event();
        event.setName(eventname);
        event.setPlace(eventplace);
        event.setIsOnline(eventIsOnline);
        event.setPrice(eventprice);
        event.setEventType(eventType);
        eventManager.add(event);
    }
}