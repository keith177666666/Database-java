package dev.keith;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.function.Function;

public interface IDataBaseObserver<V, D extends IData<V>, S extends IDataBaseObserver.Serializer<D>> {
    S getSerializer();
    Function<V, D> getFactory();
    interface Serializer<D extends IData<?>> {
        D deserialize(InputStream dataInput);
        ResultType serialize(D data, OutputStream dataOutput);
        default ResultType serialize(List<D> data, OutputStream dataOutput) {
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
