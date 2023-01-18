package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.ctimet.bedrocktechnology.util.PlayerChat;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class FixStick extends SlimefunItem {
    public FixStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) e -> {
            try {
                onClick(e);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void onClick(PlayerRightClickEvent event) {
        event.cancel();
        Optional<Block> b = event.getClickedBlock();
        Block block;
        if (b.isPresent()) {
            block = b.get();
        } else {
            return;
        }

        PlayerChat chat = new PlayerChat(event.getPlayer(), true);

        if (BlockStorage.check(block) != null) {
            chat.sendWarn("插件认为该方块未损坏，不可修复！");
            return;
        }

        if (StickData.isNotReadFinish()) {
            chat.sendWarn(StickData.getMessage());
            return;
        }

        if (!StickData.containsData(block.getLocation())) {
            chat.sendWarn("抱歉，该方块未经注册，无法修复");
            return;
        }

        if (fixBlock(block.getLocation())) {
            chat.sendInfo("方块已被修复");
        } else {
            chat.sendWarn("由于某种原因，方块无法修复");
        }
    }

    public static boolean fixBlock(Location location) {
        if (BlockStorage.check(location) == null) {
            String data = StickData.getData(location);
            if (data == null) return false;
            BlockStorage.setBlockInfo(location, data, true);
            return true;
        } else {
            return false;
        }
    }
}
