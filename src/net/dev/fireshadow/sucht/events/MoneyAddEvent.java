package net.dev.fireshadow.sucht.events;

import cn.nukkit.Player;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;

public class MoneyAddEvent extends Event {

    private final Player player;

    public MoneyAddEvent(Player player) {
        this.player = player;
    }

    public static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public Player getPlayer() {
        return player;
    }
}