package DTO;

import java.util.Date;

public class Post {
    private String image;
    private String content;
    private String title;
    private Date date;
    private String name;
    private int like;

    public Post(String image, String content, String title, Date date, String name, int like) {
        this.image = image;
        this.content = content;
        this.title = title;
        this.date = date;
        this.name = name;
        this.like = like;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
