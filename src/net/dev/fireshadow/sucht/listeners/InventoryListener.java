package net.dev.fireshadow.sucht.listeners;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.response.FormResponseModal;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindowModal;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;
import com.intellectualcrafters.plot.object.Plot;
import com.intellectualcrafters.plot.object.PlotPlayer;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.sql.Job;
import net.dev.fireshadow.sucht.utils.JobManager;
import net.dev.fireshadow.sucht.utils.Utils;

import java.io.File;

public class InventoryListener implements Listener {

    private Config cfg = new Config(new File(CityBuild.getInstance().getDataFolder(), "homes.yml"));

    private Job job = CityBuild.getInstance().getJob();

    @EventHandler
    public void onInventory(PlayerFormRespondedEvent event) {
        if(event.getWindow() instanceof FormWindowSimple) {
            if (event.getResponse() instanceof FormResponseSimple) {
                Utils utils = CityBuild.getInstance().getUtils();
                Player player = event.getPlayer();
                FormWindowSimple formwindow = (FormWindowSimple) event.getWindow();
                String title = formwindow.getTitle();
                String text = formwindow.getResponse().getClickedButton().getText();

                if(title.equals(utils.getPREFIX() + "§7Größe")) {
                    switch (text) {
                        case "Rießig":
                            player.setScale(7.0F);
                            break;
                        case "Groß":
                            player.setScale(5.0F);
                            break;
                        case "Normal":
                            player.setScale(1.0F);
                            break;
                        case "Klein":
                            player.setScale(0.7F);
                            break;
                        case "Winzig":
                            player.setScale(0.3F);
                            break;
                    }
                } else if(title.equals(utils.getPREFIX() + "§bPlot-Rand")) {
                    final PlotPlayer p = PlotPlayer.wrap(player);
                    final Plot plot = p.getCurrentPlot();

                    switch (text) {
                        case "§8Steinziegel \nSpieler":
                            for (Plot plots : plot.getConnectedPlots())
                                plots.setComponent("border", "98");
                            break;
                        case "§8Endsteinziegel \n§dPremium":
                            if(player.hasPermission("iw24essentials.rand.premium")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "121");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.premium"));
                            }
                            break;
                        case "§8Polierter Granit \n§dPremium":
                            if(player.hasPermission("iw24essentials.rand.premium")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "1:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.premium"));
                            }
                            break;
                        case "§8Polierter Diorit \n§dPremium":
                            if(player.hasPermission("iw24essentials.rand.premium")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "1:4");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.premium"));
                            }
                            break;
                        case "§8Polierter Andesit \n§dPremium":
                            if(player.hasPermission("iw24essentials.rand.premium")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "1:6");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.premium"));
                            }
                            break;
                        case "§8Prismarienziegel \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "168:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "24");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Gemeißelter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "24:1");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Geschnittener Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "24:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Glatter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "24:3");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Roter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "179");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Gemeißelter roter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "179:1");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Geschnittener Roter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "179:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Glatter Roter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.rand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "179:3");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.obsidian"));
                            }
                            break;
                        case "§8Weißer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Oranger Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:1");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Magenta Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Hellblauer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:3");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Gelber Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:4");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Hellgrüner Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:5");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Rosa Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:6");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Grauer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:7");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Hellgrauer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:8");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Türkiser Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:9");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Violetter Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:10");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Blauer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:11");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Brauner Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:12");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                            //
                        case "§8Grüner Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:13");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Roter Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:14");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Schwarzer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.rand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "236:15");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.prime"));
                            }
                            break;
                        case "§8Kohleblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.rand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "173");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.ultimate"));
                            }
                            break;
                        case "§8Lapislazuliblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.rand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "22");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.ultimate"));
                            }
                            break;
                        case "§8Eisenblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.rand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "42");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.ultimate"));
                            }
                            break;
                        case "§8Goldblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.rand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "41");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.ultimate"));
                            }
                            break;
                        case "§8Diamantblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.rand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "57");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.ultimate"));
                            }
                            break;
                        case "§8Smaragdblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.rand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("border", "133");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.rand.ultimate"));
                            }
                            break;
                    }
                } else if(title.equals(utils.getPREFIX() + "§bPlot-Wand")) {
                    final PlotPlayer p = PlotPlayer.wrap(player);
                    final Plot plot = p.getCurrentPlot();

                    switch (text) {
                        case "§8Steinziegel \nSpieler":
                            for (Plot plots : plot.getConnectedPlots())
                                plots.setComponent("wall", "98");
                            break;
                        case "§8Endsteinziegel \n§dPremium":
                            if(player.hasPermission("iw24essentials.wand.premium")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "121");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.premium"));
                            }
                            break;
                        case "§8Polierter Granit \n§dPremium":
                            if(player.hasPermission("iw24essentials.wand.premium")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "1:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.premium"));
                            }
                            break;
                        case "§8Polierter Diorit \n§dPremium":
                            if(player.hasPermission("iw24essentials.wand.premium")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "1:4");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.premium"));
                            }
                            break;
                        case "§8Polierter Andesit \n§dPremium":
                            if(player.hasPermission("iw24essentials.wand.premium")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "1:6");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.premium"));
                            }
                            break;
                        case "§8Prismarienziegel \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "168:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "24");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Gemeißelter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "24:1");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Geschnittener Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "24:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Glatter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "24:3");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Roter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "179");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Gemeißelter roter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "179:1");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Geschnittener Roter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "179:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Glatter Roter Sandstein \n§bObsidian":
                            if(player.hasPermission("iw24essentials.wand.obsidian")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "179:3");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.obsidian"));
                            }
                            break;
                        case "§8Weißer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Oranger Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:1");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Magenta Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:2");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Hellblauer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:3");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Gelber Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:4");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Hellgrüner Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:5");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Rosa Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:6");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Grauer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:7");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Hellgrauer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:8");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Türkiser Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:9");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Violetter Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:10");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Blauer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:11");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Brauner Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:12");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        //
                        case "§8Grüner Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:13");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Roter Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:14");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Schwarzer Beton \n§3§lPRIME":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "236:15");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.prime"));
                            }
                            break;
                        case "§8Kohleblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.wand.prime")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "173");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.ultimate"));
                            }
                            break;
                        case "§8Lapislazuliblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.wand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "22");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.ultimate"));
                            }
                            break;
                        case "§8Eisenblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.wand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "42");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.ultimate"));
                            }
                            break;
                        case "§8Goldblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.wand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "41");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.ultimate"));
                            }
                            break;
                        case "§8Diamantblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.wand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "57");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.ultimate"));
                            }
                            break;
                        case "§8Smaragdblock \n§9§lULTIMATE":
                            if(player.hasPermission("iw24essentials.wand.ultimate")) {
                                for (Plot plots : plot.getConnectedPlots())
                                    plots.setComponent("wall", "133");
                            } else {
                                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.wand.ultimate"));
                            }
                            break;
                    }
                } else if(title.equals(utils.getPREFIX() + "§7Deine Homes")) {
                    player.sendMessage(utils.getPREFIX() + "Du wirst in §b5s §7teleportiert");

                    Server.getInstance().getScheduler().scheduleDelayedTask(() -> {
                        player.teleport(new Location(cfg.getInt(player.getUniqueId().toString() + "." + text + ".x"), cfg.getInt(player.getUniqueId().toString() + "." + text + ".y"), cfg.getInt(player.getUniqueId().toString() + "." + text + ".z"), cfg.getInt(player.getUniqueId().toString() + "." + text + ".yaw"), cfg.getInt(player.getUniqueId().toString() + "." + text + ".pitch"), Server.getInstance().getLevelByName(cfg.getString(player.getUniqueId().toString() + "." + text + ".world"))));
                        player.sendMessage(utils.getPREFIX() + "§7Du wurdest zu deinem Home §b" + text + " §7teleportiert!");
                        }, 40);
                } else if(title.equals(utils.getPREFIX() + "Job wählen")) {
                    if(text.equals("Minenarbeiter")) {
                        FormWindowModal modal = new FormWindowModal(utils.getPREFIX() + "Job bestätigen", "§fMinenarbeiter \n§7Als Minenarbeiter musst du §bSteine§7,\n§bErze §7oder §bEdelsteine §7abbauen, um \n§7eine §bVergütung §7zu erhalten", "§a§lJob Annehmen", "§c§lZurück");
                        player.showFormWindow(modal);
                    } else if(text.equals("Holzfäller")) {
                        FormWindowModal modal = new FormWindowModal(utils.getPREFIX() + "Job bestätigen", "§fHolzfäller \n§7Als Holzfäller musst du §bHolz§7 abbauen,\n §7um eine §bVergütung §7zu erhalten", "§a§lJob Annehmen", "§c§lZurück");
                        player.showFormWindow(modal);
                    } else if(text.equals("Gräber")) {
                        FormWindowModal modal = new FormWindowModal(utils.getPREFIX() + "Job bestätigen", "§fGräber \n§7Als §bGräber musst du §bErde§7,\n§bKies §7oder §bSand §7abbauen, um \n§7eine §bVergütung §7zu erhalten", "§a§lJob Annehmen", "§c§lZurück");
                        player.showFormWindow(modal);
                    }
                } else if(title.equals(utils.getPREFIX() + "Job Menü")) {
                    if(text.equals("§bJob verlassen")) {
                        FormWindowModal formWindowModal = new FormWindowModal(utils.getPREFIX() + "§7Job verlassen", "          §cAchtung: Level geht verloren", "§a§lJob verlassen bestätigen", "§c§lSchließen");
                        event.getPlayer().showFormWindow(formWindowModal);
                    } else if(text.equals("§bJob Info")) {
                        String playerJob = job.getJob(event.getPlayer().getUniqueId());

                        if(playerJob.equals("Minenarbeiter")) {
                            FormWindowModal formWindowModal = new FormWindowModal(utils.getPREFIX() + "§7Info", "§fMinenarbeiter \n§7Als Minenarbeiter musst du §bSteine§7,\n§bErze §7oder §bEdelsteine §7abbauen, um \n§7eine §bVergütung §7zu erhalten", "§c§lZurück", "§4§lSchließen");
                            event.getPlayer().showFormWindow(formWindowModal);
                        } else if(playerJob.equals("Holzfäller")) {
                            FormWindowModal formWindowModal = new FormWindowModal(utils.getPREFIX() + "§7Info", "§fHolzfäller \n§7Als Holzfäller musst du §bHolz§7 abbauen,\n §7um eine §bVergütung §7zu erhalten", "§c§lZurück", "§4§lSchließen");
                            event.getPlayer().showFormWindow(formWindowModal);
                        } else if(playerJob.equals("Gräber")) {
                            FormWindowModal formWindowModal = new FormWindowModal(utils.getPREFIX() + "§7Info", "§fGräber \n§7Als §bGräber musst du §bErde§7,\n§bKies §7oder §bSand §7abbauen, um \n§7eine §bVergütung §7zu erhalten", "§c§lZurück", "§4§lSchließen");
                            event.getPlayer().showFormWindow(formWindowModal);
                        }
                    } else if(text.equals("§bDetails")) {
                        FormWindowModal formWindowModal = new FormWindowModal(utils.getPREFIX() + "§7Info", "§7XP: §b" + job.getExperience(player.getUniqueId()) + "/" + Utils.countMaxExperience(job.getJob(player.getUniqueId()), job.getLevel(player.getUniqueId())) + "\n§7Level: §b" + job.getLevel(player.getUniqueId()) + "\n§7Geld/Tätigkeit: §b" + (1 * (job.getLevel(player.getUniqueId()))) + "§7$", "§c§lZurück", "§4§lSchließen");
                        event.getPlayer().showFormWindow(formWindowModal);
                    }
                }
            }
        } else if(event.getWindow() instanceof FormWindowModal) {
            if (event.getResponse() instanceof FormResponseModal) {
                Utils utils = CityBuild.getInstance().getUtils();
                FormWindowModal formwindow = (FormWindowModal) event.getWindow();
                String title = formwindow.getTitle();
                String text = formwindow.getResponse().getClickedButtonText();
                String content = formwindow.getContent();
                JobManager jobManager = CityBuild.getInstance().getJobManager();

                if(content.contains("§fMinenarbeiter")) {
                    if(text.equals("§a§lJob Annehmen")) {
                        job.setJob(event.getPlayer().getUniqueId(), "Minenarbeiter");

                        event.getPlayer().sendMessage(utils.getPREFIX() + "Du hast deinen Job erfolgreich geändert");
                    } else if(text.equals("§c§lZurück")) {
                        jobManager.openOverview(event.getPlayer());
                    }
                } else if(content.contains("§fHolzfäller")) {
                    if(text.equals("§a§lJob Annehmen")) {
                        job.setJob(event.getPlayer().getUniqueId(), "Holzfäller");

                        event.getPlayer().sendMessage(utils.getPREFIX() + "Du hast deinen Job erfolgreich geändert");
                    } else if(text.equals("§c§lZurück")) {
                        jobManager.openOverview(event.getPlayer());
                    }
                } else if(content.contains("§fGräber")) {
                    if(text.equals("§a§lJob Annehmen")) {
                        job.setJob(event.getPlayer().getUniqueId(), "Gräber");

                        event.getPlayer().sendMessage(utils.getPREFIX() + "Du hast deinen Job erfolgreich geändert");
                    } else if(text.equals("§c§lZurück")) {
                        jobManager.openOverview(event.getPlayer());
                    }
                } else if(title.equals(utils.getPREFIX() + "§7Job verlassen")) {
                    if(text.equals("§a§lJob verlassen bestätigen")) {
                        job.setJob(event.getPlayer().getUniqueId(), "NONE");
                        event.getPlayer().sendMessage(utils.getPREFIX() + "Du hast deinen jetzigen Job §bverlassen");
                    }
                } else if(title.equals(utils.getPREFIX() + "§7Info")) {
                    if(text.equals("§4§lSchließen")) {
                        jobManager.openOverview(event.getPlayer());
                    }
                }
            }
        }
    }
}
