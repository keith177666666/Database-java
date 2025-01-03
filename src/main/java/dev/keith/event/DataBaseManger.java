package dev.keith.event;

import dev.keith.IData;
import dev.keith.IDataBase;

import java.util.function.Consumer;

public final class DataBaseManger {
    private static boolean isInitialed = false;
    private static DataBaseManger instance;
    public DataBaseManger() {
        if (!isInitialed) {
            isInitialed = true;
            instance = this;
        } else {
            throw new IllegalStateException("The Data Base Manger has been initialed!");
        }
    }
    public <K, V, D extends IData<V>> void addProxyTo(IDataBase<K, V, D> dataBase,
                                                      Consumer<Event> consumer) {
        dataBase.addProxy(new ProxyImpl(consumer));
    }

    static final class ProxyImpl implements Proxy {
        private final Consumer<Event> consumer;

        public ProxyImpl(Consumer<Event> consumer) {
            this.consumer = consumer;
        }

        @Override
        public void callOnMethod(Event event) {
            consumer.accept(event);
        }
    }
}
