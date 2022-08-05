package dao;

import dto.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

public class PlayerDAOTest {
    PlayerDAO playerDAO;

    @Before
    public void init() {
        playerDAO = new PlayerDAO();
    }

    @Test
    public void findAllTest() throws SQLException {
        List<Player> playerList = playerDAO.findAll();

        Assert.assertNotNull(playerList);
    }

    @Test
    public void updateTest() throws SQLException {
        String expected = "Welch";

        Player player = new Player(1, "Billy", "Welch");
        playerDAO.update(player);
        String actual = playerDAO.findAll().get(0).getLastName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createTest() throws SQLException {
        int expected = playerDAO.findAll().size() + 1;

        Player player = new Player("Kyle", "Welch");
        playerDAO.create(player);
        int actual = playerDAO.findAll().size();

        Assert.assertEquals(expected, actual);
    }

    @Test // test not repeatable as id number not regenerated
    public void deleteTest() throws SQLException {
        int expected = playerDAO.findAll().size() - 1;

        playerDAO.delete(4);
        int actual = playerDAO.findAll().size();

        Assert.assertEquals(expected, actual);
    }
}
