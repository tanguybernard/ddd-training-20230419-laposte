package com.zenika.laposte.shared_kernel.domain_event;


import java.util.HashMap;
import java.util.List;

public class DomainEventPublisher {
   private static HashMap<String, List<EventHandler>> handlersMap = new HashMap<>();

    public static void register(
            EventHandler subscriber,
            String domainEventName
    ){

        List handlers = handlersMap.get(domainEventName);
        if (handlers != null) {
            DomainEventPublisher.handlersMap.put(domainEventName, List.of(subscriber));
        } else {
            DomainEventPublisher.handlersMap.get(domainEventName).add(subscriber);
        }

    }

    public static void clearHandlers() {
        DomainEventPublisher.handlersMap = new HashMap<>();
    }

    public static void dispatch (DomainEvent event) {
        String eventClassName = event.getClass().getName();


        if (DomainEventPublisher.handlersMap.get(eventClassName) != null) {
            List<EventHandler> handlers = DomainEventPublisher.handlersMap.get(eventClassName);
            for(EventHandler handler: handlers){
                handler.handle(event);
            }



        }
    }


}

