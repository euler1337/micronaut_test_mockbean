package example.micronaut;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import javax.inject.Inject;
import static org.mockito.Mockito.mock;

@MicronautTest
public abstract class HelloControllerTestBase {

    @Inject
    HelloService helloService;

    @MockBean(HelloServiceImpl.class)
    HelloService helloService() {
        return mock(HelloService.class);
    }

    @Inject
    @Client("/")
    RxHttpClient client;

}
