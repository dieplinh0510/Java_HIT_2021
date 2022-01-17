package controller;

import common.Constants;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UserController {
    private  User user = new User();
    private  FileController fileController = new FileController();

    public UserController() {

    }

    public UserController(User user, FileController fileController) {
        this.user = user;
        this.fileController = fileController;
    }
    public  List<User> readUsersFromFile(String filename) throws IOException {
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

    public  List<User> writeUsersToFile(List<User> users, String filename) throws IOException {
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

    public  void viewUser(List<User> users) {

        System.out.println("Store user information: ");
        for (int i = 0; i < users.size(); i++) {
            users.get(i).display();
        }
    }

    public  void repairInfor() throws IOException {
        List<User> user_cur = readUsersFromFile(Constants.USER_CUR_FILE);
        Scanner scanner = new Scanner(System.in);
        int n;

        do{
            System.out.println("You want to change: ");
            System.out.println("1. Change your password. ");
            System.out.println("2. Change your e-mail. ");
            System.out.println("3. Change your address. ");
            System.out.println("4. Change your name. ");
            System.out.println("5. Change your phone number.");
            System.out.println("0. Exit.");
            System.out.println("Enter your selection: ");
            n = scanner.nextInt();

            switch (n){
                case 1:
                    repairPassword(user_cur);
                    System.out.println("<=====================>");
                    System.out.println();
                    break;
                case 2:
                    repairEmail(user_cur);
                    System.out.println("<=====================>");
                    System.out.println();
                    break;
                case 3:
                    repairAddress(user_cur);
                    System.out.println("<=====================>");
                    System.out.println();
                    break;
                case 4:
                    repairName(user_cur);
                    System.out.println("<=====================>");
                    System.out.println();
                    break;
                case 5:
                    repairPhone(user_cur);
                    System.out.println("<=====================>");
                    System.out.println();
                    break;
                default:
                    System.out.println("This option is not available.");
                    System.out.println("<=====================>");
                    System.out.println();
            }
        }while (n!=0);
    }

    public  void repairPassword(List <User> user_cur) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<User> user =readUsersFromFile(Constants.USER_CUR_FILE);
        boolean check;
        System.out.println("Enter old password: ");
        String  passwordOld = scanner.nextLine();

        if (user.get(0).getPassword().compareTo(passwordOld)==0){
            do{
                System.out.println("Enter new password: "); String passwordNew = scanner.nextLine();

                check=Constants.regexPassword.matcher(passwordNew).find();
                if (check){
                    user.get(0).setPassword(passwordNew);
                    writeUsersToFile(user, Constants.USER_CUR_FILE);

                    // mo file users.dat de thay doi mat khau
                    List<User> users1 = readUsersFromFile(Constants.USER_FILE);
                    for (int i=0; i<users1.size(); i++){
                        if (users1.get(i).getIdUser()==user.get(0).getIdUser()){
                            users1.get(i).setPassword(user.get(0).getPassword());
                            writeUsersToFile(users1, Constants.USER_FILE);
                        }
                    }
                    System.out.println("Change password successfully.");
                } else {
                    System.out.println("Invalid password. Enter the password: ");
                }
            }while (!check);

        } else System.out.println("Password is not correct, please re-enter your choice.");
    }

    public  void repairEmail(List<User> users) throws IOException {
        boolean check;
        Scanner scanner = new Scanner(System.in);
        do{

            System.out.println("Change new email: "); String emailNew = scanner.nextLine();
            check=Constants.regexEmail.matcher(emailNew).find();
            if (check){
                users.get(0).setEmail(emailNew);
                writeUsersToFile(users, Constants.USER_CUR_FILE);

                // mo file users.dat de thay doi email
                List<User> users1 = readUsersFromFile(Constants.USER_FILE);
                for (int i=0; i<users1.size(); i++){
                    if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                        users1.get(i).setEmail(users.get(0).getEmail());
                        writeUsersToFile(users1, Constants.USER_FILE);
                    }
                }
                System.out.println("Change email successfully.");
            } else {
                System.out.println("Invalid email. Enter the email: ");
            }


        }while (!check);

    }

    public  void repairAddress(List<User> users) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new address: "); String addressNew = scanner.nextLine();

        users.get(0).setAddress(addressNew);
        writeUsersToFile(users, Constants.USER_CUR_FILE);

        // mo file users.dat de thay doi dia chi
        List<User> users1 = readUsersFromFile(Constants.USER_FILE);
        for (int i=0; i<users1.size(); i++){
            if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                users1.get(i).setAddress(users.get(0).getAddress());
                writeUsersToFile(users1, Constants.USER_FILE);
            }
        }

        System.out.println("Change address successfully.");
    }

    public  void repairName(List<User> users) throws IOException {
        boolean check;
        Scanner scanner = new Scanner(System.in);
        do{

            System.out.println("Enter new name user: "); String nameNew = scanner.nextLine();
            check = Constants.regexUsername.matcher(nameNew).find();
            if (check){
                users.get(0).setNameUser(nameNew);
                writeUsersToFile(users, Constants.USER_CUR_FILE);

                // mo file users.dat de thay doi name
                List<User> users1 = readUsersFromFile(Constants.USER_FILE);
                for (int i=0; i<users1.size(); i++){
                    if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                        users1.get(i).setNameUser(users.get(0).getNameUser());
                        writeUsersToFile(users1, Constants.USER_FILE);
                    }
                }
                System.out.println("Change name user successfully.");
            } else {
                System.out.println("Invalid nameuser. Enter the nameuser: ");
            }


        }while (!check);
    }

    public  void repairPhone(List<User> users) throws IOException {
        boolean check;
        Scanner scanner = new Scanner(System.in);
        do{

            System.out.println("Enter new phone number: "); String phoneNew = scanner.nextLine();
            check = Constants.regexPhone.matcher(phoneNew).find();
            if (check){
                users.get(0).setPhoneNumber(phoneNew);
                writeUsersToFile(users, Constants.USER_CUR_FILE);

                // mo file users.dat de thay doi sodienthoai
                List<User> users1 = readUsersFromFile(Constants.USER_FILE);
                for (int i=0; i<users1.size(); i++){
                    if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                        users1.get(i).setPhoneNumber(users.get(0).getPhoneNumber());
                        writeUsersToFile(users1, Constants.USER_FILE);
                    }
                }
                System.out.println("Change phone number successfully.");
            } else {
                System.out.println("Invalid phone number. Enter the phone number:");
            }


        }while (!check);
    }

    public  void repairPermission(List<User> users) throws IOException {

        List<User> users1 = readUsersFromFile(Constants.USER_FILE);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user id you want to edit permissions: ");
        int idRepair = scanner.nextInt();
        boolean ok= false;
        for (int i=0; i<users.size(); i++){
            if (users.get(i).getIdUser()==idRepair){
                ok = true;
                if (users.get(i).getPermission().compareTo("admin")==0){
                    users.get(i).setPermission("customer");
                } else if (users.get(i).getPermission().compareTo("customer")==0){
                    users.get(i).setPermission("admin");
                }
                writeUsersToFile(users, Constants.USER_FILE);
            }
        }
        if (ok) System.out.println("Change permissions successfully.");
        else System.out.println("Id user is incorrect");
    }

    public  void logout() throws IOException {
        List<User> cur_users =readUsersFromFile(Constants.USER_CUR_FILE);
        User cur_user = cur_users.get(0);
        FileWriter fileWriter = new FileWriter(Constants.USER_CUR_FILE, false);
        cur_user = null;
        System.out.println("You have successfully logged out.");
    }






}
