package dev.keith;

import java.util.List;

public interface IDataBase<V, D extends IData<V>> {
    D read();
    ResultType write(D data);
    default ResultType write(List<D> data) {
        for (D d : data) {
            if(!(this.write(d).canContinue)) {
                return ResultType.EXCEPTION;
            }
        }
        return ResultType.SUCCESS;
    }
}
