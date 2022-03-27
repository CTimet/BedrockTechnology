package io.github.ctimet.bedrocktechnology.BektItems;

import io.github.ctimet.bedrocktechnology.BektMain;
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
    public static final BektMain main = BektMain.main;

    
    public static void registerSubCate(){
        //风扇
        BektItems.BEKT_FS.register(main);

        //铝合金
        BektItems.BEKT_LH.register(main);

        //齿轮
        BektItems.BEKT_CL.register(main);

        //提速器
        BektItems.BEKT_TS.register(main);

        //铜线圈
        BektItems.BEKT_XQ.register(main);

        //大型铜线圈
        BektItems.BEKT_DT.register(main);

        //强化合金核心
        BektItems.BEKT_QH.register(main);

        //起泡锭核心
        BektItems.BEKT_QP.register(main);

        //变压器
        BektItems.BEKT_BY.register(main);

        //A结构
        BektItems.BEKT_AJ.register(main);

        //B结构
        BektItems.BEKT_BJ.register(main);

        //C结构
        BektItems.BEKT_CJ.register(main);

        //D结构
        BektItems.BEKT_DJ.register(main);

        //E结构
        BektItems.BEKT_EJ.register(main);

        //F结构
        BektItems.BEKT_FJ.register(main);

        //G结构
        BektItems.BEKT_GJ.register(main);

        //H结构
        BektItems.BEKT_HJ.register(main);

        //I结构
        BektItems.BEKT_IJ.register(main);

        //J结构
        BektItems.BEKT_JJ.register(main);

        //K结构
        BektItems.BEKT_KJ.register(main);

        //L结构
        BektItems.BEKT_LJ.register(main);

        //M结构
        BektItems.BEKT_MJ.register(main);

        //N结构
        BektItems.BEKT_NJ.register(main);

        //铜粒子
        BektItems.BEKT_TONG.register(main);

        //金粒子
        BektItems.BEKT_JINL.register(main);

        //锌粒子
        BektItems.BEKT_XINL.register(main);
    }

    public static SubItemGroup getSubGroup(Material material,String key,String name){
        return new SubItemGroup(BektMain.createKey(key),Bekt_MainGroup,new CustomItemStack(material,name));
    }
}
