package io.github.ctimet.bedrocktechnology.core.items.group;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideImplementation;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static io.github.ctimet.bedrocktechnology.core.items.group.BItemGroup.EXPAND_PLAY_ITEM;

public class ExpandPlayGroup extends FlexItemGroup {
    private static final int[] BORDER = new int[] {
            0,  2,  3,  4,  5,  6,  7,  8,
            45, 46, 47, 48, 49, 50, 51, 52, 53
    };

    public ExpandPlayGroup(NamespacedKey key, ItemStack item) {
        super(key, item);
    }

    @Override
    public boolean isVisible(@NotNull Player p, @NotNull PlayerProfile profile, @NotNull SlimefunGuideMode mode) {
        return false;
    }

    @Override
    public void open(Player p, PlayerProfile profile, SlimefunGuideMode mode) {
        SlimefunGuideImplementation guide = Slimefun.getRegistry().getSlimefunGuide(mode);
        profile.getGuideHistory().add(this, 1);
        ChestMenu menu = new ChestMenu("BedrockTechnology Guide");

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
            if (item.getRecipe().length > 9) {
                menu.addItem(index, item.getItem(), (p12, slot, itemStack, action) -> {
                    EXPAND_PLAY_ITEM.open(p12, profile, mode, item);
                    return false;
                });
            } else {
                menu.addItem(index, item.getItem(), (p12, slot, itemStack, action) -> {
                    ExpandPlayItemGroup.open3x3Recipe(p, profile, mode, item);
                    return false;
                });
            }

            index ++;
        }

        menu.open(p);
    }
}
