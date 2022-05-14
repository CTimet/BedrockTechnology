package io.github.ctimet.bedrocktechnology.network;

/**
 * 网络通信基础，任何网络设备需实现此接口
 * @author CTimet
 */
public interface NetEquipment {
    /**
     * 获取服务器IP
     */
    String getServerIP();

    /**
     * 获取速度限制，0为无限制
     */
    int getLimit();
}
