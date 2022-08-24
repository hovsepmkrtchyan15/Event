package event.command;

public interface Commands {
int ADD_EVENT = 0;
int ADD_USER = 1;
int SHOW_EVENTS = 2;
int SHOW_USERS = 3;

public static void printCommands(){
    System.out.println( ADD_EVENT + " add event");
    System.out.println( ADD_USER + " add user");
    System.out.println(SHOW_EVENTS + " show events");
    System.out.println(SHOW_USERS + " show users");
}
}
