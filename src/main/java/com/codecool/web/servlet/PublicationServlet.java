package com.codecool.web.servlet;

import com.codecool.web.dao.PublicationDao;
import com.codecool.web.dao.database.DatabasePublicationDao;
import com.codecool.web.model.Publication;
import com.codecool.web.service.PublicationService;
import com.codecool.web.service.simple.SimplePublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/publication")
public final class PublicationServlet extends AbstractServlet {

    // https://www.postgresql.org/docs/current/static/errcodes-appendix.html
    private static final String SQL_ERROR_CODE_UNIQUE_VIOLATION = "23505";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PublicationDao publicationDao = new DatabasePublicationDao(connection);
            PublicationService publicationService = new SimplePublicationService(publicationDao);

            String id = req.getParameter("id");

            Publication publication = publicationService.getPoem(Integer.parseInt(id));

            sendMessage(resp, HttpServletResponse.SC_OK, publication);
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
