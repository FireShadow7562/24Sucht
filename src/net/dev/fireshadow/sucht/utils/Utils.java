package net.dev.fireshadow.sucht.utils;

public class Utils {

    private String PREFIX = "§9§l24SUCHT§r §8» §7";

    public static int countMaxExperience(String job, int level) {
        if(job.equals("Minenarbeiter")) {
            return 2000 * level / 2;
        } if(job.equals("Holzfäller")) {
            return 2000 * level / 2;
        } if(job.equals("Gräber")) {
            return 2000 * level / 2;
        }
        return 0;
    }

    public String getPREFIX() {
        return PREFIX;
    }

    public String getNoPerms(String perm) {
        return "§cDu darfst diesen Befehl nicht nutzen.\n(" + perm + ")";
    }

    public String getNotEnoughMoney() {
        return "§cDu hast nicht genug Geld!";
    }

    public String getPlayerIsNotOnline(String name) {
        System.out.println(getPREFIX());
        System.out.println(name);
        return getPREFIX() + "§cFehler: Spieler " + name + " ist nicht online!";
    }
}
