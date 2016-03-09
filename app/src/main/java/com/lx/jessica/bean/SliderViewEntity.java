package com.lx.jessica.bean;

/**
 * Created by lvhao on 2016/3/8 0008.
 */
public class SliderViewEntity {
    private String title;
    private String pic;

    public SliderViewEntity(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
