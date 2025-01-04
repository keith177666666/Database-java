package dev.keith.event;

import dev.keith.IData;
import dev.keith.IDataBase;

import java.util.function.Function;

public final class DataBaseManger<K, V, D extends IData<V>, DB extends IDataBase<K, V, D>> {

    private final DB db;

    public DataBaseManger(DB db) {
        this.db = db;
    }
    public void addProxyTo(Function<IEvent<?>, Permission> consumer) {
        db.addProxy(new ProxyImpl(consumer));
    }

    static final class ProxyImpl implements Proxy {
        private final Function<IEvent<?>, Permission> consumer;

        public ProxyImpl(Function<IEvent<?>, Permission> consumer) {
            this.consumer = consumer;
        }

        @Override
        public Permission callOnMethod(IEvent<?> event) {
            return consumer.apply(event);
        }
    }
}
