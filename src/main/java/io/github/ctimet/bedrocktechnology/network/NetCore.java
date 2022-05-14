package io.github.ctimet.bedrocktechnology.network;

public interface NetCore {
    /**
     * 指示当前网络系统范围，ALL为全体范围，如果为属于玩家的局域网络，则返回玩家姓名
     */
    String getWorkArea();

    /**
     * 返回当前网络通道范围(边长)
     */
    int getNetArea();
}
