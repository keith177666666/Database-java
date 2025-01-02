package dev.keith;

import java.util.Map;

public interface IDataBase<K, V, D extends IData<V>> {
    D read(K key);
    ResultType write(K key, D data);
    default ResultType write(Map<K, D> data) {
        for (Map.Entry<K, D> entry : data.entrySet()) {
            if (!write(entry.getKey(), entry.getValue()).canContinue) {
                return ResultType.EXCEPTION;
            }
        }
        return ResultType.SUCCESS;
    }
}
