package com.kfit.spring_boot_mybatis.utils;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {

    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

    /**
     * 汉语中货币单位大写，这样的设计类似于占位符
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿",
            "拾", "佰", "仟", "兆", "拾", "佰", "仟" };

    /**
     * 特殊字符：整
     */
    private static final String CN_FULL = "整";

    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";

    /**
     * 金额的精度，默认值为2
     */
    private static final int MONEY_PRECISION = 2;

    /**
     * 特殊字符：零元整
     */
    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

    /**
     * 把输入的金额转换为汉语中人民币的大写
     * 
     * @param numberOfMoney
     *            输入的金额
     * @return 对应的汉语大写
     */
    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        int signum = numberOfMoney.signum();
        // 零元整的情况
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }
        // 这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }
        return sb.toString();
    }

    /**
     * 
     * @return
     */
    public static String createNumPassword(boolean isNumber) {
        Random rd = new Random();
        String password = "";
        int getNum;
        do {
            if (isNumber) {
                getNum = Math.abs(rd.nextInt()) % 10 + 48;// 产生数字0-9的随机数
            } else {
                getNum = Math.abs(rd.nextInt()) % 26 + 97;// 产生字母a-z的随机数
            }
            char num1 = (char) getNum;
            String dn = Character.toString(num1);
            password += dn;
        } while (password.length() < 6);
        return password;
    }

    /**
     * 功能：格式化空字符串
     * 
     * @param str
     * @return String
     */
    public static String formatNull(Object str) {
        return null == str || "null".equals(str) ? "" : str.toString();
    }

    /**
     * 功能：格式化空字符串,为空时返回默认字符串
     * 
     * @param str
     *            原字符串
     * @param defaultStr
     *            默认字符串
     * @return String
     */
    public static String formatNull(String str, String defaultStr) {
        return StrUtil.isNull(str) ? defaultStr : str;
    }

    /**
     * 功能：判断字符串是否为空
     * 
     * @param str
     * @return boolean
     */
    public static boolean isNull(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    /**
     * 将String转换成byte数组
     * 
     * @param in
     * @return String
     */
    public static byte[] stringToByte(String str, String encoding) {
        byte[] result = null;
        try {
            encoding = StrUtil.isNull(encoding) ? "GBK" : encoding;
            result = str.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将byte数组转换成String
     * 
     * @param in
     * @return String
     */
    public static String byteToString(byte[] bytes, String encoding) {
        String result = null;
        try {
            encoding = StrUtil.isNull(encoding) ? "GBK" : encoding;
            result = new String(bytes, encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 把一维数组转换成以split为分隔的字符串
     * 
     * @param arrays
     * @param split
     * @return String
     */
    public static String arrayToString(String[] arrays, String split) {
        StringBuffer sb = new StringBuffer();
        if (null != arrays && arrays.length > 0) {
            for (int i = 0; i < arrays.length; i++) {
                sb.append((i == 0 ? "" : split) + arrays[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 把以split为分隔的字符串转换成一维数组
     * 
     * @param arrays
     * @param split
     * @return String
     */
    public static String arrayToString(String[][] arrays, String split) {
        String result = "";
        if (null != arrays && arrays.length > 0) {
            for (int i = 1; i < arrays.length; i++) {
                for (int m = 0; m < arrays[i].length; m++) {
                    result += (StrUtil.isNull(result) ? "" : split) + arrays[i][m];
                }
            }
        }
        return result;
    }

    /**
     * 如果文本中有xml的实体字符，则要采用CDATA的方式输出
     * 
     * @param in
     *            传入的文本
     * @return 输出的处理结果文本
     */
    public static String formatXMLValue(String in) {
        if (null == in || in.equals("")) {
            return in;
        }
        if (in.indexOf('>') >= 0 || in.indexOf('<') >= 0 || in.indexOf('&') >= 0) {
            char[] chars1 = new char[1];
            chars1[0] = 91;
            char[] chars2 = new char[1];
            chars2[0] = 93;
            return "<!" + new String(chars1) + "CDATA" + new String(chars1) + " " + in + " " + new String(chars2)
                    + new String(chars2) + ">";
        } else {
            return in;
        }
    }

    /**
     * 把字符串里出现的", <,>,&等特殊字符转换成标准可识别的字符 如字符串中包括 <,会转换成 &lt;
     */
    public static String formatXMLAttribute(String str) {
        if (null == str || str.equals("")) {
            return str;
        }
        String[] src = { "<", ">", "\"", "'", "&" };
        String[] des = { "&lt;", "&gt;", "&quot", "&apos", "&amp;" };
        String result = str;
        for (int i = 0; i < src.length; i++) {
            result = result.replaceAll(src[i], des[i]);
        }
        return result;
    }

    /**
     * 将分隔符的字符串转化为List对象
     * 
     * @param str
     *            String-传入的分隔符字符串
     * @param split
     *            String-分隔符
     * @return List对象
     */
    public static List stringToList(String str, String split) {
        List list = null;
        if (!StrUtil.isNull(str)) {
            String args[] = str.split(split);
            list = Arrays.asList(args);
        }
        return list;
    }

    /**
     * 将分隔符的字符串转化为String一维数组对象
     * 
     * @param str
     *            String-传入的分隔符字符串
     * @param split
     *            String-分隔符
     * @return String一维数组对象
     */
    public static String[] stringToArray(String str, String split) {
        String array[] = new String[0];
        if (!StrUtil.isNull(str)) {
            array = str.split(split);
        }
        return array;
    }

    /**
     * 将列表转换成以指定分隔符的字符串
     * 
     * @param list
     *            : List<String> - 含有字符串元素的列表
     * @param split
     *            : String - 分隔符
     * @return String - 以指定分隔符的字符串
     */
    public static String listToString(final List list, final String split) {
        String str = "";
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                str += (0 == i ? "" : split) + list.get(i).toString();
            }
        }
        return str;
    }

    /**
     * 判断一个字符串是否是正整数
     * 
     * @return true or false
     */
    public static boolean isPositiveInteger(String num) {
        Pattern pattern = Pattern.compile("^[0-9]*[1-9][0-9]*$");
        Matcher isNum = pattern.matcher(num);
        return isNum.matches();
    }

    /**
     * 判断一个字符串是否是负整数
     * 
     * @return true or false
     */
    public static boolean isNegativeInteger(String num) {
        Pattern pattern = Pattern.compile("^-[0-9]*[1-9][0-9]*$");
        Matcher isNum = pattern.matcher(num);
        return isNum.matches();
    }

    /**
     * 判断一个字符串是不是由整数组成的
     * 
     * @return true or false
     */
    public static boolean isNumber(String num) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher isNum = pattern.matcher(num);
        return isNum.matches();
    }

    /**
     * 将字符串中的中文数字转换成阿拉伯数字
     * 
     * @param s
     * @return String
     */
    public static String chineseToNumber(String s) {
        char[] chars = s.toCharArray();
        char[] chineseNum = new char[] { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chineseNum.length; j++) {
                if (chars[i] == chineseNum[j]) {
                    chars[i] = String.valueOf(j).charAt(0);
                }
            }
        }
        return new String(chars);
    }

    /**
     * 将字符串中的阿拉伯数字转换成中文数字
     * 
     * @param s
     * @return String
     */
    public static String numberToChinese(String s) {
        char[] chars = s.toCharArray();
        char[] chineseNum = new char[] { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chineseNum.length; j++) {
                if (chars[i] == j) {
                    chars[i] = chineseNum[j];
                }
            }
        }
        return new String(chars);
    }

    /**
     * 为字符串后面不足补0
     * 
     * @param str
     *            需要处理的字符串
     * @param length
     *            补零后的总长度
     * @param type
     *            类型：1.往前补0 2.往后补0
     * @return 长度为length的补零后的字符串
     */
    public static String fillZero(String str, int length, int type) {
        String code = "";
        for (int i = 0; i < length; i++) {
            code = code + "0";
        }

        if (type == 1) {
            code = code.substring(str.length()) + str;
        } else {
            code = str + code.substring(str.length());
        }
        return code;
    }

    /**
     * 
     * 功能说明:将1,2,3字符串转换成'1','2','3'
     * 
     * @param id
     *            -源字符串
     * @param split
     *            -字符串分割符
     * @return String
     * @author chh
     * @Jun 28, 2012
     */
    public static String toSqlIds(String id, String split) {
        if (StrUtil.isNull(id))
            return "''";
        String[] ids = id.split(split);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ids.length; i++) {
            sb.append((i == 0 ? "" : ",") + ("'" + ids[i] + "'"));
        }
        return sb.toString();
    }

    /**
     * 判断数组中是否包含指定字符串
     * 
     * @param array
     *            字符串数据
     * @param value
     *            指定的字符串
     * @return 包含则返回true,不包含返回false
     */
    public static boolean isArrayHasValue(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value))
                return true;
        }
        return false;
    }

    /**
     * 从表达式中提取参数
     * 
     * @param expression
     *            表达式
     * @param regExp
     *            参数的匹配格式(正则表达式)
     * @return 匹配的参数名称(多个参数用","分格)
     */
    public static String getPramsFromExpression(String expression, String regExp) {
        String result = "";
        if (!StrUtil.isNull(expression)) {
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(expression);
            while (m.find()) {
                String param = m.group(1);
                if (!StrUtil.isNull(param) && result.indexOf(param) < 0) {// 过滤重复的参数
                    result += (StrUtil.isNull(result) ? "" : ",") + param;
                }
            }
        }
        return result;
    }

    /**
     * 
     * 功能：过滤字符串中重复的内容,字符串的内容为1,2,3,4,2,3
     * 
     * @author 陈煌辉
     * @date 2013-08-22 09:07:51
     * @param str
     *            -字符串
     * @param split
     *            -分隔符
     * @return String
     */
    public static String filterRepeat(String str, String split) {
        if (isNull(str)) {
            return "";
        }
        String[] arrays = str.split(split);
        int length = arrays.length;
        if (length == 1) {
            return arrays[0];
        }
        // 利用HashMap的key不能重复的原理
        HashMap map = new HashMap();
        for (int i = 0; i < length; i++) {
            map.put(arrays[i], arrays[i]);
        }
        StringBuffer sb = new StringBuffer();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (it.hasNext()) {
                sb.append(entry.getKey() + ",");
            } else {
                sb.append(entry.getKey());
            }

        }
        return sb.toString();
    }

    /**
     * 根据路径获取指定的文件
     * 
     * @param path
     * @return
     */
    public static String getApkName(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] dirFiles = file.listFiles();
            for (File f : dirFiles) {
                if (f.isDirectory())
                    continue;
                else {
                    if (f.getName().endsWith(".apk")) {
                        return f.getName();
                    }
                }
            }
        }

        return null;
    }

    /**
     * 字数转中文
     * 
     * @param number
     * @return
     */
    public static String numberToChinese(int number) {
        switch (number) {
        case 0:
            return "零";
        case 1:

            return "壹";
        case 2:

            return "贰";
        case 3:

            return "叁";

        case 4:

            return "肆";
        case 5:

            return "伍";
        case 6:

            return "陆";
        case 7:

            return "柒";
        case 8:

            return "捌";
        case 9:

            return "玖";
        default:
            return "";
        }
    }

    public static String encryptMobile(String mobile) {
        if (Validator.isMobile(mobile)) {
            return mobile.substring(0, 3) + "***" + mobile.substring(7, mobile.length());
        }
        return "";
    }

    public static void main(String[] args) {
        String inputline = "20110725160412,01234567890100";
        inputline = inputline.substring(inputline.indexOf(",") + 1, inputline.indexOf(",") + 2);
        System.out.println(inputline);
    }

    public static StringBuilder formatMsg(CharSequence msgWithFormat, boolean autoQuote, Object[] args) {
        int argsLen = args.length;
        boolean markFound = false;

        StringBuilder sb = new StringBuilder(msgWithFormat);

        if (argsLen > 0) {
            for (int i = 0; i < argsLen; ++i) {
                String flag = "%" + (i + 1);
                int idx = sb.indexOf(flag);

                while (idx >= 0) {
                    markFound = true;
                    sb.replace(idx, idx + 2, toString(args[i], autoQuote));
                    idx = sb.indexOf(flag);
                }
            }

            if (args[(argsLen - 1)] instanceof Throwable) {
                StringWriter sw = new StringWriter();
                ((Throwable) args[(argsLen - 1)]).printStackTrace(new PrintWriter(sw));
                sb.append("\n").append(sw.toString());
            } else if ((argsLen == 1) && (!markFound)) {
                sb.append(args[(argsLen - 1)].toString());
            }
        }
        return sb;
    }

    public static StringBuilder formatMsg(String msgWithFormat, Object[] args) {
        return formatMsg(new StringBuilder(msgWithFormat), true, args);
    }

    public static String toString(Object obj, boolean autoQuote) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            sb.append("NULL");
        } else if (obj instanceof Object[]) {
            for (int i = 0; i < ((Object[]) obj).length; ++i) {
                sb.append(((Object[]) obj)[i]).append(", ");
            }
            if (sb.length() > 0)
                sb.delete(sb.length() - 2, sb.length());
        } else {
            sb.append(obj.toString());
        }

        if ((autoQuote) && (sb.length() > 0) && (((sb.charAt(0) != '[') || (sb.charAt(sb.length() - 1) != ']')))
                && (((sb.charAt(0) != '{') || (sb.charAt(sb.length() - 1) != '}')))) {
            sb.insert(0, "[").append("]");
        }
        return sb.toString();
    }

}
