package io.github.ctimet.bekt.BektItems;

import io.github.ctimet.bekt.BektItems.SpecialItems.CoreBlisteringIngot;
import io.github.ctimet.bekt.BektItems.SpecialRecipeType.BektRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bekt.BektItems.BektItemGroup.Bekt_SubGroup_JCCL;

public class BektItems 
{
    //风扇
    public static final SlimefunItem BEKT_FS = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_FS,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null,                               new ItemStack(Material.IRON_BLOCK), null,
                    new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.CHAIN),      new ItemStack(Material.IRON_BLOCK),
                    null,                               new ItemStack(Material.IRON_BLOCK), null
            }
    );

    //铝合金
    public static final SlimefunItem BEKT_LH = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_LH,
            RecipeType.SMELTERY,
            new ItemStack[]{
                    SlimefunItems.ALUMINUM_INGOT,          SlimefunItems.ALUMINUM_DUST, SlimefunItems.COMPRESSED_CARBON,
                    SlimefunItems.CORINTHIAN_BRONZE_INGOT, new ItemStack(Material.GLASS)
            }
    );

    //齿轮
    public static final SlimefunItem BEKT_CL = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_CL,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    new ItemStack(Material.IRON_INGOT), null,                               new ItemStack(Material.IRON_INGOT),
                    null,                               new ItemStack(Material.IRON_BLOCK), null,
                    new ItemStack(Material.IRON_INGOT), null,                               new ItemStack(Material.IRON_INGOT)
            }
    );

    //提速器
    public static final SlimefunItem BEKT_TS = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_TS,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    BektItemStack.BEKT_CL,              new ItemStack(Material.IRON_INGOT), BektItemStack.BEKT_CJ,
                    new ItemStack(Material.IRON_INGOT), SlimefunItems.OIL_BUCKET,           new ItemStack(Material.IRON_INGOT),
                    BektItemStack.BEKT_CL,              new ItemStack(Material.IRON_INGOT), BektItemStack.BEKT_CL
            }
    );
    
    //铜线圈
    public static final SlimefunItem BEKT_XQ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_XQ,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,
                    SlimefunItems.COPPER_WIRE,          null,                               SlimefunItems.COPPER_WIRE,
                    SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE
            }
    );
    
    //大型铜线圈
    public static final SlimefunItem BEKT_DT = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_DT,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,
                    BektItemStack.BEKT_XQ,          null,                           BektItemStack.BEKT_XQ,
                    BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ
            }
    );

    //强化合金核心
    public static final SlimefunItem BEKT_QH = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_QH,
            RecipeType.COMPRESSOR,
            new ItemStack[]{
                    new CustomItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT, 8)
            }
    );
    
    //起泡锭核心
    public static final SlimefunItem BEKT_QP = new CoreBlisteringIngot(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_QP,
            RecipeType.COMPRESSOR,
            new ItemStack[]{
                    new CustomItemStack(SlimefunItems.BLISTERING_INGOT_3,8)
            }
    );

    //变压器
    public static final SlimefunItem BEKT_BY = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_BY,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,
                    BektItemStack.BEKT_DT,          SlimefunItems.PLASTIC_SHEET,    BektItemStack.BEKT_DT,
                    BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT
            }
    );
    
    //A结构
    public static final SlimefunItem BEKT_AJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_AJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_AJ
            }
    );
    
    //B结构
    public static final SlimefunItem BEKT_BJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_BJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_BJ
            }
    );

    //C结构
    public static final SlimefunItem BEKT_CJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_CJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_CJ
            }
    );

    //D结构
    public static final SlimefunItem BEKT_DJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_DJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_DJ
            }
    );

    //E结构
    public static final SlimefunItem BEKT_EJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_EJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_EJ
            }
    );

    //F结构
    public static final SlimefunItem BEKT_FJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_FJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_FJ
            }
    );

    //G结构
    public static final SlimefunItem BEKT_GJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_GJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_GJ
            }
    );

    //H结构
    public static final SlimefunItem BEKT_HJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_HJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_HJ
            }
    );

    //I结构
    public static final SlimefunItem BEKT_IJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_IJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_IJ
            }
    );

    //J结构
    public static final SlimefunItem BEKT_JJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_JJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_JJ
            }
    );

    //K结构
    public static final SlimefunItem BEKT_KJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_KJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_KJ
            }
    );

    //L结构
    public static final SlimefunItem BEKT_LJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_LJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_LJ
            }
    );

    //M结构
    public static final SlimefunItem BEKT_MJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_LJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_MJ
            }
    );

    //N结构
    public static final SlimefunItem BEKT_NJ = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_NJ,
            BektRecipeType.BEKT_JGHQQ,
            new ItemStack[]{
                    BektItemStack.BEKT_NJ
            }
    );

    //铜粒子
    public static final SlimefunItem BEKT_TONG = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_TONG,
            BektRecipeType.BEKT_LZTQI,
            new ItemStack[]{
                    BektItemStack.BEKT_TONG
            }
    );

    //金粒子
    public static final SlimefunItem BEKT_JINL = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_JINL,
            BektRecipeType.BEKT_LZTQI,
            new ItemStack[]{
                    BektItemStack.BEKT_JINL
            }
    );

    //锌粒子
    public static final SlimefunItem BEKT_XINL = new SlimefunItem(
            Bekt_SubGroup_JCCL,
            BektItemStack.BEKT_XINL,
            BektRecipeType.BEKT_LZTQI,
            new ItemStack[]{
                    BektItemStack.BEKT_XINL
            }
    );


}
