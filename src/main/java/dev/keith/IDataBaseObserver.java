package dev.keith;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.util.function.Function;

public interface IDataBaseObserver<K, V, D extends IData<V>, S extends IDataBaseObserver.Serializer<K, D>> {
    S getSerializer();
    Function<V, D> getFactory();
    interface Serializer<K, D extends IData<?>> {
        D deserialize(K key, BufferedReader dataInput);
        ResultType serialize(Pair<K, D> pair, BufferedWriter dataOutput);
        ResultType remove(K key, BufferedReader dataInput, BufferedWriter dataOutput);
        default ResultType serialize(List<Pair<K, D>> data, BufferedWriter dataOutput) {
            for (Pair<K, D> pair : data) {
                if (!serialize(pair, dataOutput).canContinue) {
                    return ResultType.EXCEPTION;
                }
            }
            return ResultType.SUCCESS;
        }
    }
}
