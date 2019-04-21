package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class User extends AbstractModel {

    private String loginName;
    private String password;
    private List<Publication> publicationList;


    public User(int id, String loginName, String password) {
        super(id);
        this.loginName = loginName;
        this.password = password;
        this.publicationList = new ArrayList<>();
    }

    public void addPublication(Publication publication) {
        publicationList.add(publication);
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public List<Publication> getPublicationList() {
        return publicationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(loginName, user.loginName) &&
            Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loginName, password);
    }
}
