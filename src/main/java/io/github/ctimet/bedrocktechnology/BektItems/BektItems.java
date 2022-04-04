package io.github.ctimet.bedrocktechnology.BektItems;

import io.github.ctimet.bedrocktechnology.BektItems.SpecialItems.CoreBlisteringIngot;
import io.github.ctimet.bedrocktechnology.BektItems.SpecialRecipeType.BektRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static io.github.ctimet.bedrocktechnology.BektItems.BektItemGroup.*;


/**
 * 这是一个有着各种物品配方以及其他内容的类
 * @author CTimet
 * @author CLIEDS
 */
public class BektItems
{
    public static final ArrayList<SlimefunItem> items = new ArrayList<>();

    public static final SlimefunItem BEKT_FS;
    public static final SlimefunItem BEKT_LH;
    public static final SlimefunItem BEKT_CL;
    public static final SlimefunItem BEKT_TS;
    public static final SlimefunItem BEKT_XQ;
    public static final SlimefunItem BEKT_DT;
    public static final SlimefunItem BEKT_QH;
    public static final SlimefunItem BEKT_QP;
    public static final SlimefunItem BEKT_BY;
    public static final SlimefunItem BEKT_AJ;
    public static final SlimefunItem BEKT_BJ;
    public static final SlimefunItem BEKT_CJ;
    public static final SlimefunItem BEKT_DJ;
    public static final SlimefunItem BEKT_EJ;
    public static final SlimefunItem BEKT_FJ;
    public static final SlimefunItem BEKT_GJ;
    public static final SlimefunItem BEKT_HJ;
    public static final SlimefunItem BEKT_IJ;
    public static final SlimefunItem BEKT_JJ;
    public static final SlimefunItem BEKT_KJ;
    public static final SlimefunItem BEKT_LJ;
    public static final SlimefunItem BEKT_MJ;
    public static final SlimefunItem BEKT_NJ;
    public static final SlimefunItem BEKT_TONG;
    public static final SlimefunItem BEKT_JINL;
    public static final SlimefunItem BEKT_XINL;
    public static final SlimefunItem BEKT_LVLI;
    public static final SlimefunItem BEKT_QIAN;
    public static final SlimefunItem BEKT_XILI;
    public static final SlimefunItem BEKT_YINL;
    public static final SlimefunItem BEKT_TIEL;
    public static final SlimefunItem BEKT_MEIL;
    public static final SlimefunItem BEKT_JBLZ;
    public static final SlimefunItem BEKT_LNJG;
    public static final SlimefunItem BEKT_GFJG;
    public static final SlimefunItem BEKT_YJGG;
    public static final SlimefunItem BEKT_JYDL;
    public static final SlimefunItem BEKT_EKJG;
    public static final SlimefunItem BEKT_HIJG;
    public static final SlimefunItem BEKT_GJJY;
    public static final SlimefunItem BEKT_YSJY;
    public static final SlimefunItem BEKT_JMJY;
    public static final SlimefunItem BEKT_JYLZ;
    public static final SlimefunItem BEKT_QHLZ;
    public static final SlimefunItem BEKT_JYKK;
    public static final SlimefunItem BEKT_GONG;
    public static final SlimefunItem BEKT_XIJI;
    public static final SlimefunItem BEKT_JBKK;
    
    public static final SlimefunItem BEKT_KFJZI;
    public static final SlimefunItem BEKT_YSJZI;
    public static final SlimefunItem BEKT_EYHGI;
    public static final SlimefunItem BEKT_FLFDI;
    public static final SlimefunItem BEKT_LZTQI;
    
    public static final SlimefunItem BEKT_KFJII;
    public static final SlimefunItem BEKT_YSJII;
    public static final SlimefunItem BEKT_GJFNF;
    public static final SlimefunItem BEKT_GJLZT;
    public static final SlimefunItem BEKT_CJLZT;
    public static final SlimefunItem BEKT_FZLZT;
    public static final SlimefunItem BEKT_FKWJJ;
    public static final SlimefunItem BEKT_WHFXQ;
    public static final SlimefunItem BEKT_WPLZT;
    public static final SlimefunItem BEKT_GJWPT;
    public static final SlimefunItem BEKT_GJDWH;
    public static final SlimefunItem BEKT_DJLZZ;
    public static final SlimefunItem BEKT_GJLZZ;
    public static final SlimefunItem BEKT_LZJSJ;
    public static final SlimefunItem BEKT_CNHXI;
    public static final SlimefunItem BEKT_CNHII;
    public static final SlimefunItem BEKT_CNIII;
    public static final SlimefunItem BEKT_CNHIV;
    public static final SlimefunItem BEKT_CNHXV;
    public static final SlimefunItem BEKT_JGHQQ;
    public static final SlimefunItem BEKT_GJJGH;
    
    public static final SlimefunItem BEKT_HJJJJ;
    public static final SlimefunItem BEKT_JYHJQ;
    public static final SlimefunItem BEKT_JYHCT;
    public static final SlimefunItem BEKT_LZFDJ;
    public static final SlimefunItem BEKT_JYLZF;
    
    public static final SlimefunItem BEKT_GQJYD;
    public static final SlimefunItem BEKT_ZJJYD;
    public static final SlimefunItem BEKT_GTQJQ;
    public static final SlimefunItem BEKT_QCHQJ;
    public static final SlimefunItem BEKT_HYJSJ;
    public static final SlimefunItem BEKT_HYMTQ;
    public static final SlimefunItem BEKT_GNLZJ;
    public static final SlimefunItem BEKT_GHJJQ;
    
    public static final SlimefunItem BEKT_LZHCJ;
    public static final SlimefunItem BEKT_YYSCJ;
    public static final SlimefunItem BEKT_QCSCQ;
    public static final SlimefunItem BEKT_JJJGH;
    public static final SlimefunItem BEKT_JYLZT;
    
    public static final SlimefunItem BEKT_JYJZF;
    public static final SlimefunItem BEKT_JYKKF;
    public static final SlimefunItem BEKT_JYFYD;
    
    public static final SlimefunItem BEKT_JYLR;
    public static final SlimefunItem BEKT_JYMF;
    public static final SlimefunItem BEKT_JYLG;
    public static final SlimefunItem BEKT_JYZQ;
    

    static {
        //==============================基本材料==============================//

        /*风扇*/
         BEKT_FS = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_FS,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                               i(Material.IRON_BLOCK), null,
                        i(Material.IRON_BLOCK),             i(Material.CHAIN),      i(Material.IRON_BLOCK),
                        null,                               i(Material.IRON_BLOCK), null
                }
        );
         items.add(BEKT_FS);

        /*铝合金*/
         BEKT_LH = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_LH,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        SlimefunItems.ALUMINUM_INGOT,          SlimefunItems.ALUMINUM_DUST, SlimefunItems.COMPRESSED_CARBON,
                        SlimefunItems.CORINTHIAN_BRONZE_INGOT, i(Material.GLASS)
                }
        );
         items.add(BEKT_LH);

        /*齿轮*/
         BEKT_CL = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_CL,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.IRON_INGOT), null,                               i(Material.IRON_INGOT),
                        null,                               i(Material.IRON_BLOCK), null,
                        i(Material.IRON_INGOT), null,                               i(Material.IRON_INGOT)
                }
        );
         items.add(BEKT_CL);

        /*提速器*/
         BEKT_TS = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_TS,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CL,              i(Material.IRON_INGOT),             BektItemStack.BEKT_CL,
                        i(Material.IRON_INGOT),             SlimefunItems.OIL_BUCKET,           i(Material.IRON_INGOT),
                        BektItemStack.BEKT_CL,              i(Material.IRON_INGOT),             BektItemStack.BEKT_CL
                }
        );
         items.add(BEKT_TS);

        /*铜线圈*/
         BEKT_XQ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_XQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,
                        SlimefunItems.COPPER_WIRE,          null,                               SlimefunItems.COPPER_WIRE,
                        SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE,          SlimefunItems.COPPER_WIRE
                }
        );
         items.add(BEKT_XQ);

        /*大型铜线圈*/
         BEKT_DT = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_DT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,
                        BektItemStack.BEKT_XQ,          null,                           BektItemStack.BEKT_XQ,
                        BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ,          BektItemStack.BEKT_XQ
                }
        );
         items.add(BEKT_DT);

        /*强化合金核心*/
         BEKT_QH = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_QH,
                BektRecipeType.COMPRESSOR,
                new ItemStack[]{
                        new CustomItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT, 8)
                }
        );
         items.add(BEKT_QH);

        /*起泡锭核心*/
         BEKT_QP = new CoreBlisteringIngot(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_QP,
                BektRecipeType.COMPRESSOR,
                new ItemStack[]{
                        new CustomItemStack(SlimefunItems.BLISTERING_INGOT_3,8)
                }
        );
         items.add(BEKT_QP);

        /*变压器*/
         BEKT_BY = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_BY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_DT,          SlimefunItems.PLASTIC_SHEET,    BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT,          BektItemStack.BEKT_DT
                }
        );
         items.add(BEKT_BY);

        /*A结构*/
         BEKT_AJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_AJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_AJ);

        /*B结构*/
         BEKT_BJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_BJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_BJ);

        /*C结构*/
         BEKT_CJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_CJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_CJ);

        /*D结构*/
         BEKT_DJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_DJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_DJ);

        /*E结构*/
         BEKT_EJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_EJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_EJ);

        /*F结构*/
         BEKT_FJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_FJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_FJ);

        /*G结构*/
         BEKT_GJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_GJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_GJ);

        /*H结构*/
         BEKT_HJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_HJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_HJ);

        /*I结构*/
         BEKT_IJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_IJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_IJ);

        /*J结构*/
         BEKT_JJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_JJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_JJ);

        /*K结构*/
         BEKT_KJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_KJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_KJ);

        /*L结构*/
         BEKT_LJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_LJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_LJ);

        /*M结构*/
         BEKT_MJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_MJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_MJ);

        /*N结构*/
         BEKT_NJ = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_NJ,
                BektRecipeType.BEKT_JGHQQ,
                new ItemStack[]{
                }
        );
         items.add(BEKT_NJ);

        /*铜粒子*/
         BEKT_TONG = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_TONG,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.COPPER_INGOT
                }
        );
         items.add(BEKT_TONG);

        /*金粒子*/
         BEKT_JINL = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_JINL,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.GOLD_24K
                }
        );
         items.add(BEKT_JINL);

        /*锌粒子*/
         BEKT_XINL = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_XINL,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.ZINC_INGOT
                }
        );
         items.add(BEKT_XINL);

        /*铝粒子*/
         BEKT_LVLI = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_LVLI,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.ALUMINUM_INGOT
                }
        );
         items.add(BEKT_LVLI);

        /*铅粒子*/
         BEKT_QIAN = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                BektItemStack.BEKT_QIAN,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.LEAD_INGOT
                }
        );
         items.add(BEKT_QIAN);

         /*锡粒子*/
         BEKT_XILI = new SlimefunItem(
                 Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_XILI,
                 BektRecipeType.BEKT_WPLZT,
                 new ItemStack[]{
                        SlimefunItems.TIN_INGOT
                 }
         );
         items.add(BEKT_XILI);

         /*银粒子*/
         BEKT_YINL = new SlimefunItem(
                 Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_YINL,
                 BektRecipeType.BEKT_WPLZT,
                 new ItemStack[]{
                        SlimefunItems.SILVER_INGOT
                 }
         );
         items.add(BEKT_YINL);

         /*铁粒子*/
         BEKT_TIEL = new SlimefunItem(
                 Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_TIEL,
                 BektRecipeType.BEKT_WPLZT,
                 new ItemStack[]{
                        i(Material.IRON_INGOT)
                 }
         );
         items.add(BEKT_TIEL);

         /*镁粒子*/
         BEKT_MEIL = new SlimefunItem(
                 Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_MEIL,
                 BektRecipeType.BEKT_WPLZT,
                 new ItemStack[]{
                        SlimefunItems.MAGNESIUM_INGOT
                 }
         );
         items.add(BEKT_MEIL);

         /*基本粒子*/
         BEKT_JBLZ = new SlimefunItem(
                 Bekt_SubGroup_JCCL,
                 BektItemStack.BEKT_JBLZ,
                 BektRecipeType.BEKT_LZTQI,
                 new ItemStack[]{
                 }
         );
         items.add(BEKT_JBLZ);

        //==============================基岩材料==============================//

        /*LN结构*/
        BEKT_LNJG = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_LNJG,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        BektItemStack.BEKT_LJ,      BektItemStack.BEKT_NJ,      SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.CARBON,       BektItemStack.BEKT_LH
                }
        );
        items.add(BEKT_LNJG);

        /*GF结构*/
        BEKT_GFJG = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_GFJG,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        BektItemStack.BEKT_GJ,      BektItemStack.BEKT_FJ,      SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.HARDENED_METAL_INGOT,     BektItemStack.BEKT_LH,
                }
        );
        items.add(BEKT_GFJG);

        /*铱结构*/
        BEKT_YJGG = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_YJGG,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        BektItemStack.BEKT_LNJG,        BektItemStack.BEKT_GFJG,        SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.SYNTHETIC_DIAMOND,BektItemStack.BEKT_LH
                }
        );
        items.add(BEKT_YJGG);

        /*基岩电路*/
        BEKT_JYDL = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JYDL,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.BASIC_CIRCUIT_BOARD,  SlimefunItems.ADVANCED_CIRCUIT_BOARD,  SlimefunItems.BASIC_CIRCUIT_BOARD,
                        SlimefunItems.BASIC_CIRCUIT_BOARD,  BektItemStack.BEKT_JYLZ,               SlimefunItems.BASIC_CIRCUIT_BOARD,
                        SlimefunItems.BASIC_CIRCUIT_BOARD,  SlimefunItems.ADVANCED_CIRCUIT_BOARD,  SlimefunItems.BASIC_CIRCUIT_BOARD
                }
        );
        items.add(BEKT_JYDL);

        /*EK结构*/
        BEKT_EKJG = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_EKJG,
                BektRecipeType.COMPRESSOR,
                new ItemStack[]{
                        BektItemStack.BEKT_EJ,      BektItemStack.BEKT_KJ,      BektItemStack.BEKT_AJ,
                        BektItemStack.BEKT_LH
                }
        );
        items.add(BEKT_EKJG);

        /*HI结构*/
        BEKT_HIJG = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_HIJG,
                BektRecipeType.COMPRESSOR,
                new ItemStack[]{
                        BektItemStack.BEKT_HJ,      BektItemStack.BEKT_IJ,      BektItemStack.BEKT_AJ,
                        SlimefunItems.CARBON,       SlimefunItems.SYNTHETIC_DIAMOND,    BektItemStack.BEKT_LH
                }
        );
        items.add(BEKT_HIJG);

        /*高级基岩*/
        BEKT_GJJY = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_GJJY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.BEDROCK),    i(Material.BEDROCK),    i(Material.BEDROCK),
                        i(Material.BEDROCK),    i(Material.BEDROCK),    i(Material.BEDROCK),
                        i(Material.BEDROCK),    i(Material.BEDROCK),    i(Material.BEDROCK)
                }
        );
        items.add(BEKT_GJJY);

        /*压缩基岩*/
        BEKT_YSJY = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_YSJY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,
                        BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,
                        BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY,    BektItemStack.BEKT_GJJY
                }
        );
        items.add(BEKT_YSJY);

        /*极密基岩*/
        BEKT_JMJY = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JMJY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,
                        BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,
                        BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY,    BektItemStack.BEKT_YSJY
                }
        );
        items.add(BEKT_JMJY);

        /*基岩粒子*/
        BEKT_JYLZ = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JYLZ,
                BektRecipeType.BEKT_JYHJQ,
                new ItemStack[]{
                }
        );
        items.add(BEKT_JYLZ);

        /*强化合金粒子*/
        BEKT_QHLZ = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_QHLZ,
                BektRecipeType.BEKT_WPLZT,
                new ItemStack[]{
                        SlimefunItems.REINFORCED_ALLOY_INGOT
                }
        );
        items.add(BEKT_QHLZ);

        /*基岩夸克*/
        BEKT_JYKK = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JYKK,
                BektRecipeType.BEKT_GQYJD,
                new ItemStack[]{
                        BektItemStack.BEKT_JYLZ
                }
        );
        items.add(BEKT_JYKK);

        /*汞*/
        BEKT_GONG = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_GONG,
                BektRecipeType.BEKT_GTQJQ,
                new ItemStack[]{
                }
        );
        items.add(BEKT_GONG);

        /*稀有金*/
        BEKT_XIJI = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_XIJI,
                BektRecipeType.BEKT_GHJJQ,
                new ItemStack[]{
                        BektItemStack.BEKT_GONG
                }
        );
        items.add(BEKT_XIJI);

        /*基本夸克*/
        BEKT_JBKK = new SlimefunItem(
                Bekt_SubGroup_JYCL,
                BektItemStack.BEKT_JBKK,
                BektRecipeType.BEKT_DJLZZ,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ
                }
        );
        items.add(BEKT_JBKK);

        //==============================基础机器==============================//

        /*矿粉制造机I*/
        BEKT_KFJZI = new SlimefunItem(
                Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_KFJZI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.ELECTRIC_ORE_GRINDER_3,       SlimefunItems.ELECTRIFIED_CRUCIBLE_3,       SlimefunItems.ELECTRIC_DUST_WASHER_3,
                        SlimefunItems.REINFORCED_ALLOY_INGOT,       SlimefunItems.REINFORCED_PLATE,             SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.ELECTRIC_ORE_GRINDER_3,       SlimefunItems.ELECTRIFIED_CRUCIBLE_3,       SlimefunItems.ELECTRIC_DUST_WASHER_3
                }
        );
        items.add(BEKT_KFJZI);
        
        /*圆石制造机*/
        BEKT_YSJZI = new SlimefunItem(
                Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_YSJZI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.COBBLESTONE),            i(Material.OBSIDIAN),           i(Material.COBBLESTONE),
                        i(Material.WATER_BUCKET),           i(Material.DIAMOND_PICKAXE),    i(Material.LAVA_BUCKET),
                        i(Material.COBBLESTONE),            i(Material.OBSIDIAN),           i(Material.COBBLESTONE)
                }
        );
        items.add(BEKT_YSJZI);
        
        /*二氧化硅提取机*/
        BEKT_EYHGI = new SlimefunItem(
                Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_EYHGI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.GLASS),                        SlimefunItems.CARBON,                         i(Material.GLASS),
                        SlimefunItems.HEATING_COIL,               SlimefunItems.CARBONADO_EDGED_FURNACE,        SlimefunItems.HEATING_COIL,
                        i(Material.GLASS),                        SlimefunItems.CARBON,                         i(Material.GLASS)
                }
        );
        items.add(BEKT_EYHGI);

        /*风力发电机*/
        BEKT_FLFDI = new SlimefunItem(
                Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_FLFDI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                               i(Material.IRON_BLOCK),                         null,
                        i(Material.IRON_BLOCK),             BektItemStack.BEKT_FS,                          i(Material.IRON_BLOCK),
                        null,                               SlimefunItems.ENERGY_CONNECTOR,                 null
                }
        );
        items.add(BEKT_FLFDI);

        /*粒子提取机*/
        BEKT_LZTQI = new SlimefunItem(
                Bekt_SubGroup_JCJQ,
                BektItemStack.BEKT_LZTQI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.REINFORCED_PLATE,         SlimefunItems.CARBON_CHUNK,                 SlimefunItems.REINFORCED_PLATE,
                        SlimefunItems.SYNTHETIC_DIAMOND,        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,   SlimefunItems.SYNTHETIC_DIAMOND,
                        SlimefunItems.REINFORCED_PLATE,         SlimefunItems.CARBON_CHUNK,                 SlimefunItems.REINFORCED_PLATE
                }
        );
        items.add(BEKT_LZTQI);

        //==============================高级机器==============================//

        /*矿粉制造机II*/
        BEKT_KFJII = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_KFJII,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_LH,              SlimefunItems.CARBON,           BektItemStack.BEKT_LH,
                        SlimefunItems.BLISTERING_INGOT_3,   BektItemStack.BEKT_KFJZI,       SlimefunItems.BLISTERING_INGOT_3,
                        BektItemStack.BEKT_LH,              SlimefunItems.CARBON,           BektItemStack.BEKT_LH
                }
        );
        items.add(BEKT_KFJII);

        /*圆石制造机II*/
        BEKT_YSJII = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_YSJII,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_LH,                  BektItemStack.BEKT_YSJZI,               BektItemStack.BEKT_LH,
                        i(Material.WATER_BUCKET),               i(Material.DIAMOND_PICKAXE),            i(Material.LAVA_BUCKET),
                        BektItemStack.BEKT_LH,                  BektItemStack.BEKT_YSJZI,               BektItemStack.BEKT_LH
                }
        );
        items.add(BEKT_YSJII);

        /*高级风能*/
        BEKT_GJFNF = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJFNF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                               BektItemStack.BEKT_CL,                          null,
                        BektItemStack.BEKT_CL,              i(Material.DIAMOND_PICKAXE),                    BektItemStack.BEKT_CL,
                        SlimefunItems.BLISTERING_INGOT_3,   BektItemStack.BEKT_TS,                          SlimefunItems.BLISTERING_INGOT_3
                }
        );
        items.add(BEKT_GJFNF);

        /*高级粒子提取机*/
        BEKT_GJLZT = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.REINFORCED_PLATE,     SlimefunItems.PROGRAMMABLE_ANDROID_MINER,       SlimefunItems.REINFORCED_PLATE,
                        BektItemStack.BEKT_TS,              BektItemStack.BEKT_LZTQI,                       SlimefunItems.SYNTHETIC_DIAMOND,
                        SlimefunItems.BLISTERING_INGOT_3,   SlimefunItems.PROGRAMMABLE_ANDROID_MINER,       SlimefunItems.BLISTERING_INGOT_3
                }
        );
        items.add(BEKT_GJLZT);

        /*超级粒子提取机*/
        BEKT_CJLZT = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CJLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_TS,              BektItemStack.BEKT_TS,              BektItemStack.BEKT_TS,
                        SlimefunItems.BLISTERING_INGOT_3,   BektItemStack.BEKT_GJLZT,           SlimefunItems.BLISTERING_INGOT_3,
                        BektItemStack.BEKT_LH,              SlimefunItems.REINFORCED_PLATE,     BektItemStack.BEKT_LH
                }
        );
        items.add(BEKT_CJLZT);

        /*虚空粒子提取机*/
        BEKT_FZLZT = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_FZLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_TS,              SlimefunItems.PROGRAMMABLE_ANDROID_MINER,               BektItemStack.BEKT_TS,
                                                            BektItemStack.BEKT_GJLZT,
                        BektItemStack.BEKT_LH,              SlimefunItems.REINFORCED_PLATE,
                }
        );
        items.add(BEKT_FZLZT);

        /*方块挖掘核心*/
        BEKT_FKWJJ = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_FKWJJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.ANDROID_MEMORY_CORE,          SlimefunItems.PROGRAMMABLE_ANDROID_MINER,           SlimefunItems.ANDROID_MEMORY_CORE,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,   i(Material.DIAMOND_PICKAXE),                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        SlimefunItems.ANDROID_MEMORY_CORE,          SlimefunItems.PROGRAMMABLE_ANDROID_MINER,           SlimefunItems.ANDROID_MEMORY_CORE
                }
        );
        items.add(BEKT_FKWJJ);

        /*WH*/
        BEKT_WHFXQ = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_WHFXQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.STEEL_THRUSTER,           null,                               SlimefunItems.STEEL_THRUSTER,
                        null,                                   i(Material.ELYTRA),                 null,
                        SlimefunItems.HOLOGRAM_PROJECTOR,       SlimefunItems.HOLOGRAM_PROJECTOR,   SlimefunItems.HOLOGRAM_PROJECTOR
                }
        );
        items.add(BEKT_WHFXQ);

        /*物品粒子提取机*/
        BEKT_WPLZT = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_WPLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                                   SlimefunItems.ELECTRIC_PRESS_2,             null,
                        i(Material.DIAMOND_PICKAXE),            SlimefunItems.REINFORCED_PLATE,             i(Material.DIAMOND_PICKAXE),
                        null,                                   SlimefunItems.ELECTRIC_PRESS_2,             null
                }
        );
        items.add(BEKT_WPLZT);

        /*高级物品提取机*/
        BEKT_GJWPT = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJWPT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.REINFORCED_PLATE,         SlimefunItems.PROGRAMMABLE_ANDROID_MINER,           SlimefunItems.REINFORCED_PLATE,
                        SlimefunItems.OIL_BUCKET,               BektItemStack.BEKT_WPLZT,                           SlimefunItems.OIL_BUCKET,
                        SlimefunItems.REINFORCED_PLATE,         SlimefunItems.PROGRAMMABLE_ANDROID_MINER,           SlimefunItems.REINFORCED_PLATE
                }
        );
        items.add(BEKT_GJWPT);

        /*高级的WH*/
        BEKT_GJDWH = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJDWH,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                       SlimefunItems.ENDER_LUMP_3,                 null,
                        SlimefunItems.ENDER_LUMP_3, BektItemStack.BEKT_WHFXQ,                   SlimefunItems.ENDER_LUMP_3,
                        null,                       SlimefunItems.ENDER_LUMP_3,                 null
                }
        );
        items.add(BEKT_GJDWH);

        /*低级的粒子对撞机*/
        BEKT_DJLZZ = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_DJLZZ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,            BektItemStack.BEKT_LZJSJ,           BektItemStack.BEKT_JBLZ,
                        BektItemStack.BEKT_DT,              BektItemStack.BEKT_WHFXQ,           BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_JBLZ,            BektItemStack.BEKT_LZJSJ,           BektItemStack.BEKT_JBLZ
                }
        );
        items.add(BEKT_DJLZZ);

        /*高级的粒子对撞机*/
        BEKT_GJLZZ = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJLZZ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                   BektItemStack.BEKT_DJLZZ,               null,
                        BektItemStack.BEKT_DT,  BektItemStack.BEKT_GJDWH,               BektItemStack.BEKT_DT,
                        null,                   BektItemStack.BEKT_LZJSJ,               null
                }
        );
        items.add(BEKT_GJLZZ);

        /*粒子加速机*/
        BEKT_LZJSJ = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_LZJSJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                   BektItemStack.BEKT_DT,                  null,
                        BektItemStack.BEKT_DT,  SlimefunItems.ORE_WASHER,               BektItemStack.BEKT_DT,
                        null,                   BektItemStack.BEKT_DT,                  null
                }
        );
        items.add(BEKT_LZJSJ);

        /*充能核心I*/
        BEKT_CNHXI = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNHXI,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_QH,              SlimefunItems.SOLAR_GENERATOR_4,                BektItemStack.BEKT_QH,
                        SlimefunItems.SOLAR_GENERATOR_4,    SlimefunItems.HARDENED_METAL_INGOT,             SlimefunItems.SOLAR_GENERATOR_4,
                        BektItemStack.BEKT_QH,              SlimefunItems.SOLAR_GENERATOR_4,                BektItemStack.BEKT_QH
                }
        );
        items.add(BEKT_CNHXI);
        
        /*充能核心II*/
        BEKT_CNHII = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNHII,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_DT,              BektItemStack.BEKT_QP,              BektItemStack.BEKT_DT,
                        BektItemStack.BEKT_BY,              BektItemStack.BEKT_CNHXI,           BektItemStack.BEKT_BY,
                        BektItemStack.BEKT_DT,              BektItemStack.BEKT_QP,              BektItemStack.BEKT_DT
                }
        );
        items.add(BEKT_CNHII);
        
        /*充能核心III*/
        BEKT_CNIII = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNIII,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CNHII,           BektItemStack.BEKT_CNHII,           BektItemStack.BEKT_CNHII,
                        BektItemStack.BEKT_QP,              BektItemStack.BEKT_QH,              SlimefunItems.CARBON,
                        BektItemStack.BEKT_BY,              BektItemStack.BEKT_JJ,              BektItemStack.BEKT_BY
                }
        );
        items.add(BEKT_CNIII);
        
        /*充能核心IV*/
        BEKT_CNHIV = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNHIV,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CNIII,           BektItemStack.BEKT_CNIII,           BektItemStack.BEKT_CNIII,
                        BektItemStack.BEKT_AJ,              SlimefunItems.PLASTIC_SHEET,        BektItemStack.BEKT_BJ,
                        BektItemStack.BEKT_JBLZ,            BektItemStack.BEKT_JBLZ,            BektItemStack.BEKT_JBLZ
                }
        );
        items.add(BEKT_CNHIV);
        
        /*充能核心V*/
        BEKT_CNHXV = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_CNHXV,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_CNHIV,           BektItemStack.BEKT_CNHIV,           BektItemStack.BEKT_CNHIV,
                        BektItemStack.BEKT_LNJG,            SlimefunItems.PLASTIC_SHEET,        BektItemStack.BEKT_EKJG,
                        BektItemStack.BEKT_EYHGI,           BektItemStack.BEKT_EYHGI,           BektItemStack.BEKT_EYHGI
                }
        );
        items.add(BEKT_CNHXV);
        
        /*结构获取器*/
        BEKT_JGHQQ = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_JGHQQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.GEO_MINER,            SlimefunItems.GEO_MINER,                  SlimefunItems.GEO_MINER,
                        SlimefunItems.ENERGIZED_CAPACITOR,  i(Material.DIAMOND_PICKAXE),  SlimefunItems.ENERGIZED_CAPACITOR,
                        i(Material.BUCKET),     BektItemStack.BEKT_QH,                    i(Material.BUCKET)
                }
        );
        items.add(BEKT_JGHQQ);
        
        /*高级结构获取器*/
        BEKT_GJJGH = new SlimefunItem(
                Bekt_SubGroup_GJJQ,
                BektItemStack.BEKT_GJJGH,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                   BektItemStack.BEKT_BJ,                  null,
                        BektItemStack.BEKT_AJ,  BektItemStack.BEKT_JGHQQ,               BektItemStack.BEKT_CJ,
                        null,                   BektItemStack.BEKT_DJ,                  null
                }
        );
        items.add(BEKT_GJJGH);

        //============================低级基岩机器============================//
        
        /*轰击机*/
        BEKT_HJJJJ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_HJJJJ,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{

                }
        );
        items.add(BEKT_HJJJJ);
        
        /*基岩轰击器*/
        BEKT_JYHJQ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_JYHJQ,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        c(BektItemStack.BEKT_QHLZ,32),          BektItemStack.BEKT_LJ,          c(SlimefunItems.CARBON,32),
                        BektItemStack.BEKT_NJ,                     BektItemStack.BEKT_DJLZZ,       BektItemStack.BEKT_GJ,
                        BektItemStack.BEKT_LNJG,                   BektItemStack.BEKT_FJ,          BektItemStack.BEKT_GFJG
                }
        );
        items.add(BEKT_JYHJQ);

        /*基岩合成台*/
        BEKT_JYHCT = new SlimefunItem(
                Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_JYHCT,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        BektItemStack.BEKT_JYLZ,                BektItemStack.BEKT_JYLZ,                BektItemStack.BEKT_JYLZ,
                        c(BektItemStack.BEKT_LNJG,16),       i(Material.CRAFTING_TABLE),             c(BektItemStack.BEKT_GFJG,16),
                        BektItemStack.BEKT_JBLZ,                BektItemStack.BEKT_JBLZ,                BektItemStack.BEKT_JBLZ
                }
        );
        items.add(BEKT_JYHCT);

        /*粒子发电*/
        BEKT_LZFDJ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_LZFDJ,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        c(BektItemStack.BEKT_LNJG,32),      c(BektItemStack.BEKT_LNJG,32),      c(BektItemStack.BEKT_LNJG,32),
                        BektItemStack.BEKT_QH,                 SlimefunItems.NETHER_STAR_REACTOR,     BektItemStack.BEKT_QH,
                        c(BektItemStack.BEKT_JBLZ,32),      c(BektItemStack.BEKT_JBLZ,32),      c(BektItemStack.BEKT_JBLZ,32)
                }
        );
        items.add(BEKT_LZFDJ);

        /*简化粒子发电机*/
        BEKT_JYLZF = new SlimefunItem(
                Bekt_SubGroup_JYJQ_DJ,
                BektItemStack.BEKT_JYLZF,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                BektItemStack.BEKT_JBLZ,                BektItemStack.BEKT_JBLZ,
                        SlimefunItems.NUCLEAR_REACTOR,          SlimefunItems.NUCLEAR_REACTOR,          SlimefunItems.NUCLEAR_REACTOR,
                        c(BektItemStack.BEKT_GFJG,32),       c(BektItemStack.BEKT_GFJG,32),       c(BektItemStack.BEKT_GFJG,32)
                }
        );
        items.add(BEKT_JYLZF);

        //============================高级基岩机器============================//

        /*基岩对撞机*/
        BEKT_GQJYD = new SlimefunItem(
                Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_GQJYD,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        SlimefunItems.ENERGIZED_CAPACITOR,          BektItemStack.BEKT_EYHGI,           SlimefunItems.ENERGIZED_CAPACITOR,
                        c(BektItemStack.BEKT_HJJJJ,16),          BektItemStack.BEKT_JYLZ,            c(BektItemStack.BEKT_HJJJJ,16),
                        c(BektItemStack.BEKT_LNJG,32),           BektItemStack.BEKT_EYHGI,           c(BektItemStack.BEKT_GFJG,32)
                }
        );
        items.add(BEKT_GQJYD);

        /*加强基岩对撞机*/
        BEKT_ZJJYD = new SlimefunItem(
                Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_ZJJYD,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        BektItemStack.BEKT_YJGG,                    c(BektItemStack.BEKT_JYLZ,4),             BektItemStack.BEKT_YJGG,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,   BektItemStack.BEKT_GQJYD,                    SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        BektItemStack.BEKT_LNJG,                    c(BektItemStack.BEKT_JYLZ,4),             BektItemStack.BEKT_GFJG
                }
        );
        items.add(BEKT_ZJJYD);

        /*汞提取机*/
        BEKT_GTQJQ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_GHJJQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_HJJJJ,                   BektItemStack.BEKT_HJJJJ,                   BektItemStack.BEKT_HJJJJ,
                        BektItemStack.BEKT_JYKK,                    SlimefunItems.PROGRAMMABLE_ANDROID_MINER,   BektItemStack.BEKT_JYKK,
                        BektItemStack.BEKT_GJJGH,                   i(Material.BEDROCK),                        BektItemStack.BEKT_GJJGH
                }
        );
        items.add(BEKT_GTQJQ);

        /*鞘翅获取器*/
        BEKT_QCHQJ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_QCHQJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_GJLZT,                   BektItemStack.BEKT_JBLZ,                    BektItemStack.BEKT_GJLZT,
                        BektItemStack.BEKT_CJ,                      BektItemStack.BEKT_CNHII,                   BektItemStack.BEKT_HJ,
                        BektItemStack.BEKT_GJLZT,                   BektItemStack.BEKT_JBLZ,                    BektItemStack.BEKT_GJLZT
                }
        );
        items.add(BEKT_QCHQJ);

        /*幻翼击杀机*/
        BEKT_HYJSJ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_HYJSJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                    i(Material.PHANTOM_MEMBRANE),   BektItemStack.BEKT_JBLZ,
                        i(Material.DIAMOND_PICKAXE),                BektItemStack.BEKT_CNIII,       i(Material.DIAMOND_PICKAXE),
                        BektItemStack.BEKT_JBLZ,                    i(Material.PHANTOM_MEMBRANE),   BektItemStack.BEKT_JBLZ
                }
        );
        items.add(BEKT_HYJSJ);

        /*幻翼提取机*/
        BEKT_HYMTQ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_HYMTQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                    SlimefunItems.GPS_TRANSMITTER_4,            BektItemStack.BEKT_JBLZ,
                        BektItemStack.BEKT_JYDL,                    BektItemStack.BEKT_HYJSJ,                   BektItemStack.BEKT_JYDL,
                        BektItemStack.BEKT_JBLZ,                    SlimefunItems.GPS_TRANSMITTER_4,            BektItemStack.BEKT_JBLZ
                }
        );
        items.add(BEKT_HYMTQ);
        
        /*高级粒子转换器*/
        BEKT_GNLZJ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_GNLZJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                    SlimefunItems.ADVANCED_CIRCUIT_BOARD,       BektItemStack.BEKT_JBLZ,
                        BektItemStack.BEKT_JYDL,                    i(Material.CHEST),                          BektItemStack.BEKT_JYDL,
                        BektItemStack.BEKT_JBLZ,                    SlimefunItems.ADVANCED_CIRCUIT_BOARD,       BektItemStack.BEKT_JBLZ
                }
        );
        items.add(BEKT_GNLZJ);

        /*汞轰击器*/
        BEKT_GHJJQ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_GJ,
                BektItemStack.BEKT_GHJJQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JBLZ,                    BektItemStack.BEKT_HIJG,                    BektItemStack.BEKT_JBLZ,
                        BektItemStack.BEKT_LZJSJ,                   BektItemStack.BEKT_HJJJJ,                   BektItemStack.BEKT_LZJSJ,
                        BektItemStack.BEKT_HJ,                      BektItemStack.BEKT_EKJG,                    BektItemStack.BEKT_IJ
                }
        );
        items.add(BEKT_GHJJQ);

        //============================终极基岩机器============================//

        /*粒子合成机*/
        BEKT_LZHCJ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_LZHCJ,
                BektRecipeType.BEKT_QHGZT,
                new ItemStack[]{
                        c(BektItemStack.BEKT_XIJI,16),          c(BektItemStack.BEKT_YJGG,16),              c(BektItemStack.BEKT_JYHCT,16),
                        c(BektItemStack.BEKT_JYLZ,16),          c(i(Material.BEDROCK),16),                  c(BektItemStack.BEKT_JYDL,16),
                        c(BektItemStack.BEKT_JYKK,16),          c(BektItemStack.BEKT_LNJG,16),              c(BektItemStack.BEKT_GFJG,16)
                }
        );
        items.add(BEKT_LZHCJ);

        /*原油生成机*/
        BEKT_YYSCJ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_YYSCJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.OIL_PUMP,                     SlimefunItems.GPS_TRANSMITTER_4,                    SlimefunItems.OIL_PUMP,
                        SlimefunItems.OIL_PUMP,                     i(Material.BEDROCK),                                SlimefunItems.OIL_PUMP,
                        SlimefunItems.OIL_PUMP,                     SlimefunItems.OIL_PUMP,                             SlimefunItems.OIL_PUMP
                }
        );
        items.add(BEKT_YYSCJ);
        
        /*鞘翅生成*/
        BEKT_QCSCQ = new SlimefunItem(
                Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_QCSCQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.ELYTRA),             i(Material.ELYTRA),                     i(Material.ELYTRA),
                        BektItemStack.BEKT_XIJI,        i(Material.BEDROCK),                    BektItemStack.BEKT_XIJI,
                        i(Material.ELYTRA),             i(Material.ELYTRA),                     i(Material.ELYTRA)
                }
        );
        items.add(BEKT_QCSCQ);
        
        /*终极结构获取器*/
        BEKT_JJJGH = new SlimefunItem(
                Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_JJJGH,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_GJJGH,                   BektItemStack.BEKT_GJJGH,                   BektItemStack.BEKT_GJJGH,
                        BektItemStack.BEKT_LNJG,                    i(Material.BEDROCK),                        BektItemStack.BEKT_GFJG,
                        BektItemStack.BEKT_XIJI,                    BektItemStack.BEKT_XIJI,                    BektItemStack.BEKT_XIJI
                }
        );
        items.add(BEKT_JJJGH);
        
        /*基岩粒子提取器*/
        BEKT_JYLZT = new SlimefunItem(
                Bekt_SubGroup_JYJQ_ZJ,
                BektItemStack.BEKT_JYLZT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_FZLZT,               BektItemStack.BEKT_FZLZT,       BektItemStack.BEKT_FZLZT,
                        BektItemStack.BEKT_XIJI,                i(Material.BEDROCK),            BektItemStack.BEKT_XIJI,
                        BektItemStack.BEKT_GJJY,                i(Material.DIAMOND_PICKAXE),    BektItemStack.BEKT_GJJY
                }
        );
        items.add(BEKT_JYLZT);

        //==============================基岩发电==============================//
        
        /*基岩粒子发电机*/
        BEKT_JYJZF = new SlimefunItem(
                Bekt_SubGroup_JYFD,
                BektItemStack.BEKT_JYLZF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.BEDROCK),            BektItemStack.BEKT_JYLZ,            i(Material.BEDROCK),
                        i(Material.BEDROCK),            BektItemStack.BEKT_YSJY,            i(Material.BEDROCK),
                        i(Material.BEDROCK),            i(Material.BEDROCK),                i(Material.BEDROCK)
                }
        );
        items.add(BEKT_JYJZF);

        /*夸克发电*/
        BEKT_JYKKF = new SlimefunItem(
                Bekt_SubGroup_JYFD,
                BektItemStack.BEKT_JYKKF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_YSJY,
                        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_JMJY,        BektItemStack.BEKT_YSJY,
                        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_YSJY,        BektItemStack.BEKT_YSJY
                }
        );
        items.add(BEKT_JYKKF);

        /*基岩反应堆*/
        BEKT_JYFYD = new SlimefunItem(
                Bekt_SubGroup_JYFD,
                BektItemStack.BEKT_JYFYD,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JMJY,        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY,
                        BektItemStack.BEKT_JMJY,        SlimefunItems.NETHER_STAR_REACTOR,  BektItemStack.BEKT_JMJY,
                        BektItemStack.BEKT_JMJY,        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY
                }
        );
        items.add(BEKT_JYFYD);

        //==============================基岩工具==============================//

        /*基岩利刃*/
        BEKT_JYLR = new SlimefunItem(
                Bekt_SubGroup_JYGJ,
                BektItemStack.BEKT_JYLR,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,           BektItemStack.BEKT_JMJY,            null,
                        null,           BektItemStack.BEKT_JMJY,            null,
                        null,           i(Material.BEDROCK),                null
                }
        );
        items.add(BEKT_JYLR);

        /*基岩猛斧子*/
        BEKT_JYMF = new SlimefunItem(
                Bekt_SubGroup_JYGJ,
                BektItemStack.BEKT_JYMF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY,            null,
                        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_YSJY,            null,
                        null,                               i(Material.BEDROCK),                null
                }
        );
        items.add(BEKT_JYMF);

        /*基岩烈镐*/
        BEKT_JYLG = new SlimefunItem(
                Bekt_SubGroup_JYGJ,
                BektItemStack.BEKT_JYLG,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY,            BektItemStack.BEKT_JMJY,
                        null,                               i(Material.BEDROCK),                null,
                        null,                               i(Material.BEDROCK),                null
                }
        );
        items.add(BEKT_JYLG);

        /*基岩之锹*/
        BEKT_JYZQ = new SlimefunItem(
                Bekt_SubGroup_JYGJ,
                BektItemStack.BEKT_JYZQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                   BektItemStack.BEKT_JMJY,                    null,
                        null,                   BektItemStack.BEKT_YSJY,                    null,
                        null,                   i(Material.BEDROCK),                        null
                }
        );
        items.add(BEKT_JYZQ);
    }

    static CustomItemStack c(ItemStack itemStack, int n){
        return new CustomItemStack(itemStack,n);
    }
    
    static ItemStack i(Material material){
        return new ItemStack(material);
    }

}
