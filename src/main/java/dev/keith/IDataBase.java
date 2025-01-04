package dev.keith;

import dev.keith.event.DataBaseManger;
import dev.keith.event.Proxy;

import java.util.List;

public interface IDataBase<K, V, D extends IData<V>> {
    D read(K key);
    ResultType write(Pair<K, V> pair);
    ResultType remove(K key);
    default ResultType write(List<Pair<K, V>> data) {
        for (Pair<K, V> pair : data) {
            if (!write(pair).canContinue) {
                return ResultType.EXCEPTION;
            }
        }
        return ResultType.SUCCESS;
    }
    void addProxy(Proxy proxy);
    <THIS extends IDataBase<K, V, D>> DataBaseManger<K, V, D, THIS> getManger();
}
