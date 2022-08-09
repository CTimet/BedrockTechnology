package io.github.ctimet.bedrocktechnology.core.items;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.core.items.expand.ExpandPlayRegister;
import io.github.ctimet.bedrocktechnology.core.items.fix.MachineProtectRegister;
import io.github.ctimet.bedrocktechnology.data.BannedData;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BItems {
    public static void registerItems() {
        MachineProtectRegister.register();
        ExpandPlayRegister.register();
    }
    public static void register(SlimefunItem... items) {
        if (BannedData.isNoBanned()) {
            for (SlimefunItem item : items)
                item.register(BektMain.getInstance());
            return;
        }
        for (SlimefunItem item : items) {
            if (!BannedData.isBanned(item))
                item.register(BektMain.getInstance());
        }
    }

    public static CustomItemStack custom(ItemStack itemStack, int n){
        return new CustomItemStack(itemStack,n);
    }

    public static ItemStack item(Material material){
        return new ItemStack(material);
    }
}
