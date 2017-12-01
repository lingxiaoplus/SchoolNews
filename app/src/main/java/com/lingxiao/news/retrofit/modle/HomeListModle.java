package com.lingxiao.news.retrofit.modle;

import java.util.List;

/**
 * Created by lingxiao on 17-12-1.
 */

public class HomeListModle {

    private List<TListBean> tList;

    public List<TListBean> getTList() {
        return tList;
    }

    public void setTList(List<TListBean> tList) {
        this.tList = tList;
    }

    public static class TListBean {
        /**
         * template : normal1
         * img : http://img2.cache.netease.com/m/newsapp/banner/zhenhua.png
         * recommendOrder : 0
         * color :
         * ad_type : 1
         * recommend : 0
         * tagDate : 2017-08-08 20:33:05.0
         * tid : T1370583240249
         * headLine : false
         * topicid : 000181S1
         * alias : The Truth
         * showType : comment
         * subnum : 0
         * hasAD : 1
         * tag : hot
         * hasCover : false
         * tname : 独家
         * hashead : 1
         * isNew : 0
         * special : 0
         * ename : zhenhua
         * hasIcon : true
         * bannerOrder : 105
         * isHot : 1
         * cid : C1348654575297
         * weburl : http://www.163.com/
         * animationText : 段子频道全新改版
         */

        private String template;
        private String img;
        private int recommendOrder;
        private String color;
        private int ad_type;
        private String recommend;
        private String tagDate;
        private String tid;
        private boolean headLine;
        private String topicid;
        private String alias;
        private String showType;
        private String subnum;
        private int hasAD;
        private String tag;
        private boolean hasCover;
        private String tname;
        private int hashead;
        private int isNew;
        private int special;
        private String ename;
        private boolean hasIcon;
        private int bannerOrder;
        private int isHot;
        private String cid;
        private String weburl;
        private String animationText;

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getRecommendOrder() {
            return recommendOrder;
        }

        public void setRecommendOrder(int recommendOrder) {
            this.recommendOrder = recommendOrder;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getAd_type() {
            return ad_type;
        }

        public void setAd_type(int ad_type) {
            this.ad_type = ad_type;
        }

        public String getRecommend() {
            return recommend;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public String getTagDate() {
            return tagDate;
        }

        public void setTagDate(String tagDate) {
            this.tagDate = tagDate;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public boolean isHeadLine() {
            return headLine;
        }

        public void setHeadLine(boolean headLine) {
            this.headLine = headLine;
        }

        public String getTopicid() {
            return topicid;
        }

        public void setTopicid(String topicid) {
            this.topicid = topicid;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getShowType() {
            return showType;
        }

        public void setShowType(String showType) {
            this.showType = showType;
        }

        public String getSubnum() {
            return subnum;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public int getHashead() {
            return hashead;
        }

        public void setHashead(int hashead) {
            this.hashead = hashead;
        }

        public int getIsNew() {
            return isNew;
        }

        public void setIsNew(int isNew) {
            this.isNew = isNew;
        }

        public int getSpecial() {
            return special;
        }

        public void setSpecial(int special) {
            this.special = special;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public int getBannerOrder() {
            return bannerOrder;
        }

        public void setBannerOrder(int bannerOrder) {
            this.bannerOrder = bannerOrder;
        }

        public int getIsHot() {
            return isHot;
        }

        public void setIsHot(int isHot) {
            this.isHot = isHot;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }

        public String getAnimationText() {
            return animationText;
        }

        public void setAnimationText(String animationText) {
            this.animationText = animationText;
        }
    }
}
