package io.github.ctimet.bedrocktechnology.core.BektItems;

import io.github.ctimet.bedrocktechnology.initial.BektItems;
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
    //基础材料
    public static SubItemGroup Bekt_SubGroup_JCCL = getSubGroup(
            Material.WHITE_STAINED_GLASS,
            "BEKT_JCCL",
            "&lBEKT &7- &b基础材料"
    );
    //基岩材料
    public static SubItemGroup Bekt_SubGroup_JYCL = getSubGroup(
            Material.BLACK_STAINED_GLASS,
            "BEKT_JYCL",
            "&lBEKT &7- &b基岩材料"
    );
    //基础机器
    public static SubItemGroup Bekt_SubGroup_JCJQ = getSubGroup(
            Material.IRON_BLOCK,
            "BEKT-JCJQ",
            "&lBEKT &7- &b基础机器"
    );
    //高级机器
    public static SubItemGroup Bekt_SubGroup_GJJQ = getSubGroup(
            Material.GOLD_BLOCK,
            "BEKT-GJJQ",
            "&lBEKT &7- &b高级机器"
    );
    //低级基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_DJ = getSubGroup(
            Material.COAL_ORE,
            "BEKT_JYJQ_DJ",
            "&lBEKT &7- &b低级基岩机器"
    );
    //高级基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_GJ = getSubGroup(
            Material.GOLD_ORE,
            "BEKT_JYJQ_GJ",
            "&lBEKT &7- &b高级基岩机器"
    );
    //终极基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_ZJ = getSubGroup(
            Material.DIAMOND_ORE,
            "BEKT_JYJQ_ZJ",
            "&lBEKT &7- &b终极基岩机器"
    );
    //基岩发电
    public static SubItemGroup Bekt_SubGroup_JYFD = getSubGroup(
            Material.REDSTONE_BLOCK,
            "BEKT_JYFD",
            "&lBEKT &7- &b基岩发电"
    );
    //基岩工具
    public static SubItemGroup Bekt_SubGroup_JYGJ = getSubGroup(
            Material.CHISELED_STONE_BRICKS,
            "BEKT_JYGJ",
            "&lBEKT &7- 基岩工具"
    );
    //魔法物品
    public static SubItemGroup Bekt_SubGroup_MFWP = getSubGroup(
            Material.REDSTONE,
            "BEKT_MFWP",
            "&lBEKT &7- 魔法物品"
    );
    //无尽发电机面板数据削弱恢复  恢复无尽检测其他附属按比例削弱的发电量 建议各位腐竹ban掉无尽的发电机使用我们修复过的,以免玩家搞混
    //包含制作无尽太阳能系列所需的全部材料及其材质  面板数据1:1同步 且有此附属单独标签,无法与无尽物品联用!
    public static SubItemGroup Bekt_SubGroup_FDXF = getSubGroup(
            Material.NETHER_STAR,
            "BEKT_INFINITY_SLOAR_FIX",
            "&lBEKT &7-无尽发电机面板数据修复"
    );
    public static void registerSubCate(){
        BektItems.register();
    }

    public static SubItemGroup getSubGroup(Material material,String key,String name){
        return new SubItemGroup(BektMain.createKey(key),Bekt_MainGroup,new CustomItemStack(material,name));
    }
}
