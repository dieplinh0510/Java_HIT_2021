package model;

public class Clothes {
    private int id;
    private String name;
    private int idTypeOfClother;
    private String color;
    private String size;
    private int price;
    private String material;
    private int quantily;

    public Clothes() {
    }

    public Clothes(int id, String name, String color, String size, int price, String material, int quantily) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
        this.material = material;
        this.quantily = quantily;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    @Override
    public String toString() {
        return "model.Clothes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", material='" + material + '\'' +
                ", quantily=" + quantily +
                '}';
    }
}
