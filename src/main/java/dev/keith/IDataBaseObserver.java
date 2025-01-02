package dev.keith;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Map;
import java.util.function.Function;

public interface IDataBaseObserver<K, V, D extends IData<V>, S extends IDataBaseObserver.Serializer<K, D>> {
    S getSerializer();
    Function<V, D> getFactory();
    interface Serializer<K, D extends IData<?>> {
        D deserialize(K key, BufferedReader dataInput);
        ResultType serialize(K key, D data, BufferedWriter dataOutput);
        default ResultType serialize(Map<K, D> data, BufferedWriter dataOutput) {
            for (Map.Entry<K, D> entry : data.entrySet()) {
                if (!serialize(entry.getKey(), entry.getValue(), dataOutput).canContinue) {
                    return ResultType.EXCEPTION;
                }
            }
            return ResultType.SUCCESS;
        }
    }
}
