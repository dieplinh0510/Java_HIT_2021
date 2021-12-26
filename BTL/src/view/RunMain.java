package view;

import common.Constants;
import controller.*;
import model.Bill;
import model.Clothes;
import model.TypesOfCloth;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    private static User cur_user = null;
    private static ClotherStoreController clotherStoreController = new ClotherStoreController();
    private static BillController billController = new BillController();
    private static UserController userController = new UserController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        UserController userController = new UserController();

        List<User> users = userController.readUsersFromFile(Constants.USER_FILE);
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

        List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);

//        clothes.add(new Clothes(1, "vay hoa nhi", 1, "mau do", "size s", 110000, "nhung dui", 100));
//        clothes.add(new Clothes(2, "vay hoa nhi", 1, "mau cam", "size s", 110000, "nhung dui", 100));
//        clothes.add(new Clothes(3, "vay hoa nhi", 1, "mau do", "size s", 120000, "nhung dui", 200));
//        clothes.add(new Clothes(4, "vay hoa nhi", 1, "mau do", "size m", 120000, "nhung dui", 200));
//        clothes.add(new Clothes(5, "vay hoa nhi", 1, "mau hong", "size s", 120000, "nhung dui", 300));
//        clothes.add(new Clothes(6, "quan jean", 1, "mau xanh", "size s", 120000, "jean", 300));
//        clothes.add(new Clothes(7, "quan jean", 1, "mau den", "size s", 120000, "jean", 300));
//        clothes.add(new Clothes(8, "ao khoac", 3, "mau be", "size m", 120000, "bong", 300));
//
//      clotherStoreController.writeClothesStoreToFile(clothes, "ClothersStore.DAT");


        TypesOfClothController typesOfClothController = new TypesOfClothController();

        List<TypesOfCloth> typesOfCloths = new ArrayList<>();
//
//        typesOfCloths.add(new TypesOfCloth(1, "Vay"));
//        typesOfCloths.add(new TypesOfCloth(2, "Quan"));
//        typesOfCloths.add(new TypesOfCloth(3, "Ao khoac"));
//
//         typesOfClothController.writeTypesOfClothToFile(typesOfCloths, "TypesOfCloth.DAT");


        BillController billController = new BillController();
        List<Bill> bills = new ArrayList<>();

//        billController.writeBillToFile( bills, "Bill.DAT");

        CheckLogIn();
    }

    public  static void CheckLogIn() throws IOException {
        List <User> users = userController.readUsersFromFile(Constants.USER_CUR_FILE);
        if(users.isEmpty()){
            LogIn(users);
        }else {
            if (cur_user.getPermission().compareTo("admin")==0){
                whatAdminDo();
            } else {
                whatUserDo();
            }
        }
    }

    public static void LogIn(List<User> users) throws IOException {
        String userNameInput;
        String passwordInput;

        System.out.println("Vui long nhap username cua ban: ");
        userNameInput = scanner.nextLine();
        System.out.println("Vui long nhap password cua ban: ");
        passwordInput = scanner.nextLine();

        boolean ok = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNameUser().compareTo(userNameInput) == 0 && users.get(i).getPassword().compareTo(passwordInput) == 0) {
                ok = true;
                cur_user = users.get(i);
                System.out.println("Ban da dang nhap thanh cong. Ban la " + users.get(i).getPermission());

                List <User> user_cur = new ArrayList<>();
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
            LogIn(users);
        }

    }


    private static void whatAdminDo() throws IOException {
        // menu
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
        int x;
        do{

            System.out.println("Moi nhap lua chon cua ban: ");
            x = scanner.nextInt();
            List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);

            List<User> users = userController.readUsersFromFile(Constants.USER_FILE);

            List<Bill> bills = billController.readBillFromFile(Constants.BILL_FILE);
            switch (x) {
                case 1:

                    viewProduct(clothes);
                    System.out.println("<===========>");
                    break;

                case 2:

                    viewUser(users);
                    System.out.println("<===========>");
                    break;

                case 3:

                    viewAllBill(bills);
                    System.out.println("<===========>");
                    break;

                case 4:

                    sortProductWithPrice(clothes);
                    System.out.println("<===========>");
                    break;

                case 5:
                    findProduct();
                    System.out.println("<===========>");
                    break;

                case 6:
                    addProduct(clothes);
                    System.out.println("<===========>");
                    break;

                case 7:
                    repairPriceofProduct(clothes);
                    System.out.println("<===========>");
                    break;

                case 8:
                    deleteProduct(clothes);
                    System.out.println("<===========>");
                    break;

                case 9:
                    repairInfor();
                    System.out.println("<===========>");
                    break;

                case 10:
                    repairPermission(users);
                    System.out.println("<===========>");
                    break;

                case 11:
                    viewTurnover(bills);
                    System.out.println("<===========>");
                    break;

                case 12:
                    logout();
                    System.out.println("<===========>");
                    break;

                default:
                    System.out.println("Khong co lua chon nay");
                    System.out.println("<===========>");
                    break;
            }
        } while (x!=0);
    }




    // case 1: xem tat ca san pham
    private static void viewProduct(List<Clothes> clothes) {
        System.out.println("Thong tin cac san pham cua cua hang: ");
        for (int i = 0; i < clothes.size(); i++) {
            System.out.println(clothes.get(i));
        }
    }

    // case 2: xem tat ca user (k xem duoc password)
    private static void viewUser(List<User> users) {
        System.out.println("Thong tin cac nguoi dung cua cua hang: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    // case 3: xem tat ca cac hoa don
    private static void viewAllBill(List<Bill> bills) {
        System.out.println("Thong tin cac hoa don cua cua hang: ");
        for (int i = 0; i < bills.size(); i++) {
            System.out.println(bills.get(i));
        }
    }

    // case 4: sap xep san pham theo gia
    private static void sortProductWithPrice(List<Clothes> clothes1) {
        System.out.println("San pham sau khi da sap xep theo gia tien: ");
        for (int i = 0; i < clothes1.size(); i++) {
            for (int j = i + 1; i < clothes1.size(); i++) {
                if (clothes1.get(i).getPrice() > clothes1.get(j).getPrice()) {
                    Clothes temp = clothes1.get(i);
                    clothes1.set(i, clothes1.get(j));
                    clothes1.set(j, temp);
                }
            }
        }
        viewProduct(clothes1);
    }

    // case 5: tim san pham
    private static void findProduct() throws IOException {
        System.out.println("Ban muon tim kiem theo: ");
        System.out.println("1. Tim kiem theo ten cua san pham.");
        System.out.println("2. Tim kiem theo mau cua san pham.");
        System.out.println("3. Tim kiem theo gia tien cua san pham.");

        System.out.println("Moi nhap lua chon cua ban: ");
        int y;
        y = scanner.nextInt();
        List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
        switch (y) {
            case 1:
                findNameProduct(clothes);
                break;
            case 2:
                findColorProduct(clothes);
                break;
            case 3:
                findPriceProduct(clothes);
                break;
        }
    }

    // case 5.1: tim san pham bang ten
    private static void findNameProduct(List<Clothes> clothes) {

        System.out.println("Nhap ten san pham can tim");
        String nameInput;
        nameInput = scanner.nextLine();
        System.out.println("Cac san pham co ten can tim: ");
        for (int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i).getName().compareTo(nameInput) == 0) {
                System.out.println(clothes.get(i));
            }
        }

    }

    // case 5.2: tim san pham bang mau sac
    private static void findColorProduct(List<Clothes> clothes) {

        String color;
        System.out.println("Nhap mau san pham can tim: ");
        color = scanner.nextLine();
        System.out.println("Cac san pham co mau " + color + " : ");
        for (int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i).getColor().compareTo(color) == 0) {
                System.out.println(clothes.get(i));
            }
        }
    }

    // case 5.3: tim san pham bang gia
    private static void findPriceProduct(List<Clothes> clothes) {

        int price;
        System.out.println("Nhap gia san pham can tim: ");
        price = scanner.nextInt();
        System.out.println("Cac san pham co gia " + price + ": ");
        for (int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i).getPrice() == price) {
                System.out.println(clothes.get(i));
            }
        }
    }

    // case 6: them san pham vao kho hang
    private static void addProduct(List<Clothes> clothes) throws IOException {
        List<Clothes> clothes2 = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);

        int n;
        System.out.println("Nhap so san pham can them: "); n = scanner.nextInt();
        int id, idType, price, quanlity;
        String name, color, size, material;
        boolean ok=true;
        for (int i=0; i<n; i++){
            System.out.println("Nhap ma cua san pham can them: "); id= scanner.nextInt();
            for (int j=0; j<clothes.size(); j++){
                if (id==clothes.get(i).getId()) ok=false; break;
            }
            if (ok){
                scanner.nextLine();
                System.out.println("Nhap ten cua san pham can them: "); name =scanner.nextLine();
                System.out.println("Nhap loai ma cua san pham can them: "); idType = scanner.nextInt();
                System.out.println("Nhap mau sac cua san pham can them : "); color = scanner.nextLine(); scanner.nextLine();
                System.out.println("Nhap size cua san pham can them: "); size = scanner.nextLine();
                System.out.println("Nhap gia cua san pham can them: "); price = scanner.nextInt(); scanner.nextLine();
                System.out.println("Nhap chat lieu cua san pham can them: "); material = scanner.nextLine();
                System.out.println("Nhap so luong cua san pham can them: "); quanlity = scanner.nextInt();
                clothes.add(new Clothes(id, name, idType, color, size, price, material, quanlity));
                clotherStoreController.writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);
            } else {
                System.out.println("Ma san pham ban muon them da trung voi ma san pham trong gio hang.");
                addProduct(clothes);
            }

        }




    }
// case 7: sua gia cua san pham
    private static void repairPriceofProduct(List <Clothes> clothes) throws IOException {

        System.out.println("Nhap so san pham can sua gia: "); int n = scanner.nextInt();
        for (int j=0; j<n; j++){
            boolean ok=false;
            int idRepair;
            System.out.println("Nhap ma san pham can sua gia: ");
            idRepair = scanner.nextInt();
            for (int i=0; i<clothes.size(); i++){
                if (idRepair ==clothes.get(i).getId()) ok = true; break;
            }
            if (ok){
                System.out.println("Nhap gia sau khi sua cua san pham: ");
                int priceRepair = scanner.nextInt();
                for (int i=0; i<clothes.size(); i++){
                    if (clothes.get(i).getId()==idRepair){
                        clothes.get(i).setPrice(priceRepair);
                        clotherStoreController.writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);
                    }
                }
            } else {
                System.out.println("Ma san pham can sua gia khong khop voi ma san pham trong cua hang.");
                repairPriceofProduct(clothes);
            }

        }
    }
// case 8: xoa san pham
    private static void deleteProduct(List <Clothes> clothes) throws IOException {
        List<Clothes> clothes2 = clotherStoreController.writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);

        System.out.println("Nhap so san pham can xoa: "); int n = scanner.nextInt();
        for (int j=0; j<n; j++){
            System.out.println("Nhap ma san pham can xoa: "); int idDele = scanner.nextInt();
            for (int i=0; i<clothes.size(); i++){
                    clothes.set(i, null);
                }
            }
        }

// case 9: thay doi thong tin nguoi dung
    private static void repairInfor() throws IOException {

        System.out.println("Ban muon thay doi: ");
        System.out.println("1. Thay doi mat khau. ");
        System.out.println("2. Thay doi email. ");
        System.out.println("3. Thay doi dia chi nhan hang. ");
        System.out.println("4. Thay doi ten nguoi nhan hang. ");
        System.out.println("5. Thay doi so dien thoai nguoi nhan hang.");
        System.out.println("Nhap lua chon cua ban: "); int n = scanner.nextInt();
        List<User> user_cur = userController.readUsersFromFile(Constants.USER_CUR_FILE);
        switch (n){
            case 1: repairPassword(user_cur); break;
            case 2: repairEmail(user_cur); break;
            case 3: repairAddress(user_cur); break;
            case 4: repairName(user_cur); break;
            case 5: repairPhone(user_cur); break;
        }
    }
//case 9.1: thay doi mat khau
    private static void repairPassword(List <User> user_cur) throws IOException {
        List<User> user = userController.readUsersFromFile(Constants.USER_CUR_FILE);

        System.out.println("Nhap mat khau cu: ");
        String  passwordOld = scanner.nextLine();

        if (user.get(0).getPassword().compareTo(passwordOld)==0){
            System.out.println("Nhap mat khau moi: "); String passwordNew = scanner.nextLine();
            user.get(0).setPassword(passwordNew);
            userController.writeUsersToFile(user, Constants.USER_CUR_FILE);

            // mo file users.dat de thay doi mat khau
            List<User> users1 = userController.readUsersFromFile(Constants.USER_FILE);
            for (int i=0; i<users1.size(); i++){
                if (users1.get(i).getIdUser()==user.get(0).getIdUser()){
                    users1.get(i).setPassword(user.get(0).getPassword());
                    userController.writeUsersToFile(users1, Constants.USER_FILE);
                }
            }

            System.out.println("Thay doi mat khau thanh cong.");
        } else System.out.println("Mat khau khong dung. Moi ban nhap lai lua chon.");
    }

    //case 9.2: thay doi email
    private static void repairEmail(List<User> users) throws IOException {


            System.out.println("Nhap email moi: "); String emailNew = scanner.nextLine();
            users.get(0).setPassword(emailNew);
            userController.writeUsersToFile(users, Constants.USER_CUR_FILE);

            // mo file users.dat de thay doi email
            List<User> users1 = userController.readUsersFromFile(Constants.USER_FILE);
            for (int i=0; i<users1.size(); i++){
                if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                    users1.get(i).setEmail(users.get(0).getEmail());
                    userController.writeUsersToFile(users1, Constants.USER_FILE);
                }
            }

            System.out.println("Thay doi email thanh cong.");

    }
// case 9.3 : thay doi dia chi
    private static void repairAddress(List<User> users) throws IOException {

        Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap dia chi moi: "); String addressNew = scanner.nextLine();
            users.get(0).setAddress(addressNew);
            userController.writeUsersToFile(users, Constants.USER_CUR_FILE);

            // mo file users.dat de thay doi email
            List<User> users1 = userController.readUsersFromFile(Constants.USER_FILE);
            for (int i=0; i<users1.size(); i++){
                if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                    users1.get(i).setAddress(users.get(0).getAddress());
                    userController.writeUsersToFile(users1, Constants.USER_FILE);
                }
            }

            System.out.println("Thay doi dia chi thanh cong.");
    }

    // case 9.4: thay soi ten nguoi dung
    private static void repairName(List<User> users) throws IOException {


            System.out.println("Nhap ten moi: "); String nameNew = scanner.nextLine();
            users.get(0).setName(nameNew);
            userController.writeUsersToFile(users, Constants.USER_CUR_FILE);

            // mo file users.dat de thay doi ten
            List<User> users1 = userController.readUsersFromFile(Constants.USER_FILE);
            for (int i=0; i<users1.size(); i++){
                if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                    users1.get(i).setName(users.get(0).getName());
                    userController.writeUsersToFile(users1, Constants.USER_FILE);
                }
            }

            System.out.println("Thay doi ten thanh cong.");
    }

    // case 9.5: thay soi so dien thoai
    private static void repairPhone(List<User> users) throws IOException {

        Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap so dien thoai moi: "); String phoneNew = scanner.nextLine();
            users.get(0).setPassword(phoneNew);
            userController.writeUsersToFile(users, Constants.USER_CUR_FILE);

            // mo file users.dat de thay doi mat khau
            List<User> users1 = userController.readUsersFromFile(Constants.USER_FILE);
            for (int i=0; i<users1.size(); i++){
                if (users1.get(i).getIdUser()==users.get(0).getIdUser()){
                    users1.get(i).setPhoneNumber(users.get(0).getPhoneNumber());
                    userController.writeUsersToFile(users1, Constants.USER_FILE);
                }
            }

            System.out.println("Thay doi so dien thoai thanh cong.");
    }

    // case 10: thay doi quyen cua nguoi khac
    private static void repairPermission(List<User> users) throws IOException {

        List<User> users1 = userController.readUsersFromFile(Constants.USER_FILE);

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
                userController.writeUsersToFile(users, Constants.USER_FILE);
            }
        }
        if (ok) System.out.println("Thay doi quyen thanh cong.");
        else System.out.println("Ma nguoi ban muon chinh sua khong dung. Moi nhap lai lua chon.");
    }

//case 11: xem doanh thu cua hang
    private static void viewTurnover(List<Bill> bills) {
        int productBuy = 0;
        int monneyBuy = 0;
        for (int i=0; i<bills.size(); i++){
            int monney = 0;
            for (int j=0; j<bills.get(i).getClothes().size(); j++){
                productBuy +=bills.get(i).getClothes().get(j).getQuantily();
                monney+= bills.get(i).getClothes().get(j).getQuantily()*bills.get(i).getClothes().get(j).getPrice();
            }
            monneyBuy+=monney*(1-bills.get(i).getDiscount());
        }
        System.out.println("So san pham da ban: " + productBuy);

        System.out.println("Tong tien ban duoc: " + monneyBuy);


    }

// case 12: dang xuat
    private static void logout() throws IOException {

        FileWriter fileWriter = new FileWriter(Constants.USER_CUR_FILE, false);
        cur_user = null;
        System.out.println("Ban da dang xuat thanh cong.");
    }


        private static void whatUserDo () throws IOException {
            // menu
            System.out.println("1. Xem cac san pham cua cua hang");
            System.out.println("2. Sap xep san pham tang dan theo gia tien");
            System.out.println("3. Tim kiem san pham");
            System.out.println("4. Mua hang");
            System.out.println("5. Xem hoa don");
            System.out.println("6. Danh gia chat luong san pham");
            System.out.println("7. Thay doi thong tin ca nhan");
            System.out.println("8. Dang xuat");
            System.out.println("0. Thoat");

            int x;
            do{
                System.out.println("Moi nhap lua chon cua ban: ");
                x = scanner.nextInt();

                List<Clothes> clothes = clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
                List<Bill> bills = billController.readBillFromFile(Constants.BILL_FILE);
                switch (x) {
                    case 1:
                        viewProduct(clothes);
                        System.out.println("<===========>");
                        break;
                    case 2:
                        sortProductWithPrice(clothes);
                        System.out.println("<===========>");
                        break;
                    case 3:
                        findProduct();
                        System.out.println("<===========>");
                        break;
                    case 4:
                        buyProduct();
                        System.out.println("<===========>");
                        break;
                    case 5:
                        viewBill(bills);
                        System.out.println("<===========>");
                        break;
                    case 6:
                        qualityEvalution(bills);
                        System.out.println("<===========>");
                        break;
                    case 7:
                        repairInfor();
                        System.out.println("<===========>");
                        break;
                    case 8:
                        logout();
                        System.out.println("<===========>");
                    default:
                        System.out.println("Khong co lua chon nay");
                        System.out.println("<===========>");
                        break;
                }
            } while (x!=0);
        }


// case 4: mua san pham
    private static void buyProduct() throws IOException {
        System.out.println("Cac san pham cua hang con: ");
        List<Clothes> clothes= clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
        viewProduct(clothes);

        List<Clothes> clothesBuy = new ArrayList<>();
        Clothes clothes1= new Clothes();
        int idProductBuy;
        do {
            System.out.println("Nhap ma san pham ban muon mua (-1 la thoat): "); idProductBuy = scanner.nextInt();
            System.out.println("Nhap so luong san pham ban muon mua: "); int quanlityProductBuy = scanner.nextInt();
            for (int i=0; i<clothes.size(); i++){
                if (idProductBuy == clothes.get(i).getId()){
                    if (quanlityProductBuy<=clothes.get(i).getQuantily()){
                        clothes1 = clothes.get(i);
                        clothes.get(i).setQuantily(clothes1.getQuantily()-quanlityProductBuy);
                        clothes1.setQuantily(quanlityProductBuy);
                        clothesBuy.add(clothes1);

                        clotherStoreController.writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);
                    } else {
                        System.out.println("San pham trong kho khong du so luong ban muon.");
                    }
                    break;
                }
            }
        } while (idProductBuy!=-1);

        List<Bill> bills = billController.readBillFromFile(Constants.BILL_FILE);
        Bill bill = new Bill(
                bills.get(bills.size()-1).getIdBill()+1,
                cur_user.getIdUser(),
                clothesBuy,
                userController.isBirthday(cur_user) ? 0 : Constants.DISCOUNT_BIRTHDAY
        );

        bills.add(bill);
        billController.writeBillToFile(bills, Constants.BILL_FILE);
    }


    // case 5: xem hoa don
    private static void viewBill(List<Bill> bills) {
        System.out.println("Thong tin hoa don: ");
        for (int i=0; i<bills.size(); i++){
            if (cur_user.getIdUser() == bills.get(i).getIdUser()){
                System.out.println(bills.get(i));
            }
        }
    }


    // case 6: danh gia chat luong san pham
    private static void qualityEvalution(List<Bill> bills) {
        boolean ok = false;
        for (int i=0; i<bills.size(); i++){
            if (cur_user.getIdUser()==bills.get(i).getIdUser()){
                System.out.println("Danh gia cua ban ve san pham cua cua hang: ");
                String  evaluate = scanner.nextLine();
                System.out.println("Cam on ban da mua san pham o cua hang cua chung toi.");
                ok = true; break;
            }
        }
        if (!ok){
            System.out.println("Ban chua mua san pham cua chung toi, nen ban khong the danh gia san pham nay.");
        }
    }
}
