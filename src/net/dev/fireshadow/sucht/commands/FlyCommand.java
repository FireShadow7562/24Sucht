package net.dev.fireshadow.sucht.commands;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class FlyCommand extends Command {

    public FlyCommand(String name) {
        super(name);
    }

    private List<Player> fly = new ArrayList<>();

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                if(fly.contains(player)) {
                    fly.remove(player);

                    player.sendMessage(utils.getPREFIX() + "Flugmodus: §caus.");
                    player.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, false);
                    player.setAllowFlight(false);
                    player.getAdventureSettings().update();
                } else {
                    if(player.hasPermission("iw24essentials.commands.fly")) {
                        fly.add(player);

                        player.sendMessage(utils.getPREFIX() + "Flugmodus: §aan.");
                        player.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, true);
                        player.setAllowFlight(true);
                        player.getAdventureSettings().update();
                    } else {
                        player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.fly"));
                    }
                }
            } else if(args.length == 1) {
                Player target = Server.getInstance().getPlayer(args[0]);

                if(target != null) {
                    if(fly.contains(target)) {
                        fly.remove(target);

                        target.sendMessage(utils.getPREFIX() + "Flugmodus: §caus.");
                        player.sendMessage(utils.getPREFIX() + "Flugmodus für " + target.getName() + " §caus");
                        target.setAllowFlight(false);
                        target.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, false);
                        target.getAdventureSettings().update();
                    } else {
                        if(player.hasPermission("iw24essentials.commands.fly")) {
                            fly.add(target);

                            target.sendMessage(utils.getPREFIX() + "Flugmodus: §aan.");
                            player.sendMessage(utils.getPREFIX() + "Flugmodus für " + target.getName() + " §aan");
                            target.setAllowFlight(true);
                            target.getAdventureSettings().set(AdventureSettings.Type.ALLOW_FLIGHT, true);
                            target.getAdventureSettings().update();
                        } else {
                            player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.fly"));
                        }
                    }
                } else {
                    player.sendMessage(utils.getPlayerIsNotOnline(args[0]));
                }
            }
        }
        return true;
    }
}
