package net.dev.fireshadow.sucht.money;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.events.MoneyAddEvent;
import net.dev.fireshadow.sucht.utils.Utils;

public class EcoCommand extends Command {

    public EcoCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("iw24essentials.commands.admin")) {
                if(args.length == 0) {
                    player.sendMessage(utils.getPREFIX() + "Usage: §b/eco set|add|remove <Name> <Amount>");
                } else if(args.length == 3) {
                    if(args[0].equalsIgnoreCase("set")) {
                        Player target = Server.getInstance().getPlayer(args[1]);
                        int amount = Integer.parseInt(args[2]);

                        if(target != null) {
                            Money money = CityBuild.getInstance().getMoney();

                            if(amount >= 0) {
                                money.setMoney(target.getUniqueId(), amount);

                                player.sendMessage(utils.getPREFIX() + "Du hast " + target.getName() + " §b" + amount + "§7$ gesetzt.");
                                Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(target));
                            } else {
                                player.sendMessage(utils.getPREFIX() + "§cDu kannst dir kein Minus-Geld geben!");
                            }
                        } else {
                            player.sendMessage(utils.getPlayerIsNotOnline(args[1]));
                        }
                    } else if(args[0].equalsIgnoreCase("add")) {
                        Player target = Server.getInstance().getPlayer(args[1]);
                        int amount = Integer.parseInt(args[2]);

                        if(target != null) {
                            Money money = CityBuild.getInstance().getMoney();

                            money.addMoney(target.getUniqueId(), amount);
                            player.sendMessage(utils.getPREFIX() + "Du hast " + target.getName() + " §b" + amount + "§7$ hinzugefügt.");
                            Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(target));
                        } else {
                            player.sendMessage(utils.getPlayerIsNotOnline(args[1]));
                        }
                    } else if(args[0].equalsIgnoreCase("remove")) {
                        Player target = Server.getInstance().getPlayer(args[1]);
                        int amount = Integer.parseInt(args[2]);

                        if(target != null) {
                            Money money = CityBuild.getInstance().getMoney();

                            if(money.hasMoney(target.getUniqueId(), amount)) {
                                money.removeMoney(target.getUniqueId(), amount);

                                player.sendMessage(utils.getPREFIX() + "Du hast " + target.getName() + " §b" + amount + "§7$ entfernt.");
                                Server.getInstance().getPluginManager().callEvent(new MoneyAddEvent(target));
                            } else {
                                player.sendMessage(utils.getPREFIX() + "§cDu kannst diesem Spieler nicht mehr als er hat abziehen!");
                            }
                        } else {
                            player.sendMessage(utils.getPlayerIsNotOnline(args[1]));
                        }
                    }
                }
            } else {
                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.admin"));
            }
        }
        return true;
    }
}
