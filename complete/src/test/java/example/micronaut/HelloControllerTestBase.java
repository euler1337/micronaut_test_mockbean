package example.micronaut;

import io.micronaut.test.annotation.MockBean;
import static org.mockito.Mockito.mock;

abstract class HelloControllerTestBase {

    @MockBean(HelloService.class)
    HelloService helloService() {
        return mock(HelloService.class);
    }

}
