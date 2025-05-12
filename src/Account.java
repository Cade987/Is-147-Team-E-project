/**
 * This is the Account interface
 * Used by the User & Manager accounts to create id values
 */

package src;

public abstract class Account {
    protected int id;

    public int getId() {
        return id;
    }

    public abstract String getAccountType();
}
