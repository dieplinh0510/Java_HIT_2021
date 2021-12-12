package controller;

import model.Clothes;
import model.User;

import java.util.ArrayList;

public class ClotherController {
    private Clothes clothes = new Clothes();
    private FileController fileController = new FileController();

    public ClotherController (){
    }

    public ClotherController(Clothes clothes, FileController fileController) {
        this.clothes = clothes;
        this.fileController = fileController;
    }

    public void writeToFile (ArrayList<User> clothes, String filemane){
        fileController.OpenFileToWrite(filemane);
        for (int i=0; i<clothes.size(); i++){
            fileController.getPrintWriter().println(clothes.get(i));
        }

        fileController.CloseFileAfterWrite(filemane);
    }
}
