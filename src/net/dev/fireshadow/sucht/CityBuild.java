package net.dev.fireshadow.sucht;

import cn.nukkit.plugin.PluginBase;
import net.dev.fireshadow.sucht.commands.*;
import net.dev.fireshadow.sucht.listeners.InventoryListener;
import net.dev.fireshadow.sucht.listeners.PlayerBlockBreakListener;
import net.dev.fireshadow.sucht.listeners.PlayerJoinListener;
import net.dev.fireshadow.sucht.listeners.PlayerWorldListener;
import net.dev.fireshadow.sucht.money.EcoCommand;
import net.dev.fireshadow.sucht.money.Money;
import net.dev.fireshadow.sucht.money.MoneyCommand;
import net.dev.fireshadow.sucht.money.PayCommand;
import net.dev.fireshadow.sucht.sql.Job;
import net.dev.fireshadow.sucht.sql.MySQL;
import net.dev.fireshadow.sucht.utils.FileUtils;
import net.dev.fireshadow.sucht.utils.JobManager;
import net.dev.fireshadow.sucht.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityBuild extends PluginBase {

    private static CityBuild instance;
    private Utils utils;

    private FileUtils fileUtils;
    private Money money;
    private JobManager jobManager;
    private Job job;

    @Override
    public void onEnable() {
        instance = this;
        utils = new Utils();
        fileUtils = new FileUtils();
        money = new Money();
        jobManager = new JobManager();
        job = new Job();

        if(fileUtils.getConfig().getBoolean("MySQl-Enabled")) {
            Connection con = new MySQL().connect();
            if(con != null) {
                try {
                    PreparedStatement ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS Money(UUID VARCHAR(36) NOT NULL PRIMARY KEY, MONEY int NOT NULL, CRYSTAL int NOT NULL)");
                    PreparedStatement ps1 = con.prepareStatement("CREATE TABLE IF NOT EXISTS Jobs(UUID varchar(64), JOB varchar(64), LEVEL int, EXPERIENCE int);");
                    ps.executeUpdate();
                    ps1.executeUpdate();
                    ps.close();
                    ps1.close();
                    con.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            } else {
                getLogger().info("§cMySQL Verbindung konnte nicht hergestellt werden..");
            }

            getServer().getCommandMap().register("money", new MoneyCommand("money"));
            getServer().getCommandMap().register("eco", new EcoCommand("eco"));
            getServer().getCommandMap().register("pay", new PayCommand("pay"));
            getServer().getCommandMap().register("job", new JobCommand("job"));
            getServer().getPluginManager().registerEvents(new PlayerBlockBreakListener(), this);
        } else {
            getLogger().info(utils.getPREFIX() + "§cMySQL ist in der config.yml nicht aktiviert! Dadurch kann das JobSystem und das MoneySystem nicht arbeiten.");
        }

        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerWorldListener(), this);

        registerCommands();
    }

    public void registerCommands() {
        getServer().getCommandMap().register("scale", new ScaleCommand("scale"));
        getServer().getCommandMap().register("fly", new FlyCommand("fly"));
        getServer().getCommandMap().register("heal", new HealCommand("heal"));
        getServer().getCommandMap().register("help", new HelpCommand("help"));
        getServer().getCommandMap().register("sethome", new SetHomeCommand("sethome"));
        getServer().getCommandMap().register("home", new HomeCommand("home"));
        getServer().getCommandMap().register("sign", new SignCommand("sign"));
        getServer().getCommandMap().register("wand", new WandCommand("wand"));
        getServer().getCommandMap().register("rand", new RandCommand("rand"));
        getServer().getCommandMap().register("clear", new ClearCommand("clear"));
        getServer().getCommandMap().register("feed", new FeedCommand("feed"));
        getServer().getCommandMap().register("tpa", new TpaCommand("tpa"));
        getServer().getCommandMap().register("tpaccept", new TpacceptCommand("tpaccept"));
        getServer().getCommandMap().register("tpadeny", new TpaDenyCommand("tpadeny"));
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static CityBuild getInstance() {
        return instance;
    }

    public Utils getUtils() {
        return utils;
    }

    public FileUtils getFileUtils() {
        return fileUtils;
    }

    public Money getMoney() {
        return money;
    }

    public JobManager getJobManager() {
        return jobManager;
    }

    public Job getJob() {
        return job;
    }
}
