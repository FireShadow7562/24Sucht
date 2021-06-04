package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

public class ClearCommand extends Command {

    public ClearCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                if(player.hasPermission("iw24essentials.commands.clear")) {
                    player.getInventory().clearAll();
                    player.sendMessage(utils.getPREFIX() + "§7Inventar: §bgeleert.");
                } else {
                    player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.clear"));
                }
            }
        }
        return true;
    }
}

