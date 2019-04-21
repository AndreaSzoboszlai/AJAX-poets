package com.codecool.web.dao;

import com.codecool.web.model.Publication;
import com.codecool.web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface PublicationDao {
    List<Publication> findAll() throws SQLException;
    List<Publication> findPublicationForUser(User user) throws SQLException;
}
