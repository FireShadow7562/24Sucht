package net.dev.fireshadow.sucht.money;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.events.MoneyAddEvent;
import net.dev.fireshadow.sucht.utils.Utils;

public class PayCommand extends Command {

    public PayCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage("Usage: /pay <Name> <Amount>");
            } else if(args.length == 2) {
                Player target = Server.getInstance().getPlayer(args[0]);
                int amount = Integer.parseInt(args[1]);

                if(target != null) {
                    Money money = CityBuild.getInstance().getMoney();

                    if(money.hasMoney(player.getUniqueId(), amount)) {
                        money.removeMoney(player.getUniqueId(), amount);
                        money.addMoney(target.getUniqueId(), amount);
                        player.sendMessage(utils.getPREFIX() + "Du hast §b" + target.getName() + amount + "§7$ gegeben.");
                        target.sendMessage(utils.getPREFIX() + "Du hast von §b" + player.getName() + amount + "§7$ erhalten.");
                        Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(player));
                        Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(target));
                    } else {
                        player.sendMessage(utils.getPREFIX() + "§cDu hast nicht genug Geld!");
                    }
                } else if(args[0].equals("*")) {
                    if(player.hasPermission("iw24essentials.commands.money.*")) {
                        Money money = CityBuild.getInstance().getMoney();

                        if(money.hasMoney(player.getUniqueId(), amount)) {
                            money.removeMoney(player.getUniqueId(), amount);

                            for(Player all : Server.getInstance().getOnlinePlayers().values()) {
                                money.addMoney(all.getUniqueId(), amount);
                                all.sendMessage(utils.getPREFIX() + "Du hast von §b" + player.getName() + amount + "§7$ erhalten.");
                                Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(all));
                            }
                        } else {
                            player.sendMessage(utils.getPREFIX() + "§cDu hast nicht genug Geld!");
                        }
                    } else {
                        player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.money.*"));
                    }
                } else {
                    player.sendMessage(utils.getPlayerIsNotOnline(args[0]));
                }
            }
        }
        return true;
    }
}
