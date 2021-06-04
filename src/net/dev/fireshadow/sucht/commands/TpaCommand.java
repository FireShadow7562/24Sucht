package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

import java.util.HashMap;

public class TpaCommand extends Command {

    public TpaCommand(String name) {
        super(name);
    }

    public static HashMap<Player, Player> tpaRequest = new HashMap<>();

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(utils.getPREFIX() + "§7/tpa <Spieler>");
            } else if(args.length == 1) {
                Player target = Server.getInstance().getPlayer(args[0]);

                if(target != null) {
                    tpaRequest.put(target, player);
                    player.sendMessage(utils.getPREFIX() + "Du hast die Teleportations-Anfrage versendet.");
                    target.sendMessage(utils.getPREFIX() + "§b" +  player.getName() + "möchte sich zu dir teleportieren.");
                    target.sendMessage(utils.getPREFIX() + "Akzeptiere die Anfrage mit §b/tpaccept " + player.getName() + "§7 oder lehne sie mit §b/tpadeny " + target.getName() + "§7 ab:");
                    target.sendMessage(utils.getPREFIX() + "Die Anfrage wird in §b60 Sekunden §7ungültig.");

                    Server.getInstance().getScheduler().scheduleDelayedTask(() -> {
                        tpaRequest.remove(target, player);
                    }, 20 * 60);
                } else {
                    player.sendMessage(utils.getPlayerIsNotOnline(args[0]));
                }
            }
        }
        return true;
    }
}
