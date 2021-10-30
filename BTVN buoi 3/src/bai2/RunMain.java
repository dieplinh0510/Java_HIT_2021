package bai2;


public class RunMain {
    public static void main(String[] args) {
        Array arr1 = new Array();
        Array arr2 = new Array();
        arr1.inputData();
        arr2.inputData();
        arr1.show();
        arr2.show();
        System.out.println("Sum = " + arr1.sum());
        System.out.println("Sum = " + arr2.sum());

        arr1.filter(true);
        arr2.filter(false);
        if (arr1.tbc()> arr2.tbc()){
            arr1.show();
        } else if (arr1.tbc() < arr2.tbc()){
            arr2.show();
        } else System.out.println("Bye");
    }
}
