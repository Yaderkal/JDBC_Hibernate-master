package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 20);
        userService.saveUser("Cheslav", "Rochev", (byte) 25);
        userService.saveUser("Nick", "Valentine", (byte) 31);
        userService.saveUser("Rick", "Grimes", (byte) 38);

        userService.removeUserById(3);
        userService.getAllUsers();
    }
}
