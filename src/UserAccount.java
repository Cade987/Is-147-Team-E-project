package src;

public class UserAccount extends Account {

    private String name;
    private int workerHours;
    private char workerType;
    private int salary;

    public UserAccount() {
        // Default constructor
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkerHours(int workerHours) {
        this.workerHours = workerHours;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorkerType(char workerType) {
        this.workerType = workerType;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getWorkerHours() {
        return workerHours;
    }

    public char getWorkerType() {
        return workerType;
    }

    public int getSalary() {
        return salary;
    }

    public void setNewAccount() {
        setNewAccount("Jim Beatly", 40);
        setId(123456);  // Default static ID for demo
    }

    public void setNewAccount(String name, int workerHours) {
        setName(name);
        setWorkerHours(workerHours);

        setId(GenerateUserProperties.generateID());
        setWorkerType(GenerateUserProperties.generateWorkerType(workerHours));
        setSalary(GenerateUserProperties.generateSalary(workerHours));
    }

    @Override
    public String getAccountType() {
        return "Employee";
    }
}
