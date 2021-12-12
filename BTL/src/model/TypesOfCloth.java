package model;

public class TypesOfCloth {
    private int id;
    private String name;

    public TypesOfCloth() {
    }

    public TypesOfCloth(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "model.TypesOfCloth{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
