package io.github.ctimet.bedrocktechnology.core.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BektItemStacks {
    /*
    public static final SlimefunItemStack BEKT_SYJJ = new SlimefunItemStack(
            "BEKT_SYJJ",
            Material.AIR,
            "硅结晶",
            "",
            "被二次烧炼的硅,它变得更加光滑了"
    );
    public static final SlimefunItemStack BEKT_CDLB = new SlimefunItemStack(
            "BEKT_CDLB",
            Material.AIR,
            "磁电路板",
            "",
            "一种特殊的电路板,是BEKT的机器的组件"
    );
    public static final SlimefunItemStack BEKT_CPU = new SlimefunItemStack(
            "BEKT_CPU",
            Material.AIR,
            "机器CPU",
            "",
            "单核CPU,是构成BEKT机器的重要核心组件"
    );
    public static final SlimefunItemStack BEKT_CZKJ = new SlimefunItemStack(
            "BEKT_CZKJ",
            Material.IRON_BLOCK,
            "粗制的机械框架",
            "",
            "最基础的机器框架 是机器的模型"
    );
    public static final SlimefunItemStack BEKT_JRKJ = new SlimefunItemStack(
            "BEKT_JRKJ",
            Material.GOLD_BLOCK,
            "坚韧的机械框架",
            "",
            "工业通用的机械框架,可用来制作大部分机器"
    );
    public static final SlimefunItemStack BEKT_PYKG = new SlimefunItemStack(
            "BEKT_PYKG",
            Material.DIAMOND_BLOCK,
            "贫铀合金机械框架",
            "",
            "最高级的机械框架,可以用来制造更加高级的机器"
    );
    public static final SlimefunItemStack BEKT_PYHJ = new SlimefunItemStack(
            "BEKT_PYHJ",
            Material.GOLD_INGOT,
            "贫铀合金锭",
            "",
            "更加坚固的机械组件"
    );
    public static final SlimefunItemStack BEKT_JXFHB = new SlimefunItemStack(
            "BEKT_JXFHB",
            Material.PAPER,
            "贫铀合金机械防护板",
            "",
            "机器组件"
    );
    public static final SlimefunItemStack BEKT_LID = new SlimefunItemStack(
            "BEKT_LID",
            Material.IRON_INGOT,
            "锂锭",
            "",
            "核聚变发电的重要原料"
    );
    public static final SlimefunItemStack BEKT_QPHJ = new SlimefunItemStack(
            "BEKT_QPHJ",
            Material.GOLD_INGOT,
            "起泡合金锭",
            "",
            "辐射机械组件"
    );
    public static final SlimefunItemStack BEKT_CCC1 = new SlimefunItemStack(
            "BEKT_CCC1",
            Material.PLAYER_HEAD,
            "化学流体罐[内容物:氚(33%)]",
            "",
            "核聚变的燃料之一,通过超高压压力仓加热富集到100%纯度即可用于发电"
    );
    public static final SlimefunItemStack BEKT_CCC2 = new SlimefunItemStack(
            "BEKT_CCC2",
            Material.PLAYER_HEAD,
            "化学流体罐[内容物:氚(66%)]",
            "",
            "核聚变的燃料之一,通过超高压压力仓加热富集到100%纯度即可用于发电"
    );
    public static final SlimefunItemStack BEKT_CCCC = new SlimefunItemStack(
            "BEKT_CCCC",
            Material.PLAYER_HEAD,
            "化学流体罐[内容物:氚]",
            "",
            "核聚变的燃料之一,此富集度的氚可以用于核聚变发电"
    );
    public static final SlimefunItemStack BEKT_LF = new SlimefunItemStack(
            "BEKT_LF",
            Material.SUGAR,
            "锂粉",
            "",
            "第10种矿粉,可以在洗矿机内洗出,概率3%"
    );
    public static final SlimefunItemStack BEKT_LMHJ = new SlimefunItemStack(
            "BEKT_LMHJ",
            Material.IRON_INGOT,
            "锂镁合金",
            "",
            "核聚变燃料的本体,可用于制作氚"
    );
    public static final SlimefunItemStack BEKT_05YB = new SlimefunItemStack(
            "BEKT_05YB",
            Material.BLAZE_ROD,
            "铀燃料棒(富集度:0.5%)",
            "",
            "快中子增殖反应堆的发电材料,富集到5%即可用于生产"
    );
    public static final SlimefunItemStack BEKT_10YB = new SlimefunItemStack(
            "BEKT_10YB",
            Material.BLAZE_ROD,
            "铀燃料棒(富集度:1.0%)",
            "",
            "快中子增殖反应堆的发电材料,富集到5%即可用于生产"
    );
    public static final SlimefunItemStack BEKT_30YB = new SlimefunItemStack(
            "BEKT_30YB",
            Material.BLAZE_ROD,
            "铀燃料棒(富集度3%)",
            "",
            "快中子增殖反应堆的发电材料,富集到5%即可用于生产"
    );
    public static final SlimefunItemStack BEKT_50YB = new SlimefunItemStack(
            "BEKT_50YB",
            Material.BLAZE_ROD,
            "铀燃料棒(富集度5%)",
            "",
            "快中子增殖反应堆的发电材料,此富集度的铀燃料棒可以投入生产"
    );
    public static final SlimefunItemStack BEKT_DJZS = new SlimefunItemStack(
            "BEKT_DJZS",
            Material.WATER_BUCKET,
            "化学流体罐[内容物:电解水]",
            "",
            "电解而来的重水,可以提取氘用于核聚变发电"
    );
    public static final SlimefunItemStack BEKT_DDDD = new SlimefunItemStack(
            "BEKT_DDDD",
            Material.PLAYER_HEAD,
            "化学流体罐[内容物:氘]",
            "",
            "由电解水离心而来的氘,可用于核聚变发电"
    );
    public static final SlimefunItemStack BEKT_LTG = new SlimefunItemStack(
            "BEKT_LTG",
            Material.BUCKET,
            "化学流体罐[内容物:无物品]",
            "",
            "承载化学物品的罐子,蕴含着未知神秘的力量......"
    );
    public static final SlimefunItemStack BEKT_XBHX = new SlimefunItemStack(
            "BEKT_XBHX",
            Material.NETHER_STAR,
            "信标核心",
            "",
            "由信标二次加工提取而来的信标核心,是高级机械的核心材料"
    );
    public static final SlimefunItemStack BEKT_GQDFHB = new SlimefunItemStack(
            "BEKT_GQDFHB",
            Material.PAPER,
            "高强度防护板材",
            "",
            "由稀有金属制成的防护板材,可以抵挡大部分伤害"
    );
    public static final SlimefunItemStack BEKT_XJ = new SlimefunItemStack(
            "BEKT_XJ",
            Material.WHITE_DYE,
            "橡胶",
            "",
            "由塑料纸二次加工而来的橡胶,可用于制作各种物品"
    );*/

    public static final SlimefunItemStack BEKT_CJXF_ZC = new SlimefunItemStack(
            "BEKT-CJXF-ZC",
            Material.STICK,
            "&a超级修复-注册",
            "",
            "&7&o注册你的机器，当你的机器被卡掉时，可以通过 &b超级修复-修复&7 来修复你的机器"
    );
    public static final SlimefunItemStack BEKT_CJXF_XF = new SlimefunItemStack(
            "BEKT-CJXF-XF",
            Material.STICK,
            "&a超级修复-修复",
            "",
            "&7&o修复你的机器，当你的机器被卡掉时，你可以用此物品右键机器来修复你的机器"
    );
    /*
    public static final SlimefunItemStack BEKT_JZMZ = new SlimefunItemStack(
            "BEKT_JZMZ",
            Material.BLAZE_ROD,
            "建筑魔杖",
            "",
            "古代神秘的力量,可以自由选取128x128x384范围内的方块进行大批量修改",
            "蹲下右键绑定存储器,需要有领地内place与destory权限"
    );public static final SlimefunItemStack BEKT_ARFYZ = new SlimefunItemStack(
            "BEKT_ARFYZ",
            Material.GOLD_NUGGET,
            "α魔法因子",
            "",
            "由4个魔法因子-III合成而来,具备更加强大的魔法力量..."
    );
    public static final SlimefunItemStack BEKT_BTYZ = new SlimefunItemStack(
            "BEKT_BTYZ",
            Material.GOLD_NUGGET,
            "β魔法因子",
            "",
            "由9个魔法因子_III合成而来,具备更加强大的魔法力量..."
    );
    public static final SlimefunItemStack BEKT_ARFD = new SlimefunItemStack(
            "BEKT_ARFD",
            Material.GOLD_INGOT,
            "α魔法锭",
            "",
            "由9个α魔法因子合成而来,散发着神秘的魔法光芒..."
    );
    public static final SlimefunItemStack BEKT_BTD = new SlimefunItemStack(
            "BEKT_BTD",
            Material.GOLD_INGOT,
            "β魔法锭",
            "",
            "由9个β魔法因子合成而来,散发着神秘的魔法光芒..."
    );
    public static final SlimefunItemStack BEKT_FWSY = new SlimefunItemStack(
            "BEKT_FWSY",
            new ColoredFireworkStar(Color.fromRGB(255, 165, 0), "&7古代符文 &8&l[&6&l时运&8&l]"),
            "",
            "具备时运效果的符文"
    );
    public static final SlimefunItemStack BEKT_JLHX = new SlimefunItemStack(
            "BEKT_JLHX",
            Material.NETHER_STAR,
            "精炼核心",
            "",
            "制作高级魔法机器的机械核心"
    );
    public static final SlimefunItemStack BEKT_FWYS = new SlimefunItemStack(
            "BEKT_FWYS",
            Material.FIREWORK_STAR,
            "古代符文_[药水][药水类型:I级别药水变量]",
            "",
            "这使得装备可以附上更高等级的药水效果.蹲下右键消耗1个2级药水绑定类型!"
    );
    public static final SlimefunItemStack BEKT_FWWS = new SlimefunItemStack(
            "BEKT_FWWS",
            new ColoredFireworkStar(Color.fromRGB(0, 0, 0), "&7古代符文 &8&l[&6&l无限&8&l]"),
            "",
            "消耗大量资源制作",
            "右键消耗符文,使得副手物品基数变为0无限消耗"
    );
    public static final SlimefunItemStack BEKT_FWUNDES = new SlimefunItemStack(
            "BEKT_FWUNDES",
            new ColoredFireworkStar(Color.fromRGB(50, 205, 50), "&7古代符文 &8&l[&6&l无法破坏&8&l]"),
            "",
            "安装这个符文的任意工具/装备将无法破坏"
    );
    public static final SlimefunItemStack BEKT_NANAHO = new SlimefunItemStack(
            "BEKT_NANAHO",
            Material.GHAST_TEAR,
            "纳米因子",
            "",
            "制造精密魔法仪器的必备材料"
    );
    public static final SlimefunItemStack BEKT_SWRQ = new SlimefunItemStack(
            "BEKT_SWRQ",
            Material.LEAD,
            "末影生物容器[生物类型:生物变量]",
            "",
            "右键 捕捉生物",
            "右键方块可放出生物,也可以放入生物产物机生产掉落物"
    );*/
    /*
    public static final SlimefunItemStack BEKT_FLFDI = new SlimefunItemStack(
            "BEKT-FLFDI",
            Material.BONE_BLOCK,
            "&e风力发电机",
            "",
            getPow("10")
    );
    public static final SlimefunItemStack BEKT_HJBFYD = new SlimefunItemStack(
            "BEKT_HJBFYD",
            Material.BEACON,
            "核聚变反应堆",
            "",
            "最高级的核动力发电,安全可靠",
            getPow("10000")
    );
    public static final SlimefunItemStack BEKT_ZZHJ = new SlimefunItemStack(
            "BEKT_ZZHJ",
            Material.CRIMSON_NYLIUM,
            "中子轰炸机",
            "",
            "产生氚",
            getEff("1x"),
            getPow("50000")
    );
    public static final SlimefunItemStack BEKT_JQYLC = new SlimefunItemStack(
            "BEKT_JQYLC",
            Material.LIGHT_GRAY_STAINED_GLASS,
            "超高压加热压力仓",
            "",
            "巨大的压力,提纯核聚变所需的原料",
            getEff("1x"),
            getUse("8000")
    );
    public static final SlimefunItemStack BEKT_ZZZZJ = new SlimefunItemStack(
            "BEKT_ZZZZJ",
            Material.RESPAWN_ANCHOR,
            "快中子增值反应堆",
            "",
            "二次利用核燃料进行增值",
            getEff("1x"),
            getPow("5000")
    );
    public static final SlimefunItemStack BEKT_LXJ = new SlimefunItemStack(
            "BEKT_LXJ",
            Material.CHISELED_NETHER_BRICKS,
            "核燃料离心机",
            "",
            "离心物品获得核聚变原料",
            getEff("1x"),
            getPow("20000")
    );
    public static final SlimefunItemStack BEKT_SHJ = new SlimefunItemStack(
            "BEKT_SHJ",
            Material.RED_STAINED_GLASS,
            "骨粉/染料刷花机",
            "",
            "电力刷花",
            getEff("1x"),
            getPow("300")
    );
    public static final SlimefunItemStack BEKT_HNT = new SlimefunItemStack(
            "BEKT_HNT",
            Material.WHITE_CONCRETE,
            "混凝土制造机",
            "",
            "投入沙砾即可制造混凝土,由碎矿机和洗矿机结合而来",
            getEff("1x"),
            getPow("500")
    );
    public static final SlimefunItemStack BEKT_LSYFSJ = new SlimefunItemStack(
            "BEKT_LSYFSJ",
            Material.FURNACE,
            "硫酸盐制造机",
            "",
            "圆石粉碎为硫酸盐",
            getEff("1x"),
            getPow("2000")
    );
    public static final SlimefunItemStack BEKT_ZDDF = new SlimefunItemStack(
            "BEKT_ZDDF",
            Material.COMPOSTER,
            "自动堆肥机",
            "",
            "全自动制造堆肥机物品",
            getEff("1x"),
            getPow("600")
    );
    public static final SlimefunItemStack BEKT_SWCWJ = new SlimefunItemStack(
            "BEKT_SWCWJ",
            Material.SPAWNER,
            "生物学产物制造机",
            "",
            "放入末影生物容器读取此生物的DNA并制造掉落物",
            getEff("1x"),
            getPow("25000")
    );
    public static final SlimefunItemStack BEKT_ZSJ = new SlimefunItemStack(
            "BEKT_ZSJ",
            Material.OAK_WOOD,
            "自动植树机",
            "",
            "全自动伐木与再种植树木",
            getEff("1x"),
            getPow("1000")
    );
    public static final SlimefunItemStack BEKT_ZDNC = new SlimefunItemStack(
            "BEKT_ZDNC",
            Material.GRASS_BLOCK,
            "自动农场",
            "",
            "自动收割再种植作物,支持全种类可放在地上的自然资源产物",
            getEff("1x"),
            getPow("2000")
    );
    public static final SlimefunItemStack BEKT_XJTQJ = new SlimefunItemStack(
            "BEKT_XJTQJ",
            Material.TARGET,
            "橡胶提取机",
            "",
            "橡木提取橡胶",
            getEff("1x"),
            getPow("2500")
    );
    public static final SlimefunItemStack BEKT_TNTSSJ = new SlimefunItemStack(
            "BEKT_TNTSSJ",
            Material.CHISELED_STONE_BRICKS,
            "TNT刷石机",
            "",
            "使用TNT大批量生成圆石",
            getEff("1x"),
            getPow("500")
    );
    public static final SlimefunItemStack BEKT_KFJLJ = new SlimefunItemStack(
            "BEKT_KFJLJ",
            Material.FURNACE,
            "矿粉提取机",
            "",
            "直接从圆石提取矿粉.",
            getEff("1x"),
            getPow("800")
    );
    public static final SlimefunItemStack BEKT_QHZDJ = new SlimefunItemStack(
            "BEKT_QHZDJ",
            Material.RED_TERRACOTTA,
            "高速成锭机",
            "",
            "1秒2锭 更快的成锭机",
            getEff("1x"),
            getPow("1080")
    );
    public static final SlimefunItemStack BEKT_QHYLJ = new SlimefunItemStack(
            "BEKT_QHYLJ",
            Material.BLAST_FURNACE,
            "高速冶炼厂",
            "",
            "更加快速的冶炼厂 1秒可成1块金属",
            getEff("1x"),
            getPow("1200")
    );
    public static final SlimefunItemStack BEKT_JSCXJ = new SlimefunItemStack(
            "BEKT_JSCXJ",
            Material.EMERALD_BLOCK,
            "金属成型机",
            "",
            "投入一组圆石,直接制成对应金属,需要在EG栏位放入对应成品",
            getEff("1x"),
            getPow("2300")
    );
    public static final SlimefunItemStack BEKT_JSCJJ = new SlimefunItemStack(
            "BEKT_JSCJJ",
            Material.QUARTZ_BLOCK,
            "金属还原机",
            "",
            "将金属还原至原来的配方",
            "10000j/每次使用",
            getEff("1x"),
            getUse("10000")
    );
    public static final SlimefunItemStack BEKT_KSFSQ = new SlimefunItemStack(
            "BEKT_KSFSQ",
            Material.POLISHED_DEEPSLATE,
            "矿石发生器",
            "",
            "插入矿物芯片 自动生成对应矿物",
            "效率依据矿物稀有度和芯片等级决定,机器本体800j/s",
            getEff("1x"),
            getPow("800")
    );
    public static final SlimefunItemStack BEKT_GJKJ = new SlimefunItemStack(
            "BEKT_GJKJ",
            Material.CHISELED_RED_SANDSTONE,
            "高级采矿机",
            "",
            "更快速的挖掘矿石",
            getEff("3x"),
            getPow("4500")
    );
    public static final SlimefunItemStack BEKT_DSFDJ = new SlimefunItemStack(
            "BEKT_DSFDJ",
            Material.PLAYER_HEAD,
            "电势放大器",
            "",
            "将单个能源系统的电力成1.5x放大",
            getPow("能源系统总量x1.5")
    );
    public static final SlimefunItemStack BEKT_DSJSQ = new SlimefunItemStack(
            "BEKT_DSJSQ",
            Material.PLAYER_HEAD,
            "电流加速器",
            "",
            "将能源网络总量x6倍 供给单个高发电的机器 每个能源网络最多可以存在5个",
            "相当于一个被限制的发电机,必须插在机器上才能工作!",
            getPow("总量x6")
    );
    public static final SlimefunItemStack BEKT_NMZJ = new SlimefunItemStack(
            "BEKT_NMZJ",
            Material.FLETCHING_TABLE,
            "纳米产物编织机",
            "",
            "生产珍贵的纳米材料,如将压缩碳编织成石墨烯",
            getEff("1x"),
            getPow("8000")
    );
    public static final SlimefunItemStack BEKT_MJGJ = new SlimefunItemStack(
            "BEKT_MJGJ",
            Material.MOSSY_STONE_BRICKS,
            "生物酶反应加工机",
            "",
            "加工生物产物",
            getEff("1x"),
            getPow("5400")
    );
    public static final SlimefunItemStack BEKT_YLLL = new SlimefunItemStack(
            "BEKT_YLLL",
            Material.CRYING_OBSIDIAN,
            "引力乱流发生器",
            "",
            "放置后,周围半径64格内的生物将可以获得创造模式的飞行能力",
            getEff("1x"),
            getPow("28000")
    );
    public static final SlimefunItemStack BEKT_JBKWXP = new SlimefunItemStack(
            "BEKT_JBKWXP",
            Material.GOLDEN_HELMET,
            "基础矿石芯片[类型:矿石变量]",
            "",
            "插入矿石发生器使用,蹲下右键绑定手持矿物",
            "升级将清除矿物类型,请重新绑定",
            getEff("1x"),
            getPow("3000")
    );
    public static final SlimefunItemStack BEKT_GJKWXP = new SlimefunItemStack(
            "BEKT_GJKWXP",
            Material.DIAMOND_CHESTPLATE,
            "高级矿物芯片[类型:矿石变量]",
            "",
            "插入矿石发生器使用,蹲下右键绑定手持矿物",
            "升级将清除矿物类型,请重新绑定",
            getEff("3x"),
            getPow("9800")
    );
    public static final SlimefunItemStack BEKT_ZJKWXP = new SlimefunItemStack(
            "BEKT_ZJKWXP",
            Material.NETHERITE_CHESTPLATE,
            "终极矿物芯片[类型:矿石变量]",
            "",
            "插入矿石发生器使用,蹲下右键绑定手持矿物",
            "升级将清除矿物类型,请重新绑定",
            getEff("8x"),
            getPow("65536")
    );
    public static final SlimefunItemStack BEKT_QKJZQ = new SlimefunItemStack(
            "BEKT_QKJZQ",
            Material.BEACON,
            "区块加载器",
            "",
            "加载当前区块,蹲下右键与uuid绑定后才可使用",
            "每个uuid最多只可以制作32个区块加载器",
            "腐竹可在配置文件内设置最大数量",
            getEff("1x"),
            getPow("32768")
    );
    public static final SlimefunItemStack BEKT_XZJ = new SlimefunItemStack(
            "BEKT_XZJ",
            Material.NETHERITE_HOE,
            "机械卸载器",
            "",
            "左键拆除机器",
            "右键查看机器详细内容"
    );*/
    public static final SlimefunItemStack BEKT_GKJ = new SlimefunItemStack(
            "BEKT_GKJ",
            Material.DRIED_KELP_BLOCK,
            "&4光刻机",
            "",
            "&4制造芯片的机器"
    );
    public static final SlimefunItemStack BEKT_CPUTZ = new SlimefunItemStack(
            "BEKT_CPUTZ",
            Material.PAPER,
            "&aCPU电路图图纸",
            "",
            "&7绘制了CPU电路图的图纸"
    );
    public static final SlimefunItemStack BEKT_GPUTZ = new SlimefunItemStack(
            "BEKT_GPUTZ",
            Material.PAPER,
            "&aGPU电路图图纸",
            "",
            "&7绘制了GPU电路图的图纸"
    );
    public static final SlimefunItemStack BEKT_CPU = new SlimefunItemStack(
            "BEKT_CPU",
            Material.NETHER_STAR,
            "&6CPU",
            "",
            "&7一个高精尖设备，用来处理数据"
    );
    public static final SlimefunItemStack BEKT_GPU = new SlimefunItemStack(
            "BEKT_GPU",
            Material.NETHER_STAR,
            "&6GPU",
            "",
            "&7一个高精尖设备，用来绘制图像"
    );
    public static final SlimefunItemStack BEKT_CLOUD_TABLE = new SlimefunItemStack(
            "BEKT_CLOUD_TABLE",
            Material.COMMAND_BLOCK,
            "&bCloud云组装台",
            "构建，组装您的CLOUD云中转站"
    );

    public static final SlimefunItemStack BEKT_CLOUD_V1 = new SlimefunItemStack(
            "BEKT_CLOUD_V1",
            Material.COMMAND_BLOCK,
            "&aCloud云 -v1",
            "Cloud云，你的信息中专站",
            ""
    );

    public static final SlimefunItemStack BEKT_TEST = new SlimefunItemStack(
            "BEKT_TEST",
            Material.COMMAND_BLOCK,
            "&aTEST",
            "",
            "test"
    );

    /**
     * 机器的速度，eff内一定要带上x，比如1x，代表1倍
     * @param eff 速度，单位x
     * @return 速度
     */
    @Contract(pure = true)
    @NotNull
    public static String getEff(String eff){
        return "&7⇨ &e⚡ &7速度: &b" + eff;
    }

    /**
     * 机器的耗电量，当一个机器需要持续耗电时，请用这个方法添加lore
     * @param j 电量，单位J/S，输入的字符串中不需要带单位，只需要输入数字即可
     * @return 电量
     */
    @NotNull
    public static String getPow(String j){
        return "&7⇨ &e⚡ &7" + j + "J/s";
    }

    /**
     * 机器的耗电量，当一个机器只在用的时候才耗电时，使用这个方法添加lore
     * @param j 电量，单位J/S,输入的字符串不需要带单位
     * @return 电量
     */
    @NotNull
    public static String getUse(String j){
        return "&7⇨ &e⚡ &7" + j + "J每次使用";
    }
}
