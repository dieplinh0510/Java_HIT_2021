package model;

public class Client extends  User{
    private String noteForShop;

    public Client() {
    }

    public Client(String noteForShop) {
        this.noteForShop = noteForShop;
    }

    public Client(int idUser, String nameUser, String password, String email, String address, String name, String phoneNumber, String permission, String dateOfBirth, String noteForShop) {
        super(idUser, nameUser, password, email, address, name, phoneNumber, permission, dateOfBirth);
        this.noteForShop = noteForShop;
    }

    public String getNoteForShop() {
        return noteForShop;
    }

    public void setNoteForShop(String noteForShop) {
        this.noteForShop = noteForShop;
    }
}
