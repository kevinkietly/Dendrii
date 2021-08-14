package model;

public class NameCard {
    String name;

    //CONSTRUCTOR
    public NameCard(String name) {
        this.name = name;
    }

    public void changeName(String new_name) {
        name = new_name;
    }

    public String getName() {
        return name;
    }
}
