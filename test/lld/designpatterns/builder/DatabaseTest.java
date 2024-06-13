package test.lld.designpatterns.builder;

import lld.designpatterns.builder.Database;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {

    @Test
    public void testBuilder(){
        Database database = Database.builder().withHost("localhost").withPort(3306).build();
        assertEquals("localhost", database.getHostname(), "Hostname is not 'localhost'");
    }
}
