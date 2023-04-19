package de.reproduce.modulithreproducerissue94.module1;

import de.reproduce.modulithreproducerissue94.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

@ApplicationModuleTest
public class Module1TestClass extends BaseTest {
    static {
        database.start();
    }

    @Autowired
    private EventListenerModule1 module1;

    @Test
    void test_event_handling(Scenario scenario) {
        Module1Event event = new Module1Event();

        scenario.publish(event)
                .andWaitForStateChange(() -> module1.handledEvent());
    }
}
