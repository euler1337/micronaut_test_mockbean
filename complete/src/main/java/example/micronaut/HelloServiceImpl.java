package example.micronaut;

import javax.inject.Singleton;

@Singleton
public class HelloServiceImpl implements HelloService {
    @Override
    public String getHello() {
        return "hello";
    }
}
