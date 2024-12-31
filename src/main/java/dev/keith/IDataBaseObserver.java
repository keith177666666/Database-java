package dev.keith;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.util.function.Function;

public interface IDataBaseObserver<V, D extends IData<V>, S extends IDataBaseObserver.Serializer<D>> {
    S getSerializer();
    Function<V, D> getFactory();
    interface Serializer<D extends IData<?>> {
        D deserialize(BufferedReader dataInput);
        ResultType serialize(D data, BufferedWriter dataOutput);
        default ResultType serialize(List<D> data, BufferedWriter dataOutput) {
            for(D data1 : data) {
                if(!(serialize(data1, dataOutput).canContinue)) {
                    return ResultType.EXCEPTION;
                }
            }
            data.forEach(d -> this.serialize(d, dataOutput));
            return ResultType.SUCCESS;
        }
    }
}
