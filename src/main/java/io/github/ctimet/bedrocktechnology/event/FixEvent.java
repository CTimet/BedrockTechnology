package io.github.ctimet.bedrocktechnology.event;

import io.github.ctimet.bedrocktechnology.core.BektItems.BektItemStacks;
import io.github.ctimet.bedrocktechnology.core.Command.SendMessageToPlayer;
import io.github.ctimet.bedrocktechnology.data.PlayerBlock;
import io.github.ctimet.bedrocktechnology.initial.BektMain;
import io.github.thebusybiscuit.slimefun4.api.events.AndroidMineEvent;
import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import io.github.thebusybiscuit.slimefun4.api.events.ExplosiveToolBreakBlocksEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.HashMap;

import static io.github.ctimet.bedrocktechnology.initial.BektMain.isReadFinish;

public class FixEvent implements Listener
{
    public static HashMap<String, PlayerBlock> MAP = new HashMap<>();

    @EventHandler
    public void onClick(PlayerInteractEvent event)
    {
        if (!isReadFinish) return;

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
        String resName = BektItemStacks.BEKT_CJXF_ZC.getDisplayName();
        String fixName = BektItemStacks.BEKT_CJXF_XF.getDisplayName();

        Block block = event.getClickedBlock();

        if (block == null) return;

        Location location = block.getLocation();

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ() + "^";

        SlimefunItem item = BlockStorage.check(block);

        //注册
        if (holdName.equals(resName))
        {
            registerBlock(xyz,item,player,block);
        }

        //修复
        if (holdName.equals(fixName))
        {
            fixBlock(xyz,item,player);
        }
   }

   //注册方块
   public void registerBlock(String xyz,SlimefunItem item, Player player, Block block)
   {
       SendMessageToPlayer st = new SendMessageToPlayer(player);
       String playerName = player.getName();
       Location location = block.getLocation();
       if (!MAP.containsKey(xyz))
       {
           if (item == null)
           {
               st.sendInfo("非sf物品。暂不支持注册");
               return;
           }
           String id = item.getId();
           MAP.put(xyz,new PlayerBlock(playerName,id));
           st.sendInfo("已成功注册您的方块。方块位于"
                   + block.getWorld().getName()
                   + " x=" + location.getX()
                   + " y=" + location.getY()
                   + " z=" + location.getZ());
       }
       else st.sendPrompt("该方块已被注册过了");
   }

   //修复方块
   public void fixBlock(String xyz, SlimefunItem item, Player player)
   {
        SendMessageToPlayer st = new SendMessageToPlayer(player);
        String playerName = player.getName();
        if (MAP.containsKey(xyz) && item == null && MAP.get(xyz).getPlayerName().equals(playerName))
        {
            Inventory inventory = player.getInventory();
            if (isInventoryFull(inventory))
            {
                st.sendWarning("您的背包已满！强制填充可能会造成严重后果！已取消本次赔偿");
                return;
            }
            inventory.addItem(SlimefunItem.getById(MAP.get(xyz).getBlockId()).getItem());
            MAP.remove(xyz);
            st.sendInfo("已赔偿您的损失至背包。请查看背包寻找物品");
        }
        else if (!MAP.containsKey(xyz))
            st.sendInfo("您不是此方块的注册者或该方块未被注册。您不能获得赔偿");
        else
            st.sendPrompt("该方块未被损坏");
   }

    public boolean isInventoryFull(Inventory inventory)
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
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("plugins/" + BektMain.main.getName() + "/" +  "block.dat"));

            MAP = (HashMap<String, PlayerBlock>) inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void saveData()
    {
        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("plugins/" + BektMain.main.getName() + "/" +  "block.dat"));

            outputStream.writeObject(MAP);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    //------------------------------自动保护机制------------------------------//
    @EventHandler(priority = EventPriority.HIGH)
    public static void onPlace(BlockPlaceEvent event)
    {
        //方块放置
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBreak(BlockBreakEvent event)
    {
        //方块破坏
        protect(event.getBlock());
    }

    @EventHandler
    public static void onIgnite(BlockIgniteEvent event)
    {
        //方块被燃烧
        protect(event.getBlock());
    }

    @EventHandler
    public static void onPiston(BlockPistonExtendEvent event)
    {
        //活塞事件
        for (Block block : event.getBlocks()) protect(block);
    }

    @EventHandler
    public static void onBlockExp(BlockExpEvent event)
    {
        //方块爆炸事件
        exp(event.getBlock().getLocation());
    }

    @EventHandler
    public static void onEntityChangeBlock(EntityChangeBlockEvent event)
    {
        //实体修改方块事件
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBlockDropItem(BlockDropItemEvent event)
    {
        //方块掉落事件
        protect(event.getBlock());
    }

    @EventHandler
    public static void onAndroidBreakBlock(AndroidMineEvent event)
    {
        //机器人挖掘方块事件
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBlockPlayerPlace(BlockPlacerPlaceEvent event)
    {
        //BlockPlayer放置方块事件
        protect(event.getBlock());
    }

    @EventHandler
    public static void onExplosiveToolBreakBlocks(ExplosiveToolBreakBlocksEvent event)
    {
        //爆炸工具爆炸事件
        protect(event.getPrimaryBlock());
        for (Block block : event.getAdditionalBlocks())
        {
            protect(block);
        }
    }

   //------------------------------自动保护机制------------------------------//

    public static void protect(Block block)
    {
        Location location = block.getLocation();

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ();

        MAP.remove(xyz);
    }

    //计算爆炸所伤害的方块
    static void exp(Location location)
    {
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        double[] xs = new double[]{x-4,x-3,x-2,x-1,x,x+1,x+2,x+3,x+4};
        double[] ys = new double[]{y-3,y-2,y-1,y,y+1,y+2,y+3};
        double[] zs = new double[]{z-4,z-3,z-2,z-1,z,z+1,z+2,z+3,z+4};

        for (double xxs : xs)
        {
            for (double yys : ys)
            {
                for (double zzs : zs)
                {
                    String lt = xxs + "&" + yys + "&" + zzs + "^";
                    MAP.remove(lt);
                }
            }
        }
    }
}