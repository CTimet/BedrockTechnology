package io.github.ctimet.bedrocktechnology.core.event;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;
import io.github.ctimet.bedrocktechnology.data.BannedData;
import io.github.ctimet.bedrocktechnology.log.Color;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class CheckBanItemEvent implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        ItemMeta meta = event.getItem().getItemMeta();
        if (meta == null) return;
        if (BannedData.contains(meta.getDisplayName())) {
            event.getPlayer().getInventory().remove(event.getItem());
            Chat chat = new Chat(event.getPlayer());
            chat.sendErr("这个物品已经废弃了！你是怎么得到它的？？？");
        }
        if (event.getClickedBlock() != null) {
            if (BannedData.contains(event.getClickedBlock().getBlockData().getMaterial().name())) {
                event.getPlayer().sendMessage(Color.DEEP_RED + "这个方块已经废弃了！！你是怎么得到它的？！");
                event.getClickedBlock().setType(Material.AIR);
                BlockStorage.clearBlockInfo(event.getClickedBlock());
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (BannedData.contains(event.getBlock().getBlockData().getMaterial().name())) {
            event.getPlayer().sendMessage(Color.DEEP_RED + "这个方块已经废弃了！！你是怎么得到它的？！");
            event.getBlock().setType(Material.AIR);
            BlockStorage.clearBlockInfo(event.getBlock());
        }
    }
}
