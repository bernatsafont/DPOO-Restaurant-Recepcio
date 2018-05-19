// package where it belongs
package model;

/**
 * This class handles the data of the mail
 */
public class MailData {

    // constant attributes
    private final String USER = "dpoRestaurant@gmail.com";
    private final String PASSWORD = "AnimacioRules";

    // attributes
    private String message;

    /**
     * Constructor of the class without parameters
     */
    public MailData() {
    }

    // getters and setters
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
