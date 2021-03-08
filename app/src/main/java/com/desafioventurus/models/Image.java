package com.desafioventurus.models;

import java.util.List;

public class Image {
    private String id;
    private String title;
    private String description;
    private int datetime;
    private String type;
    private boolean animated;
    private int width;
    private int height;
    private int size;
    private int views;
    private float bandwidth;
    private String vote;
    private boolean favorite;
    private boolean nsfw;
    private String section;
    private String account_url;
    private String account_id;
    private boolean is_ad;
    private boolean in_most_viral;
    private boolean has_sound;
    private List<String> tags;
    private int ad_type;
    private String ad_url;
    private String edited;
    private boolean in_gallery;
    private String link;
    private AdConfig ad_config;
    private String mp4;
    private String gifv;

    public Image(String id, String title, String description, int datetime, String type, boolean animated, int width, int height, int size, int views, float bandwidth, String vote, boolean favorite, boolean nsfw, String section, String account_url, String account_id, boolean is_ad, boolean in_most_viral, boolean has_sound, List<String> tags, int ad_type, String ad_url, String edited, boolean in_gallery, String link, AdConfig ad_config, String mp4, String gifv) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.type = type;
        this.animated = animated;
        this.width = width;
        this.height = height;
        this.size = size;
        this.views = views;
        this.bandwidth = bandwidth;
        this.vote = vote;
        this.favorite = favorite;
        this.nsfw = nsfw;
        this.section = section;
        this.account_url = account_url;
        this.account_id = account_id;
        this.is_ad = is_ad;
        this.in_most_viral = in_most_viral;
        this.has_sound = has_sound;
        this.tags = tags;
        this.ad_type = ad_type;
        this.ad_url = ad_url;
        this.edited = edited;
        this.in_gallery = in_gallery;
        this.link = link;
        this.ad_config = ad_config;
        this.mp4 = mp4;
        this.gifv = gifv;
    }

    public String getLinkForDownload(){
        return link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(float bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAccount_url() {
        return account_url;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public boolean isIs_ad() {
        return is_ad;
    }

    public void setIs_ad(boolean is_ad) {
        this.is_ad = is_ad;
    }

    public boolean isIn_most_viral() {
        return in_most_viral;
    }

    public void setIn_most_viral(boolean in_most_viral) {
        this.in_most_viral = in_most_viral;
    }

    public boolean isHas_sound() {
        return has_sound;
    }

    public void setHas_sound(boolean has_sound) {
        this.has_sound = has_sound;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getAd_type() {
        return ad_type;
    }

    public void setAd_type(int ad_type) {
        this.ad_type = ad_type;
    }

    public String getAd_url() {
        return ad_url;
    }

    public void setAd_url(String ad_url) {
        this.ad_url = ad_url;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public boolean isIn_gallery() {
        return in_gallery;
    }

    public void setIn_gallery(boolean in_gallery) {
        this.in_gallery = in_gallery;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public AdConfig getAd_config() {
        return ad_config;
    }

    public void setAd_config(AdConfig ad_config) {
        this.ad_config = ad_config;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public String getGifv() {
        return gifv;
    }

    public void setGifv(String gifv) {
        this.gifv = gifv;
    }
}
