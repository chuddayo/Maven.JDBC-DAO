package dao;

import dto.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements DAO {
    Connection connection = ConnectionFactory.getConnection();

    public Player findById(int id) {
        return null;
    }

    public List<Player> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from players");
        List<Player> playerList = new ArrayList<Player>();

        while(resultSet.next()) {
            playerList.add(extractPlayerFromResultSet(resultSet));
        }

        return playerList;
    }

    public Player update(Player player) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE Players SET first_name = ?, last_name = ? WHERE id = ?");
        preparedStatement.setString(1, player.getFirstName());
        preparedStatement.setString(2, player.getLastName());
        preparedStatement.setInt(3, player.getId());

        int result = preparedStatement.executeUpdate();
        if (result == 1) return player;
        return null;
    }

    public Player create(Player player) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO Players VALUES (DEFAULT, ?, ?)");
        preparedStatement.setString(1, player.getFirstName());
        preparedStatement.setString(2, player.getLastName());

        int result = preparedStatement.executeUpdate();
        if (result == 1) return player;
        return null;
    }

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM Players WHERE id = ?");
        preparedStatement.setInt(1, id);

        int result = preparedStatement.executeUpdate();
    }

    private Player extractPlayerFromResultSet(ResultSet rs) throws SQLException {
        Player player = new Player();

        player.setId( rs.getInt("id") );
        player.setFirstName( rs.getString("first_name") );
        player.setLastName( rs.getString("last_name") );

        return player;
    }


}
