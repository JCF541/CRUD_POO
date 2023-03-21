package Master;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    
    private final Connection connection;
    
    public AccountDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void create(Account account) throws SQLException {
        String sql = "INSERT INTO accounts (balance, client_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, account.getBalance());
            statement.setInt(2, account.getClientId());
            statement.executeUpdate();
        }
    }
    
    public Account read(int id) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Account(
                        resultSet.getInt("id"),
                        resultSet.getDouble("balance"),
                        resultSet.getInt("client_id")
                );
            }
            return null;
        }
    }
    
    public void update(Account account) throws SQLException {
        String sql = "UPDATE accounts SET balance = ?, client_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, account.getBalance());
            statement.setInt(2, account.getClientId());
            statement.setInt(3, account.getId());
            statement.executeUpdate();
        }
    }
    
    public void delete(Account account) throws SQLException {
        String sql = "DELETE FROM accounts WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, account.getId());
            statement.executeUpdate();
        }
    }
    
    public List<Account> findAll() throws SQLException {
        String sql = "SELECT * FROM accounts";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()) {
                accounts.add(new Account(
                        resultSet.getInt("id"),
                        resultSet.getDouble("balance"),
                        resultSet.getInt("client_id")
                ));
            }
            return accounts;
        }
    }
    
    public List<Account> findByClient(Client client) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE client_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, client.getId());
            ResultSet resultSet = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()) {
                accounts.add(new Account(
                        resultSet.getInt("id"),
                        resultSet.getDouble("balance"),
                        resultSet.getInt("client_id")
                ));
            }
            return accounts;
        }
    }
}

