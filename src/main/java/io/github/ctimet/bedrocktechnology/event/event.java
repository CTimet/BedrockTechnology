package io.github.ctimet.bedrocktechnology.event;

import io.github.ctimet.bedrocktechnology.core.BektItems.BaseItem.BektItemStack;
import io.github.ctimet.bedrocktechnology.core.Command.MessagePage.SendMessageToPlayer;
import io.github.ctimet.bedrocktechnology.data.Map;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class event implements Listener
{
    public static final TreeMap<String,String> MAP = new TreeMap<>();
    public static final List<Map> DATA_MAP = new ArrayList<>();

    @EventHandler
    public static void onClick(PlayerInteractEvent event)
    {
        Action action = event.getAction();

        if (action == Action.LEFT_CLICK_AIR ||
            action == Action.RIGHT_CLICK_AIR||
            action == Action.RIGHT_CLICK_BLOCK)
            return;

        //BektMain.main.getLogger().info("yyyyy");
        Player player = event.getPlayer();

        ItemStack playerHold = player.getItemInHand();

        if (playerHold.getItemMeta() == null) return;

        String holdName = playerHold.getItemMeta().getDisplayName();
        String resName = BektItemStack.BEKT_CJXF_ZC.getDisplayName();
        String fixName = BektItemStack.BEKT_CJXF_XF.getDisplayName();

        Block block = event.getClickedBlock();

        if (block == null) return;

        Location location = block.getLocation();

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ();

        SendMessageToPlayer st = new SendMessageToPlayer(player);

        SlimefunItem item = BlockStorage.check(block);

        //注册
        if (holdName.equals(resName))
        {
            if (!MAP.containsKey(xyz))
            {
                if (item == null)
                {
                    st.sendInfo("非sf物品。暂不支持注册");
                    return;
                }
                String id = item.getId();
                MAP.put(xyz,id);
                st.sendInfo("已成功注册您的方块。方块位于"
                        + block.getWorld().getName()
                        + " x=" + location.getX()
                        + " y=" + location.getY()
                        + " z=" + location.getZ());
            }
            else st.sendPrompt("该机器已被注册过了");
        }

        //修复
        if (holdName.equals(fixName))
        {
            if (MAP.containsKey(xyz) && item == null)
            {
                Inventory inventory = player.getInventory();
                if (isInventoryFull(inventory))
                {
                    st.sendWarning("您的背包已满！强制填充可能会造成严重后果！已取消本次赔偿");
                    return;
                }
                inventory.addItem(SlimefunItem.getById(MAP.get(xyz)).getItem());
                MAP.remove(xyz);
                st.sendInfo("已赔偿您的损失至背包。请查看背包寻找物品");
            }
            else if (!MAP.containsKey(xyz))
                st.sendPrompt("该机器未被注册");
            else
                st.sendPrompt("该机器未被损坏");
        }
   }

   @EventHandler
   public static void onBreak(BlockBreakEvent event)
   {
       Location location = event.getBlock().getLocation();

       String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ();

       MAP.remove(xyz);
   }

   public static boolean isInventoryFull(Inventory inventory)
   {
       for (ItemStack stack : inventory)
       {
           if (stack == null) return false;
       }
       return true;
   }

   public static void readData()
   {
       try
       {
           ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("block.dat"));

           Config cfg = new Config("save.yml");

           int save = cfg.getInt("save");

           while (save > 0)
           {
               save --;
               Object o = inputStream.readObject();
               Map map = (Map) o;
               MAP.put(map.getS01(),map.getS02());
           }
       }
       catch (IOException | ClassNotFoundException e)
       {
           e.printStackTrace();
       }
   }

   public static void saveData()
   {
       MAP.forEach((k,v) -> DATA_MAP.add(new Map(k,v)));

       try
       {
           ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("block.dat"));

           int save = 0;
           for (Map map : DATA_MAP)
           {
               outputStream.writeObject(map);
               save++;
           }

           Config cfg = new Config("save.yml");

           cfg.setValue("save",save);

           cfg.save();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
       finally
       {
           DATA_MAP.clear();
           MAP.clear();
       }
   }
}