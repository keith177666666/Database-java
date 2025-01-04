package dev.keith.event;

import dev.keith.IData;
import dev.keith.IDataBase;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class DataBaseManger<K, V, D extends IData<V>, DB extends IDataBase<K, V, D>> {
    @NotNull
    private final DB db;

    public DataBaseManger(@NotNull DB db) {
        this.db = db;
    }
    public void addProxyTo(@NotNull Function<IEvent<?>, Permission> consumer) {
        db.addProxy(new ProxyImpl(consumer));
    }
    @ApiStatus.Internal
    static final class ProxyImpl implements Proxy {
        @NotNull
        private final Function<IEvent<?>, Permission> consumer;

        public ProxyImpl(@NotNull Function<IEvent<?>, Permission> consumer) {
            this.consumer = consumer;
        }

        @Override
        public @NotNull Permission callOnMethod(IEvent<?> event) {
            return consumer.apply(event);
        }
    }
}
