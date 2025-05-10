package src;

public abstract class Account {
    protected int id;

    public int getId() {
        return id;
    }

    public abstract String getAccountType();
}
