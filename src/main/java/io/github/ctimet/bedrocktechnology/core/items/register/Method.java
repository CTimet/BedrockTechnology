package io.github.ctimet.bedrocktechnology.core.items.register;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Method {
    public static CustomItemStack c(ItemStack itemStack, int n){
        return new CustomItemStack(itemStack,n);
    }

    public static ItemStack i(Material material){
        return new ItemStack(material);
    }
}
