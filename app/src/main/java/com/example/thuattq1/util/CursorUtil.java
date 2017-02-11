package com.example.thuattq1.util;

import android.database.Cursor;

import com.example.thuattq1.global.GlobalInfo;

public class CursorUtil {

	/**
	 * lay string tu cursor
	 *
	 * @author: 
	 * @since: 9:07:34 AM Sep 17, 2014
	 * @return: String
	 * @throws:
	 * @param c
	 * @param columnName
	 * @return:
	 */
	public static String getString(Cursor c, String columnName, String defaultValue, String nullValue){
		String str = defaultValue;
		int columnIndex = c.getColumnIndex(columnName);
		if(columnIndex >= 0){
			if (!c.isNull(columnIndex)) {
				str = c.getString(columnIndex);
			} else{
				str = nullValue;
			}
		}
		return str;
	}

    public static String getString(Cursor c, String columnName){
        return getString(c, columnName, "", "");
    }

    public static String getString(Cursor c, String columnName, String defaultValue){
        return getString(c, columnName, defaultValue, "");
    }

    public static String getStringObj(Cursor c, String defaultValue, String nullValue){
        String str = defaultValue;

        if(c != null && c.getCount() > 0) {
            c.moveToFirst();
            if (!c.isNull(0)) {
                str = c.getString(0);
            } else{
                str = nullValue;
            }
        }

        return str;
    }

	/**
	 * lay int tu cursor
	 *
	 * @author: 
	 * @since: 9:07:52 AM Sep 17, 2014
	 * @return: int
	 * @throws:
	 * @param c
	 * @param columnName
	 * @return:
	 */
	public static int getInt(Cursor c, String columnName, int defaultValue, int nullValue){
		int i = defaultValue;
		int columnIndex = c.getColumnIndex(columnName);
		if(columnIndex >= 0){
			if (!c.isNull(columnIndex)) {
				i = c.getInt(columnIndex);
			} else{
				i = nullValue;
			}
		}
		return i;
	}

    public static int getInt(Cursor c, String columnName){
        return getInt(c, columnName, 0, 0);
    }

    public static int getInt(Cursor c, String columnName, int defaultValue){
        return getInt(c, columnName, defaultValue, 0);
    }
	
    public static int getIntObj(Cursor c, int defaultValue, int nullValue){
        int object = defaultValue;

        if(c != null && c.getCount() > 0) {
            c.moveToFirst();
            object = !c.isNull(0) ? c.getInt(0) : nullValue;
        }

        return object;
    }

	/**
	 * lay long tu cursor
	 *
	 * @author: 
	 * @since: 9:08:02 AM Sep 17, 2014
	 * @return: long
	 * @throws:
	 * @param c
	 * @param columnName
	 * @return:
	 */
	public static long getLong(Cursor c, String columnName, long defaultValue, long nullValue){
		long i = defaultValue;
		int columnIndex = c.getColumnIndex(columnName);
		if(columnIndex >= 0){
			if (!c.isNull(columnIndex)) {
				i = c.getLong(columnIndex);
			} else{
				i = nullValue;
			}
		}
		return i;
	}

    public static long getLong(Cursor c, String columnName){
        return getLong(c, columnName, 0, 0);
    }

    public static long getLong(Cursor c, String columnName, long defaultValue){
        return getLong(c, columnName, defaultValue, 0);
    }

    public static long getLongObj(Cursor c, long defaultValue, long nullValue){
        long object = defaultValue;

        if(c != null && c.getCount() > 0) {
            c.moveToFirst();
            object = !c.isNull(0) ? c.getLong(0) : nullValue;
        }

        return object;
    }
	
	/**
	 * lay DOUBLE tu cursor
	 *
	 * @author: 
	 * @since: 9:08:02 AM Sep 17, 2014
	 * @return: long
	 * @throws:
	 * @param c
	 * @param columnName
	 * @return:
	 */
	public static double getDouble(Cursor c, String columnName, double defaultValue, double nullValue){
		double i = defaultValue;
		int columnIndex = c.getColumnIndex(columnName);
		if(columnIndex >= 0){
			if (!c.isNull(columnIndex)) {
				i = c.getDouble(columnIndex);
			} else{
				i = nullValue;
			}
		}
		return i;
	}

    public static double getDouble(Cursor c, String columnName){
        return getDouble(c, columnName, 0.0, 0.0);
    }

    public static double getDouble(Cursor c, String columnName, double defaultValue){
        return getDouble(c, columnName, defaultValue, 0);
    }

    public static double getDoubleObj(Cursor c, double defaultValue, double nullValue){
        double object = defaultValue;

        if(c != null && c.getCount() > 0) {
            c.moveToFirst();
            object = !c.isNull(0) ? c.getDouble(0) : nullValue;
        }

        return object;
    }

	/**
	 * lay double tu cursor
	 * @author: 
	 * @since: 08:09:11 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param c
	 * @param columnName
	 * @param sysCurrencyDivide VD 1000 doi voi vnd, 1 voi USD
	 * @param sysTypeRound 1 lam tron len, 2 lam tron xuong, 3 lam tron tu nhien
	 * @return
	 */
	public static double getDouble(Cursor c, String columnName, int sysCurrencyDivide, int sysTypeRound){
		double number = getDouble(c, columnName);
		return StringUtil.getDouble(number, sysCurrencyDivide, sysTypeRound);
	}

	/**
	 * get double amount with using round config, Currency Divide config
	 * @author: 
	 * @since: 08:09:38 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param c
	 * @param columnName
	 * @return
	 */
	public static double getDoubleUsingSysConfig(Cursor c, String columnName){
		return getDouble(c, columnName, GlobalInfo.getInstance().getSysCurrencyDivide(),
				GlobalInfo.getInstance().getSysNumRounding());
	}

	/**
	 * get float from cursor
	 *
	 * @author: 
	 * @since: 6:39:54 PM Mar 26, 2015
	 * @return: float
	 * @throws:
	 * @param c
	 * @param columnName
	 * @return
	 */
	public static float getFloat(Cursor c, String columnName, float defaultValue, float nullValue){
		float f = defaultValue;
		int columnIndex = c.getColumnIndex(columnName);
		if(columnIndex >= 0){
			if (!c.isNull(columnIndex)) {
				f = c.getFloat(columnIndex);
			} else{
				f = nullValue;
			}
		}
		return f;
	}
	
	public static float getFloat(Cursor c, String columnName, float defaultValue){
		return getFloat(c, columnName, defaultValue, 0);
	}
	
	public static float getFloat(Cursor c, String columnName){
		return getFloat(c, columnName, 0, 0);
	}

    public static double getFloatObj(Cursor c, float defaultValue, float nullValue){
        float object = defaultValue;

        if(c != null && c.getCount() > 0) {
            c.moveToFirst();
            object = !c.isNull(0) ? c.getFloat(0) : nullValue;
        }

        return object;
    }
}
