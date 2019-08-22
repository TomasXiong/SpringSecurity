package com.kfit.spring_boot_mybatis.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期相关工具
 *
 * 
 * 
 */
public abstract class DateUtil {

    
    public static final Long ONE_DAY_IN_MILLS = 1000 * 3600 * 24L;
    
    public static final String REG = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
   
    public static String DEFAULT_TIME_FORMAT_1="yyyyMMdd";
    
    public final static SimpleDateFormat YYYY_MM_DD_MM_HH_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
	public final static SimpleDateFormat YYYY_MM = new SimpleDateFormat("yyyy-MM");
	public final static SimpleDateFormat YYYYMMDDMMHHSSSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public final static SimpleDateFormat YYYYMMDDSSS = new SimpleDateFormat("yyyyMMddSSS");
	public final static SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	public final static SimpleDateFormat YYYYMM = new SimpleDateFormat("yyyyMM");
	
	//
    
    
    /**
     * 日期转字符串
     * @param date
     * @return
     */
    public static final String format(Date date,SimpleDateFormat sdf) {
    	try
    	{
    		return sdf.format(date);
    	}catch(Exception ex)
    	{
    		return "";
    	}
    }
    
    /**
     * 字符串转日期
     * @param s
     * @return
     */
    public static final Date parse(String str,SimpleDateFormat sdf) {
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }
    

    
    /**
     * 获取当前时间 格式:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static final String getCurrentDate() {
        return getNow(YYYY_MM_DD_MM_HH_SS);
    }
    
    /**
	 * 当前年
	 * @return
	 */
	public static int getCurrentYear()
	{
		 Calendar c = Calendar.getInstance();
	     c.setTime(new Date());
	     
	     return c.get(Calendar.YEAR);
	}
	
	/**
	 * 当前月（ 已加1）
	 * @return
	 */
	public static int getCurrentMonth()
	{
		 Calendar c = Calendar.getInstance();
	     c.setTime(new Date());
	     
	     return c.get(Calendar.MONTH)+1;
	}
    
    private static final String getNow(SimpleDateFormat sdf)
    {
    	return sdf.format(new Date());
    }
    
    /**
     * 为指定日期增加指定年数，原日期将不做修改
     *
     * @param date  日期，必须
     * @param amount  年数，可为负数
     * @return 新的日期
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * 为指定日期增加指定月数，原日期将不做修改
     *
     * @param date  日期，必须
     * @param amount  月数，可为负数
     * @return 新的日期
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 为指定日期增加指定周，原日期将不做修改
     *
     * @param date  日期，必须
     * @param amount  周数，可为负数
     * @return 新的日期
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    /**
     * 为指定日期增加指定天，原日期将不做修改
     *
     * @param date  日期，必须
     * @param amount  天数，可为负数
     * @return 新的日期
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }
    
    /**
	 * 日期加上天数的时间
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		return add(date, Calendar.DAY_OF_YEAR, day);
	}
	

    /**
     * 为指定日期增加指定小时，原日期将不做修改
     *
     * @param date  日期，必须
     * @param amount  小时数，可为负数
     * @return 新的日期
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 为指定日期增加指定分钟数，原日期将不做修改
     *
     * @param date  日期，必须
     * @param amount  分钟数，可为负数
     * @return 新的日期
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 为指定日期增加指定秒数，原日期将不做修改
     *
     * @param date  日期，必须
     * @param amount  秒数，可为负数
     * @return 新的日期
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    /**
     * 为指定日期增加指定毫秒数，原日期将不做修改
     *
     * @param date  日期，必须
     * @param amount  毫秒数，可为负数
     * @return 新的日期
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }
    
    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("必须设置日期");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
    /**
     * 得到某月的某一天
     * @param month 月份，与当前月比较如：上个月是 -1 ，当前月是 0 下个月是 1
     * @param day 日期，如 ：1 是 2011-04-01 ，31 是 2011-05-01
     * @param parsePattern 日期格式
     * @return 新的日期字符串
     */
    public static final String getNowDayOfMonth(int month,int day,String parsePattern){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        SimpleDateFormat sdf = new SimpleDateFormat(parsePattern);
        return sdf.format(calendar.getTime());
    }
    
    
    
    
    
    public static void main(String[] args) {
		
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(2019, 3, 0);
    	
    	System.out.println(getNextMonthFristDay(0,0));
	}
    
    
    
    public static String getFirstDay(int year,int month)
    {
    	String str = "";
    	if(year>0 && month>0)
    	{
    		str = year+"-"+(month<10?"0"+month:month)+"-01";
    	}else
    	{
    		str = getCurrentDate().substring(0, 11);
    	}
    	return str;
    }
    public static String getNextMonthFristDay(int year,int month)
    {
    	String str = "";
    	if(year>0 && month>0)
    	{
    		if(month == 12)
    		{
    			year+=1;
    			month = 1;
    		}else
    		{
    			month+=1;
    		}
    		str = year+"-"+(month<10?"0"+month:month)+"-01";
    	}else
    	{
    		str = format(addDay(new Date(),1), YYYY_MM_DD);  
    	}
    	return str;
    }
    
    /**
     * 校验日期格式
     * @param date 日期字符串
     * @param reg 正则表达式
     * @return
     */
    public static boolean checkDateStyle(String date,String reg){
    	Pattern p = Pattern.compile(reg);   
        Matcher m = p.matcher(date);   
        return m.matches();   
    }
    
    /**
     * 校验日期格式
     * @param date 日期字符串
     * @return
     */
    public static boolean checkDateStyle(String date){
    	Pattern p = Pattern.compile(REG);   
        Matcher m = p.matcher(date);   
        return m.matches();   
    }

    // 获得本年第一天的日期
    public static String getCurrentYearFirst() {
        int yearPlus = getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(Calendar.DATE, yearPlus);
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        return preYearDay;
    }

    private static int getYearPlus() {
        Calendar cd = Calendar.getInstance();
        int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天
        cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        if (yearOfNumber == 1) {
            return -MaxYear;
        } else {
            return 1 - yearOfNumber;
        }
    }

    public static Date strToDate(String dateString) {
		Date date = null;
		try {
			date = YYYY_MM_DD_MM_HH_SS.parse(dateString);
		} catch (ParseException e) {
			date = new Date();
			e.printStackTrace();
		}
		return date;
	}
	public static Date strToDate(String dateString,String pattern) {
		Date date = null;
		try {
			date = new SimpleDateFormat(pattern).parse(dateString);
		} catch (ParseException e) {
			date = new Date();
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * 日期按照指定格式转换为字符串
	 */
	public static String date2String(Date date, String formatStr) {
		return date2String(date, formatStr, Locale.getDefault());
	}
	private static String date2String(Date date, String formatStr, Locale locale) {
		Format format = new SimpleDateFormat(formatStr, locale);
		return format.format(date);
	}
	

	
}
