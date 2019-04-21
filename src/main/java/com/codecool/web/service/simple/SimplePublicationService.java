package com.codecool.web.service.simple;

import com.codecool.web.dao.PublicationDao;
import com.codecool.web.model.Publication;
import com.codecool.web.model.User;
import com.codecool.web.service.PublicationService;

import java.sql.SQLException;
import java.util.List;

public class SimplePublicationService implements PublicationService {
    private final PublicationDao publicationDao;

    public SimplePublicationService(PublicationDao publicationDao) {
        this.publicationDao = publicationDao;
    }

    public List<Publication> getAllPublication() throws SQLException {
        return publicationDao.findAll();
    }

    public List<Publication> getAllPublicationForUser(User user) throws SQLException {
        return publicationDao.findPublicationForUser(user);
    }
}
