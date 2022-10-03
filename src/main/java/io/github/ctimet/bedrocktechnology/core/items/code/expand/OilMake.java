package io.github.ctimet.bedrocktechnology.core.items.code.expand;

import io.github.ctimet.bedrocktechnology.core.items.BRecipe;
import io.github.ctimet.bedrocktechnology.core.items.code.RecipeSize;
import io.github.ctimet.bedrocktechnology.core.items.code.RecipeSizeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
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
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class OilMake extends SlimefunItem implements InventoryBlock, EnergyNetComponent, MachineProcessHolder<CraftingOperation>, RecipeSize {
    private static final int[] BORDER = {
            0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17
    };
    private static final int SCHEDULE_SLOT = 4;
    private static final CustomItemStack SCHEDULE_ITEM = new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, "§7未工作");
    private final MachineProcessor<CraftingOperation> processor = new MachineProcessor<>(this);
    protected final ArrayList<BRecipe> recipes = new ArrayList<>();

    private int speed = -1;
    private int capacity = -1;
    private int energyUse = -1;
    private String invTitle = "";

    private RecipeSizeType type;

    public OilMake(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        createPreset(this, getInvTitle(), this::constructMenu);

        addItemHandler(onBreak());
    }

    public OilMake setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public OilMake setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public OilMake setEnergyUse(int use) {
        this.energyUse = use;
        return this;
    }

    public OilMake setInvTitle(String title) {
        this.invTitle = title;
        return this;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getEnergyConsumption() {
        return this.energyUse;
    }

    public String getInvTitle() {
        return this.invTitle;
    }

    public void registerDefaultRecipes() {
        registerRecipe(100, SlimefunItems.OIL_BUCKET);
    }

    @NotNull
    protected BlockBreakHandler onBreak() {
        return new SimpleBlockBreakHandler() {

            @Override
            public void onBlockBreak(@NotNull Block b) {
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null) {
                    //inv.dropItems(b.getLocation(), getInputSlots());
                    inv.dropItems(b.getLocation(), getOutputSlots());
                }

                processor.endOperation(b);
            }

        };
    }

    @Override
    public void register(@NotNull SlimefunAddon addon) {
        this.addon = addon;

        if (getCapacity() <= 0) {
            warn("错误！机器电量容量不能小于等于0！！！");
            warn("请确保 '" + getClass().getSimpleName() + "'中的getCapacity()方法返回值大于等于0！该物品已废弃，不再注册！ ");
            warn("同时，请您在检查getCapacity方法返回值时，请一并检查getEnergyConsumption方法与getSpeed方法返回值，以免这两个方法出现错误");
            return;
        }

        if (getEnergyConsumption() <= 0) {
            warn("错误！机器进程电量使用量不能小于等于0！！！");
            warn("请确保 '" + getClass().getSimpleName() + "'中的getEnergyConsumption()方法返回值大于等于0！该物品已废弃，不再注册！ ");
            warn("同时，请您在检查getEnergyConsumption方法返回值时，请一并检查getSpeed方法返回值，以免这个方法出现错误");
            return;
        }

        if (getSpeed() <= 0) {
            warn("错误！机器进程速度不能小于等于0！！！");
            warn("请确保 '" + getClass().getSimpleName() + "'中的getSpeed()方法返回值大于等于0！该物品已废弃，不再注册！ ");
            return;
        }

        registerDefaultRecipes();

        super.register(addon);
    }
    /**
     * 此方法将注册最后返回的物品
     * @param seconds 该参数指制作该物品花费的时间
     * @param out 该参数指最后产出物品
     */
    public void registerRecipe(int seconds, SlimefunItemStack out) {
        this.recipes.add(new BRecipe(seconds, out));
    }

    protected void constructMenu(BlockMenuPreset preset) {
        for (int i : BORDER) {
            preset.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }
        preset.addItem(SCHEDULE_SLOT, SCHEDULE_ITEM, ChestMenuUtils.getEmptyClickHandler());

        //preset.addItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());

        for (int i : getOutputSlots()) {
            preset.addMenuClickHandler(i, new ChestMenu.AdvancedMenuClickHandler() {

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

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return false;
            }

            @Override
            public void tick(Block b, SlimefunItem item, Config data) {
                OilMake.this.tick(b);
            }
        });
    }

    protected void tick(Block b) {
        BlockMenu inv = BlockStorage.getInventory(b);
        CraftingOperation operation = processor.getOperation(b);
        Inventory inventory = inv.toInventory();
        //MachineRecipe recipe = null;

        if (operation != null) {
            if (takeCharge(b.getLocation())) {
                if (!operation.isFinished()) {
                    ItemMeta meta = SCHEDULE_ITEM.getItemMeta();
                    //BektMain.sayInfo(String.valueOf(max));
                    if (meta != null) {
                        ItemStack stack = inventory.getItem(getOutputSlots()[0]);
                        //BektMain.sayInfo(String.valueOf(recipes.get(0).getOut().getAmount()));
                        if (stack != null && stack.getAmount() == recipes.get(0).getOut().getMaxStackSize()) {
                            SCHEDULE_ITEM.setType(Material.RED_STAINED_GLASS_PANE);
                            meta.setDisplayName("§4警告，输出槽已满");
                        } else {
                            SCHEDULE_ITEM.setType(Material.GREEN_STAINED_GLASS_PANE);
                            operation.addProgress(1);
                            meta.setDisplayName("§a获取原油中...当前进度" + (operation.getProgress() / 2) + "/" + (operation.getTotalTicks() / 2));
                        }
                    }
                    SCHEDULE_ITEM.setItemMeta(meta);
                    inv.replaceExistingItem(SCHEDULE_SLOT,SCHEDULE_ITEM);
                } else {
                    for (ItemStack output : operation.getResults()) {
                        inv.pushItem(output.clone(), getOutputSlots());
                    }
                    processor.endOperation(b);
                    ItemMeta meta = SCHEDULE_ITEM.getItemMeta();
                    if (meta != null)
                        meta.setDisplayName("§7未工作");
                    SCHEDULE_ITEM.setItemMeta(meta);
                    SCHEDULE_ITEM.setType(Material.ORANGE_STAINED_GLASS_PANE);
                    inv.replaceExistingItem(SCHEDULE_SLOT,SCHEDULE_ITEM);
                }
            }
        } else {
            MachineRecipe recipe =  findNextRecipe();

            if (recipe != null) {
                processor.startOperation(b, new CraftingOperation(recipe));
            }
        }
    }


    protected MachineRecipe findNextRecipe() {
        Random r = new Random();
        //随机获取输出
        int next = r.nextInt(recipes.size());
        BRecipe recipe = recipes.get(next);
        ItemStack out = recipe.getOut();
        return new MachineRecipe(recipe.getSeconds(),new ItemStack[]{out},new ItemStack[]{out});
    }

    protected boolean takeCharge(@NotNull Location l) {
        Validate.notNull(l, "Can't attempt to take charge from a null location!");

        if (isChargeable()) {
            int charge = getCharge(l);

            if (charge < getEnergyConsumption()) {
                return false;

            }

            setCharge(l, charge - getEnergyConsumption());
        }
        return true;
    }


    @Override
    public int[] getInputSlots() {
        return new int[] {};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[] { 13 };
    }

    @NotNull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @NotNull
    @Override
    public MachineProcessor<CraftingOperation> getMachineProcessor() {
        return processor;
    }

    public OilMake setSize(RecipeSizeType type) {
        this.type = type;
        return this;
    }

    @Override
    public RecipeSizeType getSize() {
        return type;
    }
}
