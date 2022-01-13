package controller;

import common.Constants;
import model.Clothes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClotherStoreController {
    private  Clothes clothes = new Clothes();
    private  FileController fileController = new FileController();

    public ClotherStoreController() {

    }

    public ClotherStoreController(Clothes clothes, FileController fileController) {
        this.clothes = clothes;
        this.fileController = fileController;
    }
    public  List<Clothes> readClothesStoreFromFile(String filename) throws IOException {
        fileController.OpenFileToRead(filename);
        List<Clothes> clothes = new ArrayList<>();

        while(fileController.scanner.hasNext()) {
            String data = fileController.scanner.nextLine();
            String[] a = data.split("\\|");
            clothes.add(new Clothes(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), a[3], a[4],Integer.parseInt(a[5]), a[6], Integer.parseInt(a[7])));
        }

        fileController.CloseFileAfterRead(filename);

        return clothes;
    }

    public  List<Clothes> writeClothesStoreToFile(List<Clothes> clothes, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(Clothes clothe : clothes) {
            fileController.getPrintWriter().println(clothe.getId() + "|" + clothe.getName() + "|" + clothe.getIdTypeOfClother()+ "|" + clothe.getColor() + "|" + clothe.getSize()+ "|" + clothe.getPrice()+ "|" + clothe.getMaterial()+ "|"+ clothe.getQuantily());
        }

        fileController.CloseFileAfterWrite();
        return clothes;
    }


    public Clothes getClotherBuyId(int s) throws IOException {
        List <Clothes> clothes = readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
        for (int i=0; i<clothes.size(); i++){
            if (s==clothes.get(i).getId()){
                return clothes.get(i);
            }
        }
        return null;
    }

    public  void viewProduct(List<Clothes> clothes) {
        System.out.println("Thong tin cac san pham cua cua hang: ");
        for (int i = 0; i < clothes.size(); i++) {
            System.out.println(clothes.get(i));
        }
    }

    public  void sortProductWithPrice(List<Clothes> clothes1) {
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

    public  void findProduct() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int y;

        List<Clothes> clothes = readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
        do{
            System.out.println("Ban muon tim kiem theo: ");
            System.out.println("1. Tim kiem theo ten cua san pham.");
            System.out.println("2. Tim kiem theo mau cua san pham.");
            System.out.println("3. Tim kiem theo gia tien cua san pham.");
            System.out.println("0. Thoat.");
            System.out.println("Moi nhap lua chon cua ban: ");
            y = scanner.nextInt();
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
                default:
                    System.out.println("Khong co lua chon nay.");
                    break;

            }
        } while (y!=0);
    }

    public  void findNameProduct(List<Clothes> clothes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten san pham can tim: ");
        String nameInput;
        nameInput = scanner.nextLine();
        System.out.println("Cac san pham co ten can tim: ");
        for (int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i).getName().compareTo(nameInput) == 0) {
                System.out.println(clothes.get(i));
            }
        }

    }

    public  void findColorProduct(List<Clothes> clothes) {
        Scanner scanner = new Scanner(System.in);
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

    public  void findPriceProduct(List<Clothes> clothes) {
        Scanner scanner = new Scanner(System.in);
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

    public  void addProduct() throws IOException {
        List<Clothes> clothes = readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Nhap so san pham can them: "); n = scanner.nextInt();
        int id, idType, price, quanlity;
        String name, color, size, material;
        boolean ok=true;
        for (int i=0; i<n; i++){
            id= clothes.size()+1;
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
                writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);
            } else {
                System.out.println("Ma san pham ban muon them da trung voi ma san pham trong gio hang.");
                addProduct();
            }

        }
    }

    public  void repairPriceofProduct(List <Clothes> clothes) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so san pham can sua gia: "); int n = scanner.nextInt();
        for (int j=0; j<n; j++){
            boolean ok=true;
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
                        writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);
                    }
                }
            } else {
                System.out.println("Ma san pham can sua gia khong khop voi ma san pham trong cua hang.");
                repairPriceofProduct(clothes);
            }

        }
    }

    public  void deleteProduct() throws IOException {
        List<Clothes> clothes = readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
        List<Clothes> clothes1 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma san pham can xoa: "); int idDele = scanner.nextInt();
        for (int i=0; i<clothes.size(); i++){
            if (idDele != clothes.get(i).getId()){
                clothes1.add(clothes.get(i));

            }

        }

        writeClothesStoreToFile(clothes1, Constants.CLOTHES_STORE_FILE);

    }


}