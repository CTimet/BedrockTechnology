package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.items.register.BektExpandPlay;
import io.github.ctimet.bedrocktechnology.core.items.register.BektMachineProtect;


/**
 * 这是一个负责注册各类物品的类
 * @author CTimet
 * @author CLIEDS
 */
public final class BektItems
{
    private BektItems() {
    }

    public static void registerItems()
    {
        //机器保护类物品注册
        BektMachineProtect.register();
        //拓展玩法类物品注册
        BektExpandPlay.register();
    }
}
