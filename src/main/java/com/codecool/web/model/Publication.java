package com.codecool.web.model;

public class Publication extends AbstractModel {
    private int pId;
    private String title;
    private String content;
    private int publishedYear;

    public Publication(int uId, int pId, String title, String content, int publishedYear) {
        super(uId);
        this.pId = pId;
        this.title = title;
        this.content = content;
        this.publishedYear = publishedYear;
    }

    public int getpId() {
        return pId;
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
