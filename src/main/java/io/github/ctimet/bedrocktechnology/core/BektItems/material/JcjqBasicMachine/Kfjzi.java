package io.github.ctimet.bedrocktechnology.core.BektItems.material.JcjqBasicMachine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineProcessHolder;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.operations.MiningOperation;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import lombok.NonNull;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class Kfjzi extends SlimefunItem implements InventoryBlock, MachineProcessHolder<MiningOperation>
{
    protected static final int[] BORDER        = new int[]
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    protected static final int[] INPUT_SLOTS   = new int[]
            { 20, 21 };
    protected static final int[] INPUT_BORDER  = new int[]
            { 10, 11, 12, 13, 19, 24, 25, 26, 27};
    protected static final int[] OUTPUT_SLOTS  = new int[]
            { 24, 25 };
    protected static final int[] OUTPUT_BORDER = new int[]
            { };
    protected static final int   CLICK         = 23;

    private static final int TIME = 4;

    private final MachineProcessor<MiningOperation> processor = new MachineProcessor<>(this);

    public Kfjzi(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        
        processor.setProgressBar(new ItemStack(Material.DIAMOND_PICKAXE));
        createPreset(this, getItemName(), this::constructMenu);
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{};
    }

    @Override
    public void createPreset(SlimefunItem item, String title, Consumer<BlockMenuPreset> setup) {
        InventoryBlock.super.createPreset(item, title, setup);
    }

    @Override
    public MachineProcessor<MiningOperation> getMachineProcessor() {
        return processor;
    }

    protected void constructMenu(@NonNull BlockMenuPreset preset) {
        preset.setSize(6*9);
        for(int i : BORDER){
            preset.addItem(i,ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }
    }
}
