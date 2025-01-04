package dev.keith.event;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public sealed interface Proxy
        permits DataBaseManger.ProxyImpl {
    @NotNull
    @ApiStatus.OverrideOnly
    Permission callOnMethod(IEvent<?> iEvent);
}
