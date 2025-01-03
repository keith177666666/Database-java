package dev.keith.event;

public record Event(String message, Event.Type type) {
    public enum Type {
        WRITE,
        READ,
        CLEAR,
    }
}
