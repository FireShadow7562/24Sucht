package net.dev.fireshadow.sucht.listeners;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.scheduler.AsyncTask;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.events.MoneyAddEvent;
import net.dev.fireshadow.sucht.money.Money;
import net.dev.fireshadow.sucht.sql.Job;
import net.dev.fireshadow.sucht.utils.Utils;

public class PlayerBlockBreakListener implements Listener {

    Job jobs = CityBuild.getInstance().getJob();

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block b = e.getBlock();

        Utils utils = CityBuild.getInstance().getUtils();

        Server.getInstance().getScheduler().scheduleAsyncTask(new AsyncTask() {
            @Override
            public void onRun() {
                if(!e.isCancelled()) {
                    String job = jobs.getJob(player.getUniqueId());
                    int nextLevel = jobs.getLevel(player.getUniqueId()) + 1;

                    if(job.equals("Minenarbeiter")) {
                        if(b.getId() == BlockID.STONE || b.getId() == BlockID.IRON_ORE || b.getId() == BlockID.COAL_ORE || b.getId() == BlockID.DIAMOND_ORE || b.getId() == BlockID.EMERALD_ORE || b.getId() == BlockID.GOLD_ORE) {
                            int newExperience = jobs.getExperience(player.getUniqueId()) + 1;

                            if(newExperience == Utils.countMaxExperience(job, jobs.getLevel(player.getUniqueId()))) {
                                newExperience = 0;

                                jobs.setLevel(player.getUniqueId(), nextLevel);
                                player.sendMessage(utils.getPREFIX() + "§7Du hast ein neues Level erreicht");
                            }
                            jobs.setExperience(player.getUniqueId(), newExperience);
                            Money money = CityBuild.getInstance().getMoney();
                            money.addMoney(player.getUniqueId(), (1 * (jobs.getLevel(player.getUniqueId()))));
                            Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(player));

                            player.sendActionBar("§e+1 XP §8● §a+" + (1 * (jobs.getLevel(player.getUniqueId()))) + "$ §8● §b" + job + " §7Level " + jobs.getLevel(player.getUniqueId()) + " §8● §8(§7" + jobs.getExperience(player.getUniqueId()) + "§7/§b" + Utils.countMaxExperience(job, jobs.getLevel(player.getUniqueId())) + "§8)");
                        }
                    } else if(job.equals("Holzfäller")) {
                        if(b.getId() == BlockID.LOG || b.getId() == BlockID.LOG2) {
                            int newExperience = jobs.getExperience(player.getUniqueId()) + 1;

                            if(newExperience == Utils.countMaxExperience(job, jobs.getLevel(player.getUniqueId()))) {
                                newExperience = 0;

                                jobs.setLevel(player.getUniqueId(), nextLevel);
                                player.sendMessage(utils.getPREFIX() + "§7Du hast ein neues Level erreicht");
                            }
                            jobs.setExperience(player.getUniqueId(), newExperience);
                            Money money = CityBuild.getInstance().getMoney();
                            money.addMoney(player.getUniqueId(), (1 * (jobs.getLevel(player.getUniqueId()))));
                            Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(player));

                            player.sendActionBar("§e+1 XP §8● §a+" + (1 * (jobs.getLevel(player.getUniqueId()))) + "$ §8● §b" + job + " §7Level " + jobs.getLevel(player.getUniqueId()) + " §8● §8(§7" + jobs.getExperience(player.getUniqueId()) + "§7/§b" + Utils.countMaxExperience(job, jobs.getLevel(player.getUniqueId())) + "§8)");
                        }
                    } else if(job.equals("Gräber")) {
                        if(b.getId() == BlockID.DIRT || b.getId() == BlockID.GRASS || b.getId() == BlockID.GRAVEL || b.getId() == BlockID.SAND) {
                            int newExperience = jobs.getExperience(player.getUniqueId()) + 1;

                            if(newExperience == Utils.countMaxExperience(job, jobs.getLevel(player.getUniqueId()))) {
                                newExperience = 0;

                                jobs.setLevel(player.getUniqueId(), nextLevel);
                                player.sendMessage(utils.getPREFIX() + "§7Du hast ein neues Level erreicht");
                            }
                            jobs.setExperience(player.getUniqueId(), newExperience);
                            Money money = CityBuild.getInstance().getMoney();
                            money.addMoney(player.getUniqueId(), (1 * (jobs.getLevel(player.getUniqueId()))));
                            Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(player));

                            player.sendActionBar("§e+1 XP §8● §a+" + (1 * (jobs.getLevel(player.getUniqueId()))) + "$ §8● §b" + job + " §7Level " + jobs.getLevel(player.getUniqueId()) + " §8● §8(§7" + jobs.getExperience(player.getUniqueId()) + "§7/§b" + Utils.countMaxExperience(job, jobs.getLevel(player.getUniqueId())) + "§8)");
                        }
                    }
                }
            }
        });
    }
}
