package de.reproduce.modulithreproducerissue94.module1;

import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class EventListenerModule1 {
    private boolean handledEvent;

    public EventListenerModule1() {
        this.handledEvent = false;
    }

    @ApplicationModuleListener
    public void on(Module1Event event) {
        handledEvent = true;
    }

    public boolean handledEvent() {
        return handledEvent;
    }
}
