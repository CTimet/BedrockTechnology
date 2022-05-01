package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.BektItems.BaseItem.BektItemStack;
import io.github.ctimet.bedrocktechnology.core.BektItems.BaseItem.SpecialItems.CoreBlisteringIngot;
import io.github.ctimet.bedrocktechnology.core.BektItems.BaseItem.SpecialRecipeType.BektRecipeType;
import io.github.ctimet.bedrocktechnology.core.BektItems.BektItemGroup;
import io.github.ctimet.bedrocktechnology.core.BektItems.material.JcjqBasicMachine.Eyhgt;
import io.github.ctimet.bedrocktechnology.core.BektItems.material.JcjqBasicMachine.Kfjzi;
import io.github.ctimet.bedrocktechnology.core.BektItems.material.JcjqBasicMachine.Ysjzi;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.initial.BektMain.main;


/**
 * 这是一个有着各种物品配方以及其他内容的类
 * @author CTimet
 * @author CLIEDS
 */
public class BektItems
{
    public static void register()
    {
        //==============================基本材料==============================//

        /*风扇*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_FS,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                               i(Material.IRON_BLOCK), null,
                        i(Material.IRON_BLOCK),             i(Material.CHAIN),      i(Material.IRON_BLOCK),
                        null,                               i(Material.IRON_BLOCK), null
                }
        ).register(main);

        /*铝合金*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_LH,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        SlimefunItems.ALUMINUM_INGOT,          SlimefunItems.ALUMINUM_DUST, SlimefunItems.COMPRESSED_CARBON,
                        SlimefunItems.CORINTHIAN_BRONZE_INGOT, i(Material.GLASS)
                }
        ).register(main);

        /*齿轮*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_CL,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.IRON_INGOT), null,                               i(Material.IRON_INGOT),
                        null,                               i(Material.IRON_BLOCK), null,
                        i(Material.IRON_INGOT), null,                               i(Material.IRON_INGOT)
                }
        ).register(main);

        /*提速器*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_TS,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CL,              i(Material.IRON_INGOT),             BektItemStack.BEKT_CL,
                        i(Material.IRON_INGOT),             SlimefunItems.OIL_BUCKET,           i(Material.IRON_INGOT),
                        BektItemStack.BEKT_CL,              i(Material.IRON_INGOT),             BektItemStack.BEKT_CL
                }
        ).register(main);


        /*铜线圈*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_XQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,
                        SlimefunItems.COPPER_WIRE,          null,                               SlimefunItems.COPPER_WIRE,
                        SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE
                }
        ).register(main);

        /*大型铜线圈*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_DT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,
                        BektItemStack.BEKT_XQ,          null,                           BektItemStack.BEKT_XQ,
                        BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ
                }
        ).register(main);

        /*强化合金核心*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_QH,
                BektRecipeType.COMPRESSOR,
                new ItemStack[]{
                        new CustomItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT, 8)
                }
        ).register(main);

        /*起泡锭核心*/
         new CoreBlisteringIngot(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_QP,
                BektRecipeType.COMPRESSOR,
                new ItemStack[]{
                        new CustomItemStack(SlimefunItems.BLISTERING_INGOT_3,8)
                }
        ).register(main);

        /*变压器*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_BY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_DT,          SlimefunItems.PLASTIC_SHEET,    BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT
                }
        ).register(main);

        /*A结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_AJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*B结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_BJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*C结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_CJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*D结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_DJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*E结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_EJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*F结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_FJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*G结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_GJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*H结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_HJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*I结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_IJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*J结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_JJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*K结构*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_KJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*L结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_LJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*M结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_MJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*N结构*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_NJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        ).register(main);

        /*铜粒子*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_TONG,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.COPPER_INGOT
                }
        ).register(main);

        /*金粒子*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_JINL,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.GOLD_24K
                }
        ).register(main);

        /*锌粒子*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_XINL,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.ZINC_INGOT
                }
        ).register(main);

        /*铝粒子*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_LVLI,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.ALUMINUM_INGOT
                }
        ).register(main);

        /*铅粒子*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_QIAN,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.LEAD_INGOT
                }
        ).register(main);

         /*锡粒子*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_XILI,
                 BektRecipeType.BEKT_WPLZT,
                 new ItemStack[]{
                        SlimefunItems.TIN_INGOT
                 }
         ).register(main);

         /*银粒子*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_YINL,
                 BektRecipeType.BEKT_WPLZT,
                 new ItemStack[]{
                        SlimefunItems.SILVER_INGOT
                 }
         ).register(main);

         /*铁粒子*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_TIEL,
                 BektRecipeType.BEKT_WPLZT,
                 new ItemStack[]{
                        i(Material.IRON_INGOT)
                 }
         ).register(main);

         /*镁粒子*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_MEIL,
                 BektRecipeType.BEKT_WPLZT,
                 new ItemStack[]{
                        SlimefunItems.MAGNESIUM_INGOT
                 }
         ).register(main);

         /*基本粒子*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_JBLZ,
                 BektRecipeType.BEKT_LZTQI,
                 new ItemStack[]{
                 }
         ).register(main);

        /*二氧化硅*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_EYHG,
                BektRecipeType.BEKT_EYHGT,
                new ItemStack[]{new ItemStack(Material.SAND)}
        ).register(main);

        //==============================魔法材料==============================//

        /*超级修复-注册*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_MFWP,
                BektItemStack.BEKT_CJXF_ZC,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_AJ,          BektItemStack.BEKT_AJ,              BektItemStack.BEKT_AJ,
                        null,                           i(Material.STICK),                  null,
                        BektItemStack.BEKT_BJ,          BektItemStack.BEKT_BJ,              BektItemStack.BEKT_BJ
                }
         ).register(main);

         /*超级修复*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_MFWP,
                 BektItemStack.BEKT_CJXF_XF,
                 BektRecipeType.ENHANCED_CRAFTING_TABLE,
                 new ItemStack[]{
                         BektItemStack.BEKT_BJ,          BektItemStack.BEKT_BJ,              BektItemStack.BEKT_BJ,
                         null,                           i(Material.STICK),                  null,
                         BektItemStack.BEKT_AJ,          BektItemStack.BEKT_AJ,              BektItemStack.BEKT_AJ
                 }
         ).register(main);

        //==============================基岩材料==============================//

        /*LN结构*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_LNJG,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        BektItemStack.BEKT_LJ,      BektItemStack.BEKT_NJ,      SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.CARBON,       BektItemStack.BEKT_LH
                }
        );

        /*GF结构*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_GFJG,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        BektItemStack.BEKT_GJ,      BektItemStack.BEKT_FJ,      SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.HARDENED_METAL_INGOT,     BektItemStack.BEKT_LH,
                }
        ).register(main);

        /*铱结构*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_YJGG,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        BektItemStack.BEKT_LNJG,        BektItemStack.BEKT_GFJG,        SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.SYNTHETIC_DIAMOND,BektItemStack.BEKT_LH
                }
        ).register(main);

        /*基岩电路*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JYDL,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.BASIC_CIRCUIT_BOARD,  SlimefunItems.ADVANCED_CIRCUIT_BOARD,  SlimefunItems.BASIC_CIRCUIT_BOARD,
                        SlimefunItems.BASIC_CIRCUIT_BOARD,  BektItemStack.BEKT_JYLZ,               SlimefunItems.BASIC_CIRCUIT_BOARD,
                        SlimefunItems.BASIC_CIRCUIT_BOARD,  SlimefunItems.ADVANCED_CIRCUIT_BOARD,  SlimefunItems.BASIC_CIRCUIT_BOARD
                }
        ).register(main);

        /*EK结构*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_EKJG,
                BektRecipeType.COMPRESSOR,
                new ItemStack[]{
                        BektItemStack.BEKT_EJ,      BektItemStack.BEKT_KJ,      BektItemStack.BEKT_AJ,
                        BektItemStack.BEKT_LH
                }
        ).register(main);

        /*HI结构*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_HIJG,
                BektRecipeType.COMPRESSOR,
                new ItemStack[]{
                        BektItemStack.BEKT_HJ,      BektItemStack.BEKT_IJ,      BektItemStack.BEKT_AJ,
                        SlimefunItems.CARBON,       SlimefunItems.SYNTHETIC_DIAMOND,    BektItemStack.BEKT_LH
                }
        ).register(main);

        /*高级基岩*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_GJJY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.BEDROCK),    i(Material.BEDROCK),    i(Material.BEDROCK),
                        i(Material.BEDROCK),    i(Material.BEDROCK),    i(Material.BEDROCK),
                        i(Material.BEDROCK),    i(Material.BEDROCK),    i(Material.BEDROCK)
                }
        ).register(main);

        /*压缩基岩*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_YSJY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,
                        BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,
                        BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY
                }
        ).register(main);

        /*极密基岩*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JMJY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,
                        BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,
                        BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY
                }
        ).register(main);

        /*基岩粒子*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JYLZ,
                BektRecipeType.BEKT_JYHJQ,
                new ItemStack[]{
                }
        ).register(main);

        /*强化合金粒子*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_QHLZ,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.REINFORCED_ALLOY_INGOT
                }
        ).register(main);

        /*基岩夸克*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JYKK,
                BektRecipeType.BEKT_GQYJD,
                new ItemStack[]{
                        BektItemStack.BEKT_JYLZ
                }
        ).register(main);

        /*汞*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_GONG,
                BektRecipeType.BEKT_GTQJQ,
                new ItemStack[]{
                }
        ).register(main);

        /*稀有金*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_XIJI,
                BektRecipeType.BEKT_GHJJQ,
                new ItemStack[]{
                        BektItemStack.BEKT_GONG
                }
        ).register(main);

        /*基本夸克*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JBKK,
                BektRecipeType.BEKT_DJLZZ,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ
                }
        ).register(main);

        //==============================基础机器==============================//

        /*矿粉制造机I*/
        new Kfjzi(
                BektItemGroup.Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_KFJZI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.ELECTRIC_ORE_GRINDER_3,       SlimefunItems.ELECTRIFIED_CRUCIBLE_3,       SlimefunItems.ELECTRIC_DUST_WASHER_3,
                        SlimefunItems.REINFORCED_ALLOY_INGOT,       SlimefunItems.REINFORCED_PLATE,             SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.ELECTRIC_ORE_GRINDER_3,       SlimefunItems.ELECTRIFIED_CRUCIBLE_3,       SlimefunItems.ELECTRIC_DUST_WASHER_3
                }
        ).setCapacity(300)
                .setEnergyConsumption(300)
                .setProcessingSpeed(3)
                .setNumber(2)
                .register(main);

        /*圆石制造机*/
        new Ysjzi(
                BektItemGroup.Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_YSJZI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.COBBLESTONE),            i(Material.OBSIDIAN),           i(Material.COBBLESTONE),
                        i(Material.WATER_BUCKET),           i(Material.DIAMOND_PICKAXE),    i(Material.LAVA_BUCKET),
                        i(Material.COBBLESTONE),            i(Material.OBSIDIAN),           i(Material.COBBLESTONE)
                }
        ).setCapacity(30)
                .setEnergyConsumption(30)
                .setProcessingSpeed(1)
                .register(main);

        /*二氧化硅提取机*/
        new Eyhgt(
                BektItemGroup.Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_EYHGT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.GLASS),                        SlimefunItems.CARBON,                         i(Material.GLASS),
                        SlimefunItems.HEATING_COIL,               SlimefunItems.CARBONADO_EDGED_FURNACE,        SlimefunItems.HEATING_COIL,
                        i(Material.GLASS),                        SlimefunItems.CARBON,                         i(Material.GLASS)
                }
        ).setCapacity(500)
                .setEnergyConsumption(500)
                .setProcessingSpeed(4)
                .register(main);

        /*风力发电机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_FLFDI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                               i(Material.IRON_BLOCK),                         null,
                        i(Material.IRON_BLOCK),             BektItemStack.BEKT_FS,                          i(Material.IRON_BLOCK),
                        null,                               SlimefunItems.ENERGY_CONNECTOR,                 null
                }
        ).register(main);

        /*粒子提取机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_LZTQI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.REINFORCED_PLATE,         SlimefunItems.CARBON_CHUNK,                 SlimefunItems.REINFORCED_PLATE,
                        SlimefunItems.SYNTHETIC_DIAMOND,        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,   SlimefunItems.SYNTHETIC_DIAMOND,
                        SlimefunItems.REINFORCED_PLATE,         SlimefunItems.CARBON_CHUNK,                 SlimefunItems.REINFORCED_PLATE
                }
        ).register(main);

        //==============================高级机器==============================//

        /*矿粉制造机II*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_KFJII,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_LH,              SlimefunItems.CARBON,           BektItemStack.BEKT_LH,
                        SlimefunItems.BLISTERING_INGOT_3,   BektItemStack.BEKT_KFJZI,       SlimefunItems.BLISTERING_INGOT_3,
                        BektItemStack.BEKT_LH,              SlimefunItems.CARBON,           BektItemStack.BEKT_LH
                }
        ).register(main);

        /*圆石制造机II*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_YSJII,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_LH,                  BektItemStack.BEKT_YSJZI,               BektItemStack.BEKT_LH,
                        i(Material.WATER_BUCKET),               i(Material.DIAMOND_PICKAXE),            i(Material.LAVA_BUCKET),
                        BektItemStack.BEKT_LH,                  BektItemStack.BEKT_YSJZI,               BektItemStack.BEKT_LH
                }
        ).register(main);

        /*高级风能*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJFNF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                               BektItemStack.BEKT_CL,                          null,
                        BektItemStack.BEKT_CL,              i(Material.DIAMOND_PICKAXE),                    BektItemStack.BEKT_CL,
                        SlimefunItems.BLISTERING_INGOT_3,   BektItemStack.BEKT_TS,                          SlimefunItems.BLISTERING_INGOT_3
                }
        ).register(main);

        /*高级粒子提取机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.REINFORCED_PLATE,     SlimefunItems.PROGRAMMABLE_ANDROID_MINER,       SlimefunItems.REINFORCED_PLATE,
                        BektItemStack.BEKT_TS,              BektItemStack.BEKT_LZTQI,                       SlimefunItems.SYNTHETIC_DIAMOND,
                        SlimefunItems.BLISTERING_INGOT_3,   SlimefunItems.PROGRAMMABLE_ANDROID_MINER,       SlimefunItems.BLISTERING_INGOT_3
                }
        ).register(main);

        /*超级粒子提取机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CJLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_TS,              BektItemStack.BEKT_TS,              BektItemStack.BEKT_TS,
                        SlimefunItems.BLISTERING_INGOT_3,   BektItemStack.BEKT_GJLZT,           SlimefunItems.BLISTERING_INGOT_3,
                        BektItemStack.BEKT_LH,              SlimefunItems.REINFORCED_PLATE,     BektItemStack.BEKT_LH
                }
        ).register(main);

        /*虚空粒子提取机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_FZLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_TS,              SlimefunItems.PROGRAMMABLE_ANDROID_MINER,               BektItemStack.BEKT_TS,
                                                            BektItemStack.BEKT_GJLZT,
                        BektItemStack.BEKT_LH,              SlimefunItems.REINFORCED_PLATE,
                }
        ).register(main);

        /*方块挖掘核心*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_FKWJJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.ANDROID_MEMORY_CORE,          SlimefunItems.PROGRAMMABLE_ANDROID_MINER,           SlimefunItems.ANDROID_MEMORY_CORE,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,   i(Material.DIAMOND_PICKAXE),                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        SlimefunItems.ANDROID_MEMORY_CORE,          SlimefunItems.PROGRAMMABLE_ANDROID_MINER,           SlimefunItems.ANDROID_MEMORY_CORE
                }
        ).register(main);

        /*WH*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_WHFXQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.STEEL_THRUSTER,           null,                               SlimefunItems.STEEL_THRUSTER,
                        null,                                   i(Material.ELYTRA),                 null,
                        SlimefunItems.HOLOGRAM_PROJECTOR,       SlimefunItems.HOLOGRAM_PROJECTOR,   SlimefunItems.HOLOGRAM_PROJECTOR
                }
        ).register(main);

        /*物品粒子提取机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_WPLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                                   SlimefunItems.ELECTRIC_PRESS_2,             null,
                        i(Material.DIAMOND_PICKAXE),            SlimefunItems.REINFORCED_PLATE,             i(Material.DIAMOND_PICKAXE),
                        null,                                   SlimefunItems.ELECTRIC_PRESS_2,             null
                }
        ).register(main);

        /*高级物品提取机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJWPT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.REINFORCED_PLATE,         SlimefunItems.PROGRAMMABLE_ANDROID_MINER,           SlimefunItems.REINFORCED_PLATE,
                        SlimefunItems.OIL_BUCKET,               BektItemStack.BEKT_WPLZT,                           SlimefunItems.OIL_BUCKET,
                        SlimefunItems.REINFORCED_PLATE,         SlimefunItems.PROGRAMMABLE_ANDROID_MINER,           SlimefunItems.REINFORCED_PLATE
                }
        ).register(main);

        /*高级的WH*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJDWH,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                       SlimefunItems.ENDER_LUMP_3,                 null,
                        SlimefunItems.ENDER_LUMP_3, BektItemStack.BEKT_WHFXQ,                   SlimefunItems.ENDER_LUMP_3,
                        null,                       SlimefunItems.ENDER_LUMP_3,                 null
                }
        ).register(main);

        /*低级的粒子对撞机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_DJLZZ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,            BektItemStack.BEKT_LZJSJ,           BektItemStack.BEKT_JBLZ,
                        BektItemStack.BEKT_DT,              BektItemStack.BEKT_WHFXQ,           BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_JBLZ,            BektItemStack.BEKT_LZJSJ,           BektItemStack.BEKT_JBLZ
                }
        ).register(main);

        /*高级的粒子对撞机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJLZZ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                   BektItemStack.BEKT_DJLZZ,               null,
                        BektItemStack.BEKT_DT,  BektItemStack.BEKT_GJDWH,               BektItemStack.BEKT_DT,
                        null,                   BektItemStack.BEKT_LZJSJ,               null
                }
        ).register(main);

        /*粒子加速机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_LZJSJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                   BektItemStack.BEKT_DT,                  null,
                        BektItemStack.BEKT_DT,  SlimefunItems.ORE_WASHER,               BektItemStack.BEKT_DT,
                        null,                   BektItemStack.BEKT_DT,                  null
                }
        ).register(main);

        /*充能核心I*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNHXI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_QH,              SlimefunItems.SOLAR_GENERATOR_4,                BektItemStack.BEKT_QH,
                        SlimefunItems.SOLAR_GENERATOR_4,    SlimefunItems.HARDENED_METAL_INGOT,             SlimefunItems.SOLAR_GENERATOR_4,
                        BektItemStack.BEKT_QH,              SlimefunItems.SOLAR_GENERATOR_4,                BektItemStack.BEKT_QH
                }
        ).register(main);

        /*充能核心II*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNHII,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_DT,              BektItemStack.BEKT_QP,              BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_BY,              BektItemStack.BEKT_CNHXI,           BektItemStack.BEKT_BY,
                        BektItemStack.BEKT_DT,              BektItemStack.BEKT_QP,              BektItemStack.BEKT_DT
                }
        ).register(main);

        /*充能核心III*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNIII,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CNHII,           BektItemStack.BEKT_CNHII,           BektItemStack.BEKT_CNHII,
                        BektItemStack.BEKT_QP,              BektItemStack.BEKT_QH,              SlimefunItems.CARBON,
                        BektItemStack.BEKT_BY,              BektItemStack.BEKT_JJ,              BektItemStack.BEKT_BY
                }
        ).register(main);

        /*充能核心IV*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNHIV,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CNIII,           BektItemStack.BEKT_CNIII,           BektItemStack.BEKT_CNIII,
                        BektItemStack.BEKT_AJ,              SlimefunItems.PLASTIC_SHEET,        BektItemStack.BEKT_BJ,
                        BektItemStack.BEKT_JBLZ,            BektItemStack.BEKT_JBLZ,            BektItemStack.BEKT_JBLZ
                }
        ).register(main);

        /*充能核心V*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNHXV,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CNHIV,           BektItemStack.BEKT_CNHIV,           BektItemStack.BEKT_CNHIV,
                        BektItemStack.BEKT_LNJG,            SlimefunItems.PLASTIC_SHEET,        BektItemStack.BEKT_EKJG,
                        BektItemStack.BEKT_EYHG,            BektItemStack.BEKT_EYHG,            BektItemStack.BEKT_EYHG
                }
        ).register(main);

        /*结构获取器*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_JGHQQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.GEO_MINER,            SlimefunItems.GEO_MINER,                  SlimefunItems.GEO_MINER,
                        SlimefunItems.ENERGIZED_CAPACITOR,  i(Material.DIAMOND_PICKAXE),  SlimefunItems.ENERGIZED_CAPACITOR,
                        i(Material.BUCKET),     BektItemStack.BEKT_QH,                    i(Material.BUCKET)
                }
        ).register(main);

        /*高级结构获取器*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJJGH,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                   BektItemStack.BEKT_BJ,                  null,
                        BektItemStack.BEKT_AJ,  BektItemStack.BEKT_JGHQQ,               BektItemStack.BEKT_CJ,
                        null,                   BektItemStack.BEKT_DJ,                  null
                }
        ).register(main);

        //============================低级基岩机器============================//

        /*轰击机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_HJJJJ,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{

                }
        ).register(main);

        /*基岩轰击器*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_JYHJQ,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        c(BektItemStack.BEKT_QHLZ,32),          BektItemStack.BEKT_LJ,          c(SlimefunItems.CARBON,32),
                        BektItemStack.BEKT_NJ,                     BektItemStack.BEKT_DJLZZ,       BektItemStack.BEKT_GJ,
                        BektItemStack.BEKT_LNJG,                   BektItemStack.BEKT_FJ,          BektItemStack.BEKT_GFJG
                }
        ).register(main);

        /*基岩合成台*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_JYHCT,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        BektItemStack.BEKT_JYLZ,                BektItemStack.BEKT_JYLZ,                BektItemStack.BEKT_JYLZ,
                        c(BektItemStack.BEKT_LNJG,16),       i(Material.CRAFTING_TABLE),             c(BektItemStack.BEKT_GFJG,16),
                        BektItemStack.BEKT_JBLZ,                BektItemStack.BEKT_JBLZ,                BektItemStack.BEKT_JBLZ
                }
        ).register(main);

        /*粒子发电*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_LZFDJ,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        c(BektItemStack.BEKT_LNJG,32),      c(BektItemStack.BEKT_LNJG,32),      c(BektItemStack.BEKT_LNJG,32),
                        BektItemStack.BEKT_QH,                 SlimefunItems.NETHER_STAR_REACTOR,     BektItemStack.BEKT_QH,
                        c(BektItemStack.BEKT_JBLZ,32),      c(BektItemStack.BEKT_JBLZ,32),      c(BektItemStack.BEKT_JBLZ,32)
                }
        ).register(main);

        /*简化粒子发电机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_JYLZF,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                BektItemStack.BEKT_JBLZ,                BektItemStack.BEKT_JBLZ,
                        SlimefunItems.NUCLEAR_REACTOR,          SlimefunItems.NUCLEAR_REACTOR,          SlimefunItems.NUCLEAR_REACTOR,
                        c(BektItemStack.BEKT_GFJG,32),       c(BektItemStack.BEKT_GFJG,32),       c(BektItemStack.BEKT_GFJG,32)
                }
        ).register(main);

        //============================高级基岩机器============================//

        /*基岩对撞机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_GQJYD,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        SlimefunItems.ENERGIZED_CAPACITOR,          BektItemStack.BEKT_EYHG,           SlimefunItems.ENERGIZED_CAPACITOR,
                        c(BektItemStack.BEKT_HJJJJ,16),          BektItemStack.BEKT_JYLZ,            c(BektItemStack.BEKT_HJJJJ,16),
                        c(BektItemStack.BEKT_LNJG,32),           BektItemStack.BEKT_EYHG,           c(BektItemStack.BEKT_GFJG,32)
                }
        ).register(main);

        /*加强基岩对撞机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_ZJJYD,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        BektItemStack.BEKT_YJGG,                    c(BektItemStack.BEKT_JYLZ,4),             BektItemStack.BEKT_YJGG,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,   BektItemStack.BEKT_GQJYD,                    SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        BektItemStack.BEKT_LNJG,                    c(BektItemStack.BEKT_JYLZ,4),             BektItemStack.BEKT_GFJG
                }
        ).register(main);

        /*汞提取机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_GTQJQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_HJJJJ,                   BektItemStack.BEKT_HJJJJ,                   BektItemStack.BEKT_HJJJJ,
                        BektItemStack.BEKT_JYKK,                    SlimefunItems.PROGRAMMABLE_ANDROID_MINER,   BektItemStack.BEKT_JYKK,
                        BektItemStack.BEKT_GJJGH,                   i(Material.BEDROCK),                        BektItemStack.BEKT_GJJGH
                }
        ).register(main);

        /*鞘翅获取器*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_QCHQJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_GJLZT,                   BektItemStack.BEKT_JBLZ,                    BektItemStack.BEKT_GJLZT,
                        BektItemStack.BEKT_CJ,                      BektItemStack.BEKT_CNHII,                   BektItemStack.BEKT_HJ,
                        BektItemStack.BEKT_GJLZT,                   BektItemStack.BEKT_JBLZ,                    BektItemStack.BEKT_GJLZT
                }
        ).register(main);

        /*幻翼击杀机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_HYJSJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                    i(Material.PHANTOM_MEMBRANE),   BektItemStack.BEKT_JBLZ,
                        i(Material.DIAMOND_PICKAXE),                BektItemStack.BEKT_CNIII,       i(Material.DIAMOND_PICKAXE),
                        BektItemStack.BEKT_JBLZ,                    i(Material.PHANTOM_MEMBRANE),   BektItemStack.BEKT_JBLZ
                }
        ).register(main);

        /*幻翼提取机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_HYMTQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                    SlimefunItems.GPS_TRANSMITTER_4,            BektItemStack.BEKT_JBLZ,
                        BektItemStack.BEKT_JYDL,                    BektItemStack.BEKT_HYJSJ,                   BektItemStack.BEKT_JYDL,
                        BektItemStack.BEKT_JBLZ,                    SlimefunItems.GPS_TRANSMITTER_4,            BektItemStack.BEKT_JBLZ
                }
        ).register(main);

        /*高级粒子转换器*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_GNLZJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                    SlimefunItems.ADVANCED_CIRCUIT_BOARD,       BektItemStack.BEKT_JBLZ,
                        BektItemStack.BEKT_JYDL,                    i(Material.CHEST),                          BektItemStack.BEKT_JYDL,
                        BektItemStack.BEKT_JBLZ,                    SlimefunItems.ADVANCED_CIRCUIT_BOARD,       BektItemStack.BEKT_JBLZ
                }
        ).register(main);

        /*汞轰击器*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_GHJJQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                    BektItemStack.BEKT_HIJG,                    BektItemStack.BEKT_JBLZ,
                        BektItemStack.BEKT_LZJSJ,                   BektItemStack.BEKT_HJJJJ,                   BektItemStack.BEKT_LZJSJ,
                        BektItemStack.BEKT_HJ,                      BektItemStack.BEKT_EKJG,                    BektItemStack.BEKT_IJ
                }
        ).register(main);

        //============================终极基岩机器============================//

        /*粒子合成机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_LZHCJ,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        c(BektItemStack.BEKT_XIJI,16),          c(BektItemStack.BEKT_YJGG,16),              c(BektItemStack.BEKT_JYHCT,16),
                        c(BektItemStack.BEKT_JYLZ,16),          c(i(Material.BEDROCK),16),                  c(BektItemStack.BEKT_JYDL,16),
                        c(BektItemStack.BEKT_JYKK,16),          c(BektItemStack.BEKT_LNJG,16),              c(BektItemStack.BEKT_GFJG,16)
                }
        ).register(main);

        /*原油生成机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_YYSCJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.OIL_PUMP,                     SlimefunItems.GPS_TRANSMITTER_4,                    SlimefunItems.OIL_PUMP,
                        SlimefunItems.OIL_PUMP,                     i(Material.BEDROCK),                                SlimefunItems.OIL_PUMP,
                        SlimefunItems.OIL_PUMP,                     SlimefunItems.OIL_PUMP,                             SlimefunItems.OIL_PUMP
                }
        ).register(main);
        
        /*鞘翅生成*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_QCSCQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.ELYTRA),             i(Material.ELYTRA),                     i(Material.ELYTRA),
                        BektItemStack.BEKT_XIJI,        i(Material.BEDROCK),                    BektItemStack.BEKT_XIJI,
                        i(Material.ELYTRA),             i(Material.ELYTRA),                     i(Material.ELYTRA)
                }
        ).register(main);
        
        /*终极结构获取器*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_JJJGH,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_GJJGH,                   BektItemStack.BEKT_GJJGH,                   BektItemStack.BEKT_GJJGH,
                        BektItemStack.BEKT_LNJG,                    i(Material.BEDROCK),                        BektItemStack.BEKT_GFJG,
                        BektItemStack.BEKT_XIJI,                    BektItemStack.BEKT_XIJI,                    BektItemStack.BEKT_XIJI
                }
        ).register(main);
        
        /*基岩粒子提取器*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_JYLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_FZLZT,               BektItemStack.BEKT_FZLZT,       BektItemStack.BEKT_FZLZT,
                        BektItemStack.BEKT_XIJI,                i(Material.BEDROCK),            BektItemStack.BEKT_XIJI,
                        BektItemStack.BEKT_GJJY,                i(Material.DIAMOND_PICKAXE),    BektItemStack.BEKT_GJJY
                }
        ).register(main);

        //==============================基岩发电==============================//
        
        /*基岩粒子发电机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYFD,
                BektItemStack.BEKT_JYJZF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.BEDROCK),            BektItemStack.BEKT_JYLZ,            i(Material.BEDROCK),
                        i(Material.BEDROCK),            BektItemStack.BEKT_YSJY,            i(Material.BEDROCK),
                        i(Material.BEDROCK),            i(Material.BEDROCK),                i(Material.BEDROCK)
                }
        ).register(main);

        /*夸克发电*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYFD,
                BektItemStack.BEKT_JYKKF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_YSJY,
                        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_JMJY,        BektItemStack.BEKT_YSJY,
                        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_YSJY
                }
        ).register(main);

        /*基岩反应堆*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYFD,
                BektItemStack.BEKT_JYFYD,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JMJY,        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY,
                        BektItemStack.BEKT_JMJY,        SlimefunItems.NETHER_STAR_REACTOR,  BektItemStack.BEKT_JMJY,
                        BektItemStack.BEKT_JMJY,        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY
                }
        ).register(main);

        //==============================基岩工具==============================//

        /*基岩利刃*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYGJ,
                BektItemStack.BEKT_JYLR,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,           BektItemStack.BEKT_JMJY,            null,
                        null,           BektItemStack.BEKT_JMJY,            null,
                        null,           i(Material.BEDROCK),                null
                }
        ).register(main);

        /*基岩猛斧子*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYGJ,
                BektItemStack.BEKT_JYMF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY,            null,
                        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_YSJY,            null,
                        null,                               i(Material.BEDROCK),                null
                }
        ).register(main);

        /*基岩烈镐*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYGJ,
                BektItemStack.BEKT_JYLG,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY,
                        null,                               i(Material.BEDROCK),                null,
                        null,                               i(Material.BEDROCK),                null
                }
        ).register(main);

        /*基岩之锹*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYGJ,
                BektItemStack.BEKT_JYZQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                   BektItemStack.BEKT_JMJY,                    null,
                        null,                   BektItemStack.BEKT_YSJY,                    null,
                        null,                   i(Material.BEDROCK),                        null
                }
        ).register(main);
    }

    static CustomItemStack c(ItemStack itemStack, int n){
        return new CustomItemStack(itemStack,n);
    }
    
    static ItemStack i(Material material){
        return new ItemStack(material);
    }
}
