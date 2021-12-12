package bai_1;

public class Customer extends Person{
    private int balance;

    public Customer() {
    }

    public Customer(int balance) {
        this.balance = balance;
    }

    public Customer(String name, String address, int balance) {
        super(name, address);
        this.balance = balance;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Customer name: "+ getName());
        System.out.println("Customer address: "+ getAddress());
        System.out.println("Customer balance: "+ balance);
    }
}
