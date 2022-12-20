package io.github.ctimet.bedrocktechnology.data;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.Serializable;

public class BlockLocation implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 202212101141L;
    /*
      location字段不需要被序列化。这是因为我们为了通过Java序列化机制而保存了WorldName,x,y,z
      因此，location字段完全可以在getLocation的时候通过这些值计算的来
      而只需要添加一个if null的判断。这个判断造成的性能损失可以忽略不计。
      同时，当判断出为null时，需要为location赋值，因此location不能为final
    */
    private transient Location location;
    /*
      值得一提的是，为什么我们要采用Java序列化机制而没有采用Bukkit提供的ConfigurationSerializable接口序列化机制呢
      这是我查了半天，网上的相关使用教程均说明需要自己实现序列化与反序列化方法
      作为一个懒者我是很不愿意的(doge
     */

    private final String worldName;
    private final double x;
    private final double y;
    private final double z;

    public BlockLocation(Location location) {
        this.location = location;
        this.worldName = (location.getWorld() == null) ? "null" : location.getWorld().getName();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
    }
//
//    public double getX() {
//        return x;
//    }
//
//    public double getY() {
//        return y;
//    }
//
//    public double getZ() {
//        return z;
//    }
//
    public Location getLocation() {
        if (location == null) {
            location = new Location(Bukkit.getWorld(worldName), x, y, z);
        }
        return location;
    }
}
