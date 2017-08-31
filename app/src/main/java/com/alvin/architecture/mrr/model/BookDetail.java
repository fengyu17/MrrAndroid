package com.alvin.architecture.mrr.model;

import java.util.List;

/**
 * Created by dell on 2017/8/29.
 */

public class BookDetail {
    /**
     * rating : {"max":10,"numRaters":47,"average":"6.6","min":0}
     * subtitle :
     * author : ["穷游网、中国国家地理·图书"]
     * pubdate : 2015-4
     * tags : [{"count":21,"name":"旅行","title":"旅行"},{"count":12,"name":"旅游","title":"旅游"},{"count":11,"name":"中国国家地理","title":"中国国家地理"},{"count":8,"name":"穷游","title":"穷游"},{"count":8,"name":"摄影","title":"摄影"},{"count":6,"name":"看世界","title":"看世界"},{"count":4,"name":"旅游指南","title":"旅游指南"},{"count":2,"name":"人丑就要多读书","title":"人丑就要多读书"}]
     * origin_title :
     * image : https://img1.doubanio.com/mpic/s28047649.jpg
     * binding : 平装
     * translator : []
     * catalog : 【写在前面：和我们一起发现最世界】by蔡景晖（穷游网首席运营官）
     【年度总榜单】
     {年度旅游国家}
     {年度旅游城市}
     {年度蜜月旅行地}
     {年度家庭出游地}
     {年度美食之地}
     {年度悠闲岛屿}
     {年度终极荒野}
     {年度奇幻美景}
     {年度野生动物观赏地}
     【发现世界分榜单】
     最传奇火车站
     最个性地铁站
     最具旅行感的铁路
     最美风景自驾路线
     最酷徒步路线
     最神秘水路
     最缤纷城市
     最炫城市夜景
     最高人气购物圣地
     最避世的小镇
     最有故事的历史遗迹
     最神秘古堡
     最圣洁的宗教建筑
     最浪漫的桥
     最富魅力的大学校园
     最不像地球的地方
     最巅峰户外体验
     最动人的日出日落
     最舒适的温泉
     最精彩的主题公园
     最奇妙博物馆
     最给力球场
     最文艺咖啡馆
     最热闹的市集
     最有特色的书店
     最人气节日
     最梦幻潜水地
     最佳星空观赏地
     * pages : 320
     * images : {"small":"https://img1.doubanio.com/spic/s28047649.jpg","large":"https://img1.doubanio.com/lpic/s28047649.jpg","medium":"https://img1.doubanio.com/mpic/s28047649.jpg"}
     * alt : https://book.douban.com/subject/26364214/
     * id : 26364214
     * publisher : 北京联合出版有限公司
     * isbn10 : 755024846X
     * isbn13 : 9787550248465
     * title : 发现最世界：全球最佳旅行目的地
     * url : https://api.douban.com/v2/book/26364214
     * alt_title :
     * author_intro : 【穷游网】全球最大的中文出境旅行信息网站及社区，跨国多目的地中文旅游资讯平台。专注出境旅行，鼓励和帮助中国旅行者以自己的视角和方式去体验世界。
     【中国国家地理·图书】成立于2009年，隶属于《中国国家地理》全媒体集团。天地之美，阅然纸上。我们关注生命与美好的交织，志在出版与地理旅行、文化生活、摄影艺术、自然百科相关的优质图书。
     * summary : 【灵感·INSPIRE】
     世界如此宽广，梦想从不说谎。
     身体是我们对总在此处者的体验，旅行是灵感的无限量衍伸。
     在变幻的天地中，我们借此认知自我与世界的关系。
     2004-2014，十年征途，我们一同发现，一同见证……
     【探索·EXPLORE】
     路途纵然艰辛，世界触手可及。
     每一次启程，都是向内心的无畏探索。
     STEP 1 为下一秒的未知而出发
     STEP 2 时时刻刻在路上
     STEP 3 完美展现超300个精彩目的地
     STEP 4 2000万人共享的独特体验……
     【分享·SHARE】
     中国最大出境旅行社区“穷游网”& 本土权威旅行媒体“中国国家地理”强强联手
     重磅推出首本中国原创旅行榜单书
     原创视角+权威数据+网络票选
     2000万旅行者的智慧选择 超300个精选目的地跃然纸上
     最真实，最亲民，最丰富，最有料！
     “彼岸不在某处，在乎世界从此不同。”by亨利·米勒
     而“你喜欢的，就是你的最世界！”by蔡景晖（穷游网首席运营官）
     * price : 49.8
     */

    private RatingBean rating;
    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    private ImagesBean images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private String price;
    private List<String> author;
    private List<TagsBean> tags;
    private List<?> translator;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<?> getTranslator() {
        return translator;
    }

    public void setTranslator(List<?> translator) {
        this.translator = translator;
    }

    public static class RatingBean {
        /**
         * max : 10
         * numRaters : 47
         * average : 6.6
         * min : 0
         */

        private int max;
        private int numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img1.doubanio.com/spic/s28047649.jpg
         * large : https://img1.doubanio.com/lpic/s28047649.jpg
         * medium : https://img1.doubanio.com/mpic/s28047649.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class TagsBean {
        /**
         * count : 21
         * name : 旅行
         * title : 旅行
         */

        private int count;
        private String name;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
