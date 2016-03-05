package com.lx.jessica.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/3/3.
 */
public class SharedPreferencesUtil {

    private final static String TAG = "SharedPreferencesUtil";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SharedPreferencesUtil(Context context){
        prefs = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    /**
     * 根据字符串存储一个字符串值
     */
    public boolean putString(String key, String value){
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * 根据key值得到存储结果，如果没有找到value就返回null
     */
    public String getString(String key){
        return prefs.getString(key, null);
    }

    /**
     * 根据键字符串存储一个字符串值
     */
    public boolean putInt(String key, int value){
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * 根据key值得到存储结果， 没有找到value就返回-1
     */
    public int getInt(String key){
        return prefs.getInt(key, -1);
    }

    /**
     * 清空数据
     */
    public boolean clear(){
        editor.clear();
        return editor.commit();
    }

    /**
     * 关闭当前对象
     */
    public void close(){
        prefs = null;
    }
}
