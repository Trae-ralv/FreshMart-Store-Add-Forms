package lithan.training.javawebapp.model;

public class StoreModel {
    private String name;
    private String phoneNumber;
    private String[] localities;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getLocalities() {
        return localities;
    }

    public void setLocalities(String[] localities) {
        this.localities = localities;
    }
}

