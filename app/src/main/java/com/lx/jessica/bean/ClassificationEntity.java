package com.lx.jessica.bean;

import java.util.List;

/**
 * 分类列表实体类
 */
public class ClassificationEntity {


    private List<ObjEntity> obj;

    public void setObj(List<ObjEntity> obj) {
        this.obj = obj;
    }

    public List<ObjEntity> getObj() {
        return obj;
    }

    public static class ObjEntity {
        private String categorypicUrl;
        private String categoryName;

        public void setCategorypicUrl(String categorypicUrl) {
            this.categorypicUrl = categorypicUrl;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategorypicUrl() {
            return categorypicUrl;
        }

        public String getCategoryName() {
            return categoryName;
        }
    }
}
