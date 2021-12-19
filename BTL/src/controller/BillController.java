package controller;

import model.Bill;
import model.Clothes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillController {
    private Bill bill= new Bill();
    private FileController fileController = new FileController();

    public BillController() {

    }

    public BillController(Bill bill, FileController fileController) {
        this.bill = bill;
        this.fileController = fileController;
    }
    public List<Bill> readBillFromFile(String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        List<Bill>  bills = new ArrayList<>();

        while(fileController.scanner.hasNext()) {
            String data = fileController.scanner.nextLine();
            String[] a = data.split("\\|");
            ArrayList<Clothes> clothes = new ArrayList<>();
            for (int i=0; i<a.length; i++){
                clothes.add(new Clothes(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), a[3], a[4],Integer.parseInt(a[5]), a[6], Integer.parseInt(a[7])));
            }
            bills.add(new Bill(Integer.parseInt(a[0]), Integer.parseInt(a[1]), clothes, Double.parseDouble(a[3])));
        }

        fileController.CloseFileAfterRead(filename);

        return bills;
    }






    public void writeBillToFile(List<Bill> bills, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(Bill bill : bills) {
            fileController.getPrintWriter().println(bill.getIdBill() + "|" + bill.getIdUser() + "|" + bill.getClothes()+ "|" + bill.getDiscount() );
        }

        fileController.CloseFileAfterWrite(filename);
    }
}
