package io.github.ctimet.bedrocktechnology.core.items;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.core.items.expand.ExpandPlayRegister;
import io.github.ctimet.bedrocktechnology.core.items.fix.MachineProtectRegister;
import io.github.ctimet.bedrocktechnology.core.items.network.NetWorkRegister;
import io.github.ctimet.bedrocktechnology.data.BannedData;
import io.github.ctimet.bedrocktechnology.log.Log;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BItems {
    private static int ItemAmount = 0;
    public static void registerItems() {
        MachineProtectRegister.register();
        ExpandPlayRegister.register();
        NetWorkRegister.register();
        say();
    }
    public static void register(SlimefunItem... items) {
        if (BannedData.isNoBanned()) {
            for (SlimefunItem item : items) {
                item.register(BektMain.getInstance());
                ItemAmount ++;
            }
            return;
        }
        for (SlimefunItem item : items) {
            if (BannedData.isBanned(item)) {
                Log.info("成功ban掉物品 \"" + item.getItemName() + "\", 物品ID为 \"" + item.getId() + "\"");
                ItemMeta meta = item.getItem().getItemMeta();
                if (meta != null)
                    BannedData.put(meta.getDisplayName());
            } else {
                item.register(BektMain.getInstance());
                ItemAmount ++;
            }
        }
    }

    public static void say() {
        Log.info("加载完成，总共加载了 " + ItemAmount + " 个物品");
        if (!BannedData.isNoBanned()) {
            Log.info("ban掉了 " + BannedData.getBanedItems() + " 个物品");
        }
    }

    public static CustomItemStack custom(ItemStack itemStack, int n){
        return new CustomItemStack(itemStack,n);
    }

    public static ItemStack item(Material material){
        return new ItemStack(material);
    }
}
