package io.github.ctimet.bedrocktechnology.abstractClass;

import java.util.*;

import io.github.thebusybiscuit.slimefun4.libraries.dough.inventory.InvUtils;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ItemStackWrapper;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.AdvancedMenuClickHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public abstract class BektAcontainerTwoSlot extends SlimefunItem implements InventoryBlock, EnergyNetComponent, MachineProcessHolder<CraftingOperation>
{
    private static final int[] BORDER = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 31, 36, 37, 38, 39, 40, 41, 42, 43, 44 };
    private static final int[] BORDER_IN = { 9, 10, 11, 12, 18, 21, 27, 28, 29, 30 };
    private static final int[] BORDER_OUT = { 14, 15, 16, 17, 23, 26, 32, 33, 34, 35 };

    protected final List<MachineRecipe> recipes = new ArrayList<>();
    private final MachineProcessor<CraftingOperation> processor = new MachineProcessor<>(this);
    private ArrayList<ItemStack> itemStacks = new ArrayList<>();

    private boolean isAnother = false;

    private int energyConsumedPerTick = -1;
    private int energyCapacity = -1;
    private int processingSpeed = -1;
    private int index = 0;

    /**
     * This creates a new {@link SlimefunItem} from the given arguments.
     *
     * @param itemGroup  The {@link ItemGroup} this {@link SlimefunItem} belongs to
     * @param item       The {@link SlimefunItemStack} that describes the visual features of our {@link SlimefunItem}
     * @param recipeType the {@link RecipeType} that determines how this {@link SlimefunItem} is crafted
     * @param recipe     An Array representing the recipe of this {@link SlimefunItem}
     */
    public BektAcontainerTwoSlot(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        processor.setProgressBar(getProgressBar());
        createPreset(this, getInventoryTitle(), this::constructMenu);

        addItemHandler(onBlockBreak());
    }

    
    protected BlockBreakHandler onBlockBreak() {
        return new SimpleBlockBreakHandler() {

            @Override
            public void onBlockBreak(Block b) {
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null) {
                    inv.dropItems(b.getLocation(), getInputSlots());
                    inv.dropItems(b.getLocation(), getOutputSlots());
                }

                processor.endOperation(b);
            }

        };
    }

    
    protected BektAcontainerTwoSlot(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
        this(itemGroup, item, recipeType, recipe);
        this.recipeOutput = recipeOutput;
    }

    @Override
    public MachineProcessor<CraftingOperation> getMachineProcessor() {
        return processor;
    }

    protected void constructMenu(BlockMenuPreset preset) {
        //机器最外围边界
        for (int i : BORDER) {
            preset.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        //输入卡槽边界
        for (int i : BORDER_IN) {
            preset.addItem(i, ChestMenuUtils.getInputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        //输出卡槽边界
        for (int i : BORDER_OUT) {
            preset.addItem(i, ChestMenuUtils.getOutputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        preset.addItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());

        for (int i : getOutputSlots()) {
            preset.addMenuClickHandler(i, new AdvancedMenuClickHandler() {

                @Override
                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction action) {
                    return false;
                }

                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action) {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }
            });
        }
    }

    /**
     * 这个方法返回机器的标题
     *
     * 覆盖此方法以设置标题
     *
     * @return The title of the {@link Inventory} of this {@link AContainer}
     */
    
    public String getInventoryTitle() {
        return getItemName();
    }

    /**
     * 此方法返回{@link BektAcontainerTwoSlot}用作进度条的{@link ItemStack}物品
     *
     * 覆盖此方法可以设置进度条
     *
     * @return The {@link ItemStack} to use as the progress bar
     */
    public abstract ItemStack getProgressBar();

    /**
     * 此方法返回这台机器可以容纳的最大电量。
     *
     * @return 可以容纳的最大电量
     */
    @Override
    public int getCapacity() {
        return energyCapacity;
    }

    /**
     * 此方法返回每次操作消耗的能量。
     *
     * 每1个粘液刻(0.5s)就会调用一次此方法
     *
     * @return 每次操作消耗的能量
     */
    public int getEnergyConsumption() {
        return energyConsumedPerTick;
    }

    /**
     * 此方法返回这台机器将运行的速度。这可以在实例化级别上实现，以创建不同的机器层。
     *
     * @return 这台机器将运行的速度
     */
    public int getSpeed() {
        return processingSpeed;
    }

    /**
     * 这设置了这台机器的能量容量。 此方法<strong>必须</strong>在注册项目之前调用，并且只能在注册之前调用。
     *
     * @param capacity
     *            此机器的能量容量
     *
     * @return 此方法将返回当前实例
     */
    public final BektAcontainerTwoSlot setCapacity(int capacity) {
        Validate.isTrue(capacity > 0, "The capacity must be greater than zero!");

        if (getState() == ItemState.UNREGISTERED) {
            this.energyCapacity = capacity;
            return this;
        } else {
            throw new IllegalStateException("You cannot modify the capacity after the Item was registered.");
        }
    }

    /**
     * 此方法设置了机器的速度
     *
     * @param speed
     *            这台机器的速度，必须大于0
     *
     * @return 当前实例
     */
    public final BektAcontainerTwoSlot setProcessingSpeed(int speed) {
        Validate.isTrue(speed > 0, "The speed must be greater than zero!");

        this.processingSpeed = speed;
        return this;
    }

    /**
     * 此方法设置了机器的耗电量
     *
     * @param energyConsumption
     *            机器每粘液刻耗电量
     *
     * @return 此方法将返回当前实例
     */
    public final BektAcontainerTwoSlot setEnergyConsumption(int energyConsumption) {
        Validate.isTrue(energyConsumption > 0, "The energy consumption must be greater than zero!");
        Validate.isTrue(energyCapacity > 0, "You must specify the capacity before you can set the consumption amount.");
        Validate.isTrue(energyConsumption <= energyCapacity, "The energy consumption cannot be higher than the capacity (" + energyCapacity + ')');

        this.energyConsumedPerTick = energyConsumption;
        return this;
    }

    @Override
    public void register( SlimefunAddon addon) {
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

        registerDefaultRecipes();

        if (getCapacity() > 0 && getEnergyConsumption() > 0 && getSpeed() > 0) {
            super.register(addon);
        }
    }

    /**
     * 此方法返回用于标识此 BektAcontainerTwoSlot 及其配方的内部标识符。 在向 BektAcontainerTwoSlot 添加配方时，我们将使用此标识符来标识同一 BektAcontainerTwoSlot 的所有实例。 通过这种方式，我们可以将配方添加到同一台机器的所有实例中。 此方法将在未来被弃用和替换
     *
     * @return 机器标识
     */
    
    public abstract String getMachineIdentifier();

    /**
     * 此方法注册此机器的所有默认配方。
     */
    protected void registerDefaultRecipes() {
        // 覆盖此方法以注册默认配方
    }

    public List<MachineRecipe> getMachineRecipes() {
        return recipes;
    }

    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 2);

        for (MachineRecipe recipe : recipes) {
            if (recipe.getInput().length != 1) {
                continue;
            }

            displayRecipes.add(recipe.getInput()[0]);
            displayRecipes.add(recipe.getOutput()[0]);
        }

        return displayRecipes;
    }

    @Override
    public int[] getInputSlots() {
        return new int[] { 19, 20 };
    }

    @Override
    public int[] getOutputSlots() {
        return new int[] { 24, 25 };
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    public void registerRecipe(MachineRecipe recipe) {
        recipe.setTicks(recipe.getTicks() / getSpeed());
        recipes.add(recipe);
    }

    public void registerRecipe(int seconds, ItemStack[] input, ItemStack[] output) {
        registerRecipe(new MachineRecipe(seconds, input, output));
    }

    public void registerRecipe(int seconds, ItemStack[] input, ItemStack[] outputAnything, ArrayList<ItemStack> output, boolean isAnotherTick){
        if (isAnotherTick) {
            itemStacks = output;
            registerRecipe(new MachineRecipe(seconds,input,outputAnything));
            isAnother = true;
        }
        else registerRecipe(new MachineRecipe(seconds,input,outputAnything));
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, Config data) {
                BektAcontainerTwoSlot.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return false;
            }
        });
    }

    protected void tick(Block b) {
        BlockMenu inv = BlockStorage.getInventory(b);
        CraftingOperation currentOperation = processor.getOperation(b);
        int res = isEmpty.getEmptySlot(inv,getOutputSlots());

        if (currentOperation != null) {
            if (takeCharge(b.getLocation())) {

                if (!currentOperation.isFinished()) {
                    processor.updateProgressBar(inv, 22, currentOperation);
                    currentOperation.addProgress(1);
                } else {
                    inv.replaceExistingItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));

                    if (!isAnother){
                        for (ItemStack output : currentOperation.getResults()) {
                            inv.pushItem(output.clone(), getOutputSlots());
                        }
                    }else if (!itemStacks.isEmpty()){
                        if (res != -1){
                            inv.pushItem(itemStacks.get(index).clone(),getOutputSlots());
                            index += 1;
                            if (index == itemStacks.size()) index = 0;
                        }else {
                            inv.replaceExistingItem(22,new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE,"没有足够的空间！"));
                        }
                    }

                    processor.endOperation(b);
                }
            }
        } else {
            MachineRecipe next = findNextRecipe(inv);

            if (next != null) {
                processor.startOperation(b, new CraftingOperation(next));
            }
        }
    }

    private static class isEmpty{
        public static int getEmptySlot(BlockMenu inv,int[] slots){
            for (int s : slots){
                if (inv.getItemInSlot(s) == null)
                    return s;
            }
            return -1;
        }
    }

    /**
     * This method will remove charge from a location if it is chargeable.
     *
     * @param l
     *            location to try to remove charge from
     * @return Whether charge was taken if its chargeable
     */
    protected boolean takeCharge( Location l) {
        Validate.notNull(l, "Can't attempt to take charge from a null location!");

        if (isChargeable()) {
            int charge = getCharge(l);

            if (charge < getEnergyConsumption()) {
                return false;
            }

            setCharge(l, charge - getEnergyConsumption());
            return true;
        } else {
            return true;
        }
    }

    protected MachineRecipe findNextRecipe(BlockMenu inv) {
        Map<Integer, ItemStack> inventory = new HashMap<>();

        for (int slot : getInputSlots()) {
            ItemStack item = inv.getItemInSlot(slot);

            if (item != null) {
                inventory.put(slot, ItemStackWrapper.wrap(item));
            }
        }

        Map<Integer, Integer> found = new HashMap<>();

        for (MachineRecipe recipe : recipes) {
            for (ItemStack input : recipe.getInput()) {
                for (int slot : getInputSlots()) {
                    if (SlimefunUtils.isItemSimilar(inventory.get(slot), input, true)) {
                        found.put(slot, input.getAmount());
                        break;
                    }
                }
            }

            if (found.size() == recipe.getInput().length) {
                if (!InvUtils.fitAll(inv.toInventory(), recipe.getOutput(), getOutputSlots())) {
                    return null;
                }

                for (Map.Entry<Integer, Integer> entry : found.entrySet()) {
                    inv.consumeItem(entry.getKey(), entry.getValue());
                }

                return recipe;
            } else {
                found.clear();
            }
        }

        return null;
    }
}
