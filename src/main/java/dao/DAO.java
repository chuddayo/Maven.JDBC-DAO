package dao;

import dto.Player;

import java.sql.SQLException;
import java.util.List;

// Player here could be generic in a program with more than one Object type to manipulate
public interface DAO {
    Player findById(int id);
    List<Player> findAll() throws SQLException;
    Player update(Player dto) throws SQLException;
    Player create(Player dto) throws SQLException;
    void delete(int id) throws SQLException;
}
