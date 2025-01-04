package dev.keith.event;

public interface IEvent<T extends IEvent.Type> {
    String message();
    T type();
    Parameters parameters();
    interface Type {
        String message();
    }
}
