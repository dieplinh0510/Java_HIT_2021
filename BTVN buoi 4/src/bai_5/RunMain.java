package bai_5;

public class RunMain {

    public static boolean isPrime(int n){
        if (n<2) return false;
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n%i==0) return false;
        }
        return true;
    }

    public static boolean isPrime(long n){
        if (n<2) return false;
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n%i==0) return false;
        }
        return true;
    }

    public static boolean isPrime(float n){
        return false;
    }

    public static boolean isPrime(double n){
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(3));
        System.out.println(isPrime(22));
        System.out.println(isPrime(3.2));
        System.out.println(isPrime(6.7));
    }
}
