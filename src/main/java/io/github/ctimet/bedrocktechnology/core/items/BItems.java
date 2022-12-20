package io.github.ctimet.bedrocktechnology.core.items;

import io.github.ctimet.bedrocktechnology.core.items.code.base.BaseItemRegister;
import io.github.ctimet.bedrocktechnology.core.items.code.expand.ExpandItemRegister;
import io.github.ctimet.bedrocktechnology.core.items.code.fix.MachineProtectRegister;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BItems {
    public static void init() {
        BaseItemRegister.register();
        ExpandItemRegister.register();
        MachineProtectRegister.register();
    }

    public static CustomItemStack custom(ItemStack itemStack, int n){
        return new CustomItemStack(itemStack,n);
    }

    public static ItemStack item(Material material){
        return new ItemStack(material);
    }
}
