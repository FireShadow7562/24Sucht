package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

import java.io.File;

public class HomeCommand extends Command {

    public HomeCommand(String name) {
        super(name);
    }

    private Config cfg = new Config(new File(CityBuild.getInstance().getDataFolder(), "homes.yml"));

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            cfg.reload();

            Player player = (Player) sender;

            if(args.length == 0) {
                FormWindowSimple simple = new FormWindowSimple(utils.getPREFIX() + "§7Deine Homes", "");
                for(String home : cfg.getSection(player.getUniqueId().toString()).getKeys(false)) {
                    simple.addButton(new ElementButton(home, new ElementButtonImageData("path", "textures/items/book_written.png")));
                }
                player.showFormWindow(simple);
            } else if(args.length == 1) {
                if(cfg.getSection(player.getUniqueId().toString()).getKeys(false).contains(args[0])) {
                    Location location = new Location(cfg.getDouble(player.getUniqueId().toString() + "." + args[0] + ".x"), cfg.getDouble(player.getUniqueId().toString() + "." + args[0] + ".y"), cfg.getDouble(player.getUniqueId().toString() + "." + args[0] + ".z"), cfg.getDouble(player.getUniqueId().toString() + "." + args[0] + ".yaw"), cfg.getDouble(player.getUniqueId().toString() + "." + args[0] + ".pitch"), Server.getInstance().getLevelByName(cfg.getString(player.getUniqueId().toString() + "." + args[0] + ".world")));

                    player.sendMessage(utils.getPREFIX() + "Du wirst in §b5s §7teleportiert");
                    Server.getInstance().getScheduler().scheduleDelayedTask(() -> {
                        player.teleport(location);
                        player.sendMessage(utils.getPREFIX() + "Du wurdest zu deinem Home " + args[0] + "teleportiert");
                    }, 40);
                } else {
                    player.sendMessage(utils.getPREFIX() + "§cDieses Home existiert nicht!");
                }
            }
        }
        return true;
    }
}
