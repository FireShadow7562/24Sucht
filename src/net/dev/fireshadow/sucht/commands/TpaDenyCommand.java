package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

public class TpaDenyCommand extends Command {

    public TpaDenyCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(utils.getPREFIX() + "Benutze: §b/tpadeny <spieler>");
            } else if(args.length == 1) {
                Player target = Server.getInstance().getPlayer(args[0]);

                if(TpaCommand.tpaRequest.containsKey(player) && TpaCommand.tpaRequest.containsValue(target)) {
                    if(target != null) {
                        TpaCommand.tpaRequest.remove(player, target);
                        player.sendMessage(utils.getPREFIX() + "§cDu hast die Teleportations-Anfrage von §b" + target.getName() + " §cabgelehnt.");
                        target.sendMessage(utils.getPREFIX() + "§cDeine Teleportations-Anfrage von §b" + player.getName() + " §cwurde abgelehnt.");
                    }
                } else {
                    player.sendMessage(utils.getPREFIX() + "§cDu hast keine Teleportations-Anfragen.");
                }
            }
        }
        return true;
    }
}
