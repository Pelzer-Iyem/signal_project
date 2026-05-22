package websocket;

import com.data_management.DataStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WebSocketIntegrationTest {

    @Test
    public void testStorageSingletonWorks() {
        DataStorage storage = DataStorage.getInstance();

        assertNotNull(storage);
    }
}
