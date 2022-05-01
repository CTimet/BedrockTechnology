package io.github.ctimet.bedrocktechnology.event;

import io.github.ctimet.bedrocktechnology.core.BektItems.BaseItem.BektItemStack;
import io.github.ctimet.bedrocktechnology.core.Command.MessagePage.SendMessageToPlayer;
import io.github.ctimet.bedrocktechnology.data.Map;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
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

        Collection<ItemStack> itemStacks = block.getDrops();

        String[] items = new String[itemStacks.size()];

        int i = 0;

        for (ItemStack stack : itemStacks)
        {
            SlimefunItem item = SlimefunItem.getByItem(stack);
            if (item == null)
            {
                items[i] = "noItem";
                continue;
            }
            items[i] = item.getId();
        }

        SendMessageToPlayer st = new SendMessageToPlayer(player);

        //注册
        if (holdName.equals(resName) && !MAP.containsKey(xyz))
        {
            //System.out.println("zbc");
            if (isEmpty(items))
            {
                st.sendInfo("我很抱歉。这个方块暂时不能注册。因为它属于非sf物品");
            }
            else
            {
                int put = 0;
                for (String item : items)
                {
                    if (put == 0) MAP.put(xyz,item);
                    MAP.put(xyz + put,item);
                    put++;
                }
                st.sendInfo("以成功注册你的sf物品");
            }
            return;
        }
        else st.sendWarning("错误！此物品已被注册");

        //修复
        if (holdName.equals(fixName) && MAP.containsKey(xyz))
        {
            //System.out.println("zbc2");
            int put = 1;

            Inventory inventory = player.getInventory();

            inventory.addItem(SlimefunItem.getById(MAP.get(xyz)).getItem());

            MAP.remove(xyz);

            while (MAP.containsKey(xyz + put))
            {
                put ++;
                inventory.addItem(SlimefunItem.getById(MAP.get(xyz + put)).getItem());
                MAP.remove(xyz + put);
            }

            st.sendInfo("物品已赔偿至您的背包。请查看背包寻找赔偿物品");
        }
        else st.sendWarning("错误！此物品未被注册");
   }

   public static boolean isEmpty(String[] strings)
   {
        boolean i = true;
        for (String s : strings){
            if (s.equals("noItem")) continue;
            i = false;
        }
        return i;
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