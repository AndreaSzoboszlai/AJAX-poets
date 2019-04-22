package com.codecool.web.service;

import com.codecool.web.model.Publication;
import com.codecool.web.model.User;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface PublicationService {
    List<Publication> getAllPublication() throws SQLException, ServiceException;
    List<Publication> getAllPublicationForUser(User user) throws SQLException, ServiceException;
    Publication getPoem(int pId) throws SQLException;
}
