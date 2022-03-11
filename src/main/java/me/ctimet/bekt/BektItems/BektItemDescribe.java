package me.ctimet.bekt.BektItems;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BektItemDescribe
{
    public static final Properties pps = new Properties();
    static {
        try {
            pps.load(new FileReader("language.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //描述
    //基础材料
    public static final String BEKTMS_FS = pps.getProperty("BEKTMS_FS", "BEKTMS_FS");
    public static final String BEKTMS_LH = pps.getProperty("BEKTMS_LH", "BEKTMS_LH");
    public static final String BEKTMS_CL = pps.getProperty("BEKTMS_CL", "BEKTMS_CL");
    public static final String BEKTMS_TS = pps.getProperty("BEKTMS_TS", "BEKTMS_TS");
    public static final String BEKTMS_XQ = pps.getProperty("BEKTMS_XQ", "BEKTMS_XQ");
    public static final String BEKTMS_DT = pps.getProperty("BEKTMS_DT", "BEKTMS_DT");
    public static final String BEKTMS_QH = pps.getProperty("BEKTMS_QH", "BEKTMS_QH");
    public static final String BEKTMS_QP = pps.getProperty("BEKTMS_QP", "BEKTMS_QP");
    public static final String BEKTMS_BY = pps.getProperty("BEKTMS_BY", "BEKTMS_BY");
    public static final String BEKTMS_AJ = pps.getProperty("BEKTMS_AJ", "BEKTMS_AJ");
    public static final String BEKTMS_BJ = pps.getProperty("BEKTMS_BJ", "BEKTMS_BJ");
    public static final String BEKTMS_CJ = pps.getProperty("BEKTMS_CJ", "BEKTMS_CJ");
    public static final String BEKTMS_DJ = pps.getProperty("BEKTMS_DJ", "BEKTMS_DJ");
    public static final String BEKTMS_EJ = pps.getProperty("BEKTMS_EJ", "BEKTMS_EJ");
    public static final String BEKTMS_FJ = pps.getProperty("BEKTMS_FJ", "BEKTMS_FJ");
    public static final String BEKTMS_GJ = pps.getProperty("BEKTMS_GJ", "BEKTMS_GJ");
    public static final String BEKTMS_HJ = pps.getProperty("BEKTMS_HJ", "BEKTMS_HJ");
    public static final String BEKTMS_IJ = pps.getProperty("BEKTMS_IJ", "BEKTMS_IJ");
    public static final String BEKTMS_JJ = pps.getProperty("BEKTMS_JJ", "BEKTMS_JJ");
    public static final String BEKTMS_KJ = pps.getProperty("BEKTMS_KJ", "BEKTMS_KJ");
    public static final String BEKTMS_LJ = pps.getProperty("BEKTMS_LJ", "BEKTMS_LJ");
    public static final String BEKTMS_MJ = pps.getProperty("BEKTMS_MJ", "BEKTMS_MJ");
    public static final String BEKTMS_NJ = pps.getProperty("BEKTMS_NJ", "BEKTMS_NJ");
    public static final String BEKTMS_TONG = pps.getProperty("BEKTMS_TONG", "BEKTMS_TONG");
    public static final String BEKTMS_JINL = pps.getProperty("BEKTMS_JINL", "BEKTMS_JINL");
    public static final String BEKTMS_XINL = pps.getProperty("BEKTMS_XINL", "BEKTMS_XINL");
    public static final String BEKTMS_LVLI = pps.getProperty("BEKTMS_LVLI", "BEKTMS_LVLI");
    public static final String BEKTMS_QIAN = pps.getProperty("BEKTMS_QIAN", "BEKTMS_QIAN");
    public static final String BEKTMS_XILI = pps.getProperty("BEKTMS_XILI", "BEKTMS_XILI");
    public static final String BEKTMS_YINL = pps.getProperty("BEKTMS_YINL", "BEKTMS_YINL");
    public static final String BEKTMS_TIEL = pps.getProperty("BEKTMS_TIEL", "BEKTMS_TIEL");
    public static final String BEKTMS_MEIL = pps.getProperty("BEKTMS_MEIL", "BEKTMS_MEIL");
    public static final String BEKTMS_JBJZ = pps.getProperty("BEKTMS_JBLZ", "BEKTMS_JBLZ");

    //基岩材料
    public static final String BEKTMS_LNJG = pps.getProperty("BEKTMS_LNJG", "BEKTMS_LNJG");
    public static final String BEKTMS_GFJG = pps.getProperty("BEKTMS_GFJG", "BEKTMS_JFJG");
    public static final String BEKTMS_YJGG = pps.getProperty("BEKTMS_YJGG", "BEKTMS_YJGG");
    public static final String BEKTMS_JYDL = pps.getProperty("BEKTMS_JYDL", "BEKTMS_JYDL");
    public static final String BEKTMS_EKJG = pps.getProperty("BEKTMS_EKJG", "BEKTMS_EKJG");
    public static final String BEKTMS_HIJG = pps.getProperty("BEKTMS_HIJG", "BEKTMS_HIJG");
    public static final String BEKTMS_GJJY = pps.getProperty("BEKTMS_GJJY", "BEKTMS_GJJY");
    public static final String BEKTMS_YSJY = pps.getProperty("BEKTMS_YSJY", "BEKTMS_YSJY");
    public static final String BEKTMS_JMJY = pps.getProperty("BEKTMS_JMJY", "BEKTMS_JMJY");
    public static final String BEKTMS_JYLZ = pps.getProperty("BEKTMS_JYLZ", "BEKTMS_JYLZ");
    public static final String BEKTMS_QHLZ = pps.getProperty("BEKTMS_QHLZ", "BEKTMS_QHLZ");
    public static final String BEKTMS_JYKK = pps.getProperty("BEKTMS_JYKK", "BEKTMS_JYKK");
    public static final String BEKTMS_GONG = pps.getProperty("BEKTMS_GONG", "BEKTMS_GONG");
    public static final String BEKTMS_XIJI = pps.getProperty("BEKTMS_XIJI", "BEKTMS_XIJI");
    public static final String BEKTMS_JBKK = pps.getProperty("BEKTMS_JBKK", "BEKTMS_JBKK");

    //基础机器
    public static final String BEKTMS_KFJZI = pps.getProperty("BEKTMS_KFJZI", "BEKTMS_KFJZI");
    public static final String BEKTMS_YSJZI = pps.getProperty("BEKTMS_YSJZI", "BEKTMS_YSJZI");
    public static final String BEKTMS_EYHGI = pps.getProperty("BEKTMS_EYHGI", "BEKTMS_EYHGI");
    public static final String BEKTMS_FLFDI = pps.getProperty("BEKTMS_FLFDI", "BEKTMS_FLFDI");
    public static final String BEKTMS_LZTQI = pps.getProperty("BEKTMS_LZTQI", "BEKTMS_LZTQI");

    //高级机器
    public static final String BEKTMS_KFJII = pps.getProperty("BEKTMS_KFJII", "BEKTMS_KFJII");
    public static final String BEKTMS_YSJII = pps.getProperty("BEKTMS_YSJII", "BEKTMS_YSJII");
    public static final String BEKTMS_GJFNF = pps.getProperty("BEKTMS_GJFNF", "BEKTMS_GJFNF");
    public static final String BEKTMS_GJLZT = pps.getProperty("BEKTMS_GJLZT", "BEKTMS_GJLZT");
    public static final String BEKTMS_CJLZT = pps.getProperty("BEKTMS_CJLZT", "BEKTMS_CJLZT");
    public static final String BEKTMS_FZLZT = pps.getProperty("BEKTMS_FZLZT", "BEKTMS_FZLZT");
    public static final String BEKTMS_FKWJJ = pps.getProperty("BEKTMS_FKWJJ", "BEKTMS_FKWJJ");
    public static final String BEKTMS_WHFXQ = pps.getProperty("BEKTMS_WHFXQ", "BEKTMS_WHFXQ");
    public static final String BEKTMS_WPLZT = pps.getProperty("BEKTMS_WPLZT", "BEKTMS_WPLZT");
    public static final String BEKTMS_GJWPT = pps.getProperty("BEKTMS_GJWPT", "BEKTMS_GJWPT");
    public static final String BEKTMS_GJDWH = pps.getProperty("BEKTMS_GJDWH", "BEKTMS_GJDWH");
    public static final String BEKTMS_DJLZZ = pps.getProperty("BEKTMS_DJLZZ", "BEKTMS_DJLZZ");
    public static final String BEKTMS_GJLZZ = pps.getProperty("BEKTMS_GJLZZ", "BEKTMS_GJLZZ");
    public static final String BEKTMS_LZJSJ = pps.getProperty("BEKTMS_LZJSJ", "BEKTMS_LZJSJ");
    public static final String BEKTMS_CNHXI = pps.getProperty("BEKTMS_CNHXI", "BEKTMS_CNHXI");
    public static final String BEKTMS_CNHII = pps.getProperty("BEKTMS_CNHII", "BEKTMS_CNHII");
    public static final String BEKTMS_CNIII = pps.getProperty("BEKTMS_CNIII", "BEKTMS_CNIII");
    public static final String BEKTMS_CNHIV = pps.getProperty("BEKTMS_CNHIV", "BEKTMS_CNHIV");
    public static final String BEKTMS_JGHQQ = pps.getProperty("BEKTMS_JGHQQ", "BEKTMS_JGHQQ");
    public static final String BEKTMS_GJJGH = pps.getProperty("BEKTMS_GJJGH","BEKTMS_GJJGH");

    //基岩机器_低级
    public static final String BEKTMS_HJJJJ = pps.getProperty("BEKTMS_HJJJJ","BEKTMS_HJJJJ");
    public static final String BEKTMS_JYHJQ = pps.getProperty("BEKTMS_JYHJQ","BEKTMS_JYHJQ");
    public static final String BEKTMS_JYHCT = pps.getProperty("BEKTMS_JYHCT","BEKTMS_JYHCT");
    public static final String BEKTMS_LZFDJ = pps.getProperty("BEKTMS_LZFDJ","BEKTMS_LZFDJ");
    public static final String BEKTMS_JYLZF = pps.getProperty("BEKTMS_JYLZF","BEKTMS_JYLZF");

    //基岩机器_高级
    public static final String BEKTMS_GQLZD = pps.getProperty("BEKTMS_GQLZD","BEKTMS_GQLZD");
    public static final String BEKTMS_JQLZD = pps.getProperty("BEKTMS_JQLZD","BEKTMS_JQLZD");
    public static final String BEKTMS_GTQJQ = pps.getProperty("BEKTMS_GTQJQ","BEKTMS_GTQJQ");
    public static final String BEKTMS_QCHQJ = pps.getProperty("BEKTMS_QCHQJ","BEKTMS_QCHQJ");
    public static final String BEKTMS_HYJSJ = pps.getProperty("BEKTMS_HYJSJ","BEKTMS_HYJSJ");
    public static final String BEKTMS_GJHYJ = pps.getProperty("BEKTMS_GJHYJ","BEKTMS_GJHYJ");
    public static final String BEKTMS_GNLZJ = pps.getProperty("BEKTMS_GNLZJ","BEKTMS_GNLZJ");
    public static final String BEKTMS_GHJJQ = pps.getProperty("BEKTMS_GHJJQ","BEKTMS_GHJJQ");

    //基岩机器_终极
    public static final String BEKTMS_LZHCJ = pps.getProperty("BEKTMS_LZHCJ","BEKTMS_LZHCJ");
    public static final String BEKTMS_YYSCJ = pps.getProperty("BEKTMS_YYSCJ","BEKTMS_YYSCJ");
    public static final String BEKTMS_QCSCQ = pps.getProperty("BEKTMS_QCSCQ","BEKTMS_QCSCQ");
    public static final String BEKTMS_JJJGH = pps.getProperty("BEKTMS_JJJGH","BEKTMS_JJJGH");
    public static final String BEKTMS_JYLZT = pps.getProperty("BEKTMS_JYLZT","BEKTMS_JYLZT");

    //基岩发电
    public static final String BEKTMS_JYJZF = pps.getProperty("BEKTMS_JYJZF","BEKTMS_JYJZF");
    public static final String BEKTMS_JYKKF = pps.getProperty("BEKTMS_JYKKF","BEKTMS_JYKKF");
    public static final String BEKTMS_JYFYD = pps.getProperty("BEKTMS_JYFYD","BEKTMS_JYFYD");

    //基岩工具
    public static final String BEKTMS_JYLR = pps.getProperty("BEKTMS_JYLR","BEKTMS_JYLR");
    public static final String BEKTMS_JYMF = pps.getProperty("BEKTMS_JYMF","BEKTMS_JYMF");
    public static final String BEKTMS_JYLG = pps.getProperty("BEKTMS_JYLG","BEKTMS_JYLG");
    public static final String BEKTMS_JYZQ = pps.getProperty("BEKTMS_JYZQ","BEKTMS_JYZQ");
}
