package io.github.ctimet.bedrocktechnology.core.items.group;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class SubGroup extends ItemGroup {
    public SubGroup(NamespacedKey key, ItemStack item) {
        super(key, item);
    }

    @Override
    public boolean isHidden(@Nonnull Player p) {
        return true;
    }
}
