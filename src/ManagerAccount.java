/**
 * This is the Manager Account class.
 * Extends the Account interface and allows user to log in as the system manager
 */

package src;

public class ManagerAccount extends Account {

    private final String userName = "admin";
    private final String password = "admin123";

    public ManagerAccount() {
        this.id = 999999; // Dummy ID for compatibility
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getAccountType() {
        return "Manager";
    }
}


