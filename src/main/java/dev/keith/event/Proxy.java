package dev.keith.event;

public sealed interface Proxy
        permits DataBaseManger.ProxyImpl {
    void callOnMethod(Event event);
}
