package com.qlnv.dao;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {
    Connection connection = ConnectMysql.getConnection();
    public Account checklogin(String username, String pass) {
        try {

            String query = "select * from account where username =? and password=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String avatar = resultSet.getString("avatar");

                return new Account(id, username, password, role, avatar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createAccount(Account account) {
        String query = "INSERT INTO Account (username, password, role, avatar) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getRole());
            statement.setString(4, account.getAvatar());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Account getAccountByUsername(String username) {
        String query = "SELECT * FROM Account WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    String avatar = resultSet.getString("avatar");

                    return new Account(id, username, password, role, avatar);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateAccount(Account account){
        String query = "UPDATE Account SET password = ?, role = ?, avatar = ? WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getPassword());
            statement.setString(2, account.getRole());
            statement.setString(3, account.getAvatar());
            statement.setString(4, account.getUsername());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAccount(String username) {
        String query = "DELETE FROM Account WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
