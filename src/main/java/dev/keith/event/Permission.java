package dev.keith.event;

import java.util.function.Consumer;

public enum Permission {
    ALLOWED(parameters -> {}),
    DENIED(Parameters::cancelAction),
    CUSTOM(ALLOWED.action)
    ;
    private Consumer<Parameters> action;
    Permission(Consumer<Parameters> action) {
        this.action = action;
    }

    public void setAction(Consumer<Parameters> action) {
        this.action = action;
    }

    public Consumer<Parameters> getAction() {
        return action;
    }
}
