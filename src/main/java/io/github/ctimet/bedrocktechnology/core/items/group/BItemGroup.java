package io.github.ctimet.bedrocktechnology.core.items.group;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;

public class BItemGroup {
    public static final ItemGroup MACHINE_PROTECT = new SubGroup(BektMain.createNamespacedKey("BEKT_MACHINE_PROTECT"), new CustomItemStack(Material.COMMAND_BLOCK, "&lBEKT &7- &a机器保护"));
    public static final ItemGroup MACHINE_CHEAT = new SubGroup(BektMain.createNamespacedKey("BEKT_MACHINE_CHEAT"), new CustomItemStack(Material.FURNACE, "&lBEKT &7- &5机器"));
    public static final ItemGroup MACHINE = new MachineGroup(BektMain.createNamespacedKey("BEKT_MACHINE"), new CustomItemStack(Material.FURNACE, "&lBEKT &7- &5机器"));
    private static final MainItemGroup MAIN_GROUP = new MainItemGroup(
            BektMain.createNamespacedKey("BEKT_MAIN_GROUP"),
            new CustomItemStack(Material.BEDROCK, "&lBEKT &7- &b基岩科技"),
            MACHINE_PROTECT, MACHINE
    );

    public static void registerGroup() {
        MAIN_GROUP.register(BektMain.getInstance());
    }
}
