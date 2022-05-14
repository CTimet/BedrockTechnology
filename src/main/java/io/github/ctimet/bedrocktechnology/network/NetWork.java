package io.github.ctimet.bedrocktechnology.network;

import org.bukkit.Location;

public class NetWork implements NetCore {
    String area;
    int netArea;

    public NetWork(String ar, Location location, boolean isCore)
    {
        this.area = ar;
        int x = (int) location.getX();
        int y = (int) location.getY();
        int z = (int) location.getZ();
        if (isCore) this.netArea = 20;
        else this.netArea = 0;
    }

    @Override
    public String getWorkArea()
    {
        return this.area;
    }

    @Override
    public int getNetArea()
    {
        return this.netArea;
    }
}
