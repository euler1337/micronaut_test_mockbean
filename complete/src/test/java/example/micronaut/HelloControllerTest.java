package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@MicronautTest
class HelloControllerTest extends HelloControllerTestBase {

    @Inject
    HelloService helloService;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testHello() {
        when(helloService.getHello()).thenReturn("hey");
        HttpRequest<String> request = HttpRequest.GET("/hello"); // <3>
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("hey", body);
    }
}
