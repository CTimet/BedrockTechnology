package io.github.ctimet.bedrocktechnology.core.items.group;

import io.github.ctimet.bedrocktechnology.core.items.repcie.RecipeSize;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideImplementation;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.ItemUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ExpandPlayGroup0 extends FlexItemGroup {
    private final String name;

    private static final int[] BLUE_BORDER = new int[] { 9, 18, 27, 36, 45 };
    private static final int[] GREEN_BORDER = new int[] { 34, 35, 43, 52, 53 };
    private static final int[] ORANGE_BORDER = new int[] { 7, 8, 16, 25, 26 };

    private static final int[] BORDER = new int[] {
            0,  2,  3,  4,  5,  6,  7,  8,
            45, 46, 47, 48, 49, 50, 51, 52, 53
    };

    private static final int[] RECIPE_6x6 = new int[] {
            1, 2, 3, 4, 5, 6, 10, 11, 12, 13, 14, 15, 19, 20, 21, 22, 23, 24,
            28, 29, 30, 31, 32, 33, 37, 38, 39, 40, 41, 42, 46, 47, 48, 49,
            50, 51
    };
    private static final int[] RECIPE_3x3 = new int[] {
            3, 4, 5, 12, 13, 14, 21, 22, 23
    };

    public ExpandPlayGroup0(NamespacedKey key, ItemStack item) {
        super(key, item);
        this.name = ItemUtils.getItemName(item);
    }

    @Override
    public boolean isVisible(@NotNull Player p, @NotNull PlayerProfile profile, @NotNull SlimefunGuideMode mode) {
        return false;
    }

    @Override
    public void open(Player p, PlayerProfile profile, SlimefunGuideMode mode) {
        SlimefunGuideImplementation guide = Slimefun.getRegistry().getSlimefunGuide(mode);
        profile.getGuideHistory().add(this, 1);
        ChestMenu menu = new ChestMenu(this.name);

        menu.setEmptySlotsClickable(false);
        menu.addMenuOpeningHandler(p13 -> p13.playSound(p13.getLocation(),Sound.ITEM_BOOK_PAGE_TURN, 1.0F, 1.0F));

        for (int i : BORDER) {
            menu.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        String back = ChatColor.GRAY + Slimefun.getLocalization().getMessage(p, "guide.back.guide");
        menu.addItem(1, ChestMenuUtils.getBackButton(p, "", back));
        menu.addMenuClickHandler(1, (p1, slot, item, action) -> {
            profile.getGuideHistory().goBack(guide);
            return false;
        });

        int index = 9;
        for (SlimefunItem item : BItemGroup.EXPAND_PLAY_CHEAT.getItems()) {
            menu.addItem(index, item.getItem(), (p12, slot, itemStack, action) -> {
                if (item instanceof RecipeSize) {
                    profile.getGuideHistory().goBack(guide);
                    openRecipeIn6x6(p12, item, profile, mode);
                } else {
                    profile.getGuideHistory().add(item);
                    openRecipeIn3x3(p12, null, item, profile, mode);
                }
                return false;
            });
        }

        menu.open(p);
    }

    private void openRecipeIn3x3(Player p, SlimefunItem prev , SlimefunItem item, PlayerProfile profile, SlimefunGuideMode mode) {
        SlimefunGuideImplementation guide = Slimefun.getRegistry().getSlimefunGuide(mode);
        ChestMenu menu = new ChestMenu(this.name);

        menu.setPlayerInventoryClickable(false);
        menu.addMenuOpeningHandler((pl) -> {
            pl.playSound(pl.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1.0F, 1.0F);
        });

        String back = ChatColor.GRAY + Slimefun.getLocalization().getMessage(p, "guide.back.guide");
        menu.addItem(0, ChestMenuUtils.getBackButton(p, "", back), (pl, s, is, action) -> {
            profile.getGuideHistory().goBack(guide);
            return false;
        });

        int index = 0;
        for (ItemStack stack : item.getRecipe()) {
            menu.addItem(RECIPE_3x3[index], stack, (p1, slot, item1, action) -> {
                openItemRecipe(p1, item , item1, profile, mode);
                return false;
            });
            index ++;
        }

        menu.addItem(10, item.getRecipeType().getItem(p), ChestMenuUtils.getEmptyClickHandler());
        menu.addItem(16, item.getItem(), ChestMenuUtils.getEmptyClickHandler());

        menu.open(p);
    }
    private void openRecipeIn6x6(Player p, SlimefunItem item, PlayerProfile profile, SlimefunGuideMode mode) {
        SlimefunGuideImplementation guide = Slimefun.getRegistry().getSlimefunGuide(mode);
        ChestMenu menu = new ChestMenu(this.name);

        menu.setPlayerInventoryClickable(false);
        menu.addMenuOpeningHandler((pl) -> {
            pl.playSound(pl.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1.0F, 1.0F);
        });

        CustomItemStack BORDER_BLUE = new CustomItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " ");
        CustomItemStack BORDER_GREEN = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE, " ");
        CustomItemStack BORDER_ORANGE = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, " ");

        for (int i : BLUE_BORDER) {
            menu.addItem(i, BORDER_BLUE, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : GREEN_BORDER) {
            menu.addItem(i, BORDER_GREEN, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : ORANGE_BORDER) {
            menu.addItem(i, BORDER_ORANGE, ChestMenuUtils.getEmptyClickHandler());
        }

        String back = ChatColor.GRAY + Slimefun.getLocalization().getMessage(p, "guide.back.guide");
        menu.addItem(0, ChestMenuUtils.getBackButton(p, "", back));
        menu.addMenuClickHandler(0, (pl, s, is, action) -> {
            profile.getGuideHistory().goBack(guide);
            return false;
        });

        int index = 0;
        for (ItemStack stack : item.getRecipe()) {
            menu.addItem(RECIPE_6x6[index], stack, (player, slot, item1, action) -> {
                openItemRecipe(player, item, item1, profile, mode);
                return false;
            });
            index ++;
        }

        menu.addItem(17, item.getRecipeType().getItem(p), ChestMenuUtils.getEmptyClickHandler());
        menu.addItem(44, item.getItem(), ChestMenuUtils.getEmptyClickHandler());

        menu.open(p);
    }

    private void openItemRecipe(Player p, SlimefunItem prev, ItemStack item, PlayerProfile profile, SlimefunGuideMode mode) {
        SlimefunItem sfItem = SlimefunItem.getByItem(item);
        if (sfItem != null) {
            profile.getGuideHistory().add(sfItem);
            if (sfItem instanceof RecipeSize) {
                openRecipeIn6x6(p, sfItem, profile, mode);
            } else {
                openRecipeIn3x3(p, prev, sfItem, profile, mode);
            }
        }
    }
}
