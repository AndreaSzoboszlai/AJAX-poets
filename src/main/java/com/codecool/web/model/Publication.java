package com.codecool.web.model;

public class Publication {
    private String uId;
    private String title;
    private int publishedYear;

    public Publication(String uId, String title, int publishedYear) {
        this.uId = uId;
        this.title = title;
        this.publishedYear = publishedYear;
    }

    public String getuId() {
        return uId;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
}
