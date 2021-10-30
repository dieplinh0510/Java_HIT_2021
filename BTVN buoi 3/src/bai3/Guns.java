package bai3;

public class Guns {
    private String weaponName;
    private int ammoNumber;
    public void load(int x){
        ammoNumber+=x;
    }
    public void shoot(int x){
        if (ammoNumber==0){
            System.out.println("Het dan");
        } else if (ammoNumber>=x){
            ammoNumber-=x;
        }
    }
    public int ramdom(){
        int x= (int) Math.floor(((Math.random()*1)+10));
        return x;
    }

    public Guns() {
    }

    public Guns(String weaponName, int ammoNumber) {
        this.weaponName = weaponName;
        this.ammoNumber = ammoNumber;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getAmmoNumber() {
        return ammoNumber;
    }

    public void setAmmoNumber(int ammoNumber) {
        this.ammoNumber = ammoNumber;
    }
}
