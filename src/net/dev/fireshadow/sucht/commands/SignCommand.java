package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SignCommand extends Command {

    public SignCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("iw24essentials.commands.sign.text")) {
                if(args.length == 0) {
                    Item item = player.getInventory().getItemInHand();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    String sign = "§7Signiert von §c" + player.getName() + " §7am " + sdf.format(new Date());

                    if(item.getId() != 0) {
                        Item is = item.setLore(new String[] { "" + sign.replace("&", "§") });
                        player.getInventory().setItemInHand(is);

                        player.sendMessage(utils.getPREFIX() + "Das Item wurde signiert.");
                    } else {
                        player.sendMessage(utils.getPREFIX() + "§cFehler: Du musst ein Item in deiner Hand halten!");
                    }
                }
            } else {
                player.sendMessage(utils.getPREFIX() + utils.getNoPerms("iw24essentials.commands.sign.text"));
            }
        }
        return true;
    }
}
