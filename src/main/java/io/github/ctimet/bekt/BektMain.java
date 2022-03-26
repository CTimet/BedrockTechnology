package io.github.ctimet.bekt;

import io.github.ctimet.bekt.BektItems.BektItemGroup;
import io.github.ctimet.bekt.BektItems.BektItemStack;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import static io.github.ctimet.bekt.BektItems.BektItemGroup.Bekt_SubGroup_JCCL;

/** Main Class
 * @author CTimet
 * @author CLIEDS
 * @version beta1.0.0
 */
public class BektMain extends JavaPlugin implements SlimefunAddon
{
    public static BektMain main;

    @Override
    public void onEnable(){
        main = this;
        getLogger().info("一切正常");
        saveDefaultConfig();
        //BektItemGroup.registerSubCate();
        SlimefunItem BEKT_FS = new SlimefunItem(
                Bekt_SubGroup_JCCL,
                new SlimefunItemStack(
                        "BEKT_FS",
                        Material.NETHER_STAR,
                        "&b风扇",
                        "",
                        "&7一个很普通的风扇"
                ),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,                               new ItemStack(Material.IRON_BLOCK), null,
                        new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.CHAIN),      new ItemStack(Material.IRON_BLOCK),
                        null,                               new ItemStack(Material.IRON_BLOCK), null
                }
        );
        BEKT_FS.register(this);
    }

    @Override
    public void onDisable(){

    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }

    public static NamespacedKey createKey(String key){
        return new NamespacedKey(main,key);
    }
}
