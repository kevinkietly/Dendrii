package model;

public class PhotoCard {

    public String photo_path;
    String name;

    //CONSTRUCTOR
    public PhotoCard(String name, String photo_path) {
        this.name = name;
        this.photo_path = photo_path;
    }

    public void changeName(String new_name) {
        name = new_name;
    }

    public void changePhoto(String new_photo_path) {
        photo_path = new_photo_path;
    }

    public String getName() {
        return name;
    }

    public String getPhoto_path() {
        return photo_path;
    }
}
