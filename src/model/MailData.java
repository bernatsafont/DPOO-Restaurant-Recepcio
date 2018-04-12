package model;

public class MailData {

    private final String USER = "dpoRestaurant@gmail.com";
    private final String PASSWORD = "AnimacioRules";
    private String message;

    public MailData() {
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
