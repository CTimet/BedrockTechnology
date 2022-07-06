package io.github.ctimet.bedrocktechnology.core.items;

import io.github.ctimet.bedrocktechnology.initial.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;

/**
 * @author CTimet
 * @author CLIEDS
 * @version beta1.0.0
 */
public class BektItemGroup
{
    public static NestedItemGroup Bekt_MainGroup = new NestedItemGroup(BektMain.createKey("BEKT_BEKT_BE"),
            new CustomItemStack(Material.BEDROCK, "&lBEKT &7- &b基岩科技"));

    //机器保护
    public static SubItemGroup Bekt_SubGroup_JQBH;
    //网络系统
    public static SubItemGroup Bekt_SubGroup_WL;
    //芯片制作
    public static SubItemGroup Bekt_SubGroup_XP;
    //魔法物品
    public static SubItemGroup Bekt_SubGroup_MFWP;
    //拓展玩法
    public static SubItemGroup Bekt_SubGroup_KZWF;

    /**
     * 注册子组，该方法必须放在onEnable中且必须比BektItems.register()方法先执行
     */
    public static void registerGroup() {
        Bekt_SubGroup_JQBH = getSubGroup(
                Material.COMMAND_BLOCK,
                "BEKT_SJBH",
                "&aBEKT &7- 机器保护"
        );
        Bekt_SubGroup_WL = getSubGroup(
                Material.BEACON,
                "BEKT_WL",
                "&lBEKT &7- &bNet(开发中)"
        );
        Bekt_SubGroup_XP = getSubGroup(
                Material.BEACON,
                "BEKT_XP",
                "&lBEKT &7- &b芯片(开发中)"
        );
        Bekt_SubGroup_MFWP = getSubGroup(
                Material.REDSTONE,
                "BEKT_MFWP",
                "&lBEKT &7- 魔法物品（开发中）"
        );
        Bekt_SubGroup_KZWF = getSubGroup(
                Material.REDSTONE,
                "BEKT_TZWF",
                "&lBEKT &7- 拓展玩法（开发中）"
        );
    }

    public static SubItemGroup getSubGroup(Material material,String key,String name){
        return new SubItemGroup(BektMain.createKey(key),Bekt_MainGroup,new CustomItemStack(material,name));
    }
}
