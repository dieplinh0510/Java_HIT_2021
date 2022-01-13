package view;

import common.Constants;
import controller.*;
import model.Bill;
import model.Clothes;
import model.TypesOfCloth;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {
    private static User cur_user = null;
    private static ClotherStoreController clotherStoreController = new ClotherStoreController();
    private static BillController billController = new BillController();
    private static UserController userController = new UserController();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        UserController userController = new UserController();

        List<User> users = userController.readUsersFromFile(Constants.USER_FILE);

        ClotherStoreController clotherStoreController = new ClotherStoreController();

        List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);

        TypesOfClothController typesOfClothController = new TypesOfClothController();

        List<TypesOfCloth> typesOfCloths = new ArrayList<>();

        BillController billController = new BillController();
        List<Bill> bills = new ArrayList<>();

        CheckLogIn();
    }

    public static void CheckLogIn() throws IOException {
        List<User> users = userController.readUsersFromFile(Constants.USER_CUR_FILE);

        if (users.isEmpty()) {


            int x;
            do {
                System.out.println("1. Dang nhap tai khoan");
                System.out.println("2. Dang ki tai khoan");
                System.out.println("3. Quen mat khau");
                System.out.println("0. Thoat");
                System.out.println("Nhap lua chon cua ban: ");
                x = scanner.nextInt();
                switch (x) {
                    case 1:
                        logIn();
                        break;
                    case 2:
                        registration();
                        break;
                    case 3:
                        forgotPassword();
                        break;
                    default:
                        System.out.println("Khong co lua chon nay.");
                        break;
                }
            } while (x != 0);
        } else {
            cur_user = users.get(0);
            if (cur_user.getPermission().compareTo("admin") == 0) {
                whatAdminDo();
            } else {
                whatUserDo();
            }
        }
    }

    // tao tk moi
    private static void registration() throws IOException {
        List<User> users1 = userController.readUsersFromFile(Constants.USER_CUR_FILE);
        List<User> users = userController.readUsersFromFile(Constants.USER_FILE);
        User user = new User();
        boolean check;
        int idNew = users.size() + 1;
        user.setIdUser(idNew);

        do {
            scanner.nextLine();
            System.out.println("Nhap ten nguoi dung: ");
            String nameUserNew = scanner.nextLine();
            check = Constants.regexUsername.matcher(nameUserNew).find();
            if (check) {
                user.setNameUser(nameUserNew);
            } else {
                System.out.println("Ten nguoi dung cua ban khong hop le, moi nhap lai.");
            }
        } while (!check);

        do {
            System.out.println("Nhap mat khau: ");
            String passwordNew = scanner.nextLine();
            check = Constants.regexPassword.matcher(passwordNew).find();
            if (check) {
                user.setPassword(passwordNew);
            } else {
                System.out.println("Mat khau khong hop le, moi nhap lai.");
            }
        } while (!check);

        do {
            System.out.println("Nhap email: ");
            String emailNew = scanner.nextLine();
            check = Constants.regexEmail.matcher(emailNew).find();
            if (check) {
                user.setEmail(emailNew);
            } else {
                System.out.println("Dia chi email khong hop le, moi nhap lai.");
            }
        } while (!check);

        System.out.println("Nhap dia chi: ");
        String addressNew = scanner.nextLine();
        user.setAddress(addressNew);

        System.out.println("Nhap ten: ");
        String nameNew = scanner.nextLine();
        user.setName(nameNew);

        do {
            System.out.println("Nhap so dien thoai: ");
            String phoneNew = scanner.nextLine();
            check = Constants.regexPhone.matcher(phoneNew).find();
            if (check) {
                user.setPhoneNumber(phoneNew);
            } else {
                System.out.println("So dien thoai khong hop le, moi nhap lai.");
            }
        } while (!check);

        String permissionNew = "customer";
        user.setPermission(permissionNew);

        System.out.println("Nhap ngay sinh: ");
        String dateNew = scanner.nextLine();
        user.setDateOfBirth(dateNew);
        users.add(user);
        users1.add(user);
        userController.writeUsersToFile(users, Constants.USER_FILE);
        userController.writeUsersToFile(users1, Constants.USER_CUR_FILE);
        whatUserDo();
    }

    public static void forgotPassword() throws IOException {
        List<User> users = userController.readUsersFromFile(Constants.USER_FILE);
        scanner.nextLine();
        System.out.println("Nhap username cua ban: ");
        String userName = scanner.nextLine();
        System.out.println("Nhap email cua ban: ");
        String email = scanner.nextLine();
        int value = 0;
        boolean ok = false;
        String pass = "";
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNameUser().compareTo(userName) == 0 && users.get(i).getEmail().compareTo(email) == 0) {
                pass = users.get(i).getPassword();
                Random generator = new Random();
                value = generator.nextInt((999999 - 100000) + 1) + 100000;
                System.out.println("Ma lay lai mat khau la: " + value);
                ok = true;
                break;
            }
        }
        if (ok == true) {
            System.out.println("Nhap ma xac nhan: ");
            int ma = scanner.nextInt();
            if (ma == value && value != 0) {
                System.out.println("Mat khau cua ban la: " + pass);
            } else {
                System.out.println("Ma xac nhan cua ban khong dung.");
            }
        } else {
            System.out.println("Username va Email cua ban khong dung.");
        }
    }

    public static void logIn() throws IOException {
        String userNameInput;
        String passwordInput;
        scanner.nextLine();
        System.out.println("Vui long nhap username cua ban: ");
        userNameInput = scanner.nextLine();
        System.out.println("Vui long nhap password cua ban: ");
        passwordInput = scanner.nextLine();
        List<User> users = userController.readUsersFromFile(Constants.USER_FILE);
        boolean ok = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNameUser().compareTo(userNameInput) == 0 && users.get(i).getPassword().compareTo(passwordInput) == 0) {
                ok = true;
                cur_user = users.get(i);
                System.out.println("Ban da dang nhap thanh cong. Ban la " + users.get(i).getPermission());

                List<User> user_cur = new ArrayList<>();
                user_cur.add(users.get(i));
                userController.writeUsersToFile(user_cur, Constants.USER_CUR_FILE);

                if (users.get(i).getPermission().compareTo("admin") == 0) {
                    whatAdminDo();
                } else {
                    whatUserDo();
                }
            }
        }

        if (ok == false) {
            System.out.println("Tai khoan cua ban khong dung. Moi nhap lai tai khoan: ");
            logIn();
        }

    }


    private static void whatAdminDo() throws IOException {
        // menu

        int x;
        do {
            System.out.println("Cac cong viec ma ban co the lam: ");
            System.out.println("1. Xem cac san pham cua cua hang.");
            System.out.println("2. Xem thong tin cac khach hang.");
            System.out.println("3. Xem tat ca cac hoa don.");
            System.out.println("4. Sap xem san pham tang dan theo gia tien.");
            System.out.println("5. Tim kiem san pham.");
            System.out.println("6. Them san pham vao cua hang.");
            System.out.println("7. Sua gia cua san pham.");
            System.out.println("8. Xoa san pham khoi cua hang.");
            System.out.println("9. Thay doi thong tin ca nhan.");
            System.out.println("10. Chinh sua quyen cua nguoi khac.");
            System.out.println("11. Xem doanh thu cua cua hang.");
            System.out.println("12. Dang xuat.");
            System.out.println("0. Thoat");
            System.out.println("Moi nhap lua chon cua ban: ");
            x = scanner.nextInt();
            List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);

            List<User> users = userController.readUsersFromFile(Constants.USER_FILE);

            List<Bill> bills = billController.readBillFromFile(Constants.BILL_FILE);

            switch (x) {
                case 1:
                    clotherStoreController.viewProduct(clothes);
                    System.out.println("<===========>");
                    break;

                case 2:

                    userController.viewUser(users);
                    System.out.println("<===========>");
                    break;

                case 3:

                    billController.viewAllBill(bills);
                    System.out.println("<===========>");
                    break;

                case 4:

                    clotherStoreController.sortProductWithPrice(clothes);
                    System.out.println("<===========>");
                    break;

                case 5:
                    clotherStoreController.findProduct();
                    System.out.println("<===========>");
                    break;

                case 6:
                    clotherStoreController.addProduct();
                    System.out.println("<===========>");
                    break;

                case 7:
                    clotherStoreController.repairPriceofProduct(clothes);
                    System.out.println("<===========>");
                    break;

                case 8:
                    clotherStoreController.deleteProduct();
                    System.out.println("<===========>");
                    break;

                case 9:
                    userController.repairInfor();
                    System.out.println("<===========>");
                    break;

                case 10:
                    userController.repairPermission(users);
                    System.out.println("<===========>");
                    break;

                case 11:
                    billController.viewTurnover(bills);
                    System.out.println("<===========>");
                    break;

                case 12:
                    userController.logout();
                    System.out.println("<===========>");
                    break;

            }
        } while (x != 12 && x != 0);
    }


    private static void whatUserDo() throws IOException {

        int x;
        do {
            System.out.println("1. Xem cac san pham cua cua hang");
            System.out.println("2. Sap xep san pham tang dan theo gia tien");
            System.out.println("3. Tim kiem san pham");
            System.out.println("4. Mua hang");
            System.out.println("5. Xem hoa don");
            System.out.println("6. Danh gia chat luong san pham");
            System.out.println("7. Thay doi thong tin ca nhan");
            System.out.println("8. Dang xuat");
            System.out.println("0. Thoat");
            System.out.println("Moi nhap lua chon cua ban: ");
            x = scanner.nextInt();

            List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
            List<Bill> bills = billController.readBillFromFile(Constants.BILL_FILE);
            switch (x) {
                case 1:
                    clotherStoreController.viewProduct(clothes);
                    System.out.println("<===========>");
                    break;
                case 2:
                    clotherStoreController.sortProductWithPrice(clothes);
                    System.out.println("<===========>");
                    break;
                case 3:
                    clotherStoreController.findProduct();
                    System.out.println("<===========>");
                    break;
                case 4:
                    billController.buyProduct();
                    System.out.println("<===========>");
                    break;
                case 5:
                    billController.viewBill(bills);
                    System.out.println("<===========>");
                    break;
                case 6:
                    billController.qualityEvalution(bills);
                    System.out.println("<===========>");
                    break;
                case 7:
                    userController.repairInfor();
                    System.out.println("<===========>");
                    break;
                case 8:
                    userController.logout();
                    System.out.println("<===========>");
            }

        }while (x != 8 && x != 0) ;
    }
}





