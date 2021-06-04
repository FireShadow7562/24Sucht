package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

public class ScaleCommand extends Command {

    public ScaleCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                if(player.hasPermission("iw24essentials.commands.scale")) {
                    FormWindowSimple simple = new FormWindowSimple(utils.getPREFIX() + "§7Größe", "");
                    simple.addButton(new ElementButton("Rießig"));
                    simple.addButton(new ElementButton("Groß"));
                    simple.addButton(new ElementButton("Normal"));
                    simple.addButton(new ElementButton("Klein"));
                    simple.addButton(new ElementButton("Winzig"));
                    player.showFormWindow(simple);
                } else {
                    player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.scale"));
                }
            }
        }
        return true;
    }
}
