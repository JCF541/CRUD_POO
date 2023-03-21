package controller;

import Master.ClientDAO;
import Master.Account;
import Master.Client;

import java.util.List;

public class ClientController {
    private ClientDAO clientDAO;
    private AccountController accountController;

    public ClientController(ClientDAO clientDAO, AccountController accountController) {
        this.clientDAO = clientDAO;
        this.accountController = accountController;
    }

    public void createClient(Client client) {
        List<Account> accounts = client.getAccounts();
        for (Account account : accounts) {
            accountController.createAccount(account);
        }
        clientDAO.createClient(client);
    }

    public void updateClient(Client client) {
        List<Account> accounts = client.getAccounts();
        for (Account account : accounts) {
            accountController.updateAccount(account);
        }
        clientDAO.updateClient(client);
    }

    public void deleteClient(Client client) {
        List<Account> accounts = client.getAccounts();
        for (Account account : accounts) {
            accountController.deleteAccount(account);
        }
        clientDAO.deleteClient(client);
    }

    public Client getClientById(int id) {
        Client client = clientDAO.getClientById(id);
        if (client != null) {
            List<Account> accounts = accountController.getAllAccountsByClientId(client.getId());
            client.setAccounts(accounts);
        }
        return client;
    }

    public List<Client> getAllClients() {
        List<Client> clients = clientDAO.getAllClients();
        for (Client client : clients) {
            List<Account> accounts = accountController.getAllAccountsByClientId(client.getId());
            client.setAccounts(accounts);
        }
        return clients;
    }
}
