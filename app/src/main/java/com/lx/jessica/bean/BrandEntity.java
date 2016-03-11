package com.lx.jessica.bean;

import java.util.List;

/**
 * 品牌列表实体类
 */
public class BrandEntity {


    private ObjEntity obj;

    public void setObj(ObjEntity obj) {
        this.obj = obj;
    }

    public ObjEntity getObj() {
        return obj;
    }

    public static class ObjEntity {
        private Object mainLandBrandList;

        private List<HotBrandListEntity> hotBrandList;

        private List<BrandListEntity> brandList;

        public void setMainLandBrandList(Object mainLandBrandList) {
            this.mainLandBrandList = mainLandBrandList;
        }

        public void setHotBrandList(List<HotBrandListEntity> hotBrandList) {
            this.hotBrandList = hotBrandList;
        }

        public void setBrandList(List<BrandListEntity> brandList) {
            this.brandList = brandList;
        }

        public Object getMainLandBrandList() {
            return mainLandBrandList;
        }

        public List<HotBrandListEntity> getHotBrandList() {
            return hotBrandList;
        }

        public List<BrandListEntity> getBrandList() {
            return brandList;
        }

        public static class HotBrandListEntity {
            private String name;
            private String englishName;
            private String chineseName;
            private String brandIndex;
            private String brandPicUrl;

            public void setName(String name) {
                this.name = name;
            }

            public void setEnglishName(String englishName) {
                this.englishName = englishName;
            }

            public void setChineseName(String chineseName) {
                this.chineseName = chineseName;
            }

            public void setBrandIndex(String brandIndex) {
                this.brandIndex = brandIndex;
            }

            public void setBrandPicUrl(String brandPicUrl) {
                this.brandPicUrl = brandPicUrl;
            }

            public String getName() {
                return name;
            }

            public String getEnglishName() {
                return englishName;
            }

            public String getChineseName() {
                return chineseName;
            }

            public String getBrandIndex() {
                return brandIndex;
            }

            public String getBrandPicUrl() {
                return brandPicUrl;
            }
        }

        public static class BrandListEntity {
            private String brandIndex;

            private List<BrandListDatasEntity> brandListDatas;

            public void setBrandIndex(String brandIndex) {
                this.brandIndex = brandIndex;
            }

            public void setBrandListDatas(List<BrandListDatasEntity> brandListDatas) {
                this.brandListDatas = brandListDatas;
            }

            public String getBrandIndex() {
                return brandIndex;
            }

            public List<BrandListDatasEntity> getBrandListDatas() {
                return brandListDatas;
            }

            public static class BrandListDatasEntity {
                private String name;
                private String englishName;
                private String chineseName;
                private String brandIndex;
                private String brandPicUrl;

                public void setName(String name) {
                    this.name = name;
                }

                public void setEnglishName(String englishName) {
                    this.englishName = englishName;
                }

                public void setChineseName(String chineseName) {
                    this.chineseName = chineseName;
                }

                public void setBrandIndex(String brandIndex) {
                    this.brandIndex = brandIndex;
                }

                public void setBrandPicUrl(String brandPicUrl) {
                    this.brandPicUrl = brandPicUrl;
                }

                public String getName() {
                    return name;
                }

                public String getEnglishName() {
                    return englishName;
                }

                public String getChineseName() {
                    return chineseName;
                }

                public String getBrandIndex() {
                    return brandIndex;
                }

                public String getBrandPicUrl() {
                    return brandPicUrl;
                }
            }
        }
    }
}
