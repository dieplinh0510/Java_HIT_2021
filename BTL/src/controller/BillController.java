package controller;

import common.Constants;
import model.Bill;
import model.Clothes;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillController {
    private  Bill bill= new Bill();
    private  FileController fileController = new FileController();

    public BillController() {

    }

    public BillController(Bill bill, FileController fileController) {
        this.bill = bill;
        this.fileController = fileController;
    }
    public  List<Bill> readBillFromFile(String filename) throws IOException {
        fileController.OpenFileToRead(filename);
        List<Bill>  bills = new ArrayList<>();
        ClotherStoreController clotherStoreController = new ClotherStoreController();
        while(fileController.scanner.hasNext()) {
            String data = fileController.scanner.nextLine();
            String[] a = data.split("\\|");
            ArrayList<Clothes> clothes = new ArrayList<>();
            for (int i=2; i<a.length-2; i++){
                clothes.add(clotherStoreController.getClotherBuyId(Integer.parseInt(a[i])));
            }
            bills.add(new Bill(Integer.parseInt(a[0]), Integer.parseInt(a[1]), clothes, Double.parseDouble(a[a.length-2])));
        }

        fileController.CloseFileAfterRead(filename);

        return bills;
    }
    public  Double getTurnover() throws IOException {
        fileController.OpenFileToRead(Constants.BILL_FILE);
        Double sum=0.0;
        while (fileController.scanner.hasNext()){
            String data = fileController.scanner.nextLine();
            String[] datas = data.split("\\|");
            sum += Double.parseDouble(datas[datas.length-1]);
        }

        fileController.CloseFileAfterRead(Constants.BILL_FILE);
        return sum;
    }
    public  Integer getTotalClothes() throws IOException {
        List<Bill> bills = readBillFromFile(Constants.BILL_FILE);
        int sum = bills.stream().mapToInt(item -> item.getClothes().size()).sum();
        return sum;
    }


    public  void writeBillToFile(List<Bill> bills, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        Double thanhtien = 0.0;
        for(Bill bill : bills) {
            String s = "";
            for (int j = 0; j<bill.getClothes().size(); j++){
                s+=bill.getClothes().get(j).getId() + "|";
                thanhtien+=bill.getClothes().get(j).getPrice();
            }
            fileController.getPrintWriter().println(bill.getIdBill() + "|" + bill.getIdUser() + "|" + s +
                    bill.getDiscount() + "|" + thanhtien);
        }

        fileController.CloseFileAfterWrite();
    }

    public  void viewAllBill(List<Bill> bills) {
        System.out.println("Information of store bills: ");
        for (int i = 0; i < bills.size(); i++) {
            bills.get(i).display();
        }
    }

    public  void viewTurnover(List<Bill> bills) throws IOException {

        System.out.println("Number of products sold: " + getTotalClothes());

        System.out.println("Total revenue: " + getTurnover());


    }

    public  void buyProduct() throws IOException {
        ClotherStoreController clotherStoreController = new ClotherStoreController();
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Other store products: ");
        List<Clothes> clothes= clotherStoreController.readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
        List<User> user_curs = userController.readUsersFromFile(Constants.USER_CUR_FILE);
        User cur_user = user_curs.get(0);
        clotherStoreController.viewProduct(clothes);
        List<Clothes> clothesBuy = new ArrayList<>();
        Clothes clothes1;
        int idProductBuy;

        do {
            System.out.println("Enter the product id you want to buy(-1 is exit) "); idProductBuy = scanner.nextInt();
            System.out.println("Enter the number of products you want to buy: "); int quanlityProductBuy = scanner.nextInt();
            for (int i=0; i<clothes.size(); i++){
                if (idProductBuy == clothes.get(i).getId()){
                    if (quanlityProductBuy<=clothes.get(i).getQuantily() && quanlityProductBuy>0){
                        clothes.get(i).setQuantily(clothes.get(i).getQuantily()-quanlityProductBuy);
                        clothes1 = clothes.get(i);
                        for (int j=0; j<quanlityProductBuy; j++){

                            clothesBuy.add(clothes1);
                        }
                        clotherStoreController.writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);
                    } else {
                        System.out.println("The product in stock does not have the quantity you want to buy.");
                    }
                    break;
                }
            }
        } while (idProductBuy!=-1);

        List<Bill> bills = readBillFromFile(Constants.BILL_FILE);
        Bill bill = new Bill(
                bills.size()+1,
                cur_user.getIdUser(),
                clothesBuy,
                userController.isBirthday(cur_user) ? Constants.DISCOUNT_BIRTHDAY : 0
        );
        System.out.println(userController.isBirthday(cur_user));

        bills.add(bill);

        bill.display();

        writeBillToFile(bills, Constants.BILL_FILE);


    }

    public  void viewBill(List<Bill> bills) throws IOException {
        UserController userController = new UserController();
        List<User> user_curs = userController.readUsersFromFile(Constants.USER_CUR_FILE);
        User cur_user = user_curs.get(0);
        System.out.println("Bill information: ");
        for (int i=0; i<bills.size(); i++){
            if (cur_user.getIdUser() == bills.get(i).getIdUser()){
                bills.get(i).display();
            }
        }
    }

    public  void qualityEvalution(List<Bill> bills) throws IOException {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        List<User> user_curs = userController.readUsersFromFile(Constants.USER_CUR_FILE);
        User cur_user = user_curs.get(0);
        boolean ok = false;
        for (int i=0; i<bills.size(); i++){
            if (cur_user.getIdUser()==bills.get(i).getIdUser()){
                System.out.println("Your rating of the store's product: ");
                String  evaluate = scanner.nextLine();
                System.out.println("Thank you for purchasing products in our store.");
                ok = true; break;
            }
        }
        if (!ok){
            System.out.println("You have not purchased our product so you cannot rate it.");
        }
    }
}
