package dev.keith.event;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public enum Permission {
    ALLOWED(parameters -> {}),
    DENIED(Parameters::cancelAction),
    CUSTOM(null)
    ;
    @NotNull
    private Consumer<Parameters> action;
    Permission(@NotNull Consumer<Parameters> action) {
        this.action = action;
    }

    public void setAction(@NotNull Consumer<Parameters> action) {
        if (this == Permission.CUSTOM) {
            this.action = action;
        }
    }

    public @NotNull Consumer<Parameters> getAction() {
        return action;
    }
}
