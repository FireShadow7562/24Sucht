package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

public class HealCommand extends Command {

    public HealCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                if(player.hasPermission("iw24essentials.commands.heal")) {
                    player.setHealth(20);
                    player.sendMessage(utils.getPREFIX() + "Du wurdest geheilt");
                } else {
                    player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.heal"));
                }
            } else {
                Player target = Server.getInstance().getPlayer(args[0]);

                if(target != null) {
                    if(player.hasPermission("iw24essentials.commands.heal.other")) {
                        target.setHealth(20);
                        target.sendMessage(utils.getPREFIX() + "Du wurdest geheilt");
                    } else {
                        player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.heal.other"));
                    }
                } else {
                    player.sendMessage(utils.getPlayerIsNotOnline(args[0]));
                }
            }
        }
        return true;
    }
}
