package io.github.ctimet.bedrocktechnology.core.items.group;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
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

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class MainItemGroup extends FlexItemGroup {
    private final ItemGroup[] SUBGROUPS;

    private static final int[] BORDER = new int[] {
             0,  2,  3,  4,  5,  6,  7,  8,
            45, 46, 47, 48, 49, 50, 51, 52, 53
    };

    public MainItemGroup(NamespacedKey key, ItemStack item, ItemGroup... subGroups) {
        super(key, item);
        this.SUBGROUPS = subGroups;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isVisible(Player p, PlayerProfile profile, SlimefunGuideMode layout) {
        return layout != SlimefunGuideMode.CHEAT_MODE;
    }

    @ParametersAreNonnullByDefault
    @Override
    public void open(Player p, PlayerProfile profile, SlimefunGuideMode mode) {
        SlimefunGuideImplementation guide = Slimefun.getRegistry().getSlimefunGuide(mode);
        profile.getGuideHistory().add(this, 1);
        ChestMenu menu = new ChestMenu("BedrockTechnology Guide");
        menu.setEmptySlotsClickable(false);
        menu.addMenuOpeningHandler((pl) -> pl.playSound(pl.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1.0F, 1.0F));
        for (int i : BORDER) {
            menu.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        String back = ChatColor.GRAY + Slimefun.getLocalization().getMessage(p, "guide.back.guide");
        menu.addItem(1, ChestMenuUtils.getBackButton(p, "", back));
        menu.addMenuClickHandler(1, (pl, s, is, action) -> {
            profile.getGuideHistory().goBack(guide);
            return false;
        });

        int index = 9;
        for (ItemGroup group : SUBGROUPS) {
            menu.addItem(index, group.getItem(p));
            menu.addMenuClickHandler(index, (p1, slot, item, action) -> {
                profile.getGuideHistory().add(group, 1);
                SlimefunGuide.openItemGroup(profile, group, mode, 1);
                return false;
            });
            index ++;
        }

        menu.open(p);
    }

    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        super.register(addon);
        for (ItemGroup group : SUBGROUPS) {
            if (!group.isRegistered()) {
                group.register(addon);
            }
        }
    }
}
