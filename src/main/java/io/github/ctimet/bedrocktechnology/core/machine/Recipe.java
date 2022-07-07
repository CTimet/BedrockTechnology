package io.github.ctimet.bedrocktechnology.core.machine;

import org.bukkit.inventory.ItemStack;

public class Recipe {
    int s;
    ItemStack o;
    public Recipe(int seconds, ItemStack out) {
        this.s = seconds;
        this.o = out;
    }

    public int getSeconds() {
        return this.s;
    }

    public ItemStack getOut() {
        return this.o;
    }
}
