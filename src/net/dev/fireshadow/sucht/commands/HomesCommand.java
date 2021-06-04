package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.Config;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

import java.io.File;

public class HomesCommand extends Command {

    public HomesCommand(String name) {
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
                    simple.addButton(new ElementButton(home, new ElementButtonImageData("path", "textures/ui/")));
                }
                player.showFormWindow(simple);
            }
        }
        return true;
    }
}
