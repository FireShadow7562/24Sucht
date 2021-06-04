package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

public class FeedCommand extends Command {

    public FeedCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                if(player.hasPermission("iw24essentials.commands.feed")) {
                    player.getFoodData().setFoodSaturationLevel(20);
                    player.sendMessage(utils.getPREFIX() + "Du hast nun kein Hunger mehr");
                } else {
                    player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.feed"));
                }
            } else {
                Player target = Server.getInstance().getPlayer(args[0]);

                if(target != null) {
                    if(player.hasPermission("iw24essentials.commands.feed.other")) {
                        target.getFoodData().setFoodSaturationLevel(20);
                        target.sendMessage(utils.getPREFIX() + "Du hast nun kein Hunger mehr");
                    } else {
                        player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.feed.other"));
                    }
                } else {
                    player.sendMessage(utils.getPlayerIsNotOnline(args[0]));
                }
            }
        }
        return true;
    }
}
