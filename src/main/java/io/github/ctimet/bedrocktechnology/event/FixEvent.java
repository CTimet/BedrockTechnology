package io.github.ctimet.bedrocktechnology.event;

import io.github.ctimet.bedrocktechnology.core.command.SendMessageToPlayer;
import io.github.ctimet.bedrocktechnology.core.items.BektItemStacks;
import io.github.ctimet.bedrocktechnology.data.DataSave;
import io.github.ctimet.bedrocktechnology.data.PlayerBlock;
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

import java.util.HashMap;

import static io.github.ctimet.bedrocktechnology.initial.BektMain.isReadFinish;

public class FixEvent implements Listener
{
    public static HashMap<String, PlayerBlock> MAP = new HashMap<>();

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
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

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ() + "^" + block.getWorld().getName();

        SlimefunItem item = BlockStorage.check(block);

        //??????
        if (holdName.equals(resName))
        {
            if (!isReadFinish) {
                new SendMessageToPlayer(event.getPlayer()).sendPrompt("???????????????????????????????????????????????????????????????????????????????????????????????????????????????");
                return;
            }
            registerBlock(xyz,item,player,block);
            event.setCancelled(true);
        }

        //??????
        if (holdName.equals(fixName))
        {
            if (!isReadFinish) {
                new SendMessageToPlayer(event.getPlayer()).sendPrompt("???????????????????????????????????????????????????????????????????????????????????????????????????????????????");
                return;
            }
            fixBlock(xyz,item,player);
            event.setCancelled(true);
        }

    }

    //????????????
    public void registerBlock(String xyz,SlimefunItem item, Player player, Block block)
    {
        SendMessageToPlayer st = new SendMessageToPlayer(player);
        String playerName = player.getName();
        Location location = block.getLocation();
        if (!MAP.containsKey(xyz))
        {
            if (item == null)
            {
                st.sendInfo("???sf???????????????????????????");
                return;
            }
            String id = item.getId();
            MAP.put(xyz,new PlayerBlock(playerName,id));
            st.sendInfo("??????????????????????????????????????????"
                    + block.getWorld().getName()
                    + " x=" + location.getX()
                    + " y=" + location.getY()
                    + " z=" + location.getZ());
            DataSave.addWait();
        }
        else st.sendPrompt("???????????????????????????");
    }

    //????????????
    public void fixBlock(String xyz, SlimefunItem item, Player player)
    {
        SendMessageToPlayer st = new SendMessageToPlayer(player);
        String playerName = player.getName();
        if (MAP.containsKey(xyz) && item == null && MAP.get(xyz).getPlayerName().equals(playerName))
        {
            Inventory inventory = player.getInventory();
            if (isInventoryFull(inventory))
            {
                st.sendWarning("????????????????????????????????????????????????????????????????????????????????????");
                return;
            }
            inventory.addItem(SlimefunItem.getById(MAP.get(xyz).getBlockId()).getItem());
            MAP.remove(xyz);
            st.sendInfo("????????????????????????????????????????????????????????????");
            DataSave.addWait();
        }
        else if (!MAP.containsKey(xyz))
            st.sendInfo("??????????????????????????????????????????????????????????????????????????????");
        else
            st.sendPrompt("?????????????????????");
    }

    public boolean isInventoryFull(Inventory inventory)
    {
        for (ItemStack stack : inventory)
        {
            if (stack == null) return false;
        }
        return true;
    }

    //------------------------------??????????????????------------------------------//
    @EventHandler(priority = EventPriority.HIGH)
    public static void onPlace(BlockPlaceEvent event)
    {
        //????????????
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBreak(BlockBreakEvent event)
    {
        //????????????
        protect(event.getBlock());
    }

    @EventHandler
    public static void onIgnite(BlockIgniteEvent event)
    {
        //???????????????
        protect(event.getBlock());
    }

    @EventHandler
    public static void onPiston(BlockPistonExtendEvent event)
    {
        //????????????
        for (Block block : event.getBlocks()) protect(block);
    }

    @EventHandler
    public static void onBlockExp(BlockExpEvent event)
    {
        //??????????????????
        exp(event.getBlock().getLocation());
    }

    @EventHandler
    public static void onEntityChangeBlock(EntityChangeBlockEvent event)
    {
        //????????????????????????
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBlockDropItem(BlockDropItemEvent event)
    {
        //??????????????????
        protect(event.getBlock());
    }

    @EventHandler
    public static void onAndroidBreakBlock(AndroidMineEvent event)
    {
        //???????????????????????????
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBlockPlayerPlace(BlockPlacerPlaceEvent event)
    {
        //BlockPlayer??????????????????
        protect(event.getBlock());
    }

    @EventHandler
    public static void onExplosiveToolBreakBlocks(ExplosiveToolBreakBlocksEvent event)
    {
        //????????????????????????
        protect(event.getPrimaryBlock());
        for (Block block : event.getAdditionalBlocks())
        {
            protect(block);
        }
    }

    //------------------------------??????????????????------------------------------//

    public static void protect(Block block)
    {
        Location location = block.getLocation();

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + location.getWorld().getName();

        if (MAP.containsKey(xyz)) {
            DataSave.addWait();
            MAP.remove(xyz);
        }
    }

    //??????????????????????????????
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
                    String lt = xxs + "&" + yys + "&" + zzs + "^" + location.getWorld().getName();
                    if (MAP.containsKey(lt)) {
                        DataSave.addWait();
                        MAP.remove(lt);
                    }
                }
            }
        }
    }
}