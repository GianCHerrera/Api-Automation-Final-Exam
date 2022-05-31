package base.model;

/**
 * This class contains all details regarding the deserialization of User elements from API
 *
 */
public class User {

    /**
     * Elements contained by User
     */
    private String name;
    private String lastName;
    private float accountNumber;
    private String transactionType;
    private String email;
    private boolean active;
    private String country;
    private String telephone;
    private Double amount;
    private int id;

    public User() {
    }

    public User(String name, String lastName, float accountNumber, String transactionType,
                String email, boolean active, String country, String telephone, Double amount) {
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
        this.amount = amount;
    }

    //Setters and Getters generated


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public float getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(float accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
