package io.github.ctimet.bedrocktechnology.event;

import io.github.ctimet.bedrocktechnology.Data.BlockDataSave;
import io.github.ctimet.bedrocktechnology.core.BektItems.BaseItem.BektItemStack;
import io.github.ctimet.bedrocktechnology.core.Command.MessagePage.SendMessageToPlayer;
import io.github.ctimet.bedrocktechnology.initial.BektMain;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.*;
import java.util.HashMap;

import static io.github.ctimet.bedrocktechnology.initial.BektMain.sayWarning;

public class FixAndResEvent implements Listener, Serializable
{
    private static HashMap<Location,Block> FIXANDRESBLOCK = new HashMap<>();

    @EventHandler
    public static void onClick(PlayerInteractEvent event){
        Player p = event.getPlayer();
        sayWarning("fiuck");
        Block clickedBlock = event.getClickedBlock();
        if (clickedBlock == null) return;
        SendMessageToPlayer st = new SendMessageToPlayer(p,new String[]{});
        if (p.getInventory().contains(BektItemStack.BEKT_CJXF_ZC)){
            if (FIXANDRESBLOCK.containsKey(clickedBlock.getLocation())){
                st.sendWarning("抱歉，该机器已被注册！");
                return;
            }else {
                FIXANDRESBLOCK.put(clickedBlock.getLocation(),clickedBlock);
                st.sendInfo("以成功注册！");
                return;
            }
        }
        if (p.getInventory().contains(BektItemStack.BEKT_CJXF_XF)){
            if (FIXANDRESBLOCK.containsKey(clickedBlock.getLocation())){
                FIXANDRESBLOCK.get(clickedBlock.getLocation()).getDrops().forEach(
                        itemStack -> {
                            p.getInventory().addItem(itemStack);
                        }
                );
                FIXANDRESBLOCK.remove(clickedBlock.getLocation());
                clickedBlock.setType(Material.AIR);
                st.sendInfo("已将受损机器拆除并赔偿回原先的机器！机器注册信息以成功清除！");
                return;
            }else {
                st.sendWarning("抱歉，该机器未被注册！尚未被注册的机器暂不支持数据恢复！");
                return;
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

    public static void writeTheDat(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("protected.dat"));
            int i = FIXANDRESBLOCK.size();
            Config config = new Config(BektMain.main);
            config.setValue("Items.saveData",i);
            FIXANDRESBLOCK.forEach(
                    (k,v) -> {
                        try {
                            outputStream.writeObject(new BlockDataSave(k,v));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        } catch (IOException e) {
            sayWarning("发生了异常！我们在读写protected.dat文件时出现异常！以下为堆栈痕迹：");
            e.printStackTrace();
        }
    }

    public static void readTheDat() throws IOException,ClassNotFoundException{
        Config config = new Config(BektMain.main);
        int i = config.getInt("Items.saveData");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("protected.dat"));
        BlockDataSave save;
        for (int o = 0; o < i; o++){
            save = (BlockDataSave) inputStream.readObject();
            FIXANDRESBLOCK.put(save.getLocatData(),save.getBlockData());
        }
    }
}
