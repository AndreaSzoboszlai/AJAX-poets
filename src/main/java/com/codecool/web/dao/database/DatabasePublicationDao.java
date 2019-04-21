package com.codecool.web.dao.database;

import com.codecool.web.dao.PublicationDao;
import com.codecool.web.model.Publication;
import com.codecool.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabasePublicationDao extends AbstractDao implements PublicationDao {

    public DatabasePublicationDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Publication> findAll() throws SQLException {
        List<Publication> publications = new ArrayList<>();
        String sql = "SELECT u_id, title, text_content, published_year FROM publications";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
             while (resultSet.next()) {
                publications.add(fetchPublication(resultSet));
             }
        }
        return publications;
    }

    @Override
    public List<Publication> findPublicationForUser(User user) throws SQLException {
        List<Publication> publications = new ArrayList<>();
        String sql = "SELECT u_id, title, text_content, published_year FROM publications WHERE u_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    publications.add(fetchPublication(resultSet));
                }

            }
        }
        return publications;
    }

    private Publication fetchPublication(ResultSet resultSet) throws SQLException {
        int uId = resultSet.getInt("u_id");
        String title = resultSet.getString("title");
        String content = resultSet.getString("text_content");
        int publishedYear = resultSet.getInt("published_year");
        return new Publication(uId, title, content, publishedYear);
    }
}
