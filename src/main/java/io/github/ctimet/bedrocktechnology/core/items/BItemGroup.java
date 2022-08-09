package io.github.ctimet.bedrocktechnology.core.items;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class BItemGroup {
    private static final NestedItemGroup MAIN_GROUP = new NestedItemGroup(createKey("BEKT_BEKT_BE"), new CustomItemStack(Material.BEDROCK, "&lBEKT &7- &b基岩科技"));
    public static final SubItemGroup MACHINE_PROTECT = createSubGroup(Material.COMMAND_BLOCK, "Bekt_MachineProtect", "&lBEKT &7- &a机器保护");
    public static final SubItemGroup NETWORK = createSubGroup(Material.BEACON, "Bekt_NetWork", "&lBEKT &7- &e网络");
    public static final SubItemGroup EXPEND_PLAY = createSubGroup(Material.DIAMOND_PICKAXE, "Bekt_ExpendPlay", "&lBEKT &7- &d拓展玩法");

    public static NamespacedKey createKey(String key){
        return new NamespacedKey(BektMain.getInstance(),key);
    }

    public static SubItemGroup createSubGroup(Material material, String key, String name){
        return new SubItemGroup(createKey(key),MAIN_GROUP,new CustomItemStack(material,name));
    }
}
