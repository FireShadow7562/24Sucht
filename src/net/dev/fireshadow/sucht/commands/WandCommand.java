package net.dev.fireshadow.sucht.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.utils.Utils;

public class WandCommand extends Command {

    public WandCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Utils utils = CityBuild.getInstance().getUtils();

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                FormWindowSimple simple = new FormWindowSimple(utils.getPREFIX() + "§bPlot-Wand", utils.getPREFIX() + "§bWähle eine Plot-Wand aus!");
                simple.addButton(new ElementButton("§8Steinziegel \nSpieler", new ElementButtonImageData("path", "textures/blocks/stonebrick.png")));
                simple.addButton(new ElementButton("§8Endsteinziegel \n§dPremium", new ElementButtonImageData("path", "textures/blocks/end_bricks.png")));
                simple.addButton(new ElementButton("§8Polierter Granit \n§dPremium", new ElementButtonImageData("path", "textures/blocks/stone_granite_smooth.png")));
                simple.addButton(new ElementButton("§8Polierter Diorit \n§dPremium", new ElementButtonImageData("path", "textures/blocks/stone_diorite_smooth.png")));
                simple.addButton(new ElementButton("§8Polierter Andesit \n§dPremium", new ElementButtonImageData("path", "textures/blocks/stone_andesite_smooth.png")));
                simple.addButton(new ElementButton("§8Prismarienziegel \n§bObsidian", new ElementButtonImageData("path", "textures/blocks/prismarine_bricks.png")));
                simple.addButton(new ElementButton("§8Sandstein \n§bObsidian", new ElementButtonImageData("path", "textures/blocks/sandstone_normal.png")));
                simple.addButton(new ElementButton("§8Gemeißelter Sandstein \n§bObsidian", new ElementButtonImageData("path", "textures/blocks/sandstone_carved.png")));
                simple.addButton(new ElementButton("§8Geschnittener Sandstein \n§bObsidian", new ElementButtonImageData("path", "textures/blocks/sandstone_smooth.png")));
                simple.addButton(new ElementButton("§8Glatter Sandstein \n§bObsidian", new ElementButtonImageData("path", "textures/blocks/sandstone_top.png")));
                simple.addButton(new ElementButton("§8Roter Sandstein \n§bObsidian", new ElementButtonImageData("path", "textures/blocks/red_sandstone_normal.png")));
                simple.addButton(new ElementButton("§8Gemeißelter roter Sandstein \n§bObsidian", new ElementButtonImageData("path", "textures/blocks/red_sandstone_carved.png")));
                simple.addButton(new ElementButton("§8Geschnittener Roter Sandstein\n§bObsidian", new ElementButtonImageData("path", "textures/blocks/red_sandstone_smooth.png")));
                simple.addButton(new ElementButton("§8Glatter Roter Sandstein \n§bObsidian", new ElementButtonImageData("path", "textures/blocks/red_sandstone_top.png")));
                simple.addButton(new ElementButton("§8Weißer Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_white.png")));
                simple.addButton(new ElementButton("§8Oranger Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_orange.png")));
                simple.addButton(new ElementButton("§8Magenta Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_magenta.png")));
                simple.addButton(new ElementButton("§8Hellblauer Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_light_blue.png")));
                simple.addButton(new ElementButton("§8Gelber Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_yellow.png")));
                simple.addButton(new ElementButton("§8Hellgrüner Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_lime.png")));
                simple.addButton(new ElementButton("§8Rosa Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_pink.png")));
                simple.addButton(new ElementButton("§8Grauer Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_gray.png")));
                simple.addButton(new ElementButton("§8Hellgrauer Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_silver.png")));
                simple.addButton(new ElementButton("§8Türkiser Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_cyan.png")));
                simple.addButton(new ElementButton("§8Violetter Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_purple.png")));
                simple.addButton(new ElementButton("§8Blauer Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_blue.png")));
                simple.addButton(new ElementButton("§8Brauner Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_brown.png")));
                simple.addButton(new ElementButton("§8Grüner Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_green.png")));
                simple.addButton(new ElementButton("§8Roter Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_red.png")));
                simple.addButton(new ElementButton("§8Schwarzer Beton \n§3§lPRIME", new ElementButtonImageData("path", "textures/blocks/concrete_black.png")));
                simple.addButton(new ElementButton("§8Kohleblock \n§9§lULTIMATE", new ElementButtonImageData("path", "textures/blocks/coal_block.png")));
                simple.addButton(new ElementButton("§8Lapislazuliblock \n§9§lULTIMATE", new ElementButtonImageData("path", "textures/blocks/lapis_block.png")));
                simple.addButton(new ElementButton("§8Eisenblock \n§9§lULTIMATE", new ElementButtonImageData("path", "textures/blocks/iron_block.png")));
                simple.addButton(new ElementButton("§8Goldblock \n§9§lULTIMATE", new ElementButtonImageData("path", "textures/blocks/gold_block.png")));
                simple.addButton(new ElementButton("§8Diamantblock \n§9§lULTIMATE", new ElementButtonImageData("path", "textures/blocks/diamond_block.png")));
                simple.addButton(new ElementButton("§8Smaragdblock \n§9§lULTIMATE", new ElementButtonImageData("path", "textures/blocks/emerald_block.png")));
                player.showFormWindow(simple);
            }
        }
        return true;
    }
}
