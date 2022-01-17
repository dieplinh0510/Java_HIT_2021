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
        System.out.println("Information about products of the store: ");
        for (int i = 0; i < clothes.size(); i++) {
            clothes.get(i).display();
        }
    }

    public  void sortProductWithPrice(List<Clothes> clothes1) {
        System.out.println("Products after sorted by price: ");
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
            System.out.println("You want to search by: ");
            System.out.println("1. Search by product name.");
            System.out.println("2. Search by product color.");
            System.out.println("3. Search by product price.");
            System.out.println("0. Exit.");
            System.out.println("\nEnter your selection: ");
            y = scanner.nextInt();
            switch (y) {
                case 1:
                    findNameProduct(clothes);
                    System.out.println("<===============================>");
                    System.out.println();
                    break;
                case 2:
                    findColorProduct(clothes);
                    System.out.println("<===============================>");
                    System.out.println();
                    break;
                case 3:
                    findPriceProduct(clothes);
                    System.out.println("<===============================>");
                    System.out.println();
                    break;
                default:
                    System.out.println("Khong co lua chon nay.");
                    System.out.println("<===============================>");
                    System.out.println();
                    break;

            }
        } while (y!=0);
    }

    public  void findNameProduct(List<Clothes> clothes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the product you are looking for: ");
        String nameInput;
        nameInput = scanner.nextLine();
        System.out.println("Products whose name to look for is: ");
        for (int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i).getName().compareTo(nameInput) == 0) {
                System.out.println(clothes.get(i));
            }
        }

    }

    public  void findColorProduct(List<Clothes> clothes) {
        Scanner scanner = new Scanner(System.in);
        String color;
        System.out.println("Enter the color of the product you are looking for: ");
        color = scanner.nextLine();
        System.out.println("Products whose color to look for is: ");
        for (int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i).getColor().compareTo(color) == 0) {
                System.out.println(clothes.get(i));
            }
        }
    }

    public  void findPriceProduct(List<Clothes> clothes) {
        Scanner scanner = new Scanner(System.in);
        int price;
        System.out.println("Enter the price of the product you are looking for: ");
        price = scanner.nextInt();
        System.out.println("Products whose color to look for is: ");
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
        System.out.println("Enter the number of products to add: "); n = scanner.nextInt();
        int id, idType, price, quanlity;
        String name, color, size, material;
        for (int i=0; i<n; i++){
            id= clothes.size()+1;
                scanner.nextLine();
                System.out.println("Enter the name of the product to be added: "); name =scanner.nextLine();
                System.out.println("Enter the id type of the product to be added: "); idType = scanner.nextInt();
                System.out.println("Enter the color of the product to be added: "); color = scanner.nextLine(); scanner.nextLine();
                System.out.println("Enter the size of the product to be added: "); size = scanner.nextLine();
                System.out.println("Enter the price of the product to be added: "); price = scanner.nextInt(); scanner.nextLine();
                System.out.println("Enter the material of the product to be added: "); material = scanner.nextLine();
                System.out.println("Enter the quanlity of the product to be added: "); quanlity = scanner.nextInt();
                clothes.add(new Clothes(id, name, idType, color, size, price, material, quanlity));
                writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);
            }

    }

    public  void repairPriceofProduct(List <Clothes> clothes) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of products to fix the price: "); int n = scanner.nextInt();
        for (int j=0; j<n; j++){
            boolean ok=true;
            int idRepair;
            System.out.println("Enter the id of the product to be priced: ");
            idRepair = scanner.nextInt();
            for (int i=0; i<clothes.size(); i++){
                if (idRepair ==clothes.get(i).getId()) ok = true; break;
            }
            if (ok){
                System.out.println("Enter the price after editing: ");
                int priceRepair = scanner.nextInt();
                for (int i=0; i<clothes.size(); i++){
                    if (clothes.get(i).getId()==idRepair){
                        clothes.get(i).setPrice(priceRepair);
                        writeClothesStoreToFile(clothes, Constants.CLOTHES_STORE_FILE);
                    }
                }
            } else {
                System.out.println("The id of the product that needs fixing the price does not match the id of the product in the store.");
                repairPriceofProduct(clothes);
            }

        }
    }

    public  void deleteProduct() throws IOException {
        List<Clothes> clothes = readClothesStoreFromFile(Constants.CLOTHES_STORE_FILE);
        List<Clothes> clothes1 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of product to delete: "); int idDele = scanner.nextInt();
        for (int i=0; i<clothes.size(); i++){
            if (idDele != clothes.get(i).getId()){
                clothes1.add(clothes.get(i));

            }

        }

        writeClothesStoreToFile(clothes1, Constants.CLOTHES_STORE_FILE);

    }


}