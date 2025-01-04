package dev.keith.event;

public sealed interface Proxy
        permits DataBaseManger.ProxyImpl {
    Permission callOnMethod(IEvent<?> iEvent);
}
