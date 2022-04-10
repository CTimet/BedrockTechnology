package io.github.ctimet.bedrocktechnology.event;

import io.github.ctimet.bedrocktechnology.core.BektItems.BaseItem.BektItemStack;
import io.github.ctimet.bedrocktechnology.core.Command.MessagePage.SendMessageToPlayer;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class FixAndResEvent implements Listener, Serializable
{
    private static HashMap<Location, Collection<ItemStack>> FIXANDRESBLOCK = new HashMap<>();

    @EventHandler
    public static void onClick(PlayerRightClickEvent event){
        Player p = event.getPlayer();
        Optional<Block> clickedBlock = event.getClickedBlock();
        if (!clickedBlock.isPresent()) return;
        Block block = clickedBlock.get();
        Location location = block.getLocation();
        SendMessageToPlayer st = new SendMessageToPlayer(p,new String[]{});
        if (BektItemStack.BEKT_CJXF_ZC.isSimilar(p.getItemInHand())){
            if (!FIXANDRESBLOCK.containsKey(location)) {
                FIXANDRESBLOCK.put(location, block.getDrops());
                st.sendInfo("以成功注册！");
            }
            return;
        }
        if (BektItemStack.BEKT_CJXF_XF.isSimilar(p.getItemInHand())){
            if (FIXANDRESBLOCK.containsKey(location)){
                block.setType(Material.AIR);
                FIXANDRESBLOCK.get(location).forEach(e -> p.getInventory().addItem(e));
                FIXANDRESBLOCK.remove(location);
                st.sendInfo("已将受损机器拆除并赔偿回原先的机器！机器注册信息以成功清除！");
            }
        }
    }

    @EventHandler
    public static void onBreak(BlockBreakEvent event){
        Location location = event.getBlock().getLocation();
        if (FIXANDRESBLOCK.containsKey(location)){
            Player p = event.getPlayer();
            SendMessageToPlayer st = new SendMessageToPlayer(p,new String[]{});
            st.sendWarning("警告！您的机器以遭受人为破坏！该机器将不受保护！");
            FIXANDRESBLOCK.remove(location);
            st.sendInfo("成功将您的机器从受保护列表中移除！");
        }
    }

    //特殊防护,防止方块意外消失
    @EventHandler
    public static void onPlease(BlockPlaceEvent event){
        Location location = event.getBlock().getLocation();
        if (FIXANDRESBLOCK.containsKey(location))
            event.setCancelled(true);
    }
    /*
    public static void writeTheDat(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("protected.dat"));
            outputStream.writeObject(FIXANDRESBLOCK);
        } catch (IOException e) {
            sayWarning("发生了异常！我们在读写protected.dat文件时出现异常！以下为堆栈痕迹：");
            e.printStackTrace();
        }
    }
    /*
    public static void readTheDat() throws IOException,ClassNotFoundException{
        FIXANDRESBLOCK = (HashMap<BlockLocationData, ItemStackData>) new ObjectInputStream(new FileInputStream("protected.dat")).readObject();
    }

     */
}
