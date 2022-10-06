package io.github.ctimet.bedrocktechnology.core.listener;

import io.github.ctimet.bedrocktechnology.core.items.code.fix.RegisterStick;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AutoRegisterListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (BlockStorage.check(event.getBlock()) != null)
            RegisterStick.registerBlock(event.getPlayer(), event.getBlock());
    }
}
