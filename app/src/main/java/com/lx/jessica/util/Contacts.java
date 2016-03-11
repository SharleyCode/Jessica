package com.lx.jessica.util;

/**
 * 常量接口
 */
public class Contacts {
    /** 保存是否是第一次运行程序的标记 */
    public final static String IS_FIRST_RUN = "isFirstRun";
    /** 不是第一次运行标识 */
    public final static int NOT_FIRST = 1;
    /** 是第一次运行标识 */
    public final static int IS_FIRST = -1;
    /** 选择目的地的请求码 */
    public final static int REQUEST_DES=0x11;
    /** 选择目的地的返回码 */
    public final static int RESULT_DES=0x12;

    /** 首页接口 */
    String  HOME = "http://app.interface.jescard.com//index/indexInfo.html";

    /** 品牌列表接口 */
    String BRAND = "http://app.interface.jescard.com//categoryBrand/getBrandInfoList.html";

    /** 分类选择接口 */
    String CLASSIFICATION = "http://app.interface.jescard.com//categoryBrand/getCategoryList.html";

    /** 经典大牌 SK-II  GUERLAIN */
    String SK = "http://app.interface.jescard.com//categoryBrand/getCategoryList.html";
    String GUERLAIN = " http://app.interface.jescard.com//categoryBrand/getCategoryList.html";
}
