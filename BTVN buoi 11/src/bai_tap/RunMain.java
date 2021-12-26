package bai_tap;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {
    public static Scanner scanner = new Scanner(System.in);
    public static AccountController accountController = new AccountController();
    public static List<Account> accounts = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        List<Account> accounts = new ArrayList<>();
        menu();


    }

    public static void menu() throws IOException {
        System.out.println("Your options: ");
        System.out.println("1. Create new account.");
        System.out.println("2. Login to an existing account");
        System.out.println("3. Sort account by username");
        System.out.println("4. Exit");

        int x;
        System.out.println("Nhap lua chon cua ban: ");
        x = scanner.nextInt();
        switch (x){
            case 1: addNewAccount(); break;
            case 2: login(); break;
            case 3: sortByUserName(); break;
            case 4:
                System.out.println("Thoat vong lap.");
                break;
        }
    }

    private static void addNewAccount() throws IOException {

        Pattern regexUsername = Pattern.compile("^[a-zA-Z0-9]{6,}$");
        Pattern regexPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$");
        Pattern regexEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Pattern regexPhone = Pattern.compile("^[0-9\\-\\+]{9,15}$");

        boolean check;
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setId(accounts.size()+1);
        scanner.nextLine();
        System.out.println("Nhap full name: ");
        String  fullName = scanner.nextLine(); account.setFullName(fullName);

        do{
            System.out.println("Nhap user name: ");
            String username = scanner.nextLine();
            check = regexUsername.matcher(username).find();
            if (check){
                System.out.println("username cuar ban duoc chap nhan");
                account.setUseName(username);
            } else {
                System.out.println("username khong hop le. Nhap lai.");
            }
        } while (!check);

        do{
            System.out.println("Nhap password: ");
            String password = scanner.nextLine();
            check = regexPassword.matcher(password).find();
            if (check){
                System.out.println("password cuar ban duoc chap nhan");
                account.setPassword(password);
            } else {
                System.out.println("password khong hop le. Nhap lai.");
            }
        } while (!check);

        do{
            System.out.println("Nhap email: ");
            String email = scanner.nextLine();
            check = regexEmail.matcher(email).find();
            if (check){
                System.out.println("email cua ban duoc chap nhan");
                account.setEmail(email);
            } else {
                System.out.println("email khong hop le. Nhap lai.");
            }
        } while (!check);

        do{
            System.out.println("Nhap phone: ");
            String phone = scanner.nextLine();
            check = regexPhone.matcher(phone).find();
            if (check){
                System.out.println("phone cuar ban duoc chap nhan");
                account.setPhone(phone);
            } else {
                System.out.println("phone khong hop le. Nhap lai.");
            }
        } while (!check);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(date);
        account.setCreateAt(strDate);

        accounts.add(account);
        accountController.writeAccountToFile(accounts, "Account.DAT");



    }

    private static void login() throws IOException {
        System.out.println("Nhap user: ");
        String userName = scanner.nextLine();
        System.out.println("Nhap mat khau: ");
        String password = scanner.nextLine();
        accounts = accountController.readAccountFromFile("Account.DAT");
        for (int i=0; i<accounts.size();i++){
            if (accounts.get(i).getUseName().compareTo(userName)==0 && accounts.get(i).getPassword().compareTo(password)==0){
                System.out.println("Dang nhap thanh cong. Ban co 2 lua chon: ");
                System.out.println("1. Show Infor");
                System.out.println("2. Change password");
                System.out.println("3. Exit");
                System.out.println("Nhap lua chon cua ban: ");
                int choose = scanner.nextInt();
                switch (choose){
                    case 1:
                        accounts.get(i).toString(); break;
                    case 2:
                        System.out.println("Nhap password moi: ");
                        String passwordNew = scanner.nextLine();
                        accounts.get(i).setPassword(passwordNew);
                        accountController.writeAccountToFile(accounts,"Account.DAT");
                    case 3:
                        System.out.println("Thoat chuong trinh."); break;
                }


            }
        }
    }

    private static void sortByUserName() throws IOException {
        accounts = accountController.readAccountFromFile("Account.DAT");
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getUseName().compareTo(o2.getUseName());
            }
        });
        accountController.writeAccountToFile(accounts, "Account.DAT");
        accounts.forEach(account -> System.out.println(account));
    }


}
