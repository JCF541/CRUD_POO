package Master;
        
public class Account {
    private int accountId;
    private String accountType;
    private double balance;
    private int clientId;
    
    public Account(int accountId, String accountType, double balance, int clientId) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
        this.clientId = clientId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}

