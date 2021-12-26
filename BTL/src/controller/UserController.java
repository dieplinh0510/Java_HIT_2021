package controller;

import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserController {
    private User user = new User();
    private FileController fileController = new FileController();

    public UserController() {

    }

    public UserController(User user, FileController fileController) {
        this.user = user;
        this.fileController = fileController;
    }
    public List<User> readUsersFromFile(String filename) throws IOException {
//        fileController.OpenFileToWrite(filename);?????
        fileController.OpenFileToRead(filename);
        List<User> users = new ArrayList<>();

        while(fileController.scanner.hasNext()) {
            String data = fileController.scanner.nextLine();
            String[] a = data.split("\\|");
            users.add(new User(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8]));
        }

        fileController.CloseFileAfterRead(filename);

        return users;
    }

    public List<User> writeUsersToFile(List<User> users, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(User user : users) {
            fileController.getPrintWriter().println(user.getIdUser() + "|" + user.getNameUser() + "|" + user.getPassword()+ "|" + user.getEmail() + "|" + user.getAddress()+ "|" + user.getName()+ "|" + user.getPhoneNumber()+ "|"+ user.getPermission()+ "|" + user.getDateOfBirth());
        }

        fileController.CloseFileAfterWrite();
        return users;
    }
    public void closeUsersAfterRead(String file){
        fileController.CloseFileAfterWrite();
    }

    public boolean isBirthday(User user){
        Calendar cal = Calendar.getInstance();
        String[] data = user.getDateOfBirth().split("\\/");
        return Integer.parseInt(data[0]) == cal.get(Calendar.DAY_OF_MONTH)
                && Integer.parseInt(data[1]) == cal.get(Calendar.MONTH);

    }


}
