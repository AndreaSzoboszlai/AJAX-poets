package com.codecool.web.servlet;

import com.codecool.web.dao.CouponDao;
import com.codecool.web.dao.PublicationDao;
import com.codecool.web.dao.ShopDao;
import com.codecool.web.dao.database.DatabaseCouponDao;
import com.codecool.web.dao.database.DatabasePublicationDao;
import com.codecool.web.dao.database.DatabaseShopDao;
import com.codecool.web.dto.CouponDto;
import com.codecool.web.model.Coupon;
import com.codecool.web.model.Publication;
import com.codecool.web.model.Shop;
import com.codecool.web.model.User;
import com.codecool.web.service.CouponService;
import com.codecool.web.service.PublicationService;
import com.codecool.web.service.ShopService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleCouponService;
import com.codecool.web.service.simple.SimplePublicationService;
import com.codecool.web.service.simple.SimpleShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/protected/publication")
public final class PublicationServlet extends AbstractServlet {

    // https://www.postgresql.org/docs/current/static/errcodes-appendix.html
    private static final String SQL_ERROR_CODE_UNIQUE_VIOLATION = "23505";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PublicationDao publicationDao = new DatabasePublicationDao(connection);
            PublicationService publicationService = new SimplePublicationService(publicationDao);

            List<Publication> publications = publicationService.getAllPublication();

            sendMessage(resp, HttpServletResponse.SC_OK, publications);
        } catch (ServiceException ex) {
            sendMessage(resp, HttpServletResponse.SC_OK, ex.getMessage());
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
