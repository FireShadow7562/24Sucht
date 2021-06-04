package net.dev.fireshadow.sucht.money;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

public class MoneyCommand extends Command {

    public MoneyCommand(String name) {
        super(name);
    }

    Money money = CityBuild.getInstance().getMoney();

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(utils.getPREFIX() + "§7Dein Kontostand: §b" + money.getMoney(player.getUniqueId()) + "§7$");
            } else if(args.length == 1) {
                if(player.hasPermission("iw24essentials.commands.money.target")) {
                    Player target = Server.getInstance().getPlayer(args[0]);

                    if(target != null) {
                        player.sendMessage(utils.getPREFIX() + target.getName() + "'s Kontostand: §b" + money.getMoney(target.getUniqueId()) + "§7$");
                    } else {
                        player.sendMessage(utils.getPlayerIsNotOnline(args[0]));
                    }
                } else {
                    player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.money.target"));
                }
            }
        }
        return true;
    }
}
