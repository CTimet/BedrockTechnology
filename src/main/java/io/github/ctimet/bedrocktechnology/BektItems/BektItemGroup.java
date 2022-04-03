package io.github.ctimet.bedrocktechnology.BektItems;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;

import static io.github.ctimet.bedrocktechnology.BektItems.BektItems.items;

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
    public static final BektMain main = BektMain.main;

    
    public static void registerSubCate(){
        items.forEach(e -> e.register(main));
    }

    public static SubItemGroup getSubGroup(Material material,String key,String name){
        return new SubItemGroup(BektMain.createKey(key),Bekt_MainGroup,new CustomItemStack(material,name));
    }
}
