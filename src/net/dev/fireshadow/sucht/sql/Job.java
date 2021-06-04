package net.dev.fireshadow.sucht.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Job {

    public void setJob(UUID uuid, String job) {
        Connection connection = new MySQL().connect();

        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Jobs SET JOB = '" + job.replaceAll("u00e4", "§") + "', level = 1, experience = 0 WHERE UUID = '" + uuid + "'");
                preparedStatement.execute();

                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void setLevel(UUID uuid, int level) {
        Connection connection = new MySQL().connect();

        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Jobs SET LEVEL = " + level + " WHERE uuid = '" + uuid + "'");
                preparedStatement.execute();

                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void setExperience(UUID uuid, int experience) {
        Connection connection = new MySQL().connect();

        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Jobs SET EXPERIENCE = " + experience + " WHERE uuid = '" + uuid + "'");
                preparedStatement.execute();

                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getJob(UUID uuid) {
        Connection connection = new MySQL().connect();

        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Jobs WHERE UUID= '" + uuid + "'");
                ResultSet rs = preparedStatement.executeQuery();

                if(rs.next()) {
                    String job = rs.getString("job");
                    rs.close();

                    return job.replaceAll("u00e4", "ä");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "NONE";
        }
        return "NONE";
    }

    public int getLevel(UUID uuid) {
        Connection connection = new MySQL().connect();

        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Jobs WHERE UUID='" + uuid + "'");
                ResultSet rs = preparedStatement.executeQuery();

                if(rs.next()) {
                    int level = rs.getInt("level");
                    connection.close();
                    rs.close();

                    return level;
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }
        return 0;
    }

    public int getExperience(UUID uuid) {
        Connection connection = new MySQL().connect();

        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Jobs WHERE UUID= '" + uuid + "'");
                ResultSet rs = preparedStatement.executeQuery();

                if(rs.next()) {
                    int experience = rs.getInt("experience");
                    rs.close();
                    preparedStatement.close();
                    connection.close();

                    return experience;
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }
        return 0;
    }

    public boolean exists(UUID uuid)  {
        Connection connection = new MySQL().connect();

        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Jobs WHERE UUID= '" + uuid + "'");
                ResultSet rs = preparedStatement.executeQuery();

                boolean b = false;
                if(rs.next())  {
                    b = rs.getString("UUID") != null;
                    rs.close();
                }
                return b;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        return false;
    }

    public void createPlayer(UUID uuid) {
        Connection connection = new MySQL().connect();

        if(connection != null) {
            if(!(exists(uuid))) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Jobs(UUID, JOB, LEVEL, EXPERIENCE) VALUES ('" + uuid + "', 'NONE', '0', '0');");
                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    connection.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
