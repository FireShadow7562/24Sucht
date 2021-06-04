package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class HelpCommand extends Command {

    public HelpCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage("§8«== §9§l24SUCHT§r §8==§8»");
                player.sendMessage("§8» §b/p auto §7| §7Hole dir ein Grundstück");
                player.sendMessage("§8» §b/p trust <Name> §7| §7Vertraue einem Spieler");
                player.sendMessage("§8» §b/feed §7| §7Füttere dich");
                player.sendMessage("§8» §b/heal §7| §7Heile dich");
                player.sendMessage("§8» §b/scale §7| §7Verändere deine Größe.");
                player.sendMessage("§bNächste Seite §8| §7/help §b2");
                player.sendMessage("§8«== §9§l24SUCHT§r §8==§8»");
            } else {
                if(args[0].equals("2")) {
                    player.sendMessage("§8«== §9§l24SUCHT§r §8==§8»");
                    player.sendMessage("§8» §b/sethome §7| §7Setze dir ein Home");
                    player.sendMessage("§8» §b/home §8(§7Name§8) §7| §7Komme zu deinem ersten Home");
                    player.sendMessage("§8» §b/sign §7| §7Signiere ein Item");
                    player.sendMessage("§8» §b/wand §7| §7Ändere deine Plot-Wand");
                    player.sendMessage("§8» §b/rand §7| §7Ändere deinen Plot-Rand.");
                    player.sendMessage("§8» §b/job §7| §7Ändere deinen Plot-Rand.");
                    player.sendMessage("§8«== §9§l24SUCHT§r §8==§8»");
                }
            }
        }
        return true;
    }
}
