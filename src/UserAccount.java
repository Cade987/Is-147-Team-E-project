package src;

public class UserAccount {

    // Inputted properties
    private String name;
    private String userName;
    private String password;
    private char gender;
    private int workerHours;

    // Generated properties
    private int id;
    private char workerType;
    private int salary;

    // Constructor (optional default)
    public UserAccount() {
        // Default constructor can be used if needed
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(char gender) {
        this.gender = gender;
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

    // Getters
    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public char getGender() {
        return gender;
    }

    public int getWorkerHours() {
        return workerHours;
    }

    public int getId() {
        return id;
    }

    public char getWorkerType() {
        return workerType;
    }

    public int getSalary() {
        return salary;
    }

    // Setup default user account (Jimmy)
    public void setNewAccount() {
        setNewAccount("Jim Beatly", "jimmybeatly99", "jiMbE4*n", 'M', 40);
        setId(12345);
        setWorkerType('F');
        setSalary(15);
    }

    // Setup new user-defined account
    public void setNewAccount(String name, String userName, String password, char gender, int workerHours) {
        setName(name);
        setUserName(userName);
        setPassword(password);
        setGender(gender);
        setWorkerHours(workerHours);

        setId(GenerateUserProperties.generateID());
        setWorkerType(GenerateUserProperties.generateWorkerType(workerHours));
        setSalary(GenerateUserProperties.generateSalary(workerHours));
    }
}
