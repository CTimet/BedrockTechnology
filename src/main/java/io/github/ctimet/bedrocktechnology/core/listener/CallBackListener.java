package io.github.ctimet.bedrocktechnology.core.listener;

import io.github.ctimet.bedrocktechnology.plugin.callback.CallBack;
import io.github.ctimet.bedrocktechnology.plugin.callback.type.EventEnum;
import io.github.ctimet.bedrocktechnology.plugin.callback.type.Type;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class CallBackListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        CallBack.callEvent(new Type(EventEnum.PLAYER_CHAT, event.getPlayer().getUniqueId()), event);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        CallBack.callEvent(new Type(EventEnum.PLAYER_MOVE, event.getPlayer().getUniqueId()), event);
    }
}
