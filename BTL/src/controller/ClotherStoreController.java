package controller;

import model.Clothes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ClotherStoreController {
    private Clothes clothes = new Clothes();
    private FileController fileController = new FileController();

    public ClotherStoreController() {

    }

    public ClotherStoreController(Clothes clothes, FileController fileController) {
        this.clothes = clothes;
        this.fileController = fileController;
    }
    public List<Clothes> readClothesStoreFromFile(String filename) throws IOException {
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

    public List<Clothes> writeClothesStoreToFile(List<Clothes> clothes, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(Clothes clothe : clothes) {
            fileController.getPrintWriter().println(clothe.getId() + "|" + clothe.getName() + "|" + clothe.getIdTypeOfClother()+ "|" + clothe.getColor() + "|" + clothe.getSize()+ "|" + clothe.getPrice()+ "|" + clothe.getMaterial()+ "|"+ clothe.getQuantily());
        }

        fileController.CloseFileAfterWrite();
        return clothes;
    }


}