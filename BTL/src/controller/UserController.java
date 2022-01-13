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

        System.out.println("Thong tin cac nguoi dung cua cua hang: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    public  void repairInfor() throws IOException {
        List<User> user_cur = readUsersFromFile(Constants.USER_CUR_FILE);
        Scanner scanner = new Scanner(System.in);
        int n;

        do{
            System.out.println("Ban muon thay doi: ");
            System.out.println("1. Thay doi mat khau. ");
            System.out.println("2. Thay doi email. ");
            System.out.println("3. Thay doi dia chi nhan hang. ");
            System.out.println("4. Thay doi ten nguoi nhan hang. ");
            System.out.println("5. Thay doi so dien thoai nguoi nhan hang.");
            System.out.println("0. Thoat.");
            System.out.println("Nhap lua chon cua ban: ");
            n = scanner.nextInt();

            switch (n){
                case 1: repairPassword(user_cur); break;
                case 2: repairEmail(user_cur); break;
                case 3: repairAddress(user_cur); break;
                case 4: repairName(user_cur); break;
                case 5: repairPhone(user_cur); break;
                default:
                    System.out.println("Khong co lua chon nay.");
            }
        }while (n!=0);
    }

    public  void repairPassword(List <User> user_cur) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<User> user =readUsersFromFile(Constants.USER_CUR_FILE);
        boolean check;
        System.out.println("Nhap mat khau cu: ");
        String  passwordOld = scanner.nextLine();

        if (user.get(0).getPassword().compareTo(passwordOld)==0){
            do{
                System.out.println("Nhap mat khau moi: "); String passwordNew = scanner.nextLine();

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
                    System.out.println("Thay doi mat khau thanh cong.");
                } else {
                    System.out.println("Mat khau khong hop le. Nhap lai mat khau.");
                }
            }while (!check);

        } else System.out.println("Mat khau khong dung. Moi ban nhap lai lua chon.");
    }

    public  void repairEmail(List<User> users) throws IOException {
        boolean check;
        Scanner scanner = new Scanner(System.in);
        do{

            System.out.println("Nhap email moi: "); String emailNew = scanner.nextLine();
            check=Constants.regexEmail.matcher(emailNew).find();
            if (check){
                users.get(0).setPassword(emailNew);
                writeUsersToFile(users, Constants.USER_CUR_FILE);

                // mo file users.dat de thay doi email
                List<User> users1 = readUsersFromFile(Constants.USER_FILE);
                for (int i=0; i<users1.size(); i++){
                    if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                        users1.get(i).setEmail(users.get(0).getEmail());
                        writeUsersToFile(users1, Constants.USER_FILE);
                    }
                }
                System.out.println("Thay doi email thanh cong.");
            } else {
                System.out.println("Enail khong hop le. Moi nhap lai email.");
            }


        }while (!check);

    }

    public  void repairAddress(List<User> users) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap dia chi moi: "); String addressNew = scanner.nextLine();

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

        System.out.println("Thay doi dia chi thanh cong.");
    }

    public  void repairName(List<User> users) throws IOException {
        boolean check;
        Scanner scanner = new Scanner(System.in);
        do{

            System.out.println("Nhap ten moi: "); String nameNew = scanner.nextLine();
            check = Constants.regexUsername.matcher(nameNew).find();
            if (check){
                users.get(0).setNameUser(nameNew);
                writeUsersToFile(users, Constants.USER_CUR_FILE);

                // mo file users.dat de thay doi name user
                List<User> users1 = readUsersFromFile(Constants.USER_FILE);
                for (int i=0; i<users1.size(); i++){
                    if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                        users1.get(i).setNameUser(users.get(0).getNameUser());
                        writeUsersToFile(users1, Constants.USER_FILE);
                    }
                }
                System.out.println("Thay doi ten nguoi dung thanh cong.");
            } else {
                System.out.println("Ten nguoi dung khong hop le. Moi nhap lai ten nguoi dung.");
            }


        }while (!check);
    }

    public  void repairPhone(List<User> users) throws IOException {
        boolean check;
        Scanner scanner = new Scanner(System.in);
        do{

            System.out.println("Nhap so dien thoai moi: "); String phoneNew = scanner.nextLine();
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
                System.out.println("Thay doi so dien thoai thanh cong.");
            } else {
                System.out.println("So dien thoai khong hop le. Moi nhap lai so dien thoai.");
            }


        }while (!check);
    }

    public  void repairPermission(List<User> users) throws IOException {

        List<User> users1 = readUsersFromFile(Constants.USER_FILE);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma nguoi ban muon chinh sua quyen: ");
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
        if (ok) System.out.println("Thay doi quyen thanh cong.");
        else System.out.println("Ma nguoi ban muon chinh sua khong dung. Moi nhap lai lua chon.");
    }

    public  void logout() throws IOException {
        List<User> cur_users =readUsersFromFile(Constants.USER_CUR_FILE);
        User cur_user = cur_users.get(0);
        FileWriter fileWriter = new FileWriter(Constants.USER_CUR_FILE, false);
        cur_user = null;
        System.out.println("Ban da dang xuat thanh cong.");
    }






}
