package io.github.ctimet.bedrocktechnology.core.event;

import io.github.ctimet.bedrocktechnology.core.items.network.ItemRecipeShow;
import io.github.ctimet.bedrocktechnology.log.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;

public class InventoryProtectEvent implements Listener {
    private static final HashSet<Player> RECIPE = new HashSet<>();
    private static final HashSet<Player> COUNT = new HashSet<>();
    @EventHandler
    public void onClickOnInv(InventoryClickEvent event) {
        String invTitle = event.getWhoClicked().getOpenInventory().getTitle();
        if (invTitle.contains("物品") && invTitle.contains("的配方")) {
            event.setCancelled(true);
        } else if (invTitle.equals("§6查找配方")) {
            event.setCancelled(true);
            int slot = event.getSlot();
            if (slot == 3) {
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().sendMessage(Color.YELLOW + "请输入要查询的物品名称 >>");
                addWaitForRecipe((Player) event.getWhoClicked());
            } else if (slot == 5) {
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().sendMessage(Color.YELLOW + "请输入要统计配方的物品 >>");
                addWaitForCount((Player) event.getWhoClicked());
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (RECIPE.remove(event.getPlayer())) {
            String message = event.getMessage();
            ItemRecipeShow.showRecipe(event.getPlayer(), message);
            event.setCancelled(true);
        } else if (COUNT.remove(event.getPlayer())) {
            String message = event.getMessage();
            ItemRecipeShow.countRecipe(event.getPlayer(), message);
            event.setCancelled(true);
        }
    }

    public static void addWaitForRecipe(Player p) {
        RECIPE.add(p);
    }

    public static void addWaitForCount(Player p) {
        COUNT.add(p);
    }
}
