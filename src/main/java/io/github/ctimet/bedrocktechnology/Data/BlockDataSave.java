package io.github.ctimet.bedrocktechnology.Data;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class BlockDataSave
{
    private Location locatData;
    private Block blockData;

    public BlockDataSave(Location locatData, Block blockData){
        this.locatData = locatData;
        this.blockData = blockData;
    }

    public Location getLocatData() {
        return this.locatData;
    }

    public Block getBlockData() {
        return this.blockData;
    }
}
