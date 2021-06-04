package net.dev.fireshadow.sucht.sql;

import cn.nukkit.utils.Config;
import net.dev.fireshadow.sucht.CityBuild;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public Connection connect() {
        Connection con = null;
        Config mysql = new Config(new File(CityBuild.getInstance().getDataFolder(), "mysql.yml"));

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + mysql.get("ip") + ":" + mysql.getInt("port") + "/" + mysql.getString("database"), mysql.getString("username"), mysql.getString("password"));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return con;
    }
}
