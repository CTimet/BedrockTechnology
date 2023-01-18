package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;
import java.util.UUID;

public class AreaRegisterStick extends SlimefunItem {
    public AreaRegisterStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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

        if (StickData.isNotReadFinish()) {
            event.getPlayer().sendMessage(StickData.getMessage());
            return;
        }

        Optional<Block> b = event.getClickedBlock();
        Block block;
        if (b.isPresent()) {
            block = b.get();
        } else return;

        int centerX = block.getX();
        int centerY = block.getY();
        int centerZ = block.getZ();

        //centerX与centerY与centerZ同时执行加操作，使整个坐标系最终点位移
        int x = centerX + 4;
        int y = centerY + 4;
        int z = centerZ + 4;

        World world = block.getWorld();
        Block waitRegister;
        UUID uuid = event.getPlayer().getUniqueId();
        SlimefunItem sfItem;
        for (int i = 0; i < 9; i ++) {
            for (int i1 = 0; i1 < 9; i1 ++) {
                for (int i2 = 0; i2 < 9; i2 ++) {
                    waitRegister = world.getBlockAt(x, y, z);
//                    RegisterStick.registerBlock(event.getPlayer(), waitRegister);
                    sfItem = BlockStorage.check(waitRegister);
                    if (sfItem != null //确认为Slimefun方块
                            && !StickData.containsRefuseID(sfItem.getId()) //确认该方块可以被注册
                            && !StickData.isNotReadFinish() //确认系统准备完毕
                            && !StickData.containsData(waitRegister.getLocation()) /*确认该方块未被注册*/) {
                        StickData.putData(uuid, waitRegister.getLocation());
                    }
                    z --;
                }
                y --;
            }
            x --;
        }
    }
}
