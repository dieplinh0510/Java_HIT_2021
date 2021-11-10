package bai_4;

public class RunMain {
    public static void main(String[] args) {
        Sum <Integer> a = new Sum<Integer>(1, 2);
        System.out.println("Tong 2 so: " + (a.getSoB()+a.getSoA()));


        Sum <Long> b = new Sum<Long>(2l, 5l);
        System.out.println("Tong 2 so: "+ (b.getSoA() +b.getSoB()));
        Sum <Float> c = new Sum<Float>(1.2f, 3.4f);
        System.out.println("Tong 2 so: "+ (c.getSoB() +c.getSoA()));
        Sum <Double> d = new Sum<>(3.4, 2.2);
        System.out.println("Tong 2 so: " + (d.getSoA() +d.getSoB()));
    }
}
