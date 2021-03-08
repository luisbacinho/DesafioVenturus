package com.desafioventurus.models;

import java.util.List;

public class Gallery {

    private String id;
    private String title;
    private String description;
    private int datetime;
    private String cover;
    private String cover_width;
    private String cover_height;
    private String account_url;
    private int account_id;
    private String privacy;
    private String layout;
    private int views;
    private String link;
    private int ups;
    private int downs;
    private int points;
    private int score;
    private boolean is_album;
    private String vote;
    private boolean favorite;
    private boolean nsfw;
    private int comment_count;
    private int images_count;
    private List<Image> images;
    private boolean in_most_viral;

    public Gallery(String id, String title, String description, int datetime, String cover, String cover_width, String cover_height, String account_url, int account_id, String privacy, String layout, int views, String link, int ups, int downs, int points, int score, boolean is_album, String vote, boolean favorite, boolean nsfw, int comment_count, int images_count, List<Image> images, boolean in_most_viral) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.cover = cover;
        this.cover_width = cover_width;
        this.cover_height = cover_height;
        this.account_url = account_url;
        this.account_id = account_id;
        this.privacy = privacy;
        this.layout = layout;
        this.views = views;
        this.link = link;
        this.ups = ups;
        this.downs = downs;
        this.points = points;
        this.score = score;
        this.is_album = is_album;
        this.vote = vote;
        this.favorite = favorite;
        this.nsfw = nsfw;
        this.comment_count = comment_count;
        this.images_count = images_count;
        this.images = images;
        this.in_most_viral = in_most_viral;
    }

    public String getLinkForDownload(){
        if(images_count <= 0){
            return null;
        }

        for (Image image: images) {
            if(image.getId().equals(this.getCover())){
                return image.getLink();
            }
        }

        return null;
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

    public float getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover_width() {
        return cover_width;
    }

    public void setCover_width(String cover_width) {
        this.cover_width = cover_width;
    }

    public String getCover_height() {
        return cover_height;
    }

    public void setCover_height(String cover_height) {
        this.cover_height = cover_height;
    }

    public String getAccount_url() {
        return account_url;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isIs_album() {
        return is_album;
    }

    public void setIs_album(boolean is_album) {
        this.is_album = is_album;
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

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getImages_count() {
        return images_count;
    }

    public void setImages_count(int images_count) {
        this.images_count = images_count;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public boolean isIn_most_viral() {
        return in_most_viral;
    }

    public void setIn_most_viral(boolean in_most_viral) {
        this.in_most_viral = in_most_viral;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", cover='" + cover + '\'' +
                ", cover_width='" + cover_width + '\'' +
                ", cover_height='" + cover_height + '\'' +
                ", account_url='" + account_url + '\'' +
                ", account_id=" + account_id +
                ", privacy='" + privacy + '\'' +
                ", layout='" + layout + '\'' +
                ", views=" + views +
                ", link='" + link + '\'' +
                ", ups=" + ups +
                ", downs=" + downs +
                ", points=" + points +
                ", score=" + score +
                ", is_album=" + is_album +
                ", vote='" + vote + '\'' +
                ", favorite=" + favorite +
                ", nsfw=" + nsfw +
                ", comment_count=" + comment_count +
                ", images_count=" + images_count +
                ", images=" + images +
                ", in_most_viral=" + in_most_viral +
                '}';
    }
}
