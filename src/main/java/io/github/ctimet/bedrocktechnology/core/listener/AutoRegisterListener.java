package io.github.ctimet.bedrocktechnology.core.listener;

import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AutoRegisterListener implements Listener {
    // 此方法的优先级应当最低，应该先让 MachineProtectListener#onPlace 先执行，此方法应最后执行
    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockPlace(BlockPlaceEvent event) {
        //判断方块是否为有效的slimefun方块
        SlimefunItem item = BlockStorage.check(event.getBlock());
        if (item != null && !StickData.containsRefuseID(item.getId())) {
            //因为RegisterStick#registerBlock会给玩家发送消息，而我们不希望发送注册成功的消息，那会很烦
            //所以此处使用自实现的方法
            Player player = event.getPlayer();

            if (StickData.isNotReadFinish()) {
                player.sendMessage("基岩科技自动注册提示：数据仍未读取完毕，该方块将不会被自动注册");
                return;
            }

            Block block = event.getBlock();
            Location location = block.getLocation();

            if (StickData.containsData(location)) {
                return;
            }

            StickData.putData(player.getUniqueId(), location);
        }
    }
}
