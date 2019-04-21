package com.codecool.web.model;

public class Publication {
    private int uId;
    private String title;
    private String content;
    private int publishedYear;

    public Publication(int uId, String title, String content, int publishedYear) {
        this.uId = uId;
        this.title = title;
        this.content = content;
        this.publishedYear = publishedYear;
    }

    public int getuId() {
        return uId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
}
