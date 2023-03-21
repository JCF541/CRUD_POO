
package Master;
//import java.util.ArrayList;

public class Account {
  private int id;
  private double balance;
  private int clientId;

  public Account() {
      this.id = 0;
      this.balance = 0;
      this.clientId = 0;
  }
  

  public Account(int id, double balance, int clientId) {
    this.id = id;
    this.balance = balance;
    this.clientId = clientId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
/*public class Account {
    private int account_number;
    private double balance;
    private int client_number;
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    public Account() {
        this.account_number = 0;
        this.balance = 0;
        this.client_number = 0;
    }
    public Account(int account_number, double balance, int client_number) {
        this.account_number = account_number;
        this.balance = balance;
        this.client_number = client_number;
    }

    public int getAccountNumber() {
        return this.account_number;
    }

    public void setAccountNumber(int account_number) {
        this.account_number = account_number;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getClientNumber() {
        return this.client_number;
    }

    public void setClientNumber(int client_number) {
        this.client_number = client_number;
    }

    public void createAccount(int account_number, double balance, int client_number) {
        Account newAccount = new Account(account_number, balance, client_number);
        accounts.add(newAccount);
    }

    public void readAccount(int account_number) {
        for (Account account: accounts) {
            if (account.getAccountNumber() == account_number) {
                System.out.println("Numero cuenta: " + account.getAccountNumber());
                System.out.println("Balance: " + account.getBalance());
                System.out.println("Numero cliente: " + account.getClientNumber());
                return;
            }
        }
        System.out.println("Cuenta no encontrada");
    }

    public void updateAccount(int account_number, double new_balance) {
        for (Account account: accounts) {
            if (account.getAccountNumber() == account_number) {
                account.setBalance(new_balance);
                return;
            }
        }
        System.out.println("Cuenta no encontrada");
    }

    public void deleteAccount(int account_number) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == account_number) {
                accounts.remove(i);
                return;
            }
        }
        System.out.println("Cuenta no encontrada");
    }

    public Account findAccount(int account_number) {
        for (Account account: accounts) {
            if (account.getAccountNumber() == account_number) {
                return account;
            }
        }
        return null;
    }
    
    public void findAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No se hallaron cuentas");
            return;
        }
        for (Account account: accounts) {
            System.out.println("Numero Cuenta: " + account.getAccountNumber());
            System.out.println("Numero Cliente: " + account.getClientNumber());
        }
    }
}
*/