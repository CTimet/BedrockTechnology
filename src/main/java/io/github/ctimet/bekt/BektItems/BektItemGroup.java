package io.github.ctimet.bekt.BektItems;

import io.github.ctimet.bekt.BektItems.SpecialItems.CoreBlisteringIngot;
import io.github.ctimet.bekt.BektItems.SpecialRecipeType.BektRecipeType;
import io.github.ctimet.bekt.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author CTimet
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
        SlimefunItem BEKT_FS = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_FS,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                               new ItemStack(Material.IRON_BLOCK), null,
                        new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.CHAIN),      new ItemStack(Material.IRON_BLOCK),
                        null,                               new ItemStack(Material.IRON_BLOCK), null
                }
        );
        BEKT_FS.register(main);

        //铝合金
        SlimefunItem BEKT_LH = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_LH,
                RecipeType.SMELTERY,
                new ItemStack[]{
                        SlimefunItems.ALUMINUM_INGOT,          SlimefunItems.ALUMINUM_DUST, SlimefunItems.COMPRESSED_CARBON,
                        SlimefunItems.CORINTHIAN_BRONZE_INGOT, new ItemStack(Material.GLASS)
                }
        );
        BEKT_LH.register(main);

        //齿轮
        SlimefunItem BEKT_CL = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_CL,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.IRON_INGOT), null,                               new ItemStack(Material.IRON_INGOT),
                        null,                               new ItemStack(Material.IRON_BLOCK), null,
                        new ItemStack(Material.IRON_INGOT), null,                               new ItemStack(Material.IRON_INGOT)
                }
        );
        BEKT_CL.register(main);

        //提速器
        SlimefunItem BEKT_TS = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_TS,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CL,              new ItemStack(Material.IRON_INGOT), BektItemStack.BEKT_CJ,
                        new ItemStack(Material.IRON_INGOT), SlimefunItems.OIL_BUCKET,           new ItemStack(Material.IRON_INGOT),
                        BektItemStack.BEKT_CL,              new ItemStack(Material.IRON_INGOT), BektItemStack.BEKT_CL
                }
        );
        BEKT_TS.register(main);

        //铜线圈
        SlimefunItem BEKT_XQ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_XQ,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,
                        SlimefunItems.COPPER_WIRE,          null,                               SlimefunItems.COPPER_WIRE,
                        SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE
                }
        );
        BEKT_XQ.register(main);

        //大型铜线圈
        SlimefunItem BEKT_DT = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_DT,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,
                        BektItemStack.BEKT_XQ,          null,                           BektItemStack.BEKT_XQ,
                        BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ
                }
        );
        BEKT_DT.register(main);

        //强化合金核心
        SlimefunItem BEKT_QH = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_QH,
                RecipeType.COMPRESSOR,
                new ItemStack[]{
                        new CustomItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT, 8)
                }
        );
        BEKT_QH.register(main);

        //起泡锭核心
        SlimefunItem BEKT_QP = new CoreBlisteringIngot(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_QP,
                RecipeType.COMPRESSOR,
                new ItemStack[]{
                        new CustomItemStack(SlimefunItems.BLISTERING_INGOT_3,8)
                }
        );
        BEKT_QP.register(main);

        //变压器
        SlimefunItem BEKT_BY = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_BY,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_DT,          SlimefunItems.PLASTIC_SHEET,    BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT
                }
        );
        BEKT_BY.register(main);

        //A结构
        SlimefunItem BEKT_AJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_AJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                        BektItemStack.BEKT_AJ
                }
        );
        BEKT_AJ.register(main);

        //B结构
        SlimefunItem BEKT_BJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_BJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                        BektItemStack.BEKT_BJ
                }
        );
        BEKT_BJ.register(main);

        //C结构
        SlimefunItem BEKT_CJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_CJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                        BektItemStack.BEKT_CJ
                }
        );
        BEKT_CJ.register(main);

        //D结构
        SlimefunItem BEKT_DJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_DJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                        BektItemStack.BEKT_DJ
                }
        );
        BEKT_DJ.register(main);

        //E结构
        SlimefunItem BEKT_EJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_EJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                        BektItemStack.BEKT_EJ
                }
        );
        BEKT_EJ.register(main);

        //F结构
        SlimefunItem BEKT_FJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_FJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                        BektItemStack.BEKT_FJ
                }
        );
        BEKT_FJ.register(main);

        //G结构
        SlimefunItem BEKT_GJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_GJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                        BektItemStack.BEKT_GJ
                }
        );
        BEKT_GJ.register(main);

        //累死了，明天再写，提交推送！
    }

    public static SubItemGroup getSubGroup(Material material,String key,String name){
        return new SubItemGroup(BektMain.createKey(key),Bekt_MainGroup,new CustomItemStack(material,name));
    }

    public static void sayInfo(String info){
        BektMain.main.getLogger().info(info);
    }
}
