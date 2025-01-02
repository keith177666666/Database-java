package dev.keith;

import java.util.List;

public interface IDataBase<K, V, D extends IData<V>> {
    D read(K key);
    ResultType write(Pair<K, V> pair);
    default ResultType write(List<Pair<K, V>> data) {
        for (Pair<K, V> pair : data) {
            if (!write(pair).canContinue) {
                return ResultType.EXCEPTION;
            }
        }
        return ResultType.SUCCESS;
    }
}
