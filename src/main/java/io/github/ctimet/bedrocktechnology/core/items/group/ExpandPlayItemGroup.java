package io.github.ctimet.bedrocktechnology.core.items.group;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideImplementation;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class ExpandPlayItemGroup extends FlexItemGroup {
    private static final HashMap<UUID, SlimefunItem> PLAYER_VISIT = new HashMap<>();

    private static final int[] BLUE_BORDER = new int[] { 9, 18, 27, 36, 45 };
    private static final int[] GREEN_BORDER = new int[] { 34, 35, 43, 52, 53 };
    private static final int[] ORANGE_BORDER = new int[] { 7, 8, 16, 25, 26 };


    private static final int[] RECIPE_6x6 = new int[] {
            1, 2, 3, 4, 5, 6, 10, 11, 12, 13, 14, 15, 19, 20, 21, 22, 23, 24,
            28, 29, 30, 31, 32, 33, 37, 38, 39, 40, 41, 42, 46, 47, 48, 49,
            50, 51
    };
    private static final int[] RECIPE_3x3 = new int[] {
            3, 4, 5, 12, 13, 14, 21, 22, 23
    };


    protected ExpandPlayItemGroup(NamespacedKey key, ItemStack item) {
        super(key, item);
    }

    @Override
    public boolean isVisible(Player p, PlayerProfile profile, SlimefunGuideMode layout) {
        return false;
    }

    @Override
    public void open(Player p, PlayerProfile profile, SlimefunGuideMode mode) {
        open(p, profile, mode, PLAYER_VISIT.get(p.getUniqueId()));
    }

    public void open(Player p, PlayerProfile profile, SlimefunGuideMode mode, SlimefunItem item) {
        PLAYER_VISIT.put(p.getUniqueId(), item);
        profile.getGuideHistory().add(this, 1);

        SlimefunGuideImplementation guide = Slimefun.getRegistry().getSlimefunGuide(mode);

        ChestMenu menu = new ChestMenu("BedrockTechnology Guide");

        menu.setEmptySlotsClickable(false);
        menu.addMenuOpeningHandler(p13 -> p13.playSound(p13.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1.0F, 1.0F));

        String back = ChatColor.GRAY + Slimefun.getLocalization().getMessage(p, "guide.back.guide");
        menu.addItem(0, ChestMenuUtils.getBackButton(p, "", back));
        menu.addMenuClickHandler(0, (pl, s, is, action) -> {
            profile.getGuideHistory().goBack(guide);
            return false;
        });

        CustomItemStack blue = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE, " ");
        CustomItemStack green = new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, " ");
        CustomItemStack orange = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, " ");
        for (int i : BLUE_BORDER) {
            menu.addItem(i, blue, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : GREEN_BORDER) {
            menu.addItem(i, green, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : ORANGE_BORDER) {
            menu.addItem(i, orange, ChestMenuUtils.getEmptyClickHandler());
        }

        ItemStack[] recipe = item.getRecipe();
        int re = 0;
        for (int rp : RECIPE_6x6) {
            //re++使用此时re的值而不是re+1的值
            menu.addItem(rp, recipe[re++], (player, slot, item1, action) -> {
                SlimefunItem sfItem = SlimefunItem.getByItem(item1);
                if (sfItem != null) {
                    ItemStack[] itemRecipe = sfItem.getRecipe();
                    if (itemRecipe.length > 9) {
                        open(player, profile, mode, sfItem);
                    } else {
                        open3x3Recipe(player, profile, mode, sfItem);
                    }
                }
                return false;
            });
        }

        menu.addItem(17, item.getRecipeType().getItem(p), (player, slot, item12, action) -> {
            SlimefunItem sfItem = SlimefunItem.getByItem(item12);
            if (sfItem == null) return false;
            ItemStack[] itemRecipe = sfItem.getRecipe();
            if (itemRecipe.length > 9) {
                open(player, profile, mode, sfItem);
            } else {
                open3x3Recipe(player, profile, mode, sfItem);
            }
            return false;
        });
        menu.addItem(44, item.getItem(), ChestMenuUtils.getEmptyClickHandler());

        menu.open(p);
    }

    public static void open3x3Recipe(Player player, PlayerProfile profile, SlimefunGuideMode mode, SlimefunItem item) {
        ChestMenu menu = new ChestMenu("BedrockTechnology Guide");
        profile.getGuideHistory().add(item);

        menu.setEmptySlotsClickable(false);
        menu.addMenuOpeningHandler(p13 -> p13.playSound(p13.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1.0F, 1.0F));

        SlimefunGuideImplementation guide = Slimefun.getRegistry().getSlimefunGuide(mode);

        String back = ChatColor.GRAY + Slimefun.getLocalization().getMessage(player, "guide.back.guide");
        menu.addItem(0, ChestMenuUtils.getBackButton(player, "", back));
        menu.addMenuClickHandler(0, (pl, s, is, action) -> {
            profile.getGuideHistory().goBack(guide);
            return false;
        });

        menu.addItem(10, item.getRecipeType().getItem(player), ChestMenuUtils.getEmptyClickHandler());
        menu.addItem(16, item.getItem(), ChestMenuUtils.getEmptyClickHandler());

        ItemStack[] recipe = item.getRecipe();
        int rp = 0;
        for (ItemStack re : recipe) {
            menu.addItem(RECIPE_3x3[rp ++], re, (player1, slot, item1, action) -> {
                SlimefunItem sfItem = SlimefunItem.getByItem(re);
                if (sfItem != null) {
                    open3x3Recipe(player, profile, mode, sfItem);
                }
                return false;
            });
        }

        menu.open(player);
    }
}
