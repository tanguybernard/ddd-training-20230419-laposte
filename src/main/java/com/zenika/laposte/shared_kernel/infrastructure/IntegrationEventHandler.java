package com.zenika.laposte.shared_kernel.infrastructure;

public interface IntegrationEventHandler<Event extends IntegrationEvent> {

    void handle(Event evt);
}
