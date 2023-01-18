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
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class RegisterStick extends SlimefunItem {
    public RegisterStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
        } else return;

        Player player = event.getPlayer();
        registerBlock(player, block);
    }

    public static void registerBlock(Player player, Block block) {
        PlayerChat chat = new PlayerChat(player, true);
        SlimefunItem sfItem = BlockStorage.check(block);
        if (sfItem == null) {
            chat.sendWarn("不可注册非sf方块");
            return;
        } else if (StickData.containsRefuseID(sfItem.getId())) {
            chat.sendWarn("抱歉，该方块对应的物品ID被服务器管理员标记为不可注册。这可能是因为注册该物品可能会出现额外风险。具体请询问管理员。该方块不可注册");
            return;
        }

        if (StickData.isNotReadFinish()) {
            chat.sendWarn(StickData.getMessage());
            return;
        }

        Location location = block.getLocation();
        if (StickData.containsData(location)) {
            chat.sendWarn("该方块已被注册");
        } else {
            StickData.putData(player.getUniqueId(), location);
            chat.sendInfo("方块已成功注册");
        }
    }
}
