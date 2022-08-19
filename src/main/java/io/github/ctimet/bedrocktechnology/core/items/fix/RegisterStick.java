package io.github.ctimet.bedrocktechnology.core.items.fix;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;
import io.github.ctimet.bedrocktechnology.data.PlayerBlock;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.ctimet.bedrocktechnology.log.Color;
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
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Optional;

public class RegisterStick extends SlimefunItem {
    public RegisterStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) RegisterStick::onClick);
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

        SlimefunItem item = BlockStorage.check(block);

        if (item == null) {
            chat.sendWarn("不可注册非Slimefun方块，这没有任何意义");
            event.cancel();
            return;
        }

        if (StickData.contains(xyz)) {
            chat.sendWarn("哦不，这个方块已经被注册了呢");
            event.cancel();
            return;
        }

        StickData.putBlockData(xyz, new PlayerBlock(player.getUniqueId(), item.getId()));

        chat.sendInfo("注册成功，成功注册sf方块");
        chat.sendMessageWithoutHead("x = " + location.getX(), Color.LIGHT_BLUE);
        chat.sendMessageWithoutHead("y = " + location.getY(), Color.LIGHT_BLUE);
        chat.sendMessageWithoutHead("z = " + location.getZ(), Color.LIGHT_BLUE);
        chat.sendMessageWithoutHead("SlimefunId = " + item.getId(), Color.LIGHT_BLUE);
        event.cancel();
    }
}
