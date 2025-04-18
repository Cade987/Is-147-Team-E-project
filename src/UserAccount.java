package src;

public class UserAccount {

    // Inputted properties
    private String name;
    private String userName;
    private int age;
    private String password;
    private char gender;
    private int workerHours;

    // Generated properties
    private int id;
    private char workerType;
    private int salary;

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getAge() {
        return age;
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

    // Setup default user account
    public void setNewAccount() {
        setName("Jim Beatly");
        setUserName("jimmybeatly99");
        setAge(26);
        setPassword("jiMbE4*n");
        setGender('M');
        setWorkerHours(40);

        setId(12345);
        setWorkerType('F');
        setSalary(15);
    }

    public void setNewAccount(String name, String userName, int age, String password, char gender, int workerHours){
        setName(name);
        setUserName(userName);
        setAge(age);
        setPassword(password);
        setGender(gender);
        setWorkerHours(workerHours);

        setId(GenerateUserProperties.generateID());
        setWorkerType(GenerateUserProperties.generateWorkerType(workerHours));
        setSalary(GenerateUserProperties.generateSalary(workerHours));
    }
}
