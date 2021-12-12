package view;

import controller.ClotherController;
import controller.UserController;
import model.Clothes;
import model.User;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunMain {

    public static void main(String[] args) throws IOException {
        UserController userController = new UserController();

        List<User> users = new ArrayList<>();

        users.add(new User(1, "lamlinh1001", "lamlinh1001", "lamlinh1001@gmail.com", "duong so 1", "lamlinh1", "011111111111", "admin", "11/5/2002"));
        users.add(new User(2, "lamlinh1002", "lamlinh1002", "lamlinh1002@gmail.com", "duong so 2", "lamlinh2", "022222222222", "customer", "12/5/2002"));
        users.add(new User(3, "lamlinh1003", "lamlinh1003", "lamlinh1003@gmail.com", "duong so 3", "lamlinh3", "033333333333", "customer", "13/5/2002"));
        users.add(new User(4, "lamlinh1004", "lamlinh1004", "lamlinh1004@gmail.com", "duong so 4", "lamlinh4", "044444444444", "customer", "14/5/2002"));
        users.add(new User(5, "lamlinh1005", "lamlinh1005", "lamlinh1005@gmail.com", "duong so 5", "lamlinh5", "055555555555", "customer", "15/5/2002"));
        users.add(new User(6, "lamlinh1006", "lamlinh1006", "lamlinh1006@gmail.com", "duong so 6", "lamlinh6", "066666666666", "customer", "16/5/2002"));
        users.add(new User(7, "lamlinh1007", "lamlinh1007", "lamlinh1007@gmail.com", "duong so 7", "lamlinh7", "077777777777", "customer", "17/5/2002"));

        userController.writeUsersToFile(users, "Users.DAT");

        ClotherController clotherController = new ClotherController();

        ArrayList <Clothes> clothes = new ArrayList<>();



    }
}
