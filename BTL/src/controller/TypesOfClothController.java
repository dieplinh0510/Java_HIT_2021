package controller;

import model.TypesOfCloth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TypesOfClothController {
    private TypesOfCloth typesOfCloth = new TypesOfCloth();
    private FileController fileController = new FileController();

    public TypesOfClothController() {

    }

    public TypesOfClothController(TypesOfCloth typesOfCloth, FileController fileController) {
        this.typesOfCloth = typesOfCloth;
        this.fileController = fileController;
    }
    public List<TypesOfCloth> readTypesOfClothFromFile(String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        List<TypesOfCloth> typesOfCloths = new ArrayList<>();

        while(fileController.scanner.hasNext()) {
            String data = fileController.scanner.nextLine();
            String[] a = data.split("\\|");
            typesOfCloths.add(new TypesOfCloth(Integer.parseInt(a[0]), a[1]));
        }

        fileController.CloseFileAfterRead(filename);

        return typesOfCloths;
    }

    public void writeTypesOfClothToFile(List<TypesOfCloth> typesOfCloths, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(TypesOfCloth typesOfCloth : typesOfCloths) {
            fileController.getPrintWriter().println(typesOfCloth.getId() + "|" + typesOfCloth.getName());
        }

        fileController.CloseFileAfterWrite(filename);
    }
}
