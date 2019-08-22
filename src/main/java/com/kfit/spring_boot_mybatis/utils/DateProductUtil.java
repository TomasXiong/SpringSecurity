package com.kfit.spring_boot_mybatis.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 产品  ==>时间工具类
 * 
 * @author Administrator
 * 
 */
public class DateProductUtil {
	
	
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
	
	
	public static String dateToString(Date date) {
		return dateToString(date,"yyyy-MM-dd");
	}
	public static String dateToString(Date date, String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(date);
	}

	
	public static boolean startDateBeforEndDate(Date startDate, Date endDate){
		boolean bool=false;
		 if (startDate.getTime() <= endDate.getTime()) {
             bool=true;
         } 
		 return bool;
	}
	
	
	
	
	/**
	 * 计算日期(默认不计算最后一天)
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int diffDate(Date startDate,Date endDate){
//		System.out.print("=========startDate="+dateToString(startDate)+"=========endDate=="+dateToString(endDate)+"=====");
		return diffDate(startDate, endDate, false);
	}
	
	/**
	 * 计算日期
	 * @param startDate
	 * @param endDate
	 * @param isAddStartDay 是否计算第一天
	 * @return
	 */
	public static int diffDate(Date startDate,Date endDate,boolean isAddStartDay){
		Date _startDate= startDate;
		Date _endDate= endDate;
		if(isAddStartDay){
			_startDate.setTime(strToDate(dateToString(startDate),"yyyy-MM-dd").getTime());
//			_startDate.setTime(startDate.getTime());
			_endDate.setTime(strToDate(dateToString(endDate),"yyyy-MM-dd").getTime());
		}
		Calendar cal_start = Calendar.getInstance();    
		cal_start.setTime(_startDate);    
		long time_start = cal_start.getTimeInMillis();   
		
		Calendar cal_end = Calendar.getInstance();    
		cal_end.setTime(_endDate);    
		long time_end = cal_end.getTimeInMillis();         
		
		long between_days=(time_end-time_start)/(1000*3600*24);  
		if(between_days <= 0 ){
			between_days=0;
		}
		//是否计算 开始日期第一天
	    return Integer.parseInt(String.valueOf(between_days));      
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
	
	public static void main(String[] args) {
		
//		String pattern="yyyyMMdd";
//		Date startDate=strToDate("20140721", pattern);
//		Date endDate=strToDate("20141120", pattern);
//		int cycleDay=15;
		
//		int num =calcRepayPeriod(startDate, endDate, cycleDay);
//		System.out.println("周期数=="+num);

//		System.out.println("##############周期数==【】"+calcRepayPeriod(startDate, endDate, 15));
//		System.out.println();
//		System.out.println("##############周期数==【】"+calcRepayPeriod(startDate, endDate, 6));
//		System.out.println();
//		System.out.println("##############周期数==【】"+calcRepayPeriod(startDate, endDate, 14));
//		System.out.println();
//		System.out.println("##############周期数==【】"+calcRepayPeriod(startDate, endDate, 1));
//		System.out.println();
		
//		Date nextMonth=addMonths(startDate, 1);
		//System.out.println("相差天数="+diffDate(startDate, nextMonth)+"========="+nextMonth.toLocaleString());
//		System.out.println("====="+calcRepayDate(startDate, 20));
		
//		Date _ddate=strToDate("20140629", pattern);
		//System.out.println(addDays(_ddate, 33).toLocaleString());
		
		
	}
}
