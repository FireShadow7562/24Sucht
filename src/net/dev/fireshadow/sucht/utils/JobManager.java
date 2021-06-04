package net.dev.fireshadow.sucht.utils;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import net.dev.fireshadow.sucht.CityBuild;
import net.dev.fireshadow.sucht.sql.Job;

public class JobManager {

    public void openOverview(Player player) {
        Utils utils = CityBuild.getInstance().getUtils();
        Job job = CityBuild.getInstance().getJob();
        String playerJob = job.getJob(player.getUniqueId());

        if(playerJob.equals("NONE")) {
            FormWindowSimple simple = new FormWindowSimple(utils.getPREFIX() + "Job wählen", "");
            simple.addButton(new ElementButton("Minenarbeiter"));
            simple.addButton(new ElementButton("Holzfäller"));
            simple.addButton(new ElementButton("Gräber"));
            player.showFormWindow(simple);
        } else {
            FormWindowSimple simple = new FormWindowSimple(utils.getPREFIX() + "Job Menü", "");
            simple.addButton(new ElementButton("§bJob Info"));
            simple.addButton(new ElementButton("§bDetails"));
            simple.addButton(new ElementButton("§bJob verlassen"));
            simple.addButton(new ElementButton("§c§lSchließen"));
            player.showFormWindow(simple);
        }
    }
}
