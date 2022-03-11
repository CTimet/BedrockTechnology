package me.ctimet.bekt.BektItems;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BektItemNames {
    public static final Properties pps = new Properties();

    static {
        try {
            pps.load(new FileReader("language.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final String LanguageName = pps.getProperty("languageName", "languageName");
    public static final String Translator = pps.getProperty("Translator", "Translator");
    
    //名称
    //基础材料
    public static final String BEKT_FS = pps.getProperty("BEKT_FS", "BEKT_FS");
    public static final String BEKT_LH = pps.getProperty("BEKT_LH", "BEKT_LH");
    public static final String BEKT_CL = pps.getProperty("BEKT_CL", "BEKT_CL");
    public static final String BEKT_TS = pps.getProperty("BEKT_TS", "BEKT_TS");
    public static final String BEKT_XQ = pps.getProperty("BEKT_XQ", "BEKT_XQ");
    public static final String BEKT_DT = pps.getProperty("BEKT_DT", "BEKT_DT");
    public static final String BEKT_QH = pps.getProperty("BEKT_QH", "BEKT_QH");
    public static final String BEKT_QP = pps.getProperty("BEKT_QP", "BEKT_QP");
    public static final String BEKT_BY = pps.getProperty("BEKT_BY", "BEKT_BY");
    public static final String BEKT_AJ = pps.getProperty("BEKT_AJ", "BEKT_AJ");
    public static final String BEKT_BJ = pps.getProperty("BEKT_BJ", "BEKT_BJ");
    public static final String BEKT_CJ = pps.getProperty("BEKT_CJ", "BEKT_CJ");
    public static final String BEKT_DJ = pps.getProperty("BEKT_DJ", "BEKT_DJ");
    public static final String BEKT_EJ = pps.getProperty("BEKT_EJ", "BEKT_EJ");
    public static final String BEKT_FJ = pps.getProperty("BEKT_FJ", "BEKT_FJ");
    public static final String BEKT_GJ = pps.getProperty("BEKT_GJ", "BEKT_GJ");
    public static final String BEKT_HJ = pps.getProperty("BEKT_HJ", "BEKT_HJ");
    public static final String BEKT_IJ = pps.getProperty("BEKT_IJ", "BEKT_IJ");
    public static final String BEKT_JJ = pps.getProperty("BEKT_JJ", "BEKT_JJ");
    public static final String BEKT_KJ = pps.getProperty("BEKT_KJ", "BEKT_KJ");
    public static final String BEKT_LJ = pps.getProperty("BEKT_LJ", "BEKT_LJ");
    public static final String BEKT_MJ = pps.getProperty("BEKT_MJ", "BEKT_MJ");
    public static final String BEKT_NJ = pps.getProperty("BEKT_NJ", "BEKT_NJ");
    public static final String BEKT_TONG = pps.getProperty("BEKT_TONG", "BEKT_TONG");
    public static final String BEKT_JINL = pps.getProperty("BEKT_JINL", "BEKT_JINL");
    public static final String BEKT_XINL = pps.getProperty("BEKT_XINL", "BEKT_XINL");
    public static final String BEKT_LVLI = pps.getProperty("BEKT_LVLI", "BEKT_LVLI");
    public static final String BEKT_QIAN = pps.getProperty("BEKT_QIAN", "BEKT_QIAN");
    public static final String BEKT_XILI = pps.getProperty("BEKT_XILI", "BEKT_XILI");
    public static final String BEKT_YINL = pps.getProperty("BEKT_YINL", "BEKT_YINL");
    public static final String BEKT_TIEL = pps.getProperty("BEKT_TIEL", "BEKT_TIEL");
    public static final String BEKT_MEIL = pps.getProperty("BEKT_MEIL", "BEKT_MEIL");
    public static final String BEKT_JBJZ = pps.getProperty("BEKT_JBLZ", "BEKT_JBLZ");

    //基岩材料
    public static final String BEKT_LNJG = pps.getProperty("BEKT_LNJG", "BEKT_LNJG");
    public static final String BEKT_GFJG = pps.getProperty("BEKT_GFJG", "BEKT_JFJG");
    public static final String BEKT_YJGG = pps.getProperty("BEKT_YJGG", "BEKT_YJGG");
    public static final String BEKT_JYDL = pps.getProperty("BEKT_JYDL", "BEKT_JYDL");
    public static final String BEKT_EKJG = pps.getProperty("BEKT_EKJG", "BEKT_EKJG");
    public static final String BEKT_HIJG = pps.getProperty("BEKT_HIJG", "BEKT_HIJG");
    public static final String BEKT_GJJY = pps.getProperty("BEKT_GJJY", "BEKT_GJJY");
    public static final String BEKT_YSJY = pps.getProperty("BEKT_YSJY", "BEKT_YSJY");
    public static final String BEKT_JMJY = pps.getProperty("BEKT_JMJY", "BEKT_JMJY");
    public static final String BEKT_JYLZ = pps.getProperty("BEKT_JYLZ", "BEKT_JYLZ");
    public static final String BEKT_QHLZ = pps.getProperty("BEKT_QHLZ", "BEKT_QHLZ");
    public static final String BEKT_JYKK = pps.getProperty("BEKT_JYKK", "BEKT_JYKK");
    public static final String BEKT_GONG = pps.getProperty("BEKT_GONG", "BEKT_GONG");
    public static final String BEKT_XIJI = pps.getProperty("BEKT_XIJI", "BEKT_XIJI");
    public static final String BEKT_JBKK = pps.getProperty("BEKT_JBKK", "BEKT_JBKK");

    //基础机器
    public static final String BEKT_KFJZI = pps.getProperty("BEKT_KFJZI", "BEKT_KFJZI");
    public static final String BEKT_YSJZI = pps.getProperty("BEKT_YSJZI", "BEKT_YSJZI");
    public static final String BEKT_EYHGI = pps.getProperty("BEKT_EYHGI", "BEKT_EYHGI");
    public static final String BEKT_FLFDI = pps.getProperty("BEKT_FLFDI", "BEKT_FLFDI");
    public static final String BEKT_LZTQI = pps.getProperty("BEKT_LZTQI", "BEKT_LZTQI");

    //高级机器
    public static final String BEKT_KFJII = pps.getProperty("BEKT_KFJII", "BEKT_KFJII");
    public static final String BEKT_YSJII = pps.getProperty("BEKT_YSJII", "BEKT_YSJII");
    public static final String BEKT_GJFNF = pps.getProperty("BEKT_GJFNF", "BEKT_GJFNF");
    public static final String BEKT_GJLZT = pps.getProperty("BEKT_GJLZT", "BEKT_GJLZT");
    public static final String BEKT_CJLZT = pps.getProperty("BEKT_CJLZT", "BEKT_CJLZT");
    public static final String BEKT_FZLZT = pps.getProperty("BEKT_FZLZT", "BEKT_FZLZT");
    public static final String BEKT_FKWJJ = pps.getProperty("BEKT_FKWJJ", "BEKT_FKWJJ");
    public static final String BEKT_WHFXQ = pps.getProperty("BEKT_WHFXQ", "BEKT_WHFXQ");
    public static final String BEKT_WPLZT = pps.getProperty("BEKT_WPLZT", "BEKT_WPLZT");
    public static final String BEKT_GJWPT = pps.getProperty("BEKT_GJWPT", "BEKT_GJWPT");
    public static final String BEKT_GJDWH = pps.getProperty("BEKT_GJDWH", "BEKT_GJDWH");
    public static final String BEKT_DJLZZ = pps.getProperty("BEKT_DJLZZ", "BEKT_DJLZZ");
    public static final String BEKT_GJLZZ = pps.getProperty("BEKT_GJLZZ", "BEKT_GJLZZ");
    public static final String BEKT_LZJSJ = pps.getProperty("BEKT_LZJSJ", "BEKT_LZJSJ");
    public static final String BEKT_CNHXI = pps.getProperty("BEKT_CNHXI", "BEKT_CNHXI");
    public static final String BEKT_CNHII = pps.getProperty("BEKT_CNHII", "BEKT_CNHII");
    public static final String BEKT_CNIII = pps.getProperty("BEKT_CNIII", "BEKT_CNIII");
    public static final String BEKT_CNHIV = pps.getProperty("BEKT_CNHIV", "BEKT_CNHIV");
    public static final String BEKT_JGHQQ = pps.getProperty("BEKT_JGHQQ", "BEKT_JGHQQ");
    public static final String BEKT_GJJGH = pps.getProperty("BEKT_GJJGH","BEKT_GJJGH");

    //基岩机器_低级
    public static final String BEKT_HJJJJ = pps.getProperty("BEKT_HJJJJ","BEKT_HJJJJ");
    public static final String BEKT_JYHJQ = pps.getProperty("BEKT_JYHJQ","BEKT_JYHJQ");
    public static final String BEKT_JYHCT = pps.getProperty("BEKT_JYHCT","BEKT_JYHCT");
    public static final String BEKT_LZFDJ = pps.getProperty("BEKT_LZFDJ","BEKT_LZFDJ");
    public static final String BEKT_JYLZF = pps.getProperty("BEKT_JYLZF","BEKT_JYLZF");

    //基岩机器_高级
    public static final String BEKT_GQLZD = pps.getProperty("BEKT_GQLZD","BEKT_GQLZD");
    public static final String BEKT_JQLZD = pps.getProperty("BEKT_JQLZD","BEKT_JQLZD");
    public static final String BEKT_GTQJQ = pps.getProperty("BEKT_GTQJQ","BEKT_GTQJQ");
    public static final String BEKT_QCHQJ = pps.getProperty("BEKT_QCHQJ","BEKT_QCHQJ");
    public static final String BEKT_HYJSJ = pps.getProperty("BEKT_HYJSJ","BEKT_HYJSJ");
    public static final String BEKT_GJHYJ = pps.getProperty("BEKT_GJHYJ","BEKT_GJHYJ");
    public static final String BEKT_GNLZJ = pps.getProperty("BEKT_GNLZJ","BEKT_GNLZJ");
    public static final String BEKT_GHJJQ = pps.getProperty("BEKT_GHJJQ","BEKT_GHJJQ");

    //基岩机器_终极
    public static final String BEKT_LZHCJ = pps.getProperty("BEKT_LZHCJ","BEKT_LZHCJ");
    public static final String BEKT_YYSCJ = pps.getProperty("BEKT_YYSCJ","BEKT_YYSCJ");
    public static final String BEKT_QCSCQ = pps.getProperty("BEKT_QCSCQ","BEKT_QCSCQ");
    public static final String BEKT_JJJGH = pps.getProperty("BEKT_JJJGH","BEKT_JJJGH");
    public static final String BEKT_JYLZT = pps.getProperty("BEKT_JYLZT","BEKT_JYLZT");

    //基岩发电
    public static final String BEKT_JYJZF = pps.getProperty("BEKT_JYJZF","BEKT_JYJZF");
    public static final String BEKT_JYKKF = pps.getProperty("BEKT_JYKKF","BEKT_JYKKF");
    public static final String BEKT_JYFYD = pps.getProperty("BEKT_JYFYD","BEKT_JYFYD");

    //基岩工具
    public static final String BEKT_JYLR = pps.getProperty("BEKT_JYLR","BEKT_JYLR");
    public static final String BEKT_JYMF = pps.getProperty("BEKT_JYMF","BEKT_JYMF");
    public static final String BEKT_JYLG = pps.getProperty("BEKT_JYLG","BEKT_JYLG");
    public static final String BEKT_JYZQ = pps.getProperty("BEKT_JYZQ","BEKT_JYZQ");

    //组名
    public static final String BEKT_JJCL_BE = pps.getProperty("BEKT_JJCL_BE","BEKT_JJCL_BE");
    public static final String BEKT_JCJQ_BE = pps.getProperty("BEKT_JCJQ_BE","BEKT_JCJQ_BE");
    public static final String BEKT_GJJQ_BE = pps.getProperty("BEKT_GJJQ_BE","BEKT_GJJQ_BE");
    public static final String BEKT_JYCL_BE = pps.getProperty("BEKT_JYCL_BE","BEKT_JYCL_BE");
    public static final String BEKT_JYJQ_DJ = pps.getProperty("BEKT_JYJQ_DJ","BEKT_JYJQ_DJ");
    public static final String BEKT_JYJQ_GJ = pps.getProperty("BEKT_JYJQ_GJ","BEKT_JYJQ_GJ");
    public static final String BEKT_JYJQ_ZJ = pps.getProperty("BEKT_JYJQ_ZJ","BEKT_JYJQ_ZJ");
    public static final String BEKT_JYFD_BE = pps.getProperty("BEKT_JYFD_BE","BEKT_JYFD_BE");
    public static final String BEKT_JYGJ_BE = pps.getProperty("BEKT_JYGJ_BE","BEKT_JYGJ_BE");
    public static final String BEKT_BEKT_BE = pps.getProperty("BEKT_BEKT_BE","BEKT_BEKT_BE");



}
