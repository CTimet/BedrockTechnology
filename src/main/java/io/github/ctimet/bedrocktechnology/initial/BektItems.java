package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.BektItems.BektItemGroup;
import io.github.ctimet.bedrocktechnology.core.BektItems.BektItemStacks;
import io.github.ctimet.bedrocktechnology.core.BektItems.BektRecipeType;
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
                BektItemStacks.BEKT_FS,
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
                BektItemStacks.BEKT_LH,
                BektRecipeType.SMELTERY,
                new ItemStack[]{
                        SlimefunItems.ALUMINUM_INGOT,          SlimefunItems.ALUMINUM_DUST, SlimefunItems.COMPRESSED_CARBON,
                        SlimefunItems.CORINTHIAN_BRONZE_INGOT, i(Material.GLASS)
                }
        ).register(main);

        /*齿轮*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStacks.BEKT_CL,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        i(Material.IRON_INGOT), null,                               i(Material.IRON_INGOT),
                        null,                               i(Material.IRON_BLOCK), null,
                        i(Material.IRON_INGOT), null,                               i(Material.IRON_INGOT)
                }
        ).register(main);

        /*铜线圈*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStacks.BEKT_XQ,
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
                BektItemStacks.BEKT_DT,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStacks.BEKT_XQ,          BektItemStacks.BEKT_XQ,          BektItemStacks.BEKT_XQ,
                        BektItemStacks.BEKT_XQ,          null,                           BektItemStacks.BEKT_XQ,
                        BektItemStacks.BEKT_XQ,          BektItemStacks.BEKT_XQ,          BektItemStacks.BEKT_XQ
                }
        ).register(main);

        /*变压器*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStacks.BEKT_BY,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BektItemStacks.BEKT_DT,          BektItemStacks.BEKT_DT,          BektItemStacks.BEKT_DT,
                        BektItemStacks.BEKT_DT,          SlimefunItems.PLASTIC_SHEET,    BektItemStacks.BEKT_DT,
                        BektItemStacks.BEKT_DT,          BektItemStacks.BEKT_DT,          BektItemStacks.BEKT_DT
                }
        ).register(main);

        /*二氧化硅*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JCCL,
                BektItemStacks.BEKT_EYHG,
                BektRecipeType.BEKT_EYHGT,
                new ItemStack[]{new ItemStack(Material.SAND)}
        ).register(main);

        //==============================魔法材料==============================//

        /*超级修复-注册*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_MFWP,
                BektItemStacks.BEKT_CJXF_ZC,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,i(Material.STICK),null,
                        null,i(Material.STICK),null,
                        null,i(Material.STICK),null
                }
         ).register(main);

         /*超级修复-修复*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_MFWP,
                 BektItemStacks.BEKT_CJXF_XF,
                 BektRecipeType.ENHANCED_CRAFTING_TABLE,
                 new ItemStack[]{
                         null,i(Material.STONE),null,
                         null,i(Material.STONE),null,
                         null,i(Material.STONE),null
                 }
         ).register(main);

        //==============================基岩材料==============================//

        //==============================基础机器==============================//

        //==============================高级机器==============================//

        //============================低级基岩机器============================//

        //============================高级基岩机器============================//

        //============================终极基岩机器============================//

        /*原油生成机*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYJQ,
                BektItemStacks.BEKT_YYSCJ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.OIL_PUMP,                     SlimefunItems.GPS_TRANSMITTER_4,                    SlimefunItems.OIL_PUMP,
                        SlimefunItems.OIL_PUMP,                     i(Material.BEDROCK),                                SlimefunItems.OIL_PUMP,
                        SlimefunItems.OIL_PUMP,                     SlimefunItems.OIL_PUMP,                             SlimefunItems.OIL_PUMP
                }
        ).register(main);

        //==============================基岩发电==============================//

        //==============================基岩工具==============================//

        /*基岩利刃*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYGJ,
                BektItemStacks.BEKT_JYLR,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                }
        ).register(main);

        /*基岩猛斧*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYGJ,
                BektItemStacks.BEKT_JYMF,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                }
        ).register(main);

        /*基岩烈镐*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYGJ,
                BektItemStacks.BEKT_JYLG,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                }
        ).register(main);

        /*基岩之锹*/
        new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JYGJ,
                BektItemStacks.BEKT_JYZQ,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
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
