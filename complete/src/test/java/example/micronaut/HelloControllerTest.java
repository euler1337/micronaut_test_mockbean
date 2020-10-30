package example.micronaut;

import io.micronaut.http.HttpRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class HelloControllerTest extends HelloControllerTestBase {

    @Test
    public void testHello() {
        when(helloService.getHello()).thenReturn("hey");
        HttpRequest<String> request = HttpRequest.GET("/hello"); // <3>
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("hey", body);
    }
}
