package io.github.ctimet.bedrocktechnology.core.event;

import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.thebusybiscuit.slimefun4.api.events.AndroidMineEvent;
import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import io.github.thebusybiscuit.slimefun4.api.events.ExplosiveToolBreakBlocksEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.Objects;

public class MachineProtectEvent implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
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

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + Objects.requireNonNull(location.getWorld()).getName();

        StickData.remove(xyz);
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

        for (double xxs : xs) {
            for (double yys : ys) {
                for (double zzs : zs) {
                    String lt = xxs + "&" + yys + "&" + zzs + "&" + Objects.requireNonNull(location.getWorld()).getName();
                    StickData.remove(lt);
                }
            }
        }
    }
}
