package io.github.ctimet.bedrocktechnology.core.items.group;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;

public class BItemGroup {
    public static final ItemGroup MACHINE_PROTECT = new SubGroup(BektMain.createNamespacedKey("BEKT_MACHINE_PROTECT"), new CustomItemStack(Material.COMMAND_BLOCK, "&lBEKT &7- &a机器保护"));
    public static final ItemGroup EXPAND_PLAY_CHEAT = new SubGroup(BektMain.createNamespacedKey("BEKT_EXPAND_PLAY_CHEAT"), new CustomItemStack(Material.ANVIL, "&lBEKT &7- &5拓展玩法（作弊模式）"));
    public static final ExpandPlayItemGroup EXPAND_PLAY_ITEM = new ExpandPlayItemGroup(BektMain.createNamespacedKey("BEKT_EXPAND_PLAY_ITEM"), new CustomItemStack(Material.FURNACE, "&lBEKT &7- &5拓展玩法 (这个ItemGroup不应该被显示)"));
    public static final ItemGroup EXPAND_PLAY = new ExpandPlayGroup(BektMain.createNamespacedKey("BEKT_EXPAND_PLAY"), new CustomItemStack(Material.ANVIL, "&lBEKT &7- &5拓展玩法"));
    public static final ItemGroup BASE_ITEM = new SubGroup(BektMain.createNamespacedKey("BEKT_BASE_ITEM"), new CustomItemStack(Material.FURNACE, "&lBEKT &7- &5基础物品"));
    private static final MainItemGroup MAIN_GROUP = new MainItemGroup(
            BektMain.createNamespacedKey("BEKT_MAIN_GROUP"),
            new CustomItemStack(Material.BEDROCK, "&lBEKT &7- &b基岩科技"),
            BASE_ITEM, MACHINE_PROTECT, EXPAND_PLAY
    );

    public static void registerGroup() {
        MAIN_GROUP.register(BektMain.getInstance());
        EXPAND_PLAY_ITEM.register(BektMain.getInstance());
    }
}
