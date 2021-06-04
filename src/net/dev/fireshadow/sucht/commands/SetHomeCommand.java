package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.Config;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

import java.io.File;

public class SetHomeCommand extends Command {

    public SetHomeCommand(String name) {
        super(name);
    }

    private Config cfg = new Config(new File(CityBuild.getInstance().getDataFolder(), "homes.yml"));

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 1) {
                if(args.length <= 15) {
                    cfg.reload();

                    int currentHomes = cfg.getSection(player.getUniqueId().toString()).getKeys(false).size();

                    if(currentHomes < getMax(player)) {
                        String world = player.getLevel().getName();
                        double x = player.getLocation().getX();
                        double y = player.getLocation().getY();
                        double z = player.getLocation().getZ();
                        double yaw = player.getLocation().getYaw();
                        double pitch = player.getLocation().getPitch();
                        cfg.set(player.getUniqueId().toString() + "." + args[0] + ".world", world);
                        cfg.set(player.getUniqueId().toString() + "." + args[0] + ".x", x);
                        cfg.set(player.getUniqueId().toString() + "." + args[0] + ".y", y);
                        cfg.set(player.getUniqueId().toString() + "." + args[0] + ".z", z);
                        cfg.set(player.getUniqueId().toString() + "." + args[0] + ".yaw", yaw);
                        cfg.set(player.getUniqueId().toString() + "." + args[0] + ".pitch", pitch);
                        cfg.save();
                        player.sendMessage(utils.getPREFIX() + "Dein Home §b" + args[0] + " wurde erstellt!");
                    }
                }
            }
        }
        return true;
    }

    public int getMax(Player player) {
        if (player.hasPermission("iw24essentials.commands.home.bypass"))
            return Integer.MAX_VALUE;
        for (int i = 0; i < 50; i++) {
            if (player.hasPermission("iw24essentials.commands.homes." + i))
                return i;
        }
        return 0;
    }
}
