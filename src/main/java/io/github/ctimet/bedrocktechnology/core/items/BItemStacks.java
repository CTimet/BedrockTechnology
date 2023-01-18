package io.github.ctimet.bedrocktechnology.core.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;

import javax.annotation.Nonnull;

public class BItemStacks {
    public static final SlimefunItemStack BEKT_REGISTER_STICK = new SlimefunItemStack(
            "BEKT_REGISTER_STICK",
            Material.STICK,
            "&a注册棒",
            "",
            "&7注册你的机器",
            "&7当你的机器被卡掉时",
            "&7可以通过 &b修复棒&7 来修复你的机器"
    );
    public static final SlimefunItemStack BEKT_FIX_STICK = new SlimefunItemStack(
            "BEKT_FIX_STICK",
            Material.STICK,
            "&a修复棒",
            "",
            "&7修复你的机器",
            "&7当你的机器被卡成原版方块时",
            "&7你可以用此物品右键机器来修复你的机器",
            "&7前提是你的机器必须已经经过 &b注册棒 &7注册",
            "&7未被注册的机器将&4修复失败！"
    );
    public static final SlimefunItemStack BEKT_FIX_ALL = new SlimefunItemStack(
            "BEKT_FIX_ALL",
            Material.STICK,
            "&a修复全部棒",
            "",
            "&7修复你的机器",
            "&7当你使用时，插件会找出你所有经过 &b注册棒 &7注册过的机器",
            "&7并从中找出已经损坏的机器，然后修复",
            "&7未被注册的机器将&4不会被修复！",
            "&7该物品使用有1h的冷却时间"
    );
    public static final SlimefunItemStack BEKT_AREA_REGISTER = new SlimefunItemStack(
            "BEKT_AREA_REGISTER",
            Material.STICK,
            "&a区域注册棒",
            "",
            "&7注册你的机器",
            "&7当你使用时，插件会从你点击的方块为中心点出发，在半径为5的正方体区域内搜索方块",
            "&7在这个区域内的方块都会被依次注册，区域大小为9x9=81",
            "&7需要注意的是，区域内的方块实行&4静默注册&7，无论发生什么，插件都不会向你发送消息",
            "&7此功能适用于机器密度较大的区域，但过大区域建议采用自动注册方案"
    );
    public static final SlimefunItemStack BEKT_OWNER_REGISTER = new SlimefunItemStack(
            "BEKT_OWNER_REGISTER",
            Material.STICK,
            "&a拥有者-注册棒",
            "",
            "&7右键绑定拥有者ID,这可以让不同人注册的方块都隶属于同一个ID(同一人)下",
            "&7如果你和你的朋友合作制作机器发展粘液的话，这将非常有用"
    );
    public static final SlimefunItemStack BEKT_OWNER_FIX_ALL = new SlimefunItemStack(
            "BEKT_OWNER_FIX_ALL",
            Material.STICK,
            "&a拥有者-修复全部",
            "",
            "&7右键绑定拥有者ID\n这可以让由同一个ID的拥有者棒注册的机器都被此棒所修复，而不管使用者是谁",
            "&7如果你和你的朋友合作制作机器发展粘液的话，这将非常有用",
            "&7该物品使用有1h的冷却时间"
    );
    public static final SlimefunItemStack BEKT_OIL_MAKE = new SlimefunItemStack(
            "BEKT_OIL_MAKE",
            Material.ENCHANTING_TABLE,
            "&4原油生成机",
            "",
            "&7不受当前区块影响，全自动生成原油",
            getEff("1x"),
            getPow(10000),
            getCap(20000)
    );
    public static final SlimefunItemStack BEKT_RESOURCES_FIND = new SlimefunItemStack(
            "BEKT_RESOURCES_FIND",
            Material.DROPPER,
            "&4资源探测芯片",
            "",
            "&7可以用于寻找某些资源，比如原油，GEO矿等等"
    );
    public static final SlimefunItemStack BEKT_DIG_CORE = new SlimefunItemStack(
            "BEKT_DIG_CORE",
            Material.NETHER_STAR,
            "&4挖掘核心",
            "",
            "&7挖掘核心。用以驱动挖掘机器。只能作为零件使用"
    );
    public static final SlimefunItemStack BEKT_CONDUIT = new SlimefunItemStack(
            "BEKT_CONDUIT",
            Material.END_ROD,
            "&6输送管道",
            "",
            "&7可以运输可流动性物质。比如岩浆，原油，水等"
    );
    public static final SlimefunItemStack BEKT_WATER_BUMP = new SlimefunItemStack(
            "BEKT_WATER_BUMP",
            Material.END_PORTAL_FRAME,
            "&d水泵",
            "",
            "&7能把一些液体抽上来。只能作为零件使用"
    );
    public static final SlimefunItemStack BEKT_OBJECT_ENCAPSULATION = new SlimefunItemStack(
            "BEKT_OBJECT_ENCAPSULATION",
            Material.CHEST,
            "&d原油罐装器",
            "",
            "&7往桶里装一些原油。只可作为零件使用。"
    );
    public static final SlimefunItemStack BEKT_CRAFTING_TABLE = new SlimefunItemStack(
            "BEKT_CRAFTING_TABLE",
            Material.CRAFTING_TABLE,
            "&4基岩工作台",
            "",
            ""
    );
//    public static final SlimefunItemStack BEKT_LITHOGRAPHY_MACHINE = new SlimefunItemStack(
//            "BEKT_LITHOGRAPHY_MACHINE",
//            Material.DRIED_KELP_BLOCK,
//            "&4光刻机",
//            "",
//            "&4制造芯片的机器"
//    );
//    public static final SlimefunItemStack BEKT_CPU_PAPER = new SlimefunItemStack(
//            "BEKT_CPU_PAPER",
//            Material.PAPER,
//            "&aCPU电路图图纸",
//            "",
//            "&7绘制了CPU电路图的图纸"
//    );
//    public static final SlimefunItemStack BEKT_GPU_PAPER = new SlimefunItemStack(
//            "BEKT_GPU_PAPER",
//            Material.PAPER,
//            "&aGPU电路图图纸",
//            "",
//            "&7绘制了GPU电路图的图纸"
//    );
//    public static final SlimefunItemStack BEKT_CPU = new SlimefunItemStack(
//            "BEKT_CPU",
//            Material.NETHER_STAR,
//            "&6CPU",
//            "",
//            "&7一个高精尖设备，用来处理数据"
//    );
//    public static final SlimefunItemStack BEKT_GPU = new SlimefunItemStack(
//            "BEKT_GPU",
//            Material.NETHER_STAR,
//            "&6GPU",
//            "",
//            "&7一个高精尖设备，用来绘制图像"
//    );
//    public static final SlimefunItemStack BEKT_CLOUD_TABLE = new SlimefunItemStack(
//            "BEKT_CLOUD_TABLE",
//            Material.SEA_LANTERN,
//            "&bCloud云组装台",
//            "",
//            "构建，组装您的CLOUD云中转站"
//    );
    /**
     * 机器的速度，eff内一定要带上x，比如1x，代表1倍
     * @param eff 速度，单位x
     * @return 速度
     */
    @Nonnull
    public static String getEff(String eff){
        return "&7⇨ &e⚡ &7速度: &b" + eff;
    }

    /**
     * 机器的耗电量，当一个机器需要持续耗电时，请用这个方法添加lore
     * @param j 电量，单位J/S，输入的字符串中不需要带单位，只需要输入数字即可
     * @return 电量
     */
    @Nonnull
    public static String getPow(int j){
        return "&7⇨ &e⚡ &7" + j + "J/s";
    }

    @Nonnull
    public static String getCap(int j) {
        return "&e" + j + "J&7可储存";
    }

    /**
     * 机器的耗电量，当一个机器只在用的时候才耗电时，使用这个方法添加lore
     * @param j 电量，单位J/S,输入的字符串不需要带单位
     * @return 电量
     */
    @Nonnull
    public static String getUse(String j){
        return "&7⇨ &e⚡ &7" + j + "J每次使用";
    }
}
