package io.github.ctimet.bekt.BektItems;

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
            new CustomItemStack(Material.BEDROCK, "&l BEKT &7- &b基岩科技"));
    //基础材料
    public static SubItemGroup Bekt_SubGroup_JCCL = new SubItemGroup(
            BektMain.createKey("bektjccl"),
            Bekt_MainGroup,
            new CustomItemStack(Material.BEDROCK,"BEKT")
    );
    //基岩材料
    public static SubItemGroup Bekt_SubGroup_JYCL = getSubGroup(Material.BLACK_STAINED_GLASS,"l BEKT 7- cJYCL");
    //基础机器
    public static SubItemGroup Bekt_SubGroup_JCJQ = getSubGroup(Material.IRON_BLOCK,"l BEKT 7- eJCJQ");
    //高级机器
    public static SubItemGroup Bekt_SubGroup_GJJQ = getSubGroup(Material.GOLD_BLOCK,"l BEKT 7- bGJJQ");
    //低级基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_DJ = getSubGroup(Material.COAL_ORE,"l BEKT 7- 7JYJQDJ");
    //高级基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_GJ = getSubGroup(Material.GOLD_ORE,"l BEKT 7- ejyjqgj");
    //终极基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_ZJ = getSubGroup(Material.DIAMOND_ORE,"l BEKT 7- 4JYJQZJ");
    //基岩发电
    public static SubItemGroup Bekt_SubGroup_JYFD = getSubGroup(Material.REDSTONE_BLOCK,"l BEKT 7- 4JYFD");
    //基岩工具
    public static SubItemGroup Bekt_SubGroup_JYGJ = getSubGroup(Material.CHISELED_STONE_BRICKS,"l BEKT 7- 4JYGJ");

    
    public static void registerSubCate(){
        sayInfo("一切正常");
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
        sayInfo("仍旧正常");

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

        BEKT_FS.register(BektMain.main);
        BEKT_CL.register(BektMain.main);
        BEKT_LH.register(BektMain.main);



    }

    public static SubItemGroup getSubGroup(Material material,String name){
        return new SubItemGroup(BektMain.createKey(name),Bekt_MainGroup,new CustomItemStack(material,name));
    }

    public static void sayInfo(String info){
        BektMain.main.getLogger().info(info);
    }
}
