package view;

import common.Constants;
import controller.*;
import model.Bill;
import model.Clothes;
import model.TypesOfCloth;
import model.User;

import java.io.IOException;

import java.util.*;


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
                System.out.println("1. Account Login.");
                System.out.println("2. Register an account.");
                System.out.println("3. Forgot password.");
                System.out.println("0. Exit.");
                System.out.println("Enter your selection: ");
                x = scanner.nextInt();
                switch (x) {
                    case 1:
                        logIn();
                        System.out.println();
                        System.out.println("<==========================================>");
                        System.out.println();
                        break;
                    case 2:
                        registration();
                        System.out.println();
                        System.out.println("<==========================================>");
                        System.out.println();
                        break;
                    case 3:
                        forgotPassword();
                        System.out.println();
                        System.out.println("<==========================================>");
                        System.out.println();
                        break;
                    default:
                        System.out.println("This option is not available.");
                        System.out.println();
                        System.out.println("<==========================================>");
                        System.out.println();
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
            System.out.println("Enter username: ");
            String nameUserNew = scanner.nextLine();
            check = Constants.regexUsername.matcher(nameUserNew).find();
            if (check) {
                user.setNameUser(nameUserNew);
            } else {
                System.out.println("Your username is not valid, please re-enter.");
            }
        } while (!check);

        do {
            System.out.println("Enter password: ");
            String passwordNew = scanner.nextLine();
            check = Constants.regexPassword.matcher(passwordNew).find();
            if (check) {
                user.setPassword(passwordNew);
            } else {
                System.out.println("Invalid password, please re-enter.");
            }
        } while (!check);

        do {
            System.out.println("Enter email: ");
            String emailNew = scanner.nextLine();
            check = Constants.regexEmail.matcher(emailNew).find();
            if (check) {
                user.setEmail(emailNew);
            } else {
                System.out.println("Invalid email address, please re-enter.");
            }
        } while (!check);

        System.out.println("Enter address:  ");
        String addressNew = scanner.nextLine();
        user.setAddress(addressNew);

        System.out.println("Enter name: ");
        String nameNew = scanner.nextLine();
        user.setName(nameNew);

        do {
            System.out.println("Enter phone number: ");
            String phoneNew = scanner.nextLine();
            check = Constants.regexPhone.matcher(phoneNew).find();
            if (check) {
                user.setPhoneNumber(phoneNew);
            } else {
                System.out.println("Invalid phone number, please re-enter.");
            }
        } while (!check);

        String permissionNew = "customer";
        user.setPermission(permissionNew);

        System.out.println("Enter date of birth: ");
        String dateNew = scanner.nextLine();
        user.setDateOfBirth(dateNew);
        users.add(user);
        users1.add(user);
        userController.writeUsersToFile(users, Constants.USER_FILE);
        userController.writeUsersToFile(users1, Constants.USER_CUR_FILE);
        System.out.println("Account successfully created\n");
        whatUserDo();
    }

    public static void forgotPassword() throws IOException {
        List<User> users = userController.readUsersFromFile(Constants.USER_FILE);
        scanner.nextLine();
        System.out.println("Enter your user: ");
        String userName = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        int value = 0;
        boolean ok = false;
        String pass = "";
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNameUser().compareTo(userName) == 0 && users.get(i).getEmail().compareTo(email) == 0) {
                pass = users.get(i).getPassword();
                Random generator = new Random();
                value = generator.nextInt((999999 - 100000) + 1) + 100000;
                System.out.println("Password reset code is: " + value);
                ok = true;
                break;
            }
        }
        if (ok == true) {
            System.out.println("Enter the confirmation code: ");
            int ma = scanner.nextInt();
            if (ma == value && value != 0) {
                System.out.println("Your password is: " + pass);
            } else {
                System.out.println("Your verification code is incorrect.");
            }
        } else {
            System.out.println("Your username and email are incorrect.");
        }
    }

    public static void logIn() throws IOException {
        String userNameInput;
        String passwordInput;
        scanner.nextLine();
        System.out.println("Enter your user: ");
        userNameInput = scanner.nextLine();
        System.out.println("Enter your password: ");
        passwordInput = scanner.nextLine();
        List<User> users = userController.readUsersFromFile(Constants.USER_FILE);
        boolean ok = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNameUser().compareTo(userNameInput) == 0 && users.get(i).getPassword().compareTo(passwordInput) == 0) {
                ok = true;
                cur_user = users.get(i);
                System.out.println("Successful login. You are " + users.get(i).getPermission());

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
            System.out.println("Your account is incorrect. Please re-enter: ");
            logIn();
        }

    }


    private static void whatAdminDo() throws IOException {
        // menu

        int x;
        do {
            System.out.println("Jobs you can do : ");
            System.out.println("1. See the store's products.");
            System.out.println("2. View customer information.");
            System.out.println("3. View all bills.");
            System.out.println("4. Sort products in ascending order by price.");
            System.out.println("5. Search product.");
            System.out.println("6. Add products to the store.");
            System.out.println("7. Repair the price of the product.");
            System.out.println("8. Delete product from store.");
            System.out.println("9. Change personal information.");
            System.out.println("10. Edit other people's rights.");
            System.out.println("11. See the store's sales.");
            System.out.println("12. Logout.");
            System.out.println("0. Exit");
            System.out.println("\nEnter your selection: ");
            x = scanner.nextInt();
            List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);

            List<User> users = userController.readUsersFromFile(Constants.USER_FILE);

            List<Bill> bills = billController.readBillFromFile(Constants.BILL_FILE);

            switch (x) {
                case 1:
                    clotherStoreController.viewProduct(clothes);
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 2:

                    userController.viewUser(users);
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 3:

                    billController.viewAllBill(bills);
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 4:

                    clotherStoreController.sortProductWithPrice(clothes);
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 5:
                    clotherStoreController.findProduct();
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 6:
                    clotherStoreController.addProduct();
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 7:
                    clotherStoreController.repairPriceofProduct(clothes);
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 8:
                    clotherStoreController.deleteProduct();
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 9:
                    userController.repairInfor();
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 10:
                    userController.repairPermission(users);
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 11:
                    billController.viewTurnover(bills);
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

                case 12:
                    userController.logout();
                    System.out.println();
                    System.out.println("<====================================>");
                    System.out.println();
                    break;

            }
        } while (x != 12 && x != 0);
    }


    private static void whatUserDo() throws IOException {

        int x;
        do {
            System.out.println("Jobs you can do : ");
            System.out.println("1. See the store's products.");
            System.out.println("2. Sort products in ascending order by price.");
            System.out.println("3. Search product.");
            System.out.println("4. Buy.");
            System.out.println("5. See the bill.");
            System.out.println("6. Product quality assessment.");
            System.out.println("7. Change personal information.");
            System.out.println("8. Logout.");
            System.out.println("0. Exit");
            System.out.println("\nEnter your selection: ");
            x = scanner.nextInt();

            List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
            List<Bill> bills = billController.readBillFromFile(Constants.BILL_FILE);
            switch (x) {
                case 1:
                    clotherStoreController.viewProduct(clothes);
                    System.out.println("<====================================>");
                    break;
                case 2:
                    clotherStoreController.sortProductWithPrice(clothes);
                    System.out.println("<====================================>");
                    break;
                case 3:
                    clotherStoreController.findProduct();
                    System.out.println("<====================================>");
                    break;
                case 4:
                    billController.buyProduct();
                    System.out.println("<====================================>");
                    break;
                case 5:
                    billController.viewBill(bills);
                    System.out.println("<====================================>");
                    break;
                case 6:
                    billController.qualityEvalution(bills);
                    System.out.println("<====================================>");
                    break;
                case 7:
                    userController.repairInfor();
                    System.out.println("<====================================>");
                    break;
                case 8:
                    userController.logout();
                    System.out.println("<====================================>");
            }

        }while (x != 8 && x != 0) ;
    }
}





