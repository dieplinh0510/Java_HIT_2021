package model;

public class User {
    private int idUser;
    private String nameUser;
    private String password;
    private String email;
    private String address;
    private String name;
    private String phoneNumber;
    private String permission;
    private String dateOfBirth;

    public User() {
    }

    public User(int idUser, String nameUser, String password, String email, String address, String name, String phoneNumber, String permission, String dateOfBirth) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.password = password;
        this.email = email;
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.permission = permission;
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public void display(){
        System.out.printf("\t\t\t\t\tId user       : " + idUser + "\n");
        System.out.printf("\t\t\t\t\tName user     : " + nameUser + "\n");
        System.out.printf("\t\t\t\t\tEmail         : " + email + "\n");
        System.out.printf("\t\t\t\t\tAddress       : " + address + "\n");
        System.out.printf("\t\t\t\t\tName          : " + name + "\n");
        System.out.printf("\t\t\t\t\tPhone number  : " + phoneNumber + "\n");
        System.out.printf("\t\t\t\t\tPermission    : " + permission + "\n");
        System.out.printf("\t\t\t\t\tDate of birth : " + dateOfBirth + "\n\n");
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", nameUser='" + nameUser + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", permission='" + permission + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
