package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.core.chat.PlayerChat;
import io.github.ctimet.bedrocktechnology.data.stickdata.StickData;
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

import java.util.Objects;
import java.util.Optional;

public class FixStick extends SlimefunItem {
    public FixStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) FixStick::onClick);
    }

    private static void onClick(PlayerRightClickEvent event) {
        event.cancel();
        Optional<Block> b = event.getClickedBlock();
        Block block;
        if (b.isPresent()) {
            block = b.get();
        } else return;

        PlayerChat chat = new PlayerChat(event.getPlayer(), true);

        if (BlockStorage.check(block) != null) {
            chat.sendWarn("插件认为该方块未损坏，不可修复！");
            return;
        }

        if (StickData.isNotReadFinish()) {
            chat.sendWarn("抱歉，注册修复系统暂时没有读取完数据。待读取完再进行注册操作吧");
            return;
        }

        Location location = block.getLocation();

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + Objects.requireNonNull(location.getWorld()).getName();

        String json = StickData.getData(xyz);
        if (json != null) {
            BlockStorage.setBlockInfo(block, json, true);
            StickData.removeData(xyz);
            chat.sendInfo("方块已被修复");
        } else {
            chat.sendErr("该方块未被注册，不可修复！");
        }
    }
}
