package io.github.ctimet.bedrocktechnology.core.items.fix;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class RegisterStick extends SlimefunItem {
    public RegisterStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) e -> onClick(e.getInteractEvent()));
    }

    private static void onClick(PlayerInteractEvent event) {
        Action action = event.getAction();

        if (action == Action.LEFT_CLICK_AIR ||
                action == Action.RIGHT_CLICK_AIR||
                action == Action.RIGHT_CLICK_BLOCK)
            return;

        Chat chat = new Chat(event.getPlayer());

        if (StickData.isNotReadFinish()) {
            chat.sendWarn("数据修复系统未完成读取");
            chat.sendWarn("当前读取状态: " + StickData.getReadSituation());
            return;
        }

        Block block = event.getClickedBlock();

        if (block == null) return;

        Location location = block.getLocation();

        String xyz = location.getX()
                + "&" + location.getY()
                + "&" + location.getZ()
                + "&" + Objects.requireNonNull(location.getWorld()).getName();

        if (BlockStorage.check(block) == null) {
            chat.sendWarn("不可注册非Slimefun方块，这没有任何意义");
            return;
        }

        StickData.putBlockData(xyz, block.getBlockData());

        event.setCancelled(true);
    }
}
