package com.lingxiao.news.retrofit.modle;

import java.util.List;

public class NewsDetailModel {

    private String template;
    private SourceinfoBean sourceinfo;
    private String shareLink;
    private String source;
    private int threadVote;
    private String title;
    private String body;
    private String tid;
    private boolean picnews;
    private String advertiseType;
    private String articleType;
    private String digest;
    private String ptime;
    private String ec;
    private String docid;
    private int threadAgainst;
    private boolean hasNext;
    private String recImgsrc;
    private String dkeys;
    private boolean hidePlane;
    private int replyCount;
    private String voicecomment;
    private String replyBoard;
    private String category;
    private List<ImgBean> img;
    private List<SearchKwBean> searchKw;
    private List<TopiclistNewsBean> topiclist_news;
    private List<?> book;
    private List<LinkBean> link;
    private List<?> boboList;
    private List<?> ydbaike;
    private List<?> votes;
    private List<TopiclistBean> topiclist;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public SourceinfoBean getSourceinfo() {
        return sourceinfo;
    }

    public void setSourceinfo(SourceinfoBean sourceinfo) {
        this.sourceinfo = sourceinfo;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getThreadVote() {
        return threadVote;
    }

    public void setThreadVote(int threadVote) {
        this.threadVote = threadVote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public boolean isPicnews() {
        return picnews;
    }

    public void setPicnews(boolean picnews) {
        this.picnews = picnews;
    }

    public String getAdvertiseType() {
        return advertiseType;
    }

    public void setAdvertiseType(String advertiseType) {
        this.advertiseType = advertiseType;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public int getThreadAgainst() {
        return threadAgainst;
    }

    public void setThreadAgainst(int threadAgainst) {
        this.threadAgainst = threadAgainst;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getRecImgsrc() {
        return recImgsrc;
    }

    public void setRecImgsrc(String recImgsrc) {
        this.recImgsrc = recImgsrc;
    }

    public String getDkeys() {
        return dkeys;
    }

    public void setDkeys(String dkeys) {
        this.dkeys = dkeys;
    }

    public boolean isHidePlane() {
        return hidePlane;
    }

    public void setHidePlane(boolean hidePlane) {
        this.hidePlane = hidePlane;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getVoicecomment() {
        return voicecomment;
    }

    public void setVoicecomment(String voicecomment) {
        this.voicecomment = voicecomment;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ImgBean> getImg() {
        return img;
    }

    public void setImg(List<ImgBean> img) {
        this.img = img;
    }

    public List<SearchKwBean> getSearchKw() {
        return searchKw;
    }

    public void setSearchKw(List<SearchKwBean> searchKw) {
        this.searchKw = searchKw;
    }

    public List<TopiclistNewsBean> getTopiclist_news() {
        return topiclist_news;
    }

    public void setTopiclist_news(List<TopiclistNewsBean> topiclist_news) {
        this.topiclist_news = topiclist_news;
    }

    public List<?> getBook() {
        return book;
    }

    public void setBook(List<?> book) {
        this.book = book;
    }

    public List<LinkBean> getLink() {
        return link;
    }

    public void setLink(List<LinkBean> link) {
        this.link = link;
    }

    public List<?> getBoboList() {
        return boboList;
    }

    public void setBoboList(List<?> boboList) {
        this.boboList = boboList;
    }

    public List<?> getYdbaike() {
        return ydbaike;
    }

    public void setYdbaike(List<?> ydbaike) {
        this.ydbaike = ydbaike;
    }

    public List<?> getVotes() {
        return votes;
    }

    public void setVotes(List<?> votes) {
        this.votes = votes;
    }

    public List<TopiclistBean> getTopiclist() {
        return topiclist;
    }

    public void setTopiclist(List<TopiclistBean> topiclist) {
        this.topiclist = topiclist;
    }

    public class SourceinfoBean {
        /**
         * ename : T1438840302520
         * certificationImg : http://img2.cache.netease.com/m/newsapp/reading/vip/yellow.png
         * certificationText : 人间编辑
         * alias : 活在尘世，看见人间
         * tname : 网易人间
         * topic_icons : http://dingyue.nosdn.127.net/RO4kVaRnSCsKqnJlg9lWLDSVbTrskM2U2D66zp4oPSDZW1530172885354.png
         * tid : T1438840302520
         */

        private String ename;
        private String certificationImg;
        private String certificationText;
        private String alias;
        private String tname;
        private String topic_icons;
        private String tid;

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getCertificationImg() {
            return certificationImg;
        }

        public void setCertificationImg(String certificationImg) {
            this.certificationImg = certificationImg;
        }

        public String getCertificationText() {
            return certificationText;
        }

        public void setCertificationText(String certificationText) {
            this.certificationText = certificationText;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }

    public class ImgBean {
        /**
         * ref :
         * src : http://cms-bucket.nosdn.127.net/2018/10/13/cecfd55d3a95455094e56af3277f5885.jpeg
         * alt :
         * pixel : 1014*507
         */

        private String ref;
        private String src;
        private String alt;
        private String pixel;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }
    }

    public class SearchKwBean {
        /**
         * weight : 0.027962766779965124
         * keyword : 虚竹姥姥破色戒
         * tag_source : 3
         */

        private double weight;
        private String keyword;
        private int tag_source;

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public int getTag_source() {
            return tag_source;
        }

        public void setTag_source(int tag_source) {
            this.tag_source = tag_source;
        }
    }

    public class TopiclistNewsBean {
        /**
         * ename : zhenhua
         * hasCover : false
         * tname : 独家
         * alias : The Truth
         * subnum : 0
         * tid : T1370583240249
         * cid : C1348654575297
         */

        private String ename;
        private boolean hasCover;
        private String tname;
        private String alias;
        private String subnum;
        private String tid;
        private String cid;

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
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

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSubnum() {
            return subnum;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }
    }

    public class LinkBean {
        /**
         * ref :
         * href : http://3g.163.com/news/18/0213/19/DAI31QNG000187OQ.html
         * id : DAI31QNG000187OQ
         * type : doc
         * title : 所有好吃的蛋炒饭，都是久别重逢
         */

        private String ref;
        private String href;
        private String id;
        private String type;
        private String title;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public class TopiclistBean {
        /**
         * ename : T1438840302520
         * hasCover : false
         * tname : 网易人间
         * alias : 活在尘世，看见人间
         * subnum : 158.3万
         * tid : T1438840302520
         * cid : C1378977951794
         */

        private String ename;
        private boolean hasCover;
        private String tname;
        private String alias;
        private String subnum;
        private String tid;
        private String cid;

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
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

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSubnum() {
            return subnum;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }
    }
}
