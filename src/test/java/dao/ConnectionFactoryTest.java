package dao;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class ConnectionFactoryTest {
    @Test
    public void getConnectionTest() {
        Connection connection = ConnectionFactory.getConnection();

        Assert.assertNotNull(connection);
    }
}
