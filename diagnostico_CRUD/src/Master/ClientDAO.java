package Master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ConnectionFactory;

public class ClientDAO {

    private final Connection connection;

    public ClientDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public void addClient(Client client) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client(name) VALUES (?)");
            preparedStatement.setString(1, client.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM client WHERE id = ?");
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(Client client) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
            preparedStatement.setString(1, client.getName());
            preparedStatement.setInt(2, client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client getClientById(int clientId) {
        Client client = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client WHERE id = ?");
            preparedStatement.setInt(1, clientId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                client = new Client(rs.getInt("id"), rs.getString("name"));
                List<Account> accounts = new AccountDAO().getAccountsByClientId(clientId);
                client.setAccounts(accounts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Client client = new Client(rs.getInt("id"), rs.getString("name"));
                List<Account> accounts = new AccountDAO().getAccountsByClientId(client.getClientId());
                client.setAccounts(accounts);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
