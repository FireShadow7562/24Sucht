package net.dev.fireshadow.sucht.money;

import net.dev.fireshadow.sucht.sql.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Money {

    public boolean exists(UUID uuid) {
        Connection connection = new MySQL().connect();

        try {
            if(connection != null) {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM Money WHERE UUID = '" + uuid + "'");

                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    return true;
                }
                rs.close();
                ps.close();
                connection.close();
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void createUser(UUID uuid) {
        if(!(exists(uuid))) {
            Connection connection = new MySQL().connect();

            if(connection != null) {
                try {
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Money(UUID, MONEY, CRYSTAL) VALUES (?, ?, ?)");
                    ps.setString(1, uuid.toString());
                    ps.setInt(2, 2000);
                    ps.setInt(3, 0);
                    ps.executeUpdate();
                    ps.close();
                    connection.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void addMoney(UUID uuid, int money) {
        try {
            Connection connection = new MySQL().connect();
            if(connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Money SET MONEY = '" + (getMoney(uuid) + money) + "' WHERE UUID = '" + uuid + "'");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeMoney(UUID uuid, int money) {
        try {
            Connection connection = new MySQL().connect();
            if(connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Money SET MONEY = '" + (getMoney(uuid) - money) + "' WHERE UUID = '" + uuid + "'");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setMoney(UUID uuid, int money) {
        try {
            Connection connection = new MySQL().connect();
            if(connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Money SET MONEY = '" + (money) + "' WHERE UUID = '" + uuid + "'");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean hasMoney(UUID uuid, int money) {
        if(getMoney(uuid) >= money) {
            return true;
        }
        return false;
    }

    public double getMoney(UUID uuid) {
        try {
            Connection connection = new MySQL().connect();

            if(connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Money WHERE UUID = '" + uuid + "'");
                ResultSet rs = preparedStatement.executeQuery();

                if(rs.next()) {
                    return rs.getInt("MONEY");
                }
                preparedStatement.close();
                rs.close();
                connection.close();
                return rs.getInt("MONEY");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
