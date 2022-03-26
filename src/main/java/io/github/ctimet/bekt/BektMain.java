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
        BektItemGroup.registerSubCate();
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
