package view;

import controller.BillController;
import controller.ClotherStoreController;
import controller.TypesOfClothController;
import controller.UserController;
import model.Bill;
import model.Clothes;
import model.TypesOfCloth;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {

    public static void main(String[] args) throws IOException {

        UserController userController = new UserController();

        List<User> users = new ArrayList<>();
//
//        users.add(new User(1, "lamlinh1001", "lamlinh1001", "lamlinh1001@gmail.com", "duong so 1", "lamlinh1", "011111111111", "admin", "11/5/2002"));
//        users.add(new User(2, "lamlinh1002", "lamlinh1002", "lamlinh1002@gmail.com", "duong so 2", "lamlinh2", "022222222222", "customer", "12/5/2002"));
//        users.add(new User(3, "lamlinh1003", "lamlinh1003", "lamlinh1003@gmail.com", "duong so 3", "lamlinh3", "033333333333", "customer", "13/5/2002"));
//        users.add(new User(4, "lamlinh1004", "lamlinh1004", "lamlinh1004@gmail.com", "duong so 4", "lamlinh4", "044444444444", "customer", "14/5/2002"));
//        users.add(new User(5, "lamlinh1005", "lamlinh1005", "lamlinh1005@gmail.com", "duong so 5", "lamlinh5", "055555555555", "customer", "15/5/2002"));
//        users.add(new User(6, "lamlinh1006", "lamlinh1006", "lamlinh1006@gmail.com", "duong so 6", "lamlinh6", "066666666666", "customer", "16/5/2002"));
//        users.add(new User(7, "lamlinh1007", "lamlinh1007", "lamlinh1007@gmail.com", "duong so 7", "lamlinh7", "077777777777", "customer", "17/5/2002"));
//
//        userController.writeUsersToFile(users, "Users.DAT");
//


        ClotherStoreController clotherStoreController = new ClotherStoreController();

        List<Clothes> clothes = new ArrayList<>();
//
//        clothes.add(new Clothes(1, "vay hoa nhi", 1, "mau do", "size s", 110000, "nhung dui", 100));
//        clothes.add(new Clothes(2, "vay hoa nhi", 1, "mau cam", "size s", 110000, "nhung dui", 100));
//        clothes.add(new Clothes(3, "vay hoa nhi", 1, "mau do", "size s", 120000, "nhung dui", 200));
//        clothes.add(new Clothes(4, "vay hoa nhi", 1, "mau do", "size m", 120000, "nhung dui", 200));
//        clothes.add(new Clothes(5, "vay hoa nhi", 1, "mau hong", "size s", 120000, "nhung dui", 300));
//        clothes.add(new Clothes(5, "quan jean", 1, "mau xanh", "size s", 120000, "jean", 300));
//        clothes.add(new Clothes(5, "quan jean", 1, "mau den", "size s", 120000, "jean", 300));
//        clothes.add(new Clothes(5, "ao khoac", 3, "mau be", "size m", 120000, "bong", 300));
//
      clotherStoreController.writeClothesStoreToFile(clothes, "ClothersStore.DAT");


        TypesOfClothController typesOfClothController = new TypesOfClothController();

        List<TypesOfCloth> typesOfCloths = new ArrayList<>();
//
//        typesOfCloths.add(new TypesOfCloth(1, "Vay"));
//        typesOfCloths.add(new TypesOfCloth(2, "Quan"));
//        typesOfCloths.add(new TypesOfCloth(3, "Ao khoac"));
//
         typesOfClothController.writeTypesOfClothToFile(typesOfCloths, "TypesOfCloth.DAT");


        BillController billController = new BillController();
        List<Bill> bills = new ArrayList<>();

        billController.writeBillToFile( bills, "Bill.DAT");

        LogIn(userController, typesOfClothController, clotherStoreController, billController);
    }

    public static void LogIn(UserController userController, TypesOfClothController typesOfClothController, ClotherStoreController clotherStoreController, BillController billController) throws IOException {
        String userNameInput;
        String passwordInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui long nhap username cua ban: ");
        userNameInput = scanner.nextLine();
        System.out.println("Vui long nhap password cua ban: ");
        passwordInput = scanner.nextLine();
        for (int i=0; i<userController.readUsersFromFile("Users.DAT").size(); i++){
            if (userNameInput.equals(userController.readUsersFromFile("Users.DAT").get(i).getNameUser()) && passwordInput.equals(userController.readUsersFromFile("Users.DAT").get(i).getPassword())){
                System.out.println( "Ban la " + userController.readUsersFromFile("Users.DAT").get(i).getPassword());
            }
        }
    }
}
