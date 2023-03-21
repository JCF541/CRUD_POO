/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection connection;

    public DAO() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createClient(Client client) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO clients(name) VALUES(?)");
            stmt.setString(1, client.getName());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> readClients() {
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM clients");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                clients.add(client);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void updateClient(Client client) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE clients SET name=? WHERE id=?");
            stmt.setString(1, client.getName());
            stmt.setInt(2, client.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(Client client) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM clients WHERE id=?");
            stmt.setInt(1, client.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(Account account) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO accounts(balance, client_id) VALUES(?,?)");
            stmt.setDouble(1, account.getBalance());
            stmt.setInt(2, account.getClientId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}