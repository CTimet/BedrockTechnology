package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.ctimet.bedrocktechnology.util.Log;
import io.github.ctimet.bedrocktechnology.util.PlayerChat;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
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
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OwnerRegisterStick extends SlimefunItem {
    public OwnerRegisterStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) this::onClick);
    }

    private void onClick(PlayerRightClickEvent event) {
        event.cancel();

        Player player = event.getPlayer();
        String owner = checkOwner(player, event.getItem());

        Optional<Block> b = event.getClickedBlock();
        Block block;
        if (b.isPresent()) {
            block = b.get();
        } else {
            return;
        }

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
            StickData.putData(UUID.fromString(owner), location);
            chat.sendInfo("方块已成功注册");
        }
    }

    public static String checkOwner(Player player, ItemStack item) {
        String owner = null;
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            throw new IllegalArgumentException("Meta不应该为null!该异常不应该被抛出！");
        }
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new LinkedList<>();
        } else {
            for (String l : lore) {
                if (l.startsWith("ID:")) {
                    owner = l.substring(3);
                }
            }
        }

        if (owner == null) {
            owner = player.getUniqueId().toString();

            lore.add("\n");
            lore.add("ID:" + owner);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }

        return owner;
    }

    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        if (BektMain.getCfg().getBoolean("mysql.enabled"))
            super.register(addon);
        else
            Log.warn("检测到未启用数据库保存，物品\"拥有者-注册棒\"将不会被注册");
    }
}
