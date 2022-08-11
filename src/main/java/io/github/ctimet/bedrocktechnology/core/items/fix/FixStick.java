package io.github.ctimet.bedrocktechnology.core.items.fix;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;
import io.github.ctimet.bedrocktechnology.data.PlayerBlock;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Optional;

public class FixStick extends SlimefunItem {
    public FixStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) FixStick::onClick);
    }

    private static void onClick(PlayerRightClickEvent event) {
        Player player = event.getPlayer();

        Chat chat = new Chat(player);

        if (StickData.isNotReadFinish()) {
            chat.sendWarn("数据修复系统未完成读取");
            chat.sendWarn("当前读取状态: " + StickData.getReadSituation());
            event.cancel();
            return;
        }

        Optional<Block> b = event.getClickedBlock();
        Block block;
        if (b.isPresent()) {
            block = b.get();
        } else return;

        Location location = block.getLocation();

        String xyz = location.getX()
                + "&" + location.getY()
                + "&" + location.getZ()
                + "&" + Objects.requireNonNull(location.getWorld()).getName();

        Inventory inv = player.getInventory();
        if (StickData.isInventoryFull(inv)) {
            chat.sendWarn("插件检测到您的背包已满，不可再放入新的物品，本次赔偿已取消");
            event.cancel();
            return;
        }

        PlayerBlock pb = StickData.getBlockData(xyz);
        if (pb != null) {
            if (BlockStorage.check(block) != null) {
                chat.sendWarn("插件认为该方块未损坏，不可修复");
                event.cancel();
                return;
            }
            if (player.getUniqueId().equals(pb.uuid())) {
                inv.addItem(SlimefunItem.getById(pb.id()).getItem());
                StickData.remove(xyz);
                chat.sendInfo("已赔偿物品至玩家背包，请翻看背包查找物品");
            } else {
                chat.sendWarn("这个方块不是你注册的，你不能获得赔偿");
            }
        } else {
            chat.sendWarn("该方块未被注册");
        }

        event.cancel();
    }
}
