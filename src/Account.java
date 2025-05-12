package src;

/**
 * This is the Account interface
 * Used by the User & Manager accounts to create id values
 */
public abstract class Account {
    protected int id;

    public int getId() {
        return id;
    }

    public abstract String getAccountType();
}
