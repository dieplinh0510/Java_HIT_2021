package bai1;

public class RunMain {
    public static void main(String[] args) {
        Person person1 = new Person("Lam",6,"Nữ","Đọc truyện");
        Person person2 = new Person();
        System.out.println(person1.toString());
        person2.setAge(3);
        person2.setName("Linh");
        person2.setGender("Nữ");
        person2.setHobby("Đọc truyện");
        System.out.println(person2.toString());
    }
}
