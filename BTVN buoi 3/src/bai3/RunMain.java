package bai3;

public class RunMain {
    public static void main(String[] args) {
        Guns diep = new Guns("linh", 100);
        Guns linh = new Guns("lam", 100);
        while (diep.getAmmoNumber()>0 && linh.getAmmoNumber()>0){
            diep.load(diep.ramdom());
            linh.shoot(linh.ramdom());

        }
        if (diep.getAmmoNumber()<=0 && linh.getAmmoNumber()>0){
            System.out.println("Diep la nguoi thua");
        } else if (diep.getAmmoNumber()>0 && linh.getAmmoNumber()<=0){
            System.out.println("Linh la nguoi thua");
        } else if (diep.getAmmoNumber()<=0 && linh.getAmmoNumber()<=0){
            System.out.println("2 nguoi hoa nhau");
        }
    }
}
