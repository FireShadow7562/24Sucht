package net.dev.fireshadow.sucht.listeners;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.network.protocol.SetLocalPlayerAsInitializedPacket;
import cn.nukkit.scheduler.AsyncTask;
import de.theamychan.scoreboard.api.ScoreboardAPI;
import de.theamychan.scoreboard.network.DisplaySlot;
import de.theamychan.scoreboard.network.Scoreboard;
import de.theamychan.scoreboard.network.ScoreboardDisplay;
import de.theamychan.scoreboard.network.SortOrder;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.events.MoneyAddEvent;
import net.dev.fireshadow.sucht.money.Money;
import net.dev.fireshadow.sucht.sql.Job;
import net.dev.fireshadow.sucht.utils.FileUtils;
import net.dev.fireshadow.sucht.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class PlayerJoinListener implements Listener {

    public static Map<Player, Scoreboard> boards = new HashMap<>();

    private Job job = CityBuild.getInstance().getJob();

    @EventHandler
    public void onPacketReceive(DataPacketReceiveEvent e) {
        Player player = e.getPlayer();
        FileUtils fileUtils = CityBuild.getInstance().getFileUtils();
        Utils utils = CityBuild.getInstance().getUtils();

        if(e.getPacket() instanceof SetLocalPlayerAsInitializedPacket) {
            player.sendMessage(utils.getPREFIX() + "Verbinde zu §9§l" + fileUtils.getConfig().getString("Server-Name") + "§b...");
            player.sendTitle("§aErfolgreich", "§7Dein Inventar wurde erfolgreich geladen! (" + player.getPing() + "ms)");

            Server.getInstance().getScheduler().scheduleAsyncTask(new AsyncTask() {
                @Override
                public void onRun() {
                    job.createPlayer(player.getUniqueId());
                }
            });
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        FileUtils fileUtils = CityBuild.getInstance().getFileUtils();
        Utils utils = CityBuild.getInstance().getUtils();

        Server.getInstance().getScheduler().scheduleAsyncTask(new AsyncTask() {
            @Override
            public void onRun() {
                Money money = CityBuild.getInstance().getMoney();
                money.createUser(player.getUniqueId());

                if (boards.containsKey(player))
                    boards.get(player).hideFor(player);
                Scoreboard sb = ScoreboardAPI.createScoreboard();
                ScoreboardDisplay sbd = sb.addDisplay(DisplaySlot.SIDEBAR, "dummy", "§9§l24SUCHT", SortOrder.DESCENDING);

                sbd.addLine("§7", 10);
                sbd.addLine("§7» §9§lServer", 9);
                sbd.addLine(" §f%server".replace("%server", fileUtils.getConfig().getString("Server-Name")) + "§a ", 8);
                sbd.addLine("§8", 7);
                sbd.addLine("§7» §9§lSpieler", 6);
                sbd.addLine(" §f" + Server.getInstance().getOnlinePlayers().size() + "/" + Server.getInstance().getMaxPlayers(), 5);
                sbd.addLine("§b", 4);
                sbd.addLine("§7» §9§lKonto", 3);
                sbd.addLine(" §f%money".replace("%money", "" + money.getMoney(e.getPlayer().getUniqueId())) + "$", 2);
                sbd.addLine("§c", 1);
                boards.put(player, sb);
                sb.showFor(player);
            }
        });
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        FileUtils fileUtils = CityBuild.getInstance().getFileUtils();

        Server.getInstance().getScheduler().scheduleAsyncTask(new AsyncTask() {
            @Override
            public void onRun() {
                for(Player all : Server.getInstance().getOnlinePlayers().values()) {
                    if (boards.containsKey(all))
                        boards.get(all).hideFor(all);
                    Scoreboard sb = ScoreboardAPI.createScoreboard();
                    ScoreboardDisplay sbd = sb.addDisplay(DisplaySlot.SIDEBAR, "dummy", "§9§l24SUCHT", SortOrder.DESCENDING);

                    sbd.addLine("§7", 10);
                    sbd.addLine("§7» §9§lServer", 9);
                    sbd.addLine(" §f%server".replace("%server", fileUtils.getConfig().getString("Server-Name")) + "§a ", 8);
                    sbd.addLine("§8", 7);
                    sbd.addLine("§7» §9§lSpieler", 6);
                    sbd.addLine(" §f" + Server.getInstance().getOnlinePlayers().size() + "/" + Server.getInstance().getMaxPlayers(), 5);
                    sbd.addLine("§b", 4);
                    sbd.addLine("§7» §9§lKonto", 3);

                    Money money = CityBuild.getInstance().getMoney();
                    sbd.addLine(" §f%money".replace("%money", "" + money.getMoney(event.getPlayer().getUniqueId())) + "$", 2);
                    sbd.addLine("§c", 1);
                    boards.put(all, sb);
                    sb.showFor(all);
                }
            }
        });
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("");
        boards.remove(p);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        FileUtils fileUtils = CityBuild.getInstance().getFileUtils();

        Server.getInstance().getScheduler().scheduleAsyncTask(new AsyncTask() {
            @Override
            public void onRun() {
                for(Player all : Server.getInstance().getOnlinePlayers().values()) {
                    if (boards.containsKey(all))
                        boards.get(all).hideFor(all);
                    Scoreboard sb = ScoreboardAPI.createScoreboard();
                    ScoreboardDisplay sbd = sb.addDisplay(DisplaySlot.SIDEBAR, "dummy", "§9§l24SUCHT", SortOrder.DESCENDING);

                    sbd.addLine("§7", 10);
                    sbd.addLine("§7» §9§lServer", 9);
                    sbd.addLine(" §f%server".replace("%server", fileUtils.getConfig().getString("Server-Name")) + "§a ", 8);
                    sbd.addLine("§8", 7);
                    sbd.addLine("§7» §9§lSpieler", 6);
                    sbd.addLine(" §f" + Server.getInstance().getOnlinePlayers().size() + "/" + Server.getInstance().getMaxPlayers(), 5);
                    sbd.addLine("§b", 4);
                    sbd.addLine("§7» §9§lKonto", 3);

                    Money money = CityBuild.getInstance().getMoney();
                    sbd.addLine(" §f%money".replace("%money", "" + money.getMoney(event.getPlayer().getUniqueId())) + "$", 2);
                    sbd.addLine("§c", 1);
                    boards.put(all, sb);
                    sb.showFor(all);
                }
            }
        });
    }

    @EventHandler
    public void onMoneyUpdate(MoneyAddEvent event) {
        FileUtils fileUtils = CityBuild.getInstance().getFileUtils();
        Player player = event.getPlayer();

        Server.getInstance().getScheduler().scheduleAsyncTask(new AsyncTask() {
            @Override
            public void onRun() {
                    if (boards.containsKey(player))
                        boards.get(player).hideFor(player);
                    Scoreboard sb = ScoreboardAPI.createScoreboard();
                    ScoreboardDisplay sbd = sb.addDisplay(DisplaySlot.SIDEBAR, "dummy", "§9§l24SUCHT", SortOrder.DESCENDING);

                    sbd.addLine("§7", 10);
                    sbd.addLine("§7» §9§lServer", 9);
                    sbd.addLine(" §f%server".replace("%server", fileUtils.getConfig().getString("Server-Name")) + "§a ", 8);
                    sbd.addLine("§8", 7);
                    sbd.addLine("§7» §9§lSpieler", 6);
                    sbd.addLine(" §f" + Server.getInstance().getOnlinePlayers().size() + "/" + Server.getInstance().getMaxPlayers(), 5);
                    sbd.addLine("§b", 4);
                    sbd.addLine("§7» §9§lKonto", 3);

                    Money money = CityBuild.getInstance().getMoney();
                    sbd.addLine(" §f%money".replace("%money", "" + money.getMoney(player.getUniqueId())) + "$", 2);
                    sbd.addLine("§c", 1);
                    boards.put(player, sb);
                    sb.showFor(player);
                }
        });
    }
}