package com.codecool.web.servlet;

import com.codecool.web.dao.PublicationDao;
import com.codecool.web.dao.database.DatabasePublicationDao;
import com.codecool.web.model.Publication;
import com.codecool.web.model.User;
import com.codecool.web.service.PublicationService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimplePublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/protected/publications")
public final class PublicationsServlet extends AbstractServlet {

    // https://www.postgresql.org/docs/current/static/errcodes-appendix.html
    private static final String SQL_ERROR_CODE_UNIQUE_VIOLATION = "23505";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PublicationDao publicationDao = new DatabasePublicationDao(connection);
            PublicationService publicationService = new SimplePublicationService(publicationDao);

            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            List<Publication> publications = publicationService.getAllPublicationForUser(user);

            sendMessage(resp, HttpServletResponse.SC_OK, publications);
        } catch (ServiceException ex) {
            sendMessage(resp, HttpServletResponse.SC_OK, ex.getMessage());
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
