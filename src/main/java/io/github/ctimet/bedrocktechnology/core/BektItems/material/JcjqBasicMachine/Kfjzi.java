package io.github.ctimet.bedrocktechnology.core.BektItems.material.JcjqBasicMachine;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemState;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineProcessHolder;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.operations.MiningOperation;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import lombok.NonNull;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class Kfjzi extends SlimefunItem implements InventoryBlock, EnergyNetComponent,  MachineProcessHolder<MiningOperation>
{
    protected static final int[] BORDER        = new int[]
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 31, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    protected static final int[] INPUT_SLOTS   = new int[]
            { 19, 20};
    protected static final int[] INPUT_BORDER  = new int[]
            { 9, 10, 11, 12, 18, 21, 27, 28, 29, 30 };
    protected static final int[] OUTPUT_SLOTS  = new int[]
            { 23, 24 };
    protected static final int[] OUTPUT_BORDER = new int[]
            { 14, 15, 16, 17, 23, 26, 32, 33, 34, 35};
    protected static final int   CLICK         = 22;

    private static final int TIME = 4;
    private int energyConsumedPerTick = -1;
    private int energyCapacity = -1;
    private int processingSpeed = -1;

    private final MachineProcessor<MiningOperation> processor = new MachineProcessor<>(this);

    public Kfjzi(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        
        processor.setProgressBar(new ItemStack(Material.DIAMOND_PICKAXE));
        createPreset(this, getItemName(), this::constructMenu);

        addItemHandler(onBlockBreak());
    }

    @Override
    public int[] getInputSlots() {
        return INPUT_SLOTS;
    }

    @Override
    public int[] getOutputSlots() {
        return OUTPUT_SLOTS;
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
        preset.setSize(5*9);
        for(int i : BORDER){
            preset.addItem(i,ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : INPUT_BORDER){
            preset.addItem(i,ChestMenuUtils.getInputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : OUTPUT_BORDER){
            preset.addItem(i,ChestMenuUtils.getOutputSlotTexture(),ChestMenuUtils.getEmptyClickHandler());
        }


    }

    @NonNull
    private BlockBreakHandler onBlockBreak() {
        return new SimpleBlockBreakHandler() {

            @Override
            public void onBlockBreak(@NonNull Block b) {
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null) {
                    inv.dropItems(b.getLocation(), OUTPUT_SLOTS);
                }

                processor.endOperation(b);
            }
        };
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONNECTOR;
    }

    @Override
    public int getCapacity() {
        return energyCapacity;
    }

    public int getEnergyConsumption() {
        return energyConsumedPerTick;
    }

    /**
     * 设置机器的容纳电量
     * @param capacity
     * @return
     */
    public final Kfjzi setCapacity(int capacity) {
        Validate.isTrue(capacity > 0, "The capacity must be greater than zero!");

        if (getState() == ItemState.UNREGISTERED) {
            this.energyCapacity = capacity;
            return this;
        } else {
            throw new IllegalStateException("You cannot modify the capacity after the Item was registered.");
        }
    }

    /**
     * 设置了这台机器的速度
     * @param speed
     * @return
     */
    public final Kfjzi setProcessingSpeed(int speed) {
        Validate.isTrue(speed > 0, "The speed must be greater than zero!");

        this.processingSpeed = speed;
        return this;
    }

    /**
     * 设置耗电量
     * @param energyConsumption
     * @return
     */
    public final Kfjzi setEnergyConsumption(int energyConsumption) {
        Validate.isTrue(energyConsumption > 0, "The energy consumption must be greater than zero!");
        Validate.isTrue(energyCapacity > 0, "You must specify the capacity before you can set the consumption amount.");
        Validate.isTrue(energyConsumption <= energyCapacity, "The energy consumption cannot be higher than the capacity (" + energyCapacity + ')');

        this.energyConsumedPerTick = energyConsumption;
        return this;
    }

    public int getSpeed() {
        return processingSpeed;
    }


    @Override
    public void register(@NonNull SlimefunAddon addon) {
        this.addon = addon;

        if (getCapacity() <= 0) {
            warn("The capacity has not been configured correctly. The Item was disabled.");
            warn("Make sure to call '" + getClass().getSimpleName() + "#setEnergyCapacity(...)' before registering!");
        }

        if (getEnergyConsumption() <= 0) {
            warn("The energy consumption has not been configured correctly. The Item was disabled.");
            warn("Make sure to call '" + getClass().getSimpleName() + "#setEnergyConsumption(...)' before registering!");
        }

        if (getSpeed() <= 0) {
            warn("The processing speed has not been configured correctly. The Item was disabled.");
            warn("Make sure to call '" + getClass().getSimpleName() + "#setProcessingSpeed(...)' before registering!");
        }

        if (getCapacity() > 0 && getEnergyConsumption() > 0 && getSpeed() > 0) {
            super.register(addon);
        }
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, Config data) {
                Kfjzi.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return false;
            }

        });
    }

    private void tick(Block b) {
        BlockMenu inv = BlockStorage.getInventory(b);
        start(b,inv);
    }

    private void start(@NonNull Block b, @NonNull BlockMenu inv) {
            processor.startOperation(b, new MiningOperation(SlimefunItems.ADVANCED_CIRCUIT_BOARD,TIME));
    }
}
