package io.github.ctimet.bedrocktechnology.core.items.network;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;
import io.github.ctimet.bedrocktechnology.core.event.InventoryProtectEvent;
import io.github.ctimet.bedrocktechnology.data.SpecialRecipe;
import io.github.ctimet.bedrocktechnology.log.Color;
import io.github.ctimet.bedrocktechnology.plugin.task.PluginTask;
import io.github.ctimet.bedrocktechnology.template.OnlyGui;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ItemRecipeShow extends OnlyGui {
    private static final HashMap<String, SpecialRecipe> RECIPES = new HashMap<>();
    private static final int[] RECIPE_SLOTS = new int[] {
             0,  1,  2,  3,  4,  5,
             9, 10, 11, 12, 13, 14,
            18, 19, 20, 21, 22, 23,
            27, 28, 29, 30, 31, 32,
            36, 37, 38, 39, 40, 41,
            45, 46, 47, 48, 49, 50
    };
    private static final int[] ORANGE_BORDER = new int[] {
            6, 7, 8, 15, 17, 24, 25, 26
    };
    private static final int[] GREEN_BORDER = new int[] {
            33, 34, 35, 42, 44, 51, 52, 53
    };

    public ItemRecipeShow(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void createGui(BlockMenuPreset preset) {
        preset.addItem(3, new CustomItemStack(Material.ORANGE_STAINED_GLASS, Color.YELLOW + "点我搜索物品配方"), (p, slot, item, action) -> {
            InventoryProtectEvent.addWaitForRecipe(p);
            p.closeInventory();
            p.sendMessage(Color.YELLOW + "请输入要查询配方的物品名称 >>");
            return false;
        });
        preset.addItem(5, new CustomItemStack(Material.GREEN_STAINED_GLASS, Color.GREEN + "点我统计配方"), (p, slot, item, action) -> {
            InventoryProtectEvent.addWaitForCount(p);
            p.closeInventory();
            p.sendMessage(Color.YELLOW + "请输入要统计物品配方的物品名称 >>");
            return false;
        });
    }

    public static void addRecipe(String itemName, SpecialRecipe recipe) {
        RECIPES.put(itemName, recipe);
    }

    public static void showRecipe(Player player, String name) {
        Chat chat = new Chat(player);
        if (RECIPES.containsKey(name)) {
            Inventory show = Bukkit.createInventory(player, 6 * 9, "物品" + name + "的配方");
            for (int index : ORANGE_BORDER) {
                show.setItem(index, new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, Color.GRAY + "制造机"));
            }
            for (int index : GREEN_BORDER) {
                show.setItem(index, new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, Color.GRAY + "输出物品"));
            }
            SpecialRecipe recipe = RECIPES.get(name);
            ItemStack[] stacks = recipe.recipe();
            for (int i = 0; i < stacks.length; i ++) {
                show.setItem(RECIPE_SLOTS[i], stacks[i]);
            }
            show.setItem(16, recipe.make());
            show.setItem(43, recipe.out());
            PluginTask.runTack(() -> player.openInventory(show));
        } else {
            chat.sendMesWithHead("我很抱歉，但是我没有找到物品\"" + name + "\"", "Recipe", Color.YELLOW);
        }
    }

    public static void countRecipe(Player player, String name) {
        Chat chat = new Chat(player);
        if (RECIPES.containsKey(name)) {
            ItemStack[] items = RECIPES.get(name).recipe();
            int count = 0;
            StringBuilder out = new StringBuilder();
            HashMap<String, Integer> temp = new HashMap<>();
            for (ItemStack item : items) {
                if (item == null || item.getItemMeta() == null) continue;
                count += item.getAmount();
                String itemName = item.getItemMeta().getDisplayName();
                temp.put(itemName, temp.getOrDefault(itemName, 0) + 1);
            }
            temp.forEach((k,v) -> out.append(k).append(" x").append(v).append("\n"));
            chat.sendMessageWithoutHead("以下为物品\"" + name + "\"的配方统计，共计 " + count + "个物品 >>", Color.LIGHT_BLUE);
            chat.sendMessageWithoutHead(out.toString(), Color.PINK);
        } else {
            chat.sendMesWithHead("我很抱歉，但是我没有找到物品\"" + name + "\"", "Recipe", Color.YELLOW);
        }
    }
}
